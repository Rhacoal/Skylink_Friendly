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
package com.github.rhacoal.skylink.plug;

import java.util.UUID;
import java.util.logging.Logger;


/**
 *
 * @author Rhacoal
 */
public interface PluginServer {
    
    public PluginPlayer[] getOnlinePlayers();
    
    public PluginPlayer getOnlinePlayer(String name);
    
    public PluginPlayer getOnlinePlayer(UUID uuid);
    
    public PluginOfflinePlayer getPlayer(String name);
    
    public PluginOfflinePlayer getPlayer(UUID uuid);
    
    public boolean isPlayerOnline(String name);
    
    public boolean isPlayerOnline(UUID uuid);
    
    public PluginWorld getWorld(String name);
    
    public PluginWorld getWorld(UUID uuid);
    
    public String getPluginDataFolder(Plugin plugin);
    
    public Logger getLogger();
    
    public Logger getLogger(Plugin plugin);
    
    public <T extends Plugin> T preparePlugin(Class<T> plugin);
    
}
