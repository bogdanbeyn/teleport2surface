package by.beyn.teleport2surface.command;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Material.LEGACY_STATIONARY_LAVA;


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

        String playerName = args[0];
        Player p2 = plugin.getServer().getPlayer(playerName);


        Location p2Location = p2.getLocation();
        World p2World = p2.getWorld();
        int p2X = p2.getLocation().getBlockX();
        int p2Y = (p2World.getHighestBlockYAt(p2Location)) + 1;
        int p2Z = p2.getLocation().getBlockZ();
        Location newLocation = new Location(p2World,p2X,p2Y,p2Z);
        if(isLava(p2,newLocation)){
            p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Teleport2Surface] " + ChatColor.WHITE + "" + ChatColor.RESET + "Location isn't safe! Teleportation was cancelled.");
            return true;
        }
        if(!(isAir(p2,newLocation))){
            p.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "[Teleport2Surface] " + ChatColor.WHITE + "" + ChatColor.RESET + "Location isn't safe! Teleportation was cancelled.");
            return true;
        }
        p.teleport(newLocation);
        return true;
    }

    private boolean isLava(Player player, Location location){
        int x = location.getBlockX();
        int y = location.getBlockY() - 1;
        int z = location.getBlockZ();
        World world = player.getWorld();
        Location loc = new Location(world,x,y,z);
        Block block = world.getBlockAt(loc);

        if(block.getType() == Material.LAVA || block.getType() == LEGACY_STATIONARY_LAVA){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isAir(Player player, Location location){
        Block block = p.getWorld().getBlockAt(location);

        if(block.getType().isAir()){
            return true;
        }
        else{
            return false;
        }
    }
}
