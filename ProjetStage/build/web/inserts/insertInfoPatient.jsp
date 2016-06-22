<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.bussines.Patient"%>
<%@page import="com.keosys.dataGen.bussines.Information"%>
<%

    Information infoBussines = new Information();
    com.keosys.dataGen.bean.Information infoBean = new com.keosys.dataGen.bean.Information();
    Patient patientBussines = new Patient();

    String[] names = request.getParameterValues("nom[]");
    String[] values = request.getParameterValues("info[]");
    String centre = request.getParameter("centre");
    int idAuthor = Integer.valueOf(request.getParameter("author"));

    try {
        if (names != null) {
            for (int i = 1; i < names.length; i++) {
                if (!"".equals(values[i])) {
                    infoBean.setFK_PATIENT_MORE_INFOS_ID(patientBussines.getLastPatient().getId());
                    infoBean.setFK_TYPE_INFO_TYPE_ID(Integer.valueOf(names[i]));
                    infoBean.setVALUE(values[i]);
                    infoBussines.insertInfoPatient(infoBean);
                }
            }
            if (infoBussines.getCentresByAuthor(idAuthor) != null) {
                if (!centre.equals("NoCentre")) {
                    infoBean.setFK_PATIENT_MORE_INFOS_ID(patientBussines.getLastPatient().getId());
                    infoBean.setFK_TYPE_INFO_TYPE_ID(Integer.valueOf(10));
                    infoBean.setVALUE(centre);
                    infoBussines.insertInfoPatient(infoBean);
                }
            }
        }
        out.print("SUCCES : Les information du patient ont été insérés");
    } catch (Exception e) {
        out.print("ERREUR : Il y a eu un problème avec le tableau 'Information' ");
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec le tableau 'Information' ");
    }
%>