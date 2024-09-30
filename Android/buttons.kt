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


@Composable
fun MIconButton(onClick: () -> Unit, text: String, icon: Painter, iconDescription: String?, textColor: Color, bgColor: Color, iconHeight: Dp, iconWidth: Dp, textSize: TextUnit){
    Box(Modifier.clickable(
        interactionSource = MutableInteractionSource(),
        indication = null, onClick = onClick
        )){
        Row(
            Modifier
                .background(bgColor)
                .padding(horizontal = (iconWidth / 2), vertical = (iconHeight / 2)), verticalAlignment = Alignment.CenterVertically){
            Text(text = text, color = textColor, fontSize = textSize)
            Spacer(Modifier.width(iconWidth.div(2)))
            Image(icon, "icon", modifier = Modifier
                .height(iconHeight)
                .width(iconWidth))
        }
    }
}
