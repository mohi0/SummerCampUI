// code for custom inputs 
// OTPView, Password View, Long Texts
enum class OTP_VIEWTYPE { DASH, BOX, ROUNDED, CUSTOM }
@Composable
fun MOTPField(onComplete: (value: List<String>) -> Unit, type: OTP_VIEWTYPE, digitsCount: Int ){

    val digits = remember { mutableStateListOf<String>() }

    for (i in 0..digitsCount-1){
        digits.add(" ")
    }

    val focusManager = LocalFocusManager.current

    var textFieldModifier = Modifier.padding(3.dp)
    if (type == OTP_VIEWTYPE.BOX){
        textFieldModifier = textFieldModifier.then(Modifier.border(2.dp, Color.Black))
    }
    if(type == OTP_VIEWTYPE.ROUNDED){
        textFieldModifier = textFieldModifier.then(Modifier.border(2.dp, Color.Black, CircleShape))
    }
    if(type == OTP_VIEWTYPE.DASH ) {
        textFieldModifier = textFieldModifier.then(Modifier.drawBehind {
            drawLine(Color.Black, Offset(0f, size.height), Offset(size.width, size.height), 2f)
        })
    }


    LazyRow(
        Modifier
            .fillMaxWidth(1f)
            .background(Color.White)
            .padding(10.dp), horizontalArrangement = Arrangement.Center){
        items(count = digits.size){index ->
            BasicTextField(modifier = textFieldModifier.then(
                Modifier
                    .width(50.dp)
                    .padding(10.dp)),
                value = digits[index], onValueChange = {
                    newVal -> digits[index] = newVal; if(newVal == "") {focusManager.moveFocus(FocusDirection.Previous)}else{focusManager.moveFocus(FocusDirection.Next); if(index == digitsCount-1){onComplete(digits.toList())} }}, textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center))
        }
    }
}

@Composable
fun MMeteredTextInput(modifier: Modifier, maxLen: Int, value: String, onValueChange: (value: String) -> Unit, label: String? = null, onComplete: (value: String) -> Unit){
    val charLen : MutableState<Int> = remember { mutableIntStateOf(0) }
    val progressValue : MutableState<Float> = remember { mutableFloatStateOf(0f) }
    Column(modifier = modifier.padding(10.dp)){
        if (label != null) {
            BasicText(modifier = Modifier.padding(vertical = 10.dp), text = label)
        }
        BasicTextField(value = value,
            onValueChange = { onValueChange(it);
                            charLen.value = it.length
                            progressValue.value = it.length.toFloat() / maxLen
                            Log.d("LOG LENGTH", charLen.toString())
                            if(it.length == charLen.value){
                                onComplete(it)
                            }
                            }, modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, Color.Black)
                .padding(6.dp), textStyle = TextStyle(Color.Black, 20.sp))
        Row(modifier.fillMaxWidth(1f), verticalAlignment = Alignment.CenterVertically){
            LinearProgressIndicator(progress = progressValue.value, modifier = Modifier.weight(0.8f))
            Text(text = "${maxLen - charLen.value}", modifier = Modifier.weight(0.2f).padding(horizontal = 8.dp))
        }
    }
}
