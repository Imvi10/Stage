<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Serie"%>
<%
    Serie serieBussines = new Serie();
    String idAuthor = request.getParameter("author");
    String visiteSerie = (request.getParameter("visiteSerie"));
    try {
        if (serieBussines.modifyFile(idAuthor, visiteSerie)) {
            out.print("SUCCES : Le fichier a �t� modifi� ");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier serie.properties n'a pas �t� trouv� ");
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Fichier Imagys/properties/patient.properties not found ");
    }
%>