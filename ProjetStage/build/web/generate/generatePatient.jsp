<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%
    Patient patientBussines = new Patient();

    try {
        if (patientBussines.generate() == true) {
            out.print("SUCCES : Le patient vient d'être inséré");
        }else{
            out.print("ERREUR : Le fichier 'benerator.bat n'a pas été trouvé");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier 'benerator.bat n'a pas été trouvé");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "Fichier 'benerator.bat' not found ");
    }
%>