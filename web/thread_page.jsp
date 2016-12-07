
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
        <li><a href="buysell.jsp">Buy/Sell</a></li>
        <li><a href="contact.html">Contact</a></li>
    </ul>
    <%@page import = "java.sql.*" %>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "BlackCat13");
        Statement st = con.createStatement();
        ResultSet rs;
        rs = st.executeQuery("SELECT * FROM forum WHERE threadid = '" + request.getParameter("id") + "'");
        rs.next();
    %>
    <h1><%out.print(rs.getString("class") + ": " + rs.getString("title"));%></h1>
    <table class="response">
        <tr>
            <th>User</th>
            <th>Comment</th>
            <th>Date</th>
        </tr>
        <%
            ResultSet comments;
            comments = st.executeQuery("SELECT * FROM thread_responses WHERE threadid = '" + request.getParameter("id") + "'");
        while (comments.next()) {
        %>
            <tr>
                <td><%out.println(comments.getString("username"));%></td>
                <td><%out.println(comments.getString("response_body"));%></td>
                <td><%out.println(comments.getString("date"));%></td>
            </tr> 
        <% } %>
    </table>
    <br>
    <%
        if (session.getAttribute("userid") != null) {
            out.print("<form action=\"new_comment\" method=\"post\">");
            out.print("<h2>Add a comment:</h2>");
    %>
            <input type="hidden" value=<%out.println(session.getAttribute("userid"));%> name="uid" />
            <input type="hidden" value=<%out.println(request.getParameter("id"));%> name="threadid" />
            <input type="hidden" value=<%out.println((String)session.getAttribute("userid"));%> name="username" />

    <%
            out.print("<textarea name=\"comment\" rows=\"15\" cols=\"200\">Max 500 characters. Please make a new comment if your post is too long.</textarea>");
            out.print("<input type=\"submit\" value=\"Post\">");
            out.print("</form>");
    %>
    <br>
    <%@include  file="some.html" %>
    <%
        } else {
            out.print("Sign up or login to write a comment!");
        }
    %> 
</body>
</html>