// Add dotted border to any Composable 
@Composable
fun Modifier.dottedBorder(color: Color, dotGap: Float = 10f) : Modifier{
    val dottedStroke = Stroke(5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(1f, dotGap), 1f))
    val mod = drawBehind {
        drawRoundRect(color, style = dottedStroke)
    }
    return this then mod
}
