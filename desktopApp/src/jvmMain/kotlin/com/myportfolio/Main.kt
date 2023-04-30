package com.myportfolio

import App
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    desktopApplicationWindow()
}

@Composable
fun ApplicationScope.desktopApplicationWindow() {
    Window(
        onCloseRequest = ::exitApplication,
        title = "My Portfolio"
    ) {
        App()
    }
}