package org.example;

import org.example.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/lightcity";

    // Database credentials
    static final String USER = "your_username";
    static final String PASS = "your_password";


    private Connection connection;

    public Database(String username , String password) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT Username and Password from WHERE Username = ? and Password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JFrame frame1 = new JFrame("Signed in");
                frame1.setBounds(220,140,400,350);
                frame1.setLayout(null);

                JLabel label = new JLabel("Successfully signed in");
                label.setBounds(100, 80, 350, 40);
                label.setBackground(Menu.white2);
                label.setFont(Menu.font8);
                frame1.add(label);

                JButton button = new JButton(new AbstractAction("continue") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();

//                        Menu.game.continueGame(User );
                    }
                });
                button.setBounds(120, 220, 150, 35);
                button.setBackground(Menu.white3);
                button.setFont(Menu.font6);
                frame1.add(button);

                frame1.setVisible(true);

            } else {
                JFrame frame1 = new JFrame("error");
                frame1.getContentPane().setBackground(Menu.white2);
                frame1.setBounds(220,140,400,350);
                frame1.setLayout(null);

                JLabel label = new JLabel("Invalid Password !");
                label.setBounds(110, 80, 350, 40);
                label.setBackground(Menu.white2);
                label.setFont(Menu.font8);
                frame1.add(label);

                JButton button = new JButton(new AbstractAction("try again") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        Menu.loginMenu();
                    }
                });
                button.setBounds(120, 220, 150, 35);
                button.setBackground(Menu.white3);
                button.setFont(Menu.font6);
                frame1.add(button);

                frame1.setVisible(true);
            }
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

    public void loginGame(User user) {
        try {
            Statement stmt = connection.createStatement();
            String query = "";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
//               Check
            }
        } catch (Exception exception) {
        }

    }

    public void registerGame(User user) {
    }

}
