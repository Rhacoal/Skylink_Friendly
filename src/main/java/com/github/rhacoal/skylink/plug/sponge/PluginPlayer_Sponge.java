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
package com.github.rhacoal.skylink.plug.sponge;

import com.github.rhacoal.skylink.plug.PluginLocation;
import com.github.rhacoal.skylink.plug.PluginPlayer;
import org.spongepowered.api.entity.living.player.Player;

/**
 *
 * @author Rhacoal
 */
public class PluginPlayer_Sponge extends PluginOfflinePlayer_Sponge implements PluginPlayer {

    private Player player;
    
    public PluginPlayer_Sponge(Player player) {
        super(player);
        this.player=player;
    }

    @Override
    public PluginLocation getLocation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void teleport(PluginLocation loc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getHealth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
