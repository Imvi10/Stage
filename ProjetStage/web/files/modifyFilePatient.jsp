<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%
    String idAuthor = request.getParameter("author");
    String codePatient = request.getParameter("codePatient");
    String idProtocol = (request.getParameter("idProtocol"));
    Patient patientBussines = new Patient();

    try {
        if (patientBussines.modifyFile(idAuthor, codePatient, idProtocol)) {
            out.print("SUCCES : Le fichier a été modifié ");
        }
    } catch (Exception e) {
        out.print("ERREUR : Le fichier patient.properties n'a pas été trouvé ");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "Fichier Imagys/properties/patient.properties not found ");
    }
%>