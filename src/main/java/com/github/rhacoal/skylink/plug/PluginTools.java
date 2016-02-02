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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
public final class PluginTools {
    
    private static Logger getServerLogger() {
        return Logger.getLogger(com.github.rhacoal.skylink.plug.defaultimpl.AbstractPluginServer.FRAME_NAME);
    }
    
    public static File createFile(String fileName) throws SecurityException {
        return createFile(new File(fileName));
    }
    
    public static File createFile(File file) throws SecurityException {
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else if (file.exists()) {
                if (file.isDirectory()){
                    file.delete();
                    file.createNewFile();
                }
            }
        } catch(IOException ex) {
            getServerLogger().log(Level.WARNING, "Failed to create the file: {0}", file.getAbsolutePath());
            return null;
        }
        return file;
    }
    
    public static Properties loadProperties(String fileName) {
        return loadProperties(new File(fileName));
    }
    
    public static Properties loadProperties(File file) {
        Properties prop=null;
        if (!file.exists()) {
            createFile(file);
        }
        try (FileInputStream fis=new FileInputStream(file)) {
            prop=new Properties();
            prop.load(fis);
        } catch (FileNotFoundException ex) {//this should never happen
        } catch (IOException ex) {
            getServerLogger().log(Level.WARNING, "Failed to load properties from the file: {0}", file.getAbsolutePath());
        }
        return prop;
    }
    
    public static boolean storeProperties(Properties prop, String fileName, String comments) {
        return storeProperties(prop, new File(fileName), comments);
    }
    
    public static boolean storeProperties(Properties prop, File file, String comments) {
        createFile(file);
        try (FileOutputStream fos = new FileOutputStream(file)){
            prop.store(fos, comments);
        } catch (IOException e) {
            getServerLogger().log(Level.WARNING, "Failed to save properties to the file: {0}", file.getAbsolutePath());
            return false;
        }
        return true;
    }
            
}
