<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="com.keosys.dataGen.bussines.Configuration"%>
<%
    Configuration configuration = new Configuration();
    String imagysRep = request.getParameter("imagysRep");

    if (configuration.existDescriptorsXML(imagysRep)) {
        if (configuration.existtDescriptorProperties(imagysRep)) {
            if (configuration.existResources(imagysRep)) {

                out.print("SUCCES : Tous les fichiers ont été bien localisés ");
            } else {
                out.print("ERREUR :  Le fichier 'Imagys/resources/descriptionSerie.csv' n'a pas été trouvé");
            }
        } else {
            out.print("ERREUR : Les fichiers :  \n 'Imagys/properties/patient.properties' \n'Imagys/properties/visit.properties' \n'Imagys/properties/serie.properties' \nn'ont pas été trouvés");
        }
    } else {
        out.print("ERREUR : Les fichiers : \n'Imagys/patient.xml' \n'Imagys/visit.xml' \n'Imagys/serie.xml' \n n'ont pas été trouvés");
    }
%>