package com.seleniummaster.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //connect to database method

    public static Connection connectToDatabaseServer(String dbUrl,String dbPort,
                     String defaultDatabase,String dbUserName,String dbPassword,
                                                ConnectionType connectionType){
        //define a connection object
        Connection connection=null; //This is a connection interface
        String JTDS_Driver="net.sourceforge.jtds.jdbc.Driver";//mssql
        String MYSQL_Driver="com.mysql.cj.jdbc.Driver";//mysql

        switch (connectionType){
            case MSSQL:
                try {
                    Class.forName(JTDS_Driver); //initialize the SQL server driver(just like driver=new ChromeDriver)
                } catch (ClassNotFoundException e) {
                    new RuntimeException("Please check the sql driver information");
                }
                String connectionURL = "jdbc:jtds:sqlserver://" + dbUrl + ":" + dbPort + ";DataBaseName=" + defaultDatabase;
                try {
                    connection= DriverManager.getConnection(connectionURL,dbUserName,dbPassword);//(just like driver.get(connectionURL))
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MYSQL:
                try {
                    Class.forName(MYSQL_Driver).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String mySQLConnectionUrl="jdbc:mysql://"+dbUrl+":"+"/"+defaultDatabase+"?useSSL=false";
                try {
                    connection=DriverManager.getConnection(mySQLConnectionUrl,dbUserName,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("You need to specify a database connection type MSSQL or MYSQL");
        }

        try {
            if (!connection.isClosed()){
                System.out.println("Database connection is established!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //method to close the connection
    public static void closeDatabaseConnection(Connection connection){
        try {
            if (connection.isClosed()){
                System.out.println("Connection has already been closed!!");
            }
            else{
                connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
