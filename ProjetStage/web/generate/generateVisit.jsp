<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.bussines.Visit"%>
<%
    Visit visitBussines = new Visit();
    try {
        if (visitBussines.generate()) {
            out.print("SUCCES : La visite a �t� g�n�r�e");
        } else {
            out.print("ERREUR : Le fichier 'benerator.bat n'a pas �t� trouv�");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier 'benerator.bat n'a pas �t� trouv�");
        Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, "Fichier benerator.bat not found ");
    }
%>