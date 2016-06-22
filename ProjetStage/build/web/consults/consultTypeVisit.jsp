<%-- 
    Document   : consultTypeVisit
    Created on : 5/06/2016, 05:08:20 PM
    Author     : Vi
--%>
<%@page import="com.keosys.dataGen.bussines.TypeVisit" %>
<%@page import="com.keosys.dataGen.bean.InfoType" %>


<%
    com.keosys.dataGen.bussines.TypeVisit typeVisitBussines = new com.keosys.dataGen.bussines.TypeVisit();
    com.keosys.dataGen.bean.TypeVisit[] lesTypesVisite;
    try {
        out.print("<option id='-1' value='-1' > ------ </option>");
        lesTypesVisite = typeVisitBussines.getTypesVisite(request.getParameter("codePatient"));
        for (com.keosys.dataGen.bean.TypeVisit unTypeVisite : lesTypesVisite) {
            out.print("<option id='"+ unTypeVisite.getName()+"' value='" + unTypeVisite.getId() + "' >" + unTypeVisite.getName() + "</option>");
        }
    } catch (Exception e) {

        out.print("ERREUR: Il y a eu un probleme avec la requête des type de visite.");
        e.printStackTrace();
    }

%>