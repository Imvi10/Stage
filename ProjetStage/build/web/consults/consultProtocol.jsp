<%-- 
    Document   : consultProtocol
    Created on : 6 juin 2016, 09:23:45
    Author     : ivl
--%>
<%@page import="com.keosys.dataGen.bussines.Protocol"%>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
%>
<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
    Protocol lesProtocols = null;
    lesProtocols = new Protocol();
    out.print("<option value='-1'>------</option>");
    for (com.keosys.dataGen.bean.Protocol protocol : lesProtocols.getProtocols()) {
        out.print("<option value=" + protocol.getId() + " >" + protocol.getCode() + "</option>");
    }
%>
