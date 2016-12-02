
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
        <li><a href="buysell.html">Buy/Sell</a></li>
        <li><a href="contact.html">Contact</a></li>
    </ul>
    <div class="signupright">
        <h1>Login</h1>
        <form action="login_check" method="post">
            <table>              
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="uid"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password"></td>
                </tr>
            </table>
            <input type="submit" value="Login">
        </form>
    </div>
    <a href='createAccount.html'>Create account here</a>
</body>
</html>