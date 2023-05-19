package de.mecrytv.mc.lobbyscoreboard.events;

import de.mecrytv.mc.lobbyscoreboard.utils.ScoreboardUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setScoreboard(ScoreboardUtils.getBaseScoreboard(player));
    }
}
