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
    <h1>New Post</h1>
    <form action="create_thread" method="post">
        <table>
            <tr>
                <td>Title: </td>
                <td><input type="text" name="title" size="200"></td>
            </tr>
            <tr>
                <td>Class: </td>
                <td> <input type="text" name="course"></td>
            </tr>
            <tr>
                <td>Text: </td>
                <td>
                    <textarea name="text" rows="30" cols="200">Max 500 characters. Please make a new comment if your post is too long.</textarea>
                </td>
            </tr>
        </table>
        <input type="hidden" value=<%out.println(session.getAttribute("userid"));%> name="uid" />
        <input type="submit" value="Post">
    </form>
</body>
</html>
