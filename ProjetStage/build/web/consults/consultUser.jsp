<%-- 
    Document   : consultTypeVisit
    Created on : 5/06/2016, 05:08:20 PM
    Author     : Vi
--%>
<%@page import="com.keosys.dataGen.bussines.User" %>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%>
<%
    com.keosys.dataGen.bussines.User userBussines = new com.keosys.dataGen.bussines.User();
    com.keosys.dataGen.bean.User[] lesUtilisateurs;
    
    int idProtocol = Integer.valueOf(request.getParameter("idProtocol"));
    try {
        out.print("<option value='-1'>------</option>");
        lesUtilisateurs = userBussines.getUsers(idProtocol);
        for (com.keosys.dataGen.bean.User unUtilisateur : lesUtilisateurs) {
            out.print("<option value=" + unUtilisateur.getId()+ " > " +unUtilisateur.getLogin()  + "</option>");
        }
    } catch (Exception e) {

        out.print("ERREUR : Il y a eu un probleme avec la requête des utilisateurs.");
        e.printStackTrace();
    }

%>