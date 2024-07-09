package by.beyn.teleport2surface.command;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class surfaceCommand implements CommandExecutor {
    private final JavaPlugin plugin;
    private static Player p;
    private static World pWorld;
    private static String[] args;

    public surfaceCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;

        p = (Player) commandSender;
        pWorld = p.getWorld();

        if(strings.length != 1) return true;
        args = strings;

        String playername = args[0];
        Player p2 = plugin.getServer().getPlayer(playername);


        Location p2Location = p2.getLocation();
        World p2World = p2.getWorld();
        int p2X = p2.getLocation().getBlockX();
        int p2Y = (p2World.getHighestBlockYAt(p2Location)) + 1;
        int p2Z = p2.getLocation().getBlockZ();
        Location newLocation = new Location(p2World,p2X,p2Y,p2Z);
        p.teleport(newLocation);
        return true;
    }
}
