<%-- 
    Document   : modifFiles
    Created on : 6 juin 2016, 11:01:16
    Author     : ivl
--%>

<%@page import="com.keosys.dataGen.bussines.DatabaseUtilities"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
    
    
    DatabaseUtilities db = new DatabaseUtilities();
    String ipServer = request.getParameter("ipServer");
    String port = request.getParameter("port");
    String user = request.getParameter("usr");
    String pass = request.getParameter("pswd");

    if (db.isConnected(ipServer, Integer.valueOf(port), user, pass)) {
        String[] lesNames = db.getDatabases(ipServer, Integer.valueOf(port), user, pass);
        for (String nameDatabase : lesNames) {
            out.print("<option value=" + nameDatabase + " >" + nameDatabase + "</option>");
        }
    } else {
        out.print("ERREUR : La connexion ver la base de donn�es a �chou� il faut v�rifier les donn�es de connexion");
    }


%>