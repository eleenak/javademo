/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.StudentDao;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eleena
 */
public class StudentController extends HttpServlet {

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
            out.println("<title>Servlet StudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentController at " + request.getContextPath() + "</h1>");
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

        if (uri.equals(cp + "/Admin/Student/Add")) {
            if (request.getParameter("FailureToAdd") != null) {
                request.setAttribute("message", "Student insertion failed");
            } else if (request.getParameter("DeleteFailure") != null) {
                request.setAttribute("message", "Student deletion failed");
            }

            request.setAttribute("studentlist", StudentDao.selectAll());
            request.getRequestDispatcher("/admin/student.jsp").forward(request, response);
        } else if (uri.equals(cp + "/Admin/Student/Delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (StudentDao.delete(id)) {
                response.sendRedirect(cp + "/Admin/Student/Add");
            } else {
                response.sendRedirect(cp + "/Admin/Student/Add?DeleteFailure");

            }
        } else if (uri.equals(cp + "/Admin/Student/Edit")) {
            int id = Integer.parseInt(request.getParameter("id"));//req ma String ma aucha
            Student student = new Student();
            student = StudentDao.selectById(id);

            if (student.getId() == 0) {
                request.setAttribute("message", "Record not found");
            }

            request.setAttribute("student", student);
            request.setAttribute("studentlist", StudentDao.selectAll());
            request.getRequestDispatcher("/admin/student.jsp").forward(request, response);

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

        if (uri.equals(cp + "/Admin/Student/Add")) {
            
            Student s = new Student();
            if(request.getParameter("sid")!=null){
                s.setId(Integer.parseInt(request.getParameter("sid")));
            }
            s.setName(request.getParameter("sname"));
            s.setPhone(Long.parseLong(request.getParameter("sphone")));
            s.setAddress(request.getParameter("saddress"));
            s.setGender(request.getParameter("sgender"));
            s.setInterest(Arrays.toString(request.getParameterValues("sinterest")));

            if (StudentDao.insert(s)) {
                response.sendRedirect(cp + "/Admin/Student/Add");
            } else {
                response.sendRedirect(cp + "/Admin/Student/Add?FailureToAdd");
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
