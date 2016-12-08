<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
<link rel="stylesheet" type="text/css" href="deptstyle.css">
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
   <body> 
        <table class="fixed">
            <form action='<%=request.getContextPath()%>/showclass' method="post"> 
                <tr><td><input type="submit"> click here for class listing </td></tr>
            </form>
        </table>
    </body>
</html>
