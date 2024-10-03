struct MMeteredTextInput: View{
    
    var placeholder: String
    @Binding var value: String
    var maxLen: Int
    
    @State var progressbarValue: Float = 0
    
    var body: some View {
        VStack {
            TextField(placeholder, text: $value).onChange(of: value, perform: {
                newVal in
                progressbarValue = Float(newVal.count)
            })
            HStack {
                ProgressView(value: $progressbarValue.wrappedValue, total: Float(maxLen))
                Text("\(maxLen - Int($progressbarValue.wrappedValue))")
            }
        }
    }
}
