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
