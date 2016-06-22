<%-- 
    Document   : modifyFileConfig
    Created on : 15 juin 2016, 14:45:47
    Author     : ivl
--%>
<%@page import="com.keosys.dataGen.bussines.Configuration"%>
<%
    Configuration configuration = new Configuration();
    String beneratorPath = request.getParameter("beneratorPath");
    String imagysRep = request.getParameter("imagysRep");

    if (configuration.modifyFile(beneratorPath, imagysRep)) {
        out.print("SUCCESS : La configuration a été changé ");
    } else {
        out.print("ERREUR : La configuration a échoué ");
    }


%>