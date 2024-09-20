// code for buttons, switches, toggle widgets
@Composable
fun MToggleSwitch(value: Boolean, onToggle: (value: Boolean)->Unit){
    Row(modifier = Modifier
        .height(20.dp)
        .width(40.dp)
        .clip(CircleShape)
        .background(Color.LightGray)
        .border(1.dp, Color.Gray)){
        if (value){
            Spacer(modifier=Modifier.width(20.dp))
        }
        Button(onClick = { onToggle(!value) }, modifier= Modifier
            .width(20.dp)
            .height(20.dp)
            .clip(CircleShape)){
        }
    }
}
