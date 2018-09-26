/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.UserDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eleena
 */
public class UserDetailsDao {

    public static boolean insert(UserDetail ud) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into user_detail(name,email,password,role,image) values(?,?,?,?,?)";
        try {
            conn = DbConnection.connect();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ud.getName());
            ps.setString(2, ud.getEmail());
            ps.setString(3, ud.getPassword());
            ps.setString(4, ud.getRole());
            ps.setString(5, ud.getImage());
            if (ps.executeUpdate() > 0) {
                status = true;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }

    public static UserDetail validateUser(UserDetail ud) {
        UserDetail validUser = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select uid from user_detail where email=? and password=?";
        try {
            conn = DbConnection.connect();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, ud.getEmail());
            ps.setString(2, ud.getPassword());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                validUser = new UserDetail();
                validUser.setId(rs.getInt("uid"));
//                validUser.setName(rs.getString("name"));
//                validUser.setEmail(rs.getString("email"));
//                validUser.setImage(rs.getString("image"));
System.out.println(validUser.getId());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return validUser;
    }
    
    
    public static UserDetail selectById(int id) {
        UserDetail validUser = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user_detail where uid=?";
        try {
            conn = DbConnection.connect();
            ps = conn.prepareStatement(sql);
            System.out.println("email");
            ps.setInt(1,id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                validUser = new UserDetail();
                validUser.setId(rs.getInt("uid"));
                validUser.setName(rs.getString("name"));
                validUser.setEmail(rs.getString("email"));
                validUser.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return validUser;
    }
    
}
