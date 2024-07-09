package by.beyn.teleport2surface;

import by.beyn.teleport2surface.command.surfaceCommand;
import by.beyn.teleport2surface.command.surfaceCommandTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Teleport2surface extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try{
            getServer().getPluginCommand("surface").setExecutor(new surfaceCommand(this));
            getServer().getPluginCommand("surface").setTabCompleter(new surfaceCommandTabCompleter());
        } catch (Exception e){
            System.out.println("[MADY BY BEYN] commands enabling error.");
        }
        finally {
            System.out.println("[MADE BY BEYN] teleport2surface plugin is working well :)");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[MADE BY BEYN] Goodbye!");
    }
}
