<%-- 
    Document   : arithmeticcalculator
    Created on : Jan 18, 2020, 6:21:53 PM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Part 2</h1>
        <br>
        <h1>Arithmetic Calculator</h1>
        <form method="GET">
            First: <input type="text" name="first"><br>
            Second: <input type="text" name="second"><br>
            <button type="submit" name="add" value="add">+</button>
            <button type="submit" name="sub" value="sub">-</button>
            <button type="submit" name="mul" value="mul">*</button>
            <button type="submit" name="div"  value="div">%</button>
        </form>  

        ${message}



        <br>
        <a href="/Week2Lab_Calculators/age" >Age Calculator</a>


        <br>
        ${guestcount}
    </body>
</html>
