package user.register;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author latta
 */
public class registration extends HttpServlet {

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
            out.println("<title>Servlet registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registration at " + request.getContextPath() + "</h1>");
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

        String user = request.getParameter("uid");
        String pwd = request.getParameter("password1");
        String pwd2 = request.getParameter("password2");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("signup.jsp").include(request, response);

        if (email.indexOf('@') < 0) {
            out.print("<strong><p style=color:red;>Error: Invalid email<br></p></strong>");
        }

        String[] parsed_email = email.split("@");
        if (!parsed_email[1].equals("student.nmt.edu")) {
            out.print("<strong><p style=color:red;>Error: please use your student.nmt.edu email to register<br></p></strong>");
        }

        if (user.equals("") || pwd.equals("") || pwd2.equals("") || email.equals("") || !(pwd.equals(pwd2))) {
            out.print("<strong><p style=color:red;>Error: missing fields/Passwords don't match<br></p></strong>");
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "BlackCat13");
                Statement st = con.createStatement();
                //ResultSet rs;
                String command = "INSERT INTO users (username, password, email, privilege) VALUES ('" + user + "', ' " + pwd + "', '" + email + "', 0)";
                int i = st.executeUpdate(command);
                if (i > 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("userid", user);
                    response.sendRedirect("index.jsp");
                    // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
                } else {
                    response.sendRedirect("signup.jsp");
                }
            } catch (ClassNotFoundException | SQLException e) {
                //fuck
            
            String user = request.getParameter("uid");    
            String pwd = request.getParameter("password1");
            String pwd2 = request.getParameter("password2");
            String email = request.getParameter("email");
            
            response.setContentType("text/html");  
            PrintWriter out = response.getWriter();  
            request.getRequestDispatcher("signup.jsp").include(request, response);  
            
            if(user.equals("") || pwd.equals("") || pwd2.equals("") || email.equals("") || !(pwd.equals(pwd2))) {
                    out.print("<strong><p style=color:red;>Error: missing fields/Passwords don't match<br></p></strong>");
            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "d@rklight1");
                    Statement st = con.createStatement();
                    //ResultSet rs;
                    String command = "INSERT INTO users (username, password, email, privilege) VALUES ('" + user + "', ' " + pwd + "', '" + email +"', 0)";
                    int i = st.executeUpdate(command);
                    if (i > 0) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userid", user);
                        response.sendRedirect("index.jsp");
                        // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
                    } else {
                        response.sendRedirect("signup.jsp");
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    out.print("<strong><p style=color:red;>the fuck <br></p></strong>"); 
                }                
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
