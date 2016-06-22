<%-- 
    Document   : consultTypeIfno
    Created on : 6 juin 2016, 09:32:32
    Author     : ivl
--%>
<%@page import="com.keosys.dataGen.bussines.InfoType"%>
<%@page import="com.keosys.dataGen.util.Constants"%>
<%
    InfoType lesInfoTypes = null;
    lesInfoTypes = new InfoType();
    String table = request.getParameter("table");
    if ( 0!= lesInfoTypes.getInfoTypes(table).length) {
        out.print("<legend>Information "+ table +" </legend>");
        for (com.keosys.dataGen.bean.InfoType infoType : lesInfoTypes.getInfoTypes(table)) {
            if (infoType.getLabel().equals("Investigator centre")) {
                out.print("<div class='form-group'>");
                out.print(" <label class='col-md-4 control-label' for='Investigator centre'>" + infoType.getLabel() + "</label>");
                out.print("<div class='col-md-4'>");
                out.print("<select id='InvestigatorCentre' name='" + infoType.getLabel() + "'class='form-control'>");
                out.print("<option value='-1'>------</option>");
                out.print("</select>");
                out.print("</div>");
                out.print("</div>");
            } else {
                out.print("<div class='form-group'>");
                out.print(" <label class='col-md-4 control-label' for='txt" + infoType.getLabel() + "'>" + infoType.getLabel() + "</label>");
                out.print("<div class='col-md-4'>");
                out.print(" <input id='" + infoType.getId() + "' name='" + infoType.getLabel() + "' placeholder='" + infoType.getLabel() + "' class='form-control input-md' type='text'>");
                out.print("</div>");
                out.print("</div>");
            }
        }
    }

%>