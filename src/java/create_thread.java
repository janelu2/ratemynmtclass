/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author latta
 */
public class create_thread extends HttpServlet {

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
            out.println("<title>Servlet create_thread</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet create_thread at " + request.getContextPath() + "</h1>");
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

            String title = request.getParameter("title");
            String course = request.getParameter("course");
            String text = request.getParameter("text");
            String uid = request.getParameter("uid");
            
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            request.getRequestDispatcher("new_thread.jsp").include(request, response);  
            if(title.equals("") || course.equals("") || text.equals("")) {
                    out.print("<strong><p style=color:red;>Error: missing fields<br></p></strong>");
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "BlackCat13");
                    Statement st = con.createStatement();
                    String command = "INSERT INTO forum (title, author, class, deleted, summary) VALUES ('" + title + "', '" + uid + "', '" + course + "', 0, '" + text +"')";
                    st.executeUpdate(command);
                    ResultSet rs;
                    rs = st.executeQuery("SELECT * from forum ORDER BY threadid DESC LIMIT 1;");
                    rs.next();
                    response.sendRedirect("thread_page.jsp?id=" + rs.getString("threadid"));
                } catch (ClassNotFoundException | SQLException e) {
                    out.println(e);
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
