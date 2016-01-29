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
package com.github.rhacoal.skylink.plug.defaultimpl;

import com.github.rhacoal.skylink.plug.Plugin;
import com.github.rhacoal.skylink.plug.PluginManager;
import com.github.rhacoal.skylink.plug.PluginServer;
import com.github.rhacoal.skylink.plug.SkylinkPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
public abstract class AbstractPluginServer implements PluginServer {
    
    public static final String LOGGER_NAME="Plugin Framework for Skylink";
    
    PluginManager pm=new DefaultPluginManager();

    @Override
    public String getPluginDataFolder(Plugin plugin) {
        return "/plugindata/"+plugin.getInfo().getName();
    }
    
    @Override
    public Logger getLogger() {
        return Logger.getLogger(LOGGER_NAME);
    }
    
    @Override
    public Logger getLogger(Plugin plugin) {
        return Logger.getLogger(plugin.getInfo().getName());
    }
    
    @Override
    public <T extends Plugin> T preparePlugin
    (Class<T> pluginClass) {
        try {
            T plugin=pluginClass.newInstance();
            SkylinkPlugin sp=pluginClass.getAnnotation(SkylinkPlugin.class);
            if (sp==null){
                getLogger().log(Level.SEVERE, "A plugin must have a SkylinkPlugin "
                        + "annotation!: {0}", plugin.getClass().getName());
                return null;
            }
            plugin.initPlugin(sp.name(),sp.version(),sp.description(),this);
            pm.registerPlugin(plugin);
            return plugin;
        } catch (InstantiationException ex) {
            getLogger().log(Level.SEVERE, "Load plugin {0} Failed! It must have a "
                    + "nullary constructor and not an abstract class or interface!", 
                    pluginClass.getName());
        } catch (IllegalAccessException ex) {
            getLogger().log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
