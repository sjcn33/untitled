package io.github.sjcn33.untitled

import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object UntitledItem {
    private val testItemStackText =
        text().content("testItemStack").decoration(TextDecoration.ITALIC, false).color(NamedTextColor.WHITE).build()
    val testItemStack = ItemStack(Material.NETHER_STAR).apply {
        itemMeta = itemMeta.apply { displayName(testItemStackText) }
    }
}