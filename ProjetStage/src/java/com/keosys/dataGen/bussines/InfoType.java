package com.keosys.dataGen.bussines;

import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

/**
 * ***************************************************************************
 * Class Name                           InfoType                             *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à faire des 
 *                                      insertions vers le tableau 
 *                                      information et obtenir des 
 *                                      informations enregistres comme
 *                                      le centre investigation  
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class InfoType {

    com.keosys.dataGen.bean.InfoType[] lesInfoTypes = null;
    DBConnection dbConnection = null;

    /**
     *
     * @return Tableau de type InfoType avec les paramétres id,ENTITY_TYPE,
     * LABEL, NEEDED de toutes les type_info
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.InfoType[] getInfoTypes() throws SQLException {
        dbConnection = new DBConnection();
        return dbConnection.getTypesInfo();
    }

    /**
     *
     * @param table
     * @return Tableau de type InfoType avec les paramétres id,ENTITY_TYPE,
     * LABEL, NEEDED des info types rélationes avec le paramètre table qui est
     * le nom de la table dans la base de données
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.InfoType[] getInfoTypes(String table) throws SQLException {
        dbConnection = new DBConnection();
        return dbConnection.getTypesInfo(table);
    }
}
