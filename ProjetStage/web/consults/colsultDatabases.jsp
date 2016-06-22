<%-- 
    Document   : modifFiles
    Created on : 6 juin 2016, 11:01:16
    Author     : ivl
--%>

<%@page import="com.keosys.dataGen.bussines.DatabaseUtilities"%>
<%
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
        out.print("ERREUR : La connexion ver la base de données a échoué il faut vérifier les données de connexion");
    }


%>