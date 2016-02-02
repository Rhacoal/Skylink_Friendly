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

import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
@SkylinkPlugin(name="Abstract Plugin", version="1.0.0", description="no description")
public abstract class Plugin {
    
    private String name, version, description;
    private PluginServer server;
    
    /**
     *To init a plugin.
     * Notice: This method must be called before the plugin is put in use.
     * If you want to rewrite it, make sure you've called the original method through super().initPlugin()
     * The name, version and description parameters should come from the plugin's "SkylinkPlugin" annotation
     * I know this is stupid. I'll try to change this soon.
     * @param name
     * @param version
     * @param description
     * @param server
     */
    public void initPlugin(String name, String version, String description, PluginServer server){
        this.name=name;
        this.version=version;
        this.description=description;
        this.server=server;
    }
    
    /**
     *Get some basic information about a plugin.
     * @return plugin's infomation: name, version, description
     */
    public final PluginInfo getInfo(){
        return new PluginInfo();
    }
    
    public final PluginServer getServer(){
        return server;
    }
    
    /**
     *Get the logger for the plugin.
     * This method is an equivalent to getServer().getLogger(this);
     * @return logger for this plugin
     */
    public final Logger getLogger(){
        return server.getLogger(this);
    }
    
    public final String getDataFolder(){
        return server.getPluginDataFolder(this);
    }
    
    public void load(){}
    
    public void enable(){}
    
    public void disable(){}
    
    public void unload(){}
    
    public final class PluginInfo{
        
        public String getName(){
            return name;
        }
        
        public String getVersion(){
            return version;
        }
        
        public String getDescription(){
            return description;
        }
        
    }
    
}
