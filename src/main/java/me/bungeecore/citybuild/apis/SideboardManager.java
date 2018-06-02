package me.bungeecore.citybuild.apis;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class SideboardManager {

    private void sendPacket(Player p, Packet<?> packet) {
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public void setSideboard(Player p) {
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("§8•", IScoreboardCriteria.b);


        obj.setDisplayName("§8•● §6CityBuid §8● §eAviumMC.net");
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§0");
        ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§6☣ §7Du");
        ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8➥ §7" + p.getDisplayName());
        ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§2");
        ScoreboardScore s5 = new ScoreboardScore(scoreboard, obj, "§6⚔ §6Kontostand");
        ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§8➥ §e" + new Money().getMoney(p.getUniqueId()));
        ScoreboardScore s7 = new ScoreboardScore(scoreboard, obj, "§3");
        ScoreboardScore s8 = new ScoreboardScore(scoreboard, obj, "§6✄ §9Shop");
        ScoreboardScore s9 = new ScoreboardScore(scoreboard, obj, "§6➥ §eshop.AviumMC.net");
        ScoreboardScore s10 = new ScoreboardScore(scoreboard, obj, "§4");
        ScoreboardScore s11 = new ScoreboardScore(scoreboard, obj, "§6✸ §7TeamSpeak");
        ScoreboardScore s12 = new ScoreboardScore(scoreboard, obj, "§8➥ §eAviumMC.net");
        s1.setScore(11);
        s2.setScore(10);
        s3.setScore(9);
        s4.setScore(8);
        s5.setScore(7);
        s6.setScore(6);
        s7.setScore(5);
        s8.setScore(4);
        s9.setScore(3);
        s10.setScore(2);
        s11.setScore(1);
        s12.setScore(0);

        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
        PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(s7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(s8);
        PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(s9);
        PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(s10);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(s11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(s12);

        sendPacket(p, removePacket);
        sendPacket(p, createPacket);
        sendPacket(p, display);
        sendPacket(p, pa1);
        sendPacket(p, pa2);
        sendPacket(p, pa3);
        sendPacket(p, pa4);
        sendPacket(p, pa5);
        sendPacket(p, pa6);
        sendPacket(p, pa7);
        sendPacket(p, pa8);
        sendPacket(p, pa9);
        sendPacket(p, pa10);
        sendPacket(p, pa11);
        sendPacket(p, pa12);
    }
}
