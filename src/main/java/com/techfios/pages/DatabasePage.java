package com.techfios.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;


import com.mysql.cj.*;

import com.mysql.cj.protocol.Resultset;

public class DatabasePage {
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    // String returnValue = "";
    LinkedHashMap<Integer, String[]> hashMap = new LinkedHashMap<Integer, String[]>();

    public LinkedHashMap<Integer, String[]> getData() {

        // setting properties
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //??
            String sqlUrl = "jdbc:mysql://127.0.0.1:3306/september2021"; //?
            String sqlUserName = "root";
            String sqlPassword = "root";
            String query = "select * from users;";

            // Creating connection to local database
            connection = DriverManager.getConnection(sqlUrl, sqlUserName, sqlPassword);

            // Empowering the connection reference variable to execute queries
            statement = connection.createStatement();

            // Delivering the query
            resultSet = statement.executeQuery(query);

            // Reading the data from resultSet
            int i = 1;
            while (resultSet.next()) { // reads next row
                String usernameValue = resultSet.getString("username"); // get value from row 0, column "username"
                String passwordValue = resultSet.getString("password"); // get value from row 0, column "password"
                System.out.println("row " + i + ": " + usernameValue + " -> " + passwordValue);

                // returnValue = usernameValue + " " + passwordValue;
                hashMap.put(i, new String[] { usernameValue, passwordValue });
                i++;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // return returnValue;
        return hashMap;
    }

}
