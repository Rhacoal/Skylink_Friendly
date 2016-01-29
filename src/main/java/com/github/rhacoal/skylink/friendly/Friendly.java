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

import com.github.rhacoal.skylink.plug.Plugin;
import com.github.rhacoal.skylink.plug.PluginServer;
import com.github.rhacoal.skylink.plug.PluginTools;
import com.github.rhacoal.skylink.plug.SQLConnector;
import com.github.rhacoal.skylink.plug.SkylinkPlugin;
import java.io.File;
import java.util.Properties;

/**
 *
 * @author Rhacoal
 */
@SkylinkPlugin(name="Skylink Friendly",version="",description="")
public class Friendly extends Plugin {
    
    private SQLConnector sqlc;
    private Properties prop;
    private static final Properties defaultprop;
    private File config_file;
    
    static{
        Properties prop=new Properties();
        prop.setProperty("MySQL_url", "jdbc:mysql://127.0.0.1:3306");
        prop.setProperty("user", "root");
        prop.setProperty("password", "");
        prop.setProperty("database", "db");
        prop.setProperty("prefix", "friendly_");
        defaultprop=prop;
    }
    
    @Override
    public void initPlugin(String name, String version, String description, PluginServer server){
        super.initPlugin(name, version, description, server);
        config_file=new File(getDataFolder()+"/config.txt");
    }
    
    public void load() {
        if (config_file.exists()) {
            loadConfiguration();
        } else {
            loadDefaultConfiguration();
        }
    }
    
    public void enable() {
        
    }
    
    public void disable() {
        
    }
    
    public void unload() {
        
    }
    
    public void loadConfiguration(){
        prop=PluginTools.loadProperties(getDataFolder()+"/config.txt");
    }
    
    public void loadDefaultConfiguration(){
        this.prop=(Properties)defaultprop.clone();
    }
    
}
