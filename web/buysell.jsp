<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="deptstyle.css">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <ul>
        <li><a class="active" href="index.html">Home</a></li>
        <li><a href="depts.html">Department/Classes</a></li>
        <li><a href="login.html">Login/Sign Up</a></li>
        <li><a href="buysell.html">Buy/Sell</a></li>
        <li><a href="contact.html">Contact</a></li>
    </ul>
    <h1>Buy/Sell Front Page</h1>
    <table class="fixed">
        <tr>
            <th>Post Title</th>
            <th>Author</th>
            <th>Class</th>
            <th>Date</th>
        </tr>
        <%@page import = "java.sql.*" %>
        <%                 
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "BlackCat13");
                Statement st = con.createStatement();
                ResultSet rs;
                rs = st.executeQuery("SELECT * FROM forum");
               while (rs.next()) { %>
                   <tr>
                        <td><a href="thread_page.jsp?id=<%out.println(rs.getString("threadid"));%>"><%out.println(rs.getString("title"));%></a></td>
                        <td><%out.println(rs.getString("author"));%></td>
                        <td><%out.println(rs.getString("class"));%></td>
                        <td><%out.println(rs.getString("timestamp"));%></td>
                    </tr> 
                <% } %>
    </table>
    <br>
        <%   
            if (session.getAttribute("userid") != null) {
                out.print("<h2>Submit New Post</h2>");  
                out.print("<form action=\"new_thread.jsp\">");
                out.print("<input type=\"submit\" value=\"Post\">");
                out.print("</form>");
        %>
        <%@include  file="some.html" %>
        <%      
            } else {
                out.print("Sign up or login to submit a post!");
            }
        %> 
</body>
</html>