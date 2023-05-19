package de.mecrytv.mc.lobbyscoreboard.utils;

import de.mecrytv.mc.lobbyscoreboard.LobbyScoreboard;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardUtils {

    private static LuckPerms luckPerms = LobbyScoreboard.getApi;


    public static Scoreboard getBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main" , "main", "Analritter.de");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String currentWorld = player.getWorld().getName();

        objective.getScore("Test").setScore(0);
        objective.getScore("§a").setScore(1);
        objective.getScore(currentWorld).setScore(2);
        objective.getScore("Dein Server").setScore(3);
        objective.getScore("§a").setScore(4);
        objective.getScore(prefix).setScore(5);
        objective.getScore("Dein Rank").setScore(6);
        objective.getScore("§a").setScore(7);




        //-             7
        //Dein Rank:    6
        //            / 5
        //-             4
        //Dein Server:  3
        //              2
        //-             1
        //              0

        return s;
    }
}
