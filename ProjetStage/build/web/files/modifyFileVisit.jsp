<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Visit"%>
<%

    Visit visitBussines = new Visit();
    String idPatient = request.getParameter("idPatient");
    String idTypeVisit = (request.getParameter("idTypeVisit"));
    String codeTypeVisite = (request.getParameter("codeTypeVisit"));
    try {
        if (visitBussines.modifyVisitFile(codeTypeVisite, idTypeVisit, idPatient)) {
            out.print("SUCCES : Le fichier a été modifié ");
        }
    } catch (Exception e) {
         out.print("ERREUR : Le fichier visit.properties n'a pas été trouvé ");
             Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, e);
             Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, "Fichier Imagys/properties/visit.properties not found ");

    }
%>