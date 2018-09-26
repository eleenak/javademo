/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.UserDetailsDao;
import entity.UserDetail;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.MD5Encrypt;

/**
 *
 * @author Eleena
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2mb 
        maxFileSize = 1024 * 1024 * 10,//10mb
        maxRequestSize = 1024 * 1024 * 50)//50mb
public class UserController extends HttpServlet {

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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

        if (uri.equals(cp + "/Admin/User/Register")) {
            if (request.getParameter("PasswordMismatch") != null) {
                request.setAttribute("msg", "Password and Confirm Password did not match");
            }
             request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
        }else if(uri.equals(cp + "/Admin/User/Details")){
            request.setAttribute("userinfo",UserDetailsDao.selectById(Integer.parseInt(request.getParameter("UID"))));
            request.getRequestDispatcher("/admin/userdetail.jsp").forward(request, response);
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
        if (uri.equals(cp + "/Admin/User/Register")) {
            UserDetail ud = new UserDetail();
//            confirm password fields
            if (request.getParameter("password").equals(request.getParameter("cpassword"))) {
                ud.setPassword(MD5Encrypt.crypt(request.getParameter("password")));
            } else {
                response.sendRedirect(cp + "/Admin/User/Register?PasswordMismatch");
            }
//            upload image files

            String savePath = request.getServletContext().getRealPath("/");
            File saveDir = new File(savePath + "user_image");
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            String fileName = null;
            for (Part part : request.getParts()) {
                if (part.getName().equals("image")) {
                    //actual file upload is done here
                    fileName = getImageName(part);
                    fileName = new File(fileName).getName();
                    part.write(saveDir+File.separator+fileName);
                    //upload complete 
                    ud.setImage(fileName);
                }
            }

            ud.setName(request.getParameter("name"));
            ud.setEmail(request.getParameter("email"));
            ud.setRole(request.getParameter("role"));

            if (UserDetailsDao.insert(ud)) {
                response.sendRedirect(cp + "/Login");
            } else {
                //if image has already been uploaded then delete image to reverse the process
                File deleteFile = new File(saveDir.getAbsolutePath() + File.separator + fileName);
                if (deleteFile.exists()) {
                    deleteFile.delete();
                }
                response.sendRedirect(cp + "/Admin/User/Register?Failed");
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

    private String getImageName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
