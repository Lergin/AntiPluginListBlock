package de.lergin.spigot.antiAntiPluginlist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public final class AntiAntiPluginlist implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();

        String message = e.getMessage();

        if (message.startsWith("/pl") || message.startsWith("/bukkit:pl")){
            if(!player.hasPermission("bukkit.command.plugins") || e.isCancelled()){
                player.sendMessage("");

                for(Plugin plugin : Bukkit.getPluginManager().getPlugins()){
                    PluginDescriptionFile pluginDescription = plugin.getDescription();

                    player.sendMessage(ChatColor.BOLD + pluginDescription.getFullName());

                    String authorMessage = "by";

                    for(String author : pluginDescription.getAuthors()){
                        authorMessage = authorMessage + " " + author + ",";
                    }

                    authorMessage = authorMessage.substring(0, authorMessage.length()-1);

                    player.sendMessage(authorMessage);

                    if(pluginDescription.getWebsite() != null)
                        player.sendMessage("Website: " + pluginDescription.getWebsite());


                    if(pluginDescription.getDescription() != null)
                        player.sendMessage(pluginDescription.getDescription());

                    player.sendMessage("");
                }
            }
        }
    }
}
