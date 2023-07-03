package org.example;

import org.example.models.User;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "19911994";


    private Connection conn;

    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connecting to database...");
        } catch (Exception exp) {
            System.out.println("Database Exception : \n" + exp.toString());
            System.exit(0);
        }
    }
    //    Tables

    /**
     * Users
     */

    private void createTables() {
//        query example
        String query = "CREATE TABLE IF NOT EXISTS Users (username varchar(255) primary key ,password varchar(255));" +
                "CREATE TABLE IF NOT EXISTS ....";
        try {
            Statement stmt = conn.createStatement();
           if(stmt.execute(query)){

           }else
               System.out.println("An error accord during operation");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean loginGame(User user) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT Password from avatar WHERE Username = ? and Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (Exception exception) {
        }
        return false;
    }

    public void registerGame(User user) {
    }

}
