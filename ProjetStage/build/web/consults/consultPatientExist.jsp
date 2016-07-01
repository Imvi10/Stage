<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>

<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%>
<%
    Patient patientBussines = new Patient();
    String codePatient = request.getParameter("codePatient");

    try {
        if (patientBussines.patientExist(codePatient).getCode()==null) {
            out.print("SUCCES : Le patient n'existait pas");
        }else{
            out.print("ERREUR : Le patient existe déjà");
        }
    } catch (Exception e) {
        out.print("Il y a eu un erreur avec le base de données");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
    }
%>