/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CourseDao;
import entity.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eleena
 */
public class CourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        String cp = request.getContextPath();

        if (uri.equals(cp + "/Admin/Course/Add")) {
            RequestDispatcher rd = request.getRequestDispatcher("/admin/addcourse.jsp");
            rd.forward(request, response);
        } else if (uri.equals(cp + "/Admin/Course/Display")) {
            ArrayList<Course> al = CourseDao.selectAll();
            if (al != null) {
                request.setAttribute("courselist", al);
                if (request.getParameter("DeleteFailure") != null) {
                    request.setAttribute("message", "Delete failed");
                }
            } else {
                request.setAttribute("message", "Database connection failed");
            }

            request.getRequestDispatcher("/admin/displaycourse.jsp").forward(request, response);
        } else if (uri.equals(cp + "/Admin/Course/Edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Course b = CourseDao.selectById(id);
            if (b != null) {
                request.setAttribute("coursedata", b);

            } else {
                request.setAttribute("message", "Course not found");
            }
            request.getRequestDispatcher("/admin/editcourse.jsp").forward(request, response);

        } else if (uri.equals(cp + "/Admin/Course/Delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (CourseDao.delete(id)) {
                response.sendRedirect(cp + "/Admin/Course/Display");
            } else {
                response.sendRedirect(cp + "/Admin/Course/Display?DeleteFailure");

            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String cp = request.getContextPath();

        if (uri.equals(cp + "/Admin/Course/Add")) {

            Course cm = new Course();
            cm.setTitle(request.getParameter("c_title"));
            cm.setPrice(Double.parseDouble(request.getParameter("c_price")));
            cm.setDuration(request.getParameter("c_duration"));

            if (CourseDao.insert(cm)) {
                response.sendRedirect(cp + "/Admin/Course/Add");
            } else {
                request.setAttribute("status", "Record insertion failed!");
                request.getRequestDispatcher("/admin/addcourse.jsp").forward(request, response);
            }

        } else if (uri.equals(cp + "/Admin/Course/Update")) {
            Course c = new Course(
                    Integer.parseInt(request.getParameter("c_id")),
                    request.getParameter("c_title"),
                    Double.parseDouble(request.getParameter("c_price")),
                    request.getParameter("c_duration")
            );

            if (CourseDao.update(c)) {
                response.sendRedirect(cp + "/Admin/Course/Display");

            } else {
                request.setAttribute("message", "Update failed");
                request.getRequestDispatcher("/admin/editcourse.jsp").forward(request, response);
            }

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
