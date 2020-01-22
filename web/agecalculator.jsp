<%-- 
    Document   : agecalculator
    Created on : Jan 18, 2020, 6:05:52 PM
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
        <h1>Part 1 </h1>

        <h1>Age Calculator</h1>
        <form method="GET">
            Enter your age: <input type="text" name="yourAge" />
            <br />
            <button type="submit" >Age next  birthday</button>
        </form>
        <%--
        <%
            String str = (String) request.getAttribute("yourAge");
            if (str != null) {
                Integer num = Integer.parseInt(str);
                if (num >= 0) {
                    out.println("Your age birthday is :" + (num + 1));

                } else {
                    out.println("Your input is valid");
                }
            } else {
                out.println("You must give your current age");
            }
        %>
        --%>
        
        
        ${message}
        <a href="arithmeticcalculator.jsp" >Arithmetic Calculator</a>
        <br>
        
        ${guestcount}

    </body>
</html>
