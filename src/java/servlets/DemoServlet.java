/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eleena
 */
public class DemoServlet extends HttpServlet {

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
            out.println("<title>Servlet DemoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemoServlet at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher rd;
//        getRequestDispatcher is the method of HttpServletRequest interface
        if (uri.equals(cp+"/Home")) {
            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);//move to other path
        }else if(uri.equals(cp+"/About")){
            rd = request.getRequestDispatcher("/about.jsp");
            rd.forward(request, response);
        }else if(uri.equals(cp+"/Contact")){
            rd = request.getRequestDispatcher("/contact.jsp");
            rd.forward(request, response);
        }else if(uri.equals(cp+"/Services")){
            rd = request.getRequestDispatcher("/services.jsp");
            rd.forward(request, response);
        }else if(uri.equals(cp+"/Login")){
            rd = request.getRequestDispatcher("/admin/login.jsp");
            rd.forward(request, response);
        }else if(uri.equals(cp+"/PageNotFound")){
            rd = request.getRequestDispatcher("/pagenotfound.jsp");
            rd.forward(request, response);
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
