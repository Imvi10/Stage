<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Serie"%>
<%
    Serie serieBussines = new Serie();
    try {
        if (serieBussines.generate() == true) {
            out.print("SUCCES : La serie vient d'être inséré");
        } else {
            out.print("ERREUR : Le fichier 'benerator.bat n'a pas été trouvé");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier 'benerator.bat n'a pas été trouvé");
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Fichier 'benerator.bat' not found ");
    }
%>