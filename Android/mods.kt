// Add dotted border to any Composable 
@Composable
fun Modifier.dottedBorder(color: Color, dotGap: Float = 10f) : Modifier{
    val dottedStroke = Stroke(5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(1f, dotGap), 1f))
    val mod = drawBehind {
        drawRoundRect(color, style = dottedStroke)
    }
    return this then mod
}

@Composable
fun Modifier.dashedBorder(color: Color, dashLength: Float = 20f, dashGap: Float = 20f): Modifier {
    val dashedStroke = Stroke(5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, dashGap), 1f))
    val mod = drawBehind {
        drawRoundRect(color, style = dashedStroke)
    }
    return this then mod
}
