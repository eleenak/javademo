/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.StudentCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eleena
 */
public class RelationDao {

    public static boolean insert(int sid, int cid) {
        boolean status = false;
        PreparedStatement ps = null;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "insert into student_course(sid,cid) values(?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, sid);
                ps.setInt(2, cid);
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

    public static ArrayList<StudentCourse> selectAll() {
        ArrayList<StudentCourse> al = new ArrayList<>();

        Connection conn = DbConnection.connect();
        PreparedStatement ps = null;

        if (conn != null) {
            String sql = "select sc.id,s.id,s.name,s.address,s.phone,c.id,c.title,c.duration from student_course as sc,student_table as s,course_table as c where sc.sid=s.id and sc.cid=c.id";
            try {
                ps = conn.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    al.add(new StudentCourse(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getLong(5),
                            rs.getString(4),//constructor order milaune at model entity
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8)
                    ));
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

        return al;
    }
}
