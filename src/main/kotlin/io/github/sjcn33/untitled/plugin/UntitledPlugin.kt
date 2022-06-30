package io.github.sjcn33.untitled.plugin

import io.github.sjcn33.untitled.Untitled
import io.github.sjcn33.untitled.UntitledItem.testItemStack
import io.github.sjcn33.untitled.UntitledManager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class UntitledPlugin : JavaPlugin() {
    private val console = Bukkit.getConsoleSender()

    override fun onEnable() {
        val untitledManager = UntitledManager(this)
        Untitled.untitledManager = untitledManager
        console.sendMessage("${ChatColor.YELLOW}[Untitled] : ==============================")
        console.sendMessage("${ChatColor.YELLOW}[Untitled] : Enable UntitledPlugin")
        console.sendMessage("${ChatColor.YELLOW}[Untitled] : by sjcn33")
        console.sendMessage("${ChatColor.YELLOW}[Untitled] : ==============================")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (sender.isOp) {
                if (args.isNotEmpty()) {
                    when (args[0]) {
                        "test" -> {
                            sender.inventory.addItem(testItemStack)
                            sender.sendMessage("${ChatColor.GREEN}<Untitled>${ChatColor.RESET} 아이템이 지급되었습니다")
                        }
                        else -> {
                            sender.sendMessage("${ChatColor.YELLOW}<Untitled>${ChatColor.RESET} '/untitled 값' 형태로 사용할 수 있습니다")
                        }
                    }
                } else {
                    sender.sendMessage("${ChatColor.YELLOW}<Untitled>${ChatColor.RESET} '/untitled 값' 형태로 사용할 수 있습니다")
                }
            } else if (!sender.isOp) {
                sender.sendMessage("${ChatColor.RED}<Untitled>${ChatColor.RESET} 사용 불가능한 명령어입니다")
            } else {
                console.sendMessage("${ChatColor.RED}[Untitled]${ChatColor.RESET} : Error")
            }
        } else if (sender == console) {
            console.sendMessage("${ChatColor.RED}[Untitled]${ChatColor.RESET} : 해당 명령어는 플레이어만 사용할 수 있습니다")
        } else {
            console.sendMessage("${ChatColor.RED}[Untitled]${ChatColor.RESET} : Error")
        }
        return true
    }
}
