import SwiftUI
import Shared

@main
struct TodoApp: App {

    private var appDI: AppDI = AppDI()

    var body: some Scene {
        WindowGroup {
            ContentView(appDI:appDI)
        }
    }
}
