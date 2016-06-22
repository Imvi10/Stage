<%-- 
    Document   : consultTypeVisit
    Created on : 5/06/2016, 05:08:20 PM
    Author     : Vi
--%>
<%@page import="com.keosys.dataGen.bussines.Visit" %>

<%
    com.keosys.dataGen.bussines.Visit typeVisitBussines = new com.keosys.dataGen.bussines.Visit();
    com.keosys.dataGen.bean.Visit[] lesTypesVisite;
    try {
        out.print("<option value='-1'>------</option>");
        lesTypesVisite = typeVisitBussines.getVisitsByCodePatient(request.getParameter("codePatient"));
        for (com.keosys.dataGen.bean.Visit unTypeVisite : lesTypesVisite) {
            out.print("<option value=" + unTypeVisite.getId() + " >" + unTypeVisite.getCode() + "</option>");
        }
    } catch (Exception e) {

        out.print("ERREUR : Il y a eu un probleme avec la requête des type de visite.");
        e.printStackTrace();
    }

%>

