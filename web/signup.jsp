
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="deptstyle.css">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
</head>
<body>
    <ul>
        <li><a class="active" href="index.html">Home</a></li>
        <li><a href="depts.html">Department/Classes</a></li>
        <li><a href="login.html">Login/Sign Up</a></li>
        <li><a href="buysell.jsp">Buy/Sell</a></li>
        <li><a href="contact.html">Contact</a></li>
    </ul>
    <div class="signupleft">
        <h1>Sign Up</h1>
        <form action="registration" method="post">
            <table>
                <%String uid=request.getParameter("uid");%>
                <%String password1=request.getParameter("password1");%>
                <%String password2=request.getParameter("password2");%>

                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="uid"></td>
                    </tr>
                    <tr>
                        <td>NMT Email: </td>
                        <td> <input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="text" name="password1"></td>
                    </tr>
                    <tr>
                        <td>Retype Password: </td>
                        <td><input type="text" name="password2"></td>
                    </tr>
            </table>
            <input type="submit" value="Sign Up">
        </form>
    </div>
</body>
</html>