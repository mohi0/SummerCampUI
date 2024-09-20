//contains code for views used to styling multimedia

@Composable
fun RoundedImage(size: Int, img: @Composable() () -> Unit){
    Box(modifier = Modifier
        .width(size.dp)
        .height(size.dp)
//        .border(2.dp, Color.Red, CircleShape)
        .clip(CircleShape)){
        img()
    }
}
