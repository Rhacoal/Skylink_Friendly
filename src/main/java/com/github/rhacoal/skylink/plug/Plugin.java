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

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
public abstract class Plugin {
    
    private String name, version, description;
    private PluginServer server;
    
    public void initPlugin(String name, String version, String description, PluginServer server){
        this.name=name;
        this.version=version;
        this.description=description;
        this.server=server;
    }
    
    public PluginInfo getInfo(){
        return new PluginInfo();
    }
    
    public Logger getLogger(){
        return server.getLogger(this);
    }
    
    public String getDataFolder(){
        return server.getPluginDataFolder(this);
    }
    
    public class PluginInfo{
        
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
