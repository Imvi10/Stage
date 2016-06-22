package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                           InfoType                             *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à gérér les status 
 *                                      des connexions vers la base de 
 *                                      données et aussi pour modifier
 *                                      le fichier database/properties dans 
 *                                      les resources externes du projet  le    
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

public class Information {

    DBConnection connection = new DBConnection();
    com.keosys.dataGen.bean.Information info = new com.keosys.dataGen.bean.Information();

    /**
     * @param informationPatient Insertion des informations des patients, il
     * recoive un objet de type informarion bean .Information @see
     * com.keosys.dataGen.bean.Information;
     * @throws SQLException
     */
    public void insertInfoPatient(com.keosys.dataGen.bean.Information informationPatient) throws SQLException {
        connection.insertInfoTypePatient(informationPatient);
    }

    /**
     * @param info Insertion des informations des Series, il re�oive un objet de
     * type bean.Information
     *
     * @throws SQLException Connection vers la base de donnees pas de risque
     * d'exception ici
     *
     */
    public void insertInfoSerie(com.keosys.dataGen.bean.Information info) throws SQLException {
        connection.insertInfoTypeSerie(info);
    }

    /**
     * métode pour réaliser une insertion dans le tableau information avec une
     * fk de visite et de le patient auquel la visite a été assigné
     *
     * @param information
     * @throws SQLException
     */

    public void insertInfoVisit(com.keosys.dataGen.bean.Information information) throws SQLException {
        connection.insertInfoTypeVisit(information);
    }

    /**
     * Méthode pour obtenir les centres qui aux quelles un utilisateur est
     * attache.
     *
     * @param idAuthor qui est saisie depuis le jsp Patient.jsp
     * @return
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Information[] getCentresByAuthor(int idAuthor) throws SQLException {
        return connection.getCentresByAuthor(idAuthor);
    }

}
