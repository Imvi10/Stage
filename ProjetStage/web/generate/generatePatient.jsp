<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%
    Patient patientBussines = new Patient();

    try {
        if (patientBussines.generate() == true) {
            out.print("SUCCES : Le patient vient d'�tre ins�r�");
        }else{
            out.print("ERREUR : Le fichier 'benerator.bat n'a pas �t� trouv�");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier 'benerator.bat n'a pas �t� trouv�");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "Fichier 'benerator.bat' not found ");
    }
%>