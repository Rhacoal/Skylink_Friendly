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

import com.github.rhacoal.skylink.plug.PluginLocation;
import com.github.rhacoal.skylink.plug.PluginServer;
import com.github.rhacoal.skylink.plug.PluginWorld;
//import org.spongepowered.api.world.Location;
import org.bukkit.Location;
import org.bukkit.Server;

/**
 *
 * @author Rhacoal
 */
public class PluginLocation_Bukkit implements PluginLocation {

    private final Location loc;
    
    public PluginLocation_Bukkit(Location loc) {
        this.loc=loc;
    }
    
    public PluginLocation_Bukkit(Server server, PluginLocation loc) {
        if(loc instanceof PluginLocation_Bukkit) {
            this.loc=((PluginLocation_Bukkit) loc).loc;
        } else {
            this.loc=new Location(server.getWorld(loc.getWorld().getUUID()),loc.getX(),loc.getY(),loc.getZ(),loc.getYaw(),loc.getPitch());
        }
    }
    
    @Override
    public double getX() {
        return getBukkitLocation().getX();
    }

    @Override
    public double getZ() {
        return getBukkitLocation().getZ();
    }

    @Override
    public double getY() {
        return getBukkitLocation().getY();
    }

    @Override
    public PluginWorld getWorld() {
        return new PluginWorld_Bukkit(getBukkitLocation().getWorld());
    }

    @Override
    public float getPitch() {
        return getBukkitLocation().getPitch();
    }

    @Override
    public float getYaw() {
        return getBukkitLocation().getYaw();
    }

    public Location getBukkitLocation() {
        return loc;
    }
    
}
