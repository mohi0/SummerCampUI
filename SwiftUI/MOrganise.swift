struct MDayPoint: Identifiable {
    var id = UUID()
    var timeInterval: DateInterval
    var view: any View
}

struct MDayScheduleView : View {
    @Binding var dayPoints: [MDayPoint]
    var body: some View {
        VStack{
            ForEach(dayPoints, id: \.id) { point in
                VStack(alignment: .leading){
                    Text(point.timeInterval.description)
                    AnyView(point.view)
                }
            }
        }
    }
}
