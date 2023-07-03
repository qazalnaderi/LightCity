package org.example;

import org.example.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    static String DB_URL = "jdbc:mysql://localhost:3306/lightcity";
    static String USER = "root";
    static String PASS = "19911994";

    static Color blue1 = new Color(190, 190, 220, 255);
    static Color blue2 = new Color(148, 192, 210, 255);
    static Color blue3 = new Color(218, 228, 246);
    static Color blue4 = new Color(4, 34, 80, 240);
    static Color blue5 = new Color(186, 209, 245, 240);
    static Color white1 = new Color(231, 233, 238, 255);
    static Color white2 = new Color(252, 250, 250, 255);
    static Color white3 = new Color(229, 246, 250, 255);


    static Font font1 = new Font("SansSerif", 2, 18);
    static Font font2 = new Font("Serif", 1, 15);
    static Font font3 = new Font("Serif", 1, 25);
    static Font font5 = new Font("Serif", 1, 20);
    static Font font6 = new Font("Serif", 1, 17);
    static Font font7 = new Font("Serif", 1, 20);
    static Font font8 = new Font("SansSerif", 1, 20);
    static Font font9 = new Font("SansSerif", 2, 20);

    private static Game game = new Game();
    private static Scanner scanner = new Scanner(System.in);
    public static void showMenu(){
        mainMenu();
    }
    public static void mainMenu(){
        JFrame frame = new JFrame("Menu");
        frame.setBounds(50,50,750,500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(blue4);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\user\\Desktop\\project\\LightCity\\data\\background.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(300,0,450,500);
        frame.add(imageLabel);

        JButton Continue = new JButton(new AbstractAction("Continue") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                loginMenu();
            }
        });
        Continue.setBounds(15,85,270,45);
        Continue.setBackground(blue3);
        Continue.setFont(font3);
        frame.add(Continue);

        JButton New = new JButton(new AbstractAction("Start New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                signUpMenu();
            }
        });
        New.setBounds(15,160,270,45);
        New.setBackground(blue3);
        New.setFont(font3);
        frame.add(New);

        JButton Join = new JButton(new AbstractAction("Join Server") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                joinServer();
            }
        });
        Join.setBounds(15,235,270,45);
        Join.setBackground(blue3);
        Join.setFont(font3);
        frame.add(Join);

        JButton Exit = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                JFrame frame1 = new JFrame("");
                frame1.setBounds(220,200,400,200);
                frame1.getContentPane().setBackground(white2);
                frame1.setLayout(null);

                JLabel label = new JLabel("  Are you sure you want to exit ?");
                label.setBounds(60,20,350,40);
                label.setBackground(white2);
                label.setFont(font5);
                frame1.add(label);

                JButton button = new JButton(new AbstractAction("cancel") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();

                        mainMenu();
                    }
                });
                button.setBounds(70,110,120,35);
                button.setBackground(white3);
                button.setFont(font8);
                frame1.add(button);
                JButton button1 = new JButton(new AbstractAction("exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                button1.setBounds(220,110,120,35);
                button1.setBackground(white3);
                button1.setFont(font8);
                frame1.add(button1);

                frame1.setVisible(true);
            }
        });
        Exit.setBounds(15,310,270,45);
        Exit.setBackground(blue3);
        Exit.setFont(font3);
        frame.add(Exit);

        frame.setVisible(true);
    }

    public static User loginMenu(){
        JFrame frame1 = new JFrame("Login");
        frame1.setBounds(220,140,400,350);
        frame1.getContentPane().setBackground(blue5);
        frame1.setLayout(null);

        JLabel label1 = new JLabel("unsername :");
        label1.setBounds(10,60,200,40);
        label1.setBackground(white2);
        label1.setFont(font5);
        frame1.add(label1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(125,70,250,30);
        frame1.add(txt1);

        JLabel label2 = new JLabel("password :");
        label2.setBounds(10,135,350,40);
        label2.setBackground(white2);
        label2.setFont(font5);
        frame1.add(label2);

        JPasswordField txt2 = new JPasswordField();
        txt2.setBounds(115,145,260,30);
        frame1.add(txt2);

        JButton button1 = new JButton(new AbstractAction("login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();

                String username = txt1.getText();
                String pass = txt2.getText();

                if (username.length() < 4 || username.length() > 20) {
                    JFrame frame2 = new JFrame("");
                    frame2.setBounds(220, 140, 400, 350);
                    frame2.getContentPane().setBackground(white2);
                    frame2.setLayout(null);

                    JLabel label = new JLabel("Invalid Username !");
                    label.setBounds(110, 80, 350, 40);
                    label.setBackground(white2);
                    label.setFont(font8);
                    frame2.add(label);

                    JButton button = new JButton(new AbstractAction("try again") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();
                            loginMenu();
                        }
                    });
                    button.setBounds(120, 220, 150, 35);
                    button.setBackground(white3);
                    button.setFont(font6);
                    frame2.add(button);

                    frame2.setVisible(true);
                } else if (pass.length() < 7 || pass.length() > 12) {
                    JFrame frame2 = new JFrame("");
                    frame2.setBounds(220, 140, 400, 350);
                    frame2.getContentPane().setBackground(white2);
                    frame2.setLayout(null);

                    JLabel label = new JLabel("Invalid Password !");
                    label.setBounds(110, 80, 350, 40);
                    label.setBackground(white2);
                    label.setFont(font8);
                    frame2.add(label);

                    JButton button = new JButton(new AbstractAction("try again") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();
                            loginMenu();
                        }
                    });
                    button.setBounds(120, 220, 150, 35);
                    button.setBackground(white3);
                    button.setFont(font6);
                    frame2.add(button);

                    frame2.setVisible(true);
                } else {
                    frame1.dispose();
                    pass = encryption(pass);
                    User user = new User(username,pass);
                    Database database = new Database();
//                    database.loginGame(user);
                    JFrame frame2;
                    if (database.loginGame(user)) {
                        frame2 = new JFrame("Signed in");
                        frame2.setBounds(220,140,400,350);
                        frame2.setLayout(null);

                        JLabel label = new JLabel("Successfully signed in");
                        label.setBounds(80, 80, 350, 40);
                        label.setBackground(Menu.white2);
                        label.setFont(Menu.font8);
                        frame2.add(label);

                        JButton button = new JButton(new AbstractAction("continue") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame2.dispose();

//                        Menu.game.continueGame(User );
//                        return user;
//                                makeUser(user);
                            }
                        });
                        button.setBounds(120, 220, 150, 35);
                        button.setBackground(Menu.white3);
                        button.setFont(Menu.font6);
                        frame2.add(button);

                    } else {
                        frame2 = new JFrame("error");
                        frame2.getContentPane().setBackground(Menu.white2);
                        frame2.setBounds(220, 140, 400, 350);
                        frame2.setLayout(null);

                        JLabel label = new JLabel("Invalid Information !");
                        label.setBounds(110, 80, 350, 40);
                        label.setBackground(Menu.white2);
                        label.setFont(Menu.font8);
                        frame2.add(label);

                        JButton button = new JButton(new AbstractAction("try again") {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame2.dispose();
                                Menu.loginMenu();
                            }
                        });
                        button.setBounds(120, 220, 150, 35);
                        button.setBackground(Menu.white3);
                        button.setFont(Menu.font6);
                        frame2.add(button);
                    }
                }
            }
        });
        button1.setBounds(220,255,130,35);
        button1.setBackground(white1);
        button1.setFont(font6);
        frame1.add(button1);

        JButton button2 = new JButton(new AbstractAction("cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                mainMenu();
            }
        });
        button2.setBounds(40,255,130,35);
        button2.setBackground(white1);
        button2.setFont(font6);
        frame1.add(button2);

        frame1.setVisible(true);

        return null;
    }

    public static void signUpMenu() {
        JFrame frame1 = new JFrame("Login");
        frame1.setBounds(220,140,400,350);
        frame1.getContentPane().setBackground(blue1);
        frame1.setLayout(null);

        JLabel label1 = new JLabel("unsername :");
        label1.setBounds(10,60,200,40);
        label1.setBackground(white2);
        label1.setFont(font5);
        frame1.add(label1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(125,70,250,30);
        frame1.add(txt1);

        JLabel label2 = new JLabel("password :");
        label2.setBounds(10,135,350,40);
        label2.setBackground(white2);
        label2.setFont(font5);
        frame1.add(label2);

        JTextField txt2 = new JTextField();
        txt2.setBounds(115,145,260,30);
        frame1.add(txt2);

        JButton button1 = new JButton(new AbstractAction("sign up") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();

                String username = txt1.getText();
                String pass = txt2.getText();

                if (username.length() < 4 || username.length() > 20){
                    JFrame frame2 = new JFrame("");
                    frame2.setBounds(220,140,400,350);
                    frame2.getContentPane().setBackground(white2);
                    frame2.setLayout(null);

                    JLabel label = new JLabel("Username must be");
                    label.setBounds(110,50,350,40);
                    label.setBackground(white2);
                    label.setFont(font8);
                    frame2.add(label);

                    JLabel label1 = new JLabel("between 4 and 20 characters");
                    label1.setBounds(60,110,350,40);
                    label1.setBackground(white2);
                    label1.setFont(font8);
                    frame2.add(label1);

                    JButton button = new JButton(new AbstractAction("try again") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();
                            signUpMenu();
                        }
                    });
                    button.setBounds(120,220,150,35);
                    button.setBackground(white3);
                    button.setFont(font6);
                    frame2.add(button);

                    frame2.setVisible(true);
                } else if (pass.length() < 7 || pass.length() > 12) {
                    JFrame frame2 = new JFrame("");
                    frame2.setBounds(220,140,400,350);
                    frame2.getContentPane().setBackground(white2);
                    frame2.setLayout(null);

                    JLabel label = new JLabel("Password must be");
                    label.setBounds(110,50,350,40);
                    label.setBackground(white2);
                    label.setFont(font8);
                    frame2.add(label);

                    JLabel label1 = new JLabel("between 8 and 12 characters");
                    label1.setBounds(60,110,350,40);
                    label1.setBackground(white2);
                    label1.setFont(font8);
                    frame2.add(label1);

                    JButton button = new JButton(new AbstractAction("try again") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();
                            signUpMenu();
                        }
                    });
                    button.setBounds(120,220,150,35);
                    button.setBackground(white3);
                    button.setFont(font6);
                    frame2.add(button);

                    frame2.setVisible(true);
                }else {
                    pass = encryption(pass);
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO avatar (Username , Password) VALUES (?,?)");
                        preparedStatement.setString(1,username);
                        preparedStatement.setString(2,pass);
                        preparedStatement.executeUpdate();
                        connection.close();
                    } catch (SQLException e1) {
                        throw new RuntimeException(e1);
                    }

                    JFrame frame2 = new JFrame("");
                    frame2.setBounds(220,190,400,300);
                    frame2.getContentPane().setBackground(white2);
                    frame2.setLayout(null);

                    JLabel label = new JLabel("Successfully signed up !");
                    label.setBounds(80,50,350,40);
                    label.setBackground(white2);
                    label.setFont(font8);
                    frame2.add(label);

                    JButton button = new JButton(new AbstractAction("continue") {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();

//                            Game
                        }
                    });
                    button.setBounds(120,220,150,35);
                    button.setBackground(white3);
                    button.setFont(font6);
                    frame2.add(button);

                    frame2.setVisible(true);
                }
            }
        });
        button1.setBounds(220,255,130,35);
        button1.setBackground(white1);
        button1.setFont(font6);
        frame1.add(button1);

        JButton button2 = new JButton(new AbstractAction("cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                mainMenu();
            }
        });
        button2.setBounds(40,255,130,35);
        button2.setBackground(white1);
        button2.setFont(font6);
        frame1.add(button2);

        frame1.setVisible(true);
    }

    private static void joinServer(){
        JFrame frame1 = new JFrame("Login");
        frame1.setBounds(220,140,400,350);
        frame1.getContentPane().setBackground(blue2);
        frame1.setLayout(null);

        JLabel label1 = new JLabel("Enter server IP address :");
        label1.setBounds(20,50,300,40);
        label1.setBackground(white2);
        label1.setFont(font5);
        frame1.add(label1);

        JTextField txt1 = new JTextField();
        txt1.setBounds(30,85,320,30);
        frame1.add(txt1);

        JLabel label2 = new JLabel("Enter server port :");
        label2.setBounds(20,130,350,40);
        label2.setBackground(white2);
        label2.setFont(font5);
        frame1.add(label2);

        JTextField txt2 = new JTextField();
        txt2.setBounds(30,165,320,30);
        frame1.add(txt2);

        JButton button1 = new JButton(new AbstractAction("join") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = txt1.getText();
                int port = Integer.parseInt(txt2.getText());

                game.joinServer(ip,port);
            }
        });
        button1.setBounds(220,255,130,35);
        button1.setBackground(white1);
        button1.setFont(font6);
        frame1.add(button1);

        JButton button2 = new JButton(new AbstractAction("cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                mainMenu();
            }
        });
        button2.setBounds(40,255,130,35);
        button2.setBackground(white1);
        button2.setFont(font6);
        frame1.add(button2);

        frame1.setVisible(true);
    }
    public static void main(String[] args) {
        showMenu();
    }

    public static String encryption(String pass) {
        String encryptedPassword = null;
        try
        {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(pass.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedPassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

}
