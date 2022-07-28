package com.seleniummaster.database.databaseUtility;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.net.CacheRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
    //write a method to get an information from database

    //get the new created store name to verify from database(Gvlmihre)
    public boolean getStoreName(String storeViewName, Connection connection) {
        boolean isStoreViewExist = false;
        Statement statement = null; //the new statement object window to write a query in it
        ResultSet resultSet = null; //the result after running the query
        CachedRowSet cachedRowSet = null; //save the result set to local

        //execute the query to see the result and save it to the cachedRowSet
        try {
            statement = connection.createStatement();
            String storeViewSqlScript = String.format("select code,name from i5751295_mg2.mg_core_store where name='%s'", storeViewName);
            resultSet = statement.executeQuery(storeViewSqlScript);
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //verify the result set
        if (resultSet == null) {
            System.out.println("No Records Found");

        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

                //count the record lines
                int count = 0;
                while (true) {
                    try {
                        if (!cachedRowSet.next()){
                            break;}

                    //get the results from cachedRowSet and print them to console
                    String storeName = cachedRowSet.getString("name");
                    String storeCode = cachedRowSet.getString("code");
                    System.out.println(String.format("storeName=%s,storeCode=%s", storeName, storeCode));
                    count = cachedRowSet.getRow();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            if (count >= 1)
                isStoreViewExist = true;
       }
        return isStoreViewExist;
    }
}