/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.FeeDao;
import dao.RelationDao;
import entity.Fee;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eleena
 */
public class FeeController extends HttpServlet {

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
            out.println("<title>Servlet FeeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeeController at " + request.getContextPath() + "</h1>");
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

        if (uri.equals(cp + "/Admin/Fee/Pay")) {

            request.setAttribute("studentcourselist", RelationDao.selectAll());

            request.getRequestDispatcher("/admin/fee.jsp").forward(request, response);
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

        if (uri.equals(cp + "/Admin/Fee/Pay")) {
            Fee fee=new Fee();
            fee.setSc_id(Integer.parseInt(request.getParameter("student_course")));
            fee.setAmount(Double.parseDouble(request.getParameter("amount")));
//            fee.setDate(LocalDate.parse(request.getParameter("date")));
            fee.setDate(LocalDate.now());
            
            if(FeeDao.insert(fee)){
                response.sendRedirect(cp+"/Admin/Fee/Pay?Success");
            }else{
                response.sendRedirect(cp+"/Admin/Fee/Pay?Failures");
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
