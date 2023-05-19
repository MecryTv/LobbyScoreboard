package de.mecrytv.mc.lobbyscoreboard;

import de.mecrytv.mc.lobbyscoreboard.events.Listeners;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyScoreboard extends JavaPlugin {

    private static LuckPerms api;
    private LobbyScoreboard ls;
    private Player player;


    @Override
    public void onEnable() {

        ls = this;

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();
        }

        this.ListenerRegistration();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static LuckPerms getApi() {
        return api;
    }

    public LobbyScoreboard getLs() {
        return ls;
    }

    public Player getPlayer() {
        return player;
    }

    public void ListenerRegistration(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new Listeners(), this);

    }
}

