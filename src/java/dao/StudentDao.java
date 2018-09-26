/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eleena
 */
public class StudentDao {

    public static boolean insert(Student student) {
        boolean status = false;
        Connection conn = DbConnection.connect();
        String sql;
        if (conn != null) {
            if (student.getId() == 0) {
                sql = "insert into student_table(name,phone,address,gender,interest) values(?,?,?,?,?)";
            } else {
                sql = "update student_table set name=?,phone=?,address=?,gender=?,interest=? where id=? ";
            }

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setLong(2, student.getPhone());
                ps.setString(3, student.getAddress());
                ps.setString(4, student.getGender());
                ps.setString(5, student.getInterest());

                if (student.getId() > 0) {
                    ps.setInt(6, student.getId());
                }

                if (ps.executeUpdate() > 0) {
                    System.out.println("Record inserted");
                    status = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }

        return status;
    }

    public static ArrayList<Student> selectAll() {
        ArrayList<Student> al = new ArrayList();
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "select id,name,phone,address,gender,interest from student_table";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    al.add(new Student(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getLong(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    ));

                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {

                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } else {
            System.out.println("connection not available");
        }

        return al;
    }

    public static Student selectById(int id) {
        Student s = null;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "select * from student_table where id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    s = new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getLong("phone"),
                            rs.getString("address"),
                            rs.getString("gender"),
                            rs.getString("interest")
                    );
                }
            } catch (SQLException se) {
                System.out.println(se);
            } finally {

                try {
                    conn.close();
                } catch (SQLException se) {
                    System.out.println(se);
                }

            }
        }
        return s;
    }

    public static boolean delete(int id) {
        boolean status = false;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "delete from student_table where id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    status = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {

                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }

            }

        }
        return status;
    }
}
