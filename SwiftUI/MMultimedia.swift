struct MCircleImage: View {
    var img: Image
    var width: CGFloat
    var height: CGFloat
    var body: some View {
        ZStack {
            img.aspectRatio(1.0, contentMode: .fill)
                .clipShape(Circle())
                .frame(width: width, height: height)
        }
    }
}