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
import com.github.rhacoal.skylink.plug.SQLConnector;
import com.github.rhacoal.skylink.plug.SkylinkPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
@SkylinkPlugin(name="Skylink Friendly",version="",description="")
public class Friendly extends Plugin {
    
    private SQLConnector sqlc;
    private Properties prop;
    
    public void load() {
        File file=new File(getDataFolder()+"/config");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                getLogger().warning("Failed to create configuration file");
            }
        } else if (file.isDirectory()) {
            if (!file.delete()) {
                
            }
        }
        try {
            prop.load(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }
    }
    
    public void enable() {
        
    }
    
    public void disable() {
        
    }
    
    public void unload() {
        
    }
    
}
