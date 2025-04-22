import SwiftUI
import Shared

struct ContentView: View {

    @State
    private var componentHolder =
        ComponentHolder {
            DecomposeContext(
                rootComponentContext: $0
            )
        }
    
    var body: some View {
        ComposeView(rootComponentContext:self.componentHolder.component.rootComponentContext)
            .onAppear { LifecycleRegistryExtKt.resume(self.componentHolder.lifecycle) }
            .onDisappear { LifecycleRegistryExtKt.stop(self.componentHolder.lifecycle) }
    }
}

// struct ContentView_Previews: PreviewProvider {
//     static var previews: some View {
//         ContentView()
//     }
// }
