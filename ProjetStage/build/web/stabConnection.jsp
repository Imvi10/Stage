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
        db.connectPersistence(ipServer, Integer.valueOf(port), usr, pswd, dbName);
        session.setAttribute("connected", Boolean.TRUE);
        out.print("SUCCES : La connection a été établié");
    } catch (Exception e) {
        out.print("ERREUR : Il a eu un problème avec la connection vers la base de données");
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "Error while conecting to the database");
    }


%>