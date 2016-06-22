<%-- 
    Document   : LogOut
    Created on : 13 juin 2016, 13:57:03
    Author     : ivl
--%>

<%@page import="com.keosys.dataGen.bussines.DatabaseUtilities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        DatabaseUtilities db = new DatabaseUtilities();
        session.setAttribute("connected", Boolean.FALSE);
        db.closeConnection();

        response.sendRedirect("Connexion.jsp");
    %>
    <body>

    </body>
</html>
