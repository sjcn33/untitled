package io.github.sjcn33.untitled

import io.github.sjcn33.untitled.plugin.UntitledPlugin

class UntitledManager(
    plugin: UntitledPlugin
) {
    private val listener: UntitledListener

    init {
        val server = plugin.server
        listener = UntitledListener().also {
            server.pluginManager.registerEvents(it, plugin)
        }
    }
}