<%-- 
    Document   : modifFiles
    Created on : 6 juin 2016, 11:01:16
    Author     : ivl
--%>

<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.db.DBConnection"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.DatabaseUtilities"%>
<%
    DatabaseUtilities db = new DatabaseUtilities();
    String ipServer = request.getParameter("ipServer");
    String port = request.getParameter("port");
    String usr = request.getParameter("usr");
    String pswd = request.getParameter("pswd");
    String dbName = request.getParameter("db");

    try {
        if (db.modifyFile(ipServer, Integer.valueOf(port), usr, pswd, dbName)) {
            out.print("SUCCES : La base de données a été changé");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier 'imagys/util/database.properties' n'a pas été trouvé");
       Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Fichier Imagys/util/database.properties not found ");
    }
%>