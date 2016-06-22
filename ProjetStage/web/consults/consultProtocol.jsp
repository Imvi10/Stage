<%-- 
    Document   : consultProtocol
    Created on : 6 juin 2016, 09:23:45
    Author     : ivl
--%>
<%@page import="com.keosys.dataGen.bussines.Protocol"%>
<%
    Protocol lesProtocols = null;
    lesProtocols = new Protocol();
    out.print("<option value='-1'>------</option>");
    for (com.keosys.dataGen.bean.Protocol protocol : lesProtocols.getProtocols()) {
        out.print("<option value=" + protocol.getId() + " >" + protocol.getCode() + "</option>");
    }
%>
