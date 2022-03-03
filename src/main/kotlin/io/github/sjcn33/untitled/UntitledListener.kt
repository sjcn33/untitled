package io.github.sjcn33.untitled

import io.github.sjcn33.untitled.UntitledInventory.lodestoneInventory
import io.github.sjcn33.untitled.UntitledItem.testItemStack
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class UntitledListener : Listener {

    @EventHandler
    fun onInteractEvent(event: PlayerInteractEvent) {
        val player = event.player
        val action = event.action
        val item = event.item
        val block = event.clickedBlock

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            when (item) {
                testItemStack -> {
                    player.sendMessage("${ChatColor.GREEN}<Untitled>${ChatColor.RESET} 성공")
                }
            }
        }

        if (block != null && action == Action.RIGHT_CLICK_BLOCK) {
            if (block.type == Material.LODESTONE) {
                player.openInventory(lodestoneInventory)
            }
        }
    }
}