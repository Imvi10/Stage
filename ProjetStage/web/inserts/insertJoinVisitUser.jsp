<%-- 
    Document   : modifFiles
    Created on : 6 juin 2016, 11:01:16
    Author     : ivl
--%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.keosys.dataGen.bussines.Visit"%>
<%@page import="com.keosys.dataGen.bussines.JoinVisitUser"%>
<%
    JoinVisitUser joinVisitUserBussines = new JoinVisitUser();
    com.keosys.dataGen.bean.JoinVisitUser joinVisitUserBean = new com.keosys.dataGen.bean.JoinVisitUser();
    Visit visitBussines = new Visit();

    String idAuthor = request.getParameter("author");
    try {
        joinVisitUserBean.setUserId(Integer.valueOf(idAuthor));
        joinVisitUserBean.setVisitId(visitBussines.getLastVisit().getId());
        joinVisitUserBussines.insertUserVisit(joinVisitUserBean);
        out.print("SUCCES : La rélation visit-investigateur vient d'être inseré ");
    } catch (Exception e) {
        out.print("ERREUR : La relation entre visit et investigateur éxistait déjà");
        Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, e);
    }

%>