/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Fee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eleena
 */
public class FeeDao {

    public static boolean insert(Fee fee) {
        boolean status = false;
        PreparedStatement ps = null;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "insert into fee_table(sc_id,amount,date) values(?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, fee.getSc_id());
                ps.setDouble(2, fee.getAmount());
                ps.setDate(3, Date.valueOf(fee.getDate()));
                if (ps.executeUpdate() > 0) {
                    status = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }

        }
        return status;
    }

    public static ArrayList<Fee> selectAll() {
        ArrayList<Fee> al = new ArrayList<>();
        Connection conn = DbConnection.connect();
        PreparedStatement ps = null;
        String sql = "select * from fee_table";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                al.add(new Fee(rs.getInt("fid"), rs.getInt("sc_id"), rs.getDouble("amount"), rs.getDate("date").toLocalDate()));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return al;
    }
}
