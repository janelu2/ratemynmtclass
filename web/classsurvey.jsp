<%-- 
    Document   : classsurvey
    Created on : Dec 7, 2016, 1:52:40 AM
    Author     : Rajat
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>
            Class Survey For: <%@page import = "java.sql.*" %>
            
         <% Class.forName("com.mysql.jdbc.Driver"); %>
         <% Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/class_db", "root", "d@rklight1"); %>
         <%  Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT course_title FROM classes ORDER BY course_title ASC LIMIT 1"); 
              while (rs.next()) { %>
                   <%out.print(rs.getString("course_title"));%>
                 <% }
         %> 
        </h1>
  
        <p>Average Difficulty: 
        <label>
            <input type="radio" name="editList" value="1"/>1
        </label>
        <label>
            <input type="radio" name="editList" value="2"/>2
        </label>
        <label>
            <input type="radio" name="editList" value="3"/>3
        </label> 
        <label>
            <input type="radio" name="editList" value="4"/>4
        </label> 
        <label>
            <input type="radio" name="editList" value="5"/>5
        </label> 
         <input type="button" value="Enter">
        </p>
        
        <p>Workload: 
        <label>
            <input type="radio" name="editList" value="1"/>1
        </label>
        <label>
            <input type="radio" name="editList" value="2"/>2
        </label>
        <label>
            <input type="radio" name="editList" value="3"/>3
        </label> 
        <label>
            <input type="radio" name="editList" value="4"/>4
        </label> 
        <label>
            <input type="radio" name="editList" value="5"/>5
        </label> 
            <input type="button" value="Enter">
        </p>
        
        <p>Time Spent (in hours) Weekly: 
        <label>
            <input type="radio" name="editList" value="1"/>1
        </label>
        <label>
            <input type="radio" name="editList" value="2"/>2
        </label>
        <label>
            <input type="radio" name="editList" value="3"/>3
        </label> 
        <label>
            <input type="radio" name="editList" value="4"/>4
        </label> 
        <label>
            <input type="radio" name="editList" value="5"/>5
        </label> 
            <input type="button" value="Enter">
        </p>
    </body>
    <h3>Favorite Aspect</h3>
    <input type="checkbox" name="aspect" value="aspect1">Interesting Content<br>
    <input type="checkbox" name="aspect" value="aspect2">Interesting Assignments<br>
    <input type="checkbox" name="aspect" value="aspect3">Help Available Outside of Class<br>   
    <h3>Other Comments</h3>
    Title: <input type="text" name="title"><br><br>
    Comment: <br> <textarea rows="4" cols="50">

    </textarea> <br>
    <input type="button" value="Submit">
</html>

