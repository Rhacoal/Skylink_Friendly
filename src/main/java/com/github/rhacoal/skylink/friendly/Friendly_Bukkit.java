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
package com.github.rhacoal.skylink.friendly;

import com.github.rhacoal.skylink.friendly.Friendly;
import com.github.rhacoal.skylink.plug.bukkit.PluginServer_Bukkit;
import com.github.rhacoal.skylink.plug.PluginServer;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Rhacoal
 */
public class Friendly_Bukkit extends JavaPlugin {
    
    private final Friendly friendly;
    private final PluginServer plugserver=new PluginServer_Bukkit(this.getServer());
    
    public Friendly_Bukkit(){
        friendly=plugserver.preparePlugin(Friendly.class);
    }
    
}
