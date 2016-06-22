
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Visit"%>
<%@page import="com.keosys.dataGen.bussines.Information"%>
<%

    Information infoBussines = new Information();
    com.keosys.dataGen.bean.Information infoBean = new com.keosys.dataGen.bean.Information();
    Visit visitBussines = new Visit();
    String[] names = request.getParameterValues("nom[]");
    String[] values = request.getParameterValues("info[]");
    try {
        if (names != null) {
            for (int i = 1; i < names.length; i++) {
                if (!"".equals(values[i])) {
                    infoBean.setFK_VISIT_MORE_INFOS_ID(visitBussines.getLastVisit().getId());
                    infoBean.setFK_TYPE_INFO_TYPE_ID(Integer.valueOf(names[i]));
                    infoBean.setVALUE(values[i]);
                    infoBussines.insertInfoVisit(infoBean);
                }
            }
            out.print("SUCCES : Les informations de la visite ont été insérés");
        }else{
            out.print("SUCCES : Il n'avait pas informations à insérer");
        }
        
    } catch (Exception e) {
        out.print("ERROR : Il y a eu un erreur avec le tableau information");
        Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Visit.class.getName()).log(Level.SEVERE,"Il y a eu un problème avec le tableau Information");

    }
%>