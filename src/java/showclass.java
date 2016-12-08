/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import java.sql.*;

/**
 *
 * @author latta
 */
public class showclass extends HttpServlet {

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
            out.println("<title>Servlet login_check</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login_check at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
  
            PrintWriter out=response.getWriter();  
            
            try { 
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/class_db", "root", "d@rklight1");
                Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery("select * from classes");
                out.println("<table class=\"fixed\" border=1>");
                out.println("<tr>");
                out.println("<th>Course Title</th>");
                out.println("<th>Course Number</th>");
                out.println("<th>Level</th>");
                out.println("</tr>");
                while (rs.next()) {
                 String ct = rs.getString("course_title");
                 String cn = rs.getString("course_number");
                 String level = rs.getString("level"); 
                 out.println("<tr><td>" + ct + "</td><td>" + cn + "</td><td>" + level + "</td></tr>"); 
                }
                    out.println("</table>");
            } catch (ClassNotFoundException | SQLException e){
                out.print("<strong><p style=color:red;>the fuck <br></p></strong>"); 
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
