//
//  DecomposeContext.swift
//  TodoAppCompose
//
//  Created by Денис Маслов on 13.04.2024.
//

import Foundation
import SwiftUI
import Shared

class DecomposeContext {
    var rootComponentContext: ComponentContext

    init(rootComponentContext: ComponentContext) {
        self.rootComponentContext = rootComponentContext
    }
}
