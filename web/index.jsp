<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="homestyle.css">
    <head>
        <meta charset="UTF-8">
        <title>Home Page</title>    
    </head>
    <body>
        <p style="text-align: center;"><img src="nmtlogo.png" width="33%" height="auto"></p><br>
            <ul id="nav">
                <li><a class="active" href="#home">Home</a></li>
                <li><a href="depts.html">Department/Classes</a></li>
                <li><a href="login.html">Login/Sign Up</a></li>
                <li><a href="buysell.html">Buy/Sell</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        <br><br><br><br>
        <p align="center">Look up your class!<br><br><input type="search"><input type="button" value="Search"></p>
        <%   
            if (session.getAttribute("userid") != null) {
                String name=request.getParameter("userid");  
                out.print("Welcome "+name);  
            } else {
                out.print("Sign up today!");
            }
        %> 
    </body>
</html>