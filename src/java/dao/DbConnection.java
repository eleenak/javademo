/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eleena
 */
public class DbConnection {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/webdemo";
    private static final String USER = "dbuser";
    private static final String PASSWORD = "dbpassword";

   
    public static Connection connect() {
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException se) {
            System.out.println(se);
            conn=null;
        }
        return conn;
    }

}
