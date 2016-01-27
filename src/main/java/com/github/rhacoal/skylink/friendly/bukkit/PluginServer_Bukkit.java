/*
 * Copyright 2016 LeonZhou.
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

import com.github.rhacoal.skylink.friendly.plug.PluginServer;
import com.github.rhacoal.skylink.friendly.plug.SQLConnector;
import java.util.Properties;

/**
 *
 * @author LeonZhou
 */
public class PluginServer_Bukkit implements PluginServer {
    
    public PluginServer_Bukkit(){
        
    }

    @Override
    public Properties getProps() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SQLConnector getSQLConnector() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
