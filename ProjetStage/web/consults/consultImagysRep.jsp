<%@page import="com.keosys.dataGen.bussines.Configuration"%>
<%
    Configuration configuration = new Configuration();
    String imagysRep = request.getParameter("imagysRep");

    if (configuration.existImagysFolder(imagysRep)) {
        out.print("SUCCES : Le r�pertoire Imagys a �t� trouv�");
    } else {
        out.print("ERREUR : Le r�pertoire Imagys n'a pas �t� trouv�");
    }
%>
