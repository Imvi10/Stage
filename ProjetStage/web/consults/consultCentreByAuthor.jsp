<%@page import="com.keosys.dataGen.bussines.Information"%>
<%
    Information informationBussines = new Information();
    com.keosys.dataGen.bean.Information lesInformations[];
    int idAuthor = Integer.valueOf(request.getParameter("author"));
    try {
        out.print("<option value='-1'>------</option>");
        lesInformations = informationBussines.getCentresByAuthor(idAuthor);
        for (com.keosys.dataGen.bean.Information uneInformation : lesInformations) {
            out.print("<option value='" + uneInformation.getVALUE() + "' > " + uneInformation.getVALUE() + "</option>");
        }
    } catch (Exception e) {
        out.print("ERREUR : Il y a eu un probleme avec la requête des centres .");
    }

%>