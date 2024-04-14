import SwiftUI
import Shared

struct ComposeView: UIViewControllerRepresentable {
    private var rootComponentContext: ComponentContext
    private var appDI: AppDI

    init(rootComponentContext: ComponentContext, appDI: AppDI) {
        self.rootComponentContext = rootComponentContext
        self.appDI = appDI
    }
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController(rootComponentContext: rootComponentContext, appDI:appDI)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
