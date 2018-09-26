/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eleena
 */
public class CourseDao {

    public static boolean insert(Course cm) {
        Connection conn = DbConnection.connect();
        boolean status = false;
        int count = 0;
        do {
            count++;

            if (conn != null) {
                String sql = "insert into course_table (title,price,duration) values(?,?,?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, cm.getTitle());
                    ps.setDouble(2, cm.getPrice());
                    ps.setString(3, cm.getDuration());
                    if (ps.executeUpdate() > 0) {
                        System.out.println("Record inserted");
                        status = true;
                    }
                } catch (Exception se) {
                    System.out.println(se);
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                }
                break;
            } else {
                DbConnection.connect();
            }
        } while (count < 5);
        return status;
    }

    public static ArrayList<Course> selectAll() {
        ArrayList<Course> al = null;
        Connection conn = DbConnection.connect();

        if (conn != null) {
            al = new ArrayList<>();
            try {
                String sql = "select * from course_table";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    al.add(new Course(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getDouble("price"),
                            rs.getString("duration")
                    ));
                }
            } catch (SQLException se) {
                System.out.println(se);
            } catch (Exception e) {
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

    public static Course selectById(int id) {
        Course c = null;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "select * from course_table where id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    c = new Course(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getDouble("price"),
                            rs.getString("duration")
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
        return c;
    }

    public static boolean update(Course c) {
        boolean status = false;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "update course_table set title=?,price=?,duration=? where id=?";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, c.getTitle());
                ps.setDouble(2, c.getPrice());
                ps.setString(3, c.getDuration());
                ps.setInt(4, c.getId());
                if (ps.executeUpdate() > 0) {
                    status = true;

                }
            } catch (SQLException se) {
                System.out.println(se);
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

    public static boolean delete(int id) {
        boolean status = false;
        Connection conn = DbConnection.connect();
        if (conn != null) {
            String sql = "delete from course_table where id=?";
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
