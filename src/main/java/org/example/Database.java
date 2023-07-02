package org.example;

import org.example.models.User;

import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "19911994";


    private Connection connection;
    static boolean information = false;
    public Database() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

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
            Statement stmt = connection.createStatement();
           if(stmt.execute(query)){

           }else
               System.out.println("An error accord during operation");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public User loginGame(User user) {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT Username and Password from avatar WHERE Username = ? and Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return user;
            }
        } catch (Exception exception) {

        }
        return null;
    }

    public void registerGame(User user) {
    }

}
