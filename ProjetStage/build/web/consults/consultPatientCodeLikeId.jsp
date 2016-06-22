<%-- 
    Document   : consultTypeVisit
    Created on : 5/06/2016, 05:08:20 PM
    Author     : Vi
--%>
<%@page import="com.keosys.dataGen.bussines.Patient" %>



<%
    com.keosys.dataGen.bussines.Patient patientBussines = new com.keosys.dataGen.bussines.Patient();
    com.keosys.dataGen.bean.Patient[] lesPatients;
    int idUser = Integer.valueOf(request.getParameter("idAuthor"));
    try {
        
        lesPatients = patientBussines.getPatients(idUser);
        out.print("<option value='-1' >------ </option>");
        for (com.keosys.dataGen.bean.Patient unPatient : lesPatients) {
            out.print("<option id='"+unPatient.getId()+"' value='" + unPatient.getCode() + "' >" + unPatient.getCode() + "</option>");
        }
    } catch (Exception e) {

        out.print("ERREUR : Il y a eu un probleme avec la requête des utilisateurs.");
        e.printStackTrace();
    }

%>
