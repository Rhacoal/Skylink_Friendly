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
import com.github.rhacoal.skylink.plug.defaultimpl.MySQLConnector;
import java.io.File;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

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
        prop.setProperty("address", "127.0.0.1");
        prop.setProperty("port", "3306");
        prop.setProperty("addtional-connection-params", "?characterEncoding=UTF-8");
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
    
    @Override
    public void load() {
        if (config_file.exists()) {
            loadConfiguration();
        } else {
            loadDefaultConfiguration();
            PluginTools.storeProperties(prop, config_file, "default settings for Plugin Skylink");
        }
    }
    
    @Override
    public void enable() {
        String url = "jdbc:mysql://"+prop.getProperty("address","127.0.0.1")+":"+prop.getProperty("port","3306");
        String user = prop.getProperty("user","root");
        String password = prop.getProperty("password","");
        try {
            sqlc=MySQLConnector.connect(url, user, password);
        } catch (SQLException ex) {
            try {
                sqlc=MySQLConnector.connect(url, user, password);
            } catch(SQLException ex1) {
                getLogger().severe("Failed to handle sql exception(s)! Details:");
                do {
                    getLogger().log(Level.SEVERE, null, ex1.getMessage());
                } while((ex1=ex1.getNextException())!=null);
            }
        }
    }
    
    @Override
    public void disable() {
        try {
            sqlc.getConnection().close();
        } catch (SQLException ex) {
            getLogger().log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void unload() {
        
    }
    
    public void loadConfiguration(){
        prop=PluginTools.loadProperties(getDataFolder()+"/config.txt");
    }
    
    public void loadDefaultConfiguration(){
        this.prop=(Properties)defaultprop.clone();
    }
    
}
