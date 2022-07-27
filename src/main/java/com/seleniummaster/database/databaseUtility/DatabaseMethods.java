package com.seleniummaster.database.databaseUtility;

import com.seleniummaster.configutility.ApplicationConfig;
import com.seleniummaster.database.databaseUtility.ConnectionManager;
import com.seleniummaster.database.databaseUtility.ConnectionType;

import java.sql.Connection;

public class DatabaseMethods {

    Connection connection=null;

    final static String configFile="config.properties";

    public void databaseConnectionSetUp(){
        String dbUrl= ApplicationConfig.readFromConfigProperties(configFile,"dbUrl");
        String dbPort= ApplicationConfig.readFromConfigProperties(configFile,"dbPort");
        String defaultDatabase= ApplicationConfig.readFromConfigProperties(configFile,"defaultDatabase");
        String dbUserName= ApplicationConfig.readFromConfigProperties(configFile,"dbUserName");
        String dbPassword= ApplicationConfig.readFromConfigProperties(configFile,"dbPassword");
        connection= ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,dbUserName,dbPassword, ConnectionType.MYSQL);
    }

    public void closeDatabaseConnection(){
        ConnectionManager.closeDatabaseConnection(connection);
    }


}
