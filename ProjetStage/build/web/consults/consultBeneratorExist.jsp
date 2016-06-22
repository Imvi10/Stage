<%@page import="com.keosys.dataGen.bussines.Configuration"%>
<%
    Configuration configuration = new Configuration();
    String beneratorPath = request.getParameter("beneratorPath");

    if (configuration.existBeneratorBat(beneratorPath)) {
        out.print("SUCCES : Le fichier benerator.bat a été localisé");
    } else {
        out.print("ERREUR : Le fichier benerator.bat n'a pas été localisé");
    }
%>