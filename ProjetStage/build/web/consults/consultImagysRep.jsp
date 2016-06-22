<%@page import="com.keosys.dataGen.bussines.Configuration"%>
<%
    Configuration configuration = new Configuration();
    String imagysRep = request.getParameter("imagysRep");

    if (configuration.existImagysFolder(imagysRep)) {
        out.print("SUCCES : Le répertoire Imagys a été trouvé");
    } else {
        out.print("ERREUR : Le répertoire Imagys n'a pas été trouvé");
    }
%>
