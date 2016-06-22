<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%@page import="com.keosys.dataGen.bussines.JoinUserPatient"%>
<%
    JoinUserPatient joinUserPatientBussines = new JoinUserPatient();
    com.keosys.dataGen.bean.JoinUserPatient joinUserPatientBean = new com.keosys.dataGen.bean.JoinUserPatient();
    Patient patientBussines = new Patient();

    String idAuthor = request.getParameter("author");
    try {
        joinUserPatientBean.setIdPatient(patientBussines.getLastPatient().getId());
        joinUserPatientBean.setUserId(Integer.valueOf(idAuthor));
        joinUserPatientBussines.insertUserPatient(joinUserPatientBean);
        out.print("SUCCES : La rélation entre patient-investigateur vient d'être inseré");
    } catch (Exception e) {
        out.print("ERREUR :  Il y a eu un erreur avec le tableau Join user patient");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
    }
%>