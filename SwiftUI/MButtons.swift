enum MIconPosition {case ABOVE; case BELOW; case RIGHT; case LEFT}
struct MIconButton : View{
    var action: () -> Void
    var label: Text
    var icon: Image
    var iconPosition : MIconPosition
    var body: some View {
        Button {
            action()
        } label: {
            if(iconPosition == .ABOVE || iconPosition == .BELOW){
                VStack {
                    if(iconPosition == .ABOVE){
                        icon
                    }
                    label
                    if(iconPosition == .BELOW){
                        icon
                    }
                }
            }else {
                HStack {
                    if(iconPosition == .LEFT){
                        icon
                    }
                    label
                    if(iconPosition == .RIGHT){
                        icon
                    }
                }
            }
        }
    }
}
