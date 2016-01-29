# AntiPluginListBlock
This Eventlistener sends a list of all Plugins that the Bukkit/Spigot server is using if a player is trying to use the command /plugins and don't have the permissions to use it or another plugin is trying to block it.

To use this Listener in your plugin you only need to copy the listener and register it in your mainClass:

```java
getServer().getPluginManager().registerEvents(new AntiAntiPluginlist(), this);
```


### Why should i use this listener in my plugin?

There are a lot of small and big servers out there that think, that they can hide there pluginlist and aren't giving us developers even this bit of respect for our work. Some servers are even thinking, that they can claim to have only plugins writen by there developers while they are actually using some public plugins. So we need to enforce that we get atleast the bit of credit of the /plugins command. And exactly that is what this eventListener is for: it sends the pluginlist even if its blocked by the serverowner. 
