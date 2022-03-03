package io.github.sjcn33.untitled

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit

object UntitledInventory {
    private val lodestoneInventoryText =
        text().content("lodestoneInventory").color(NamedTextColor.DARK_GRAY).build()
    val lodestoneInventory = Bukkit.createInventory(null, 27, lodestoneInventoryText)
}