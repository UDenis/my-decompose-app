import SwiftUI
import Shared

struct ComposeView: UIViewControllerRepresentable {
    private var rootComponentContext: ComponentContext
    
    init(rootComponentContext: ComponentContext) {
        self.rootComponentContext = rootComponentContext
    }
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.MainViewController(rootComponentContext: rootComponentContext)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
