<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Serie"%>
<%@page import="com.keosys.dataGen.bussines.Information"%>
<%

    Information infoBussines = new Information();
    com.keosys.dataGen.bean.Information infoBean = new com.keosys.dataGen.bean.Information();
    Serie serieBussines = new Serie();
    String[] names = request.getParameterValues("nom[]");
    String[] values = request.getParameterValues("info[]");
    try {
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                if (!"".equals(values[i])) {
                    infoBean.setVALUE(values[i]);
                    infoBean.setFK_SERIE_MORE_INFOS_ID(serieBussines.getLastSerie().getId());
                    infoBean.setFK_TYPE_INFO_TYPE_ID(Integer.valueOf(names[i]));
                    infoBussines.insertInfoSerie(infoBean);
                }
            }
        }
        out.print("SUCCES : Les informations de la serie ont été insérés");
    } catch (Exception e) {
        out.print("ERREUR : Il y a eu un problème avec le tableau Information");
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, e);
        Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a un probmème avec le tableau Information ");
    }
%>