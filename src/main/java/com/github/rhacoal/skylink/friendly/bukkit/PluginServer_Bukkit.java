/*
 * Copyright 2016 Rhacoal.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rhacoal.skylink.friendly.bukkit;

import com.github.rhacoal.skylink.plug.PluginOfflinePlayer;
import com.github.rhacoal.skylink.plug.PluginPlayer;
import com.github.rhacoal.skylink.plug.PluginServer;
import com.github.rhacoal.skylink.plug.PluginWorld;
import java.util.UUID;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 *
 * @author Rhacoal
 */
public class PluginServer_Bukkit implements PluginServer {
    
    Server server;
    
    public PluginServer_Bukkit(Server server){
        this.server=server;
    }

    @Override
    public PluginPlayer[] getOnlinePlayers() {
        Object players_[]=server.getOnlinePlayers().toArray();
        PluginPlayer players[]=new PluginPlayer[players_.length];
        for(int i=0;i<players_.length;i++){
            players[i]=new PluginPlayer_Bukkit((Player)players_[i]);
        }
        return players;
    }

    @Override
    public PluginPlayer getOnlinePlayer(String name) {
        Player player=server.getPlayer(name);
        if(player==null)return null;
        return new PluginPlayer_Bukkit(player);
    }

    @Override
    public PluginPlayer getOnlinePlayer(UUID uuid) {
        Player player=server.getPlayer(uuid);
        if(player==null)return null;
        return new PluginPlayer_Bukkit(player);
    }

    @Override
    @Deprecated
    public PluginOfflinePlayer getPlayer(String name) {
        return new PluginOfflinePlayer_Bukkit(server.getOfflinePlayer(name));
    }

    @Override
    public PluginOfflinePlayer getPlayer(UUID uuid) {
        return new PluginOfflinePlayer_Bukkit(server.getOfflinePlayer(uuid));
    }

    @Override
    public boolean isPlayerOnline(String name) {
        return server.getPlayer(name)!=null;
    }

    @Override
    public boolean isPlayerOnline(UUID uuid) {
        return server.getPlayer(uuid)!=null;
    }

    @Override
    public PluginWorld getWorld(String name) {
        World world=server.getWorld(name);
        if(world==null)return null;
        return new PluginWorld_Bukkit(world);
    }

    @Override
    public PluginWorld getWorld(UUID uuid) {
        World world=server.getWorld(uuid);
        if(world==null)return null;
        return new PluginWorld_Bukkit(world);
    }
    
    
}
