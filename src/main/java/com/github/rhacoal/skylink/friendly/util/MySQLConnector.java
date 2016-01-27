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
package com.github.rhacoal.skylink.friendly.util;

import com.github.rhacoal.skylink.friendly.plug.SQLConnector;
import com.github.rhacoal.skylink.friendly.plug.SQLWatchDog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rhacoal
 */
public class MySQLConnector extends SQLConnector {
    
    private SQLWatchDog wd;
    private String url,user,pass;private Properties info;
    private int login;
    
    public MySQLConnector(Connection conn) {
        super(conn);
    }
    
    public void reConnect(){
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="public static SQLConnector connect(...)">
    public static SQLConnector connect(String url) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url);
            MySQLConnector mys=new MySQLConnector(conn);
            mys.url=url;
            mys.login=0;
            return mys;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static SQLConnector connect(String url, Properties info) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, info);
            MySQLConnector mys=new MySQLConnector(conn);
            mys.url=url;
            mys.info=info;
            mys.login=1;
            return mys;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static SQLConnector connect(String url, String user, String password) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(url, user, password);
            MySQLConnector mys=new MySQLConnector(conn);
            mys.url=url;
            mys.user=user;
            mys.pass=password;
            mys.login=2;
            return mys;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    //</editor-fold>
    
}
