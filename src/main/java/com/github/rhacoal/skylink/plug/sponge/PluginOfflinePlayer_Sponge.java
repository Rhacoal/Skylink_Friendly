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

import com.github.rhacoal.skylink.plug.PluginOfflinePlayer;
import java.util.UUID;
import org.spongepowered.api.entity.living.player.User;

/**
 *
 * @author Rhacoal
 */
public class PluginOfflinePlayer_Sponge implements PluginOfflinePlayer {

    private User user;
    
    public PluginOfflinePlayer_Sponge(User user){
        this.user=user;
    }
    
    @Override
    public UUID getUUID() {
        return user.getUniqueId();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
