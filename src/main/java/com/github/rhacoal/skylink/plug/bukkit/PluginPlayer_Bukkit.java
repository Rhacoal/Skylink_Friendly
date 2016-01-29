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
package com.github.rhacoal.skylink.plug.bukkit;

import com.github.rhacoal.skylink.plug.PluginLocation;
import com.github.rhacoal.skylink.plug.PluginPlayer;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Rhacoal
 */
public class PluginPlayer_Bukkit implements PluginPlayer {
    
    private final Player player;
    
    public PluginPlayer_Bukkit(Player player){
        this.player=player;
    }

    @Override
    public UUID getUUID() {
        return player.getUniqueId();
    }

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public PluginLocation getLocation() {
        return new PluginLocation_Bukkit(player.getLocation());
    }

    @Override
    public void teleport(PluginLocation loc) {
        player.teleport(new PluginLocation_Bukkit(player.getServer(), loc).getBukkitLocation());
    }

    @Override
    public double getHealth() {
        return player.getHealth();
    }
    
}
