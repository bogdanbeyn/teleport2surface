package by.beyn.teleport2surface.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class surfaceCommandTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            Collection<? extends Player> onlinePlayers = Bukkit.getServer().getOnlinePlayers();
            ArrayList<String> onlinePlayersName = new ArrayList<>();
            for (Player onlinePlayer:onlinePlayers){
                String name = onlinePlayer.getName();
                onlinePlayersName.add(name);
            }
            return onlinePlayersName;
        }
        return new ArrayList<>();
    }
}
