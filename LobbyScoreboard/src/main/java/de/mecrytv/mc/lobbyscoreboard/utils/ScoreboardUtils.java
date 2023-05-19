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

    private static LuckPerms luckPerms = LobbyScoreboard.getApi();


    public static Scoreboard getBaseScoreboard(Player player){
        Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = s.registerNewObjective("main" , "main", "Analritter.de");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String currentWorld = player.getWorld().getName();

        objective.getScore("§9§l§r§9■■■■■■■■■■").setScore(0);
        objective.getScore(currentWorld).setScore(1);
        objective.getScore("§6➜" + " " + "§3Server").setScore(2);
        objective.getScore("§c").setScore(3);
        objective.getScore("CoinsAPI").setScore(4);
        objective.getScore("§6➜" + " " + "§3Coins").setScore(5);
        objective.getScore("§e").setScore(6);
        objective.getScore("§7" + Bukkit.getOnlinePlayers().size()  + "§b/" + "§7" + Bukkit.getMaxPlayers()).setScore(7);
        objective.getScore("§6➜" + " " + "§3Online").setScore(8);
        objective.getScore("§f").setScore(9);
        objective.getScore(prefix).setScore(10);
        objective.getScore("§6➜" + " " + "§3Rank").setScore(11);
        objective.getScore("§9■■■■■■■■■■").setScore(12);



        //-       12
        //Rank    11
        //        10
        //-       9
        //Online: 8
        //        7
        //-       6
        //Coins:  5
        //        4
        //-       3
        //Server: 2
        //        1
        //-       0

        return s;
    }
}
