package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                                        TypePatient
 *
 *
 * @author                                           Ivan Emmanuel VILLEGAS LIRA
 * Date                                              20/06/2016
 *
 * @description                                      Cette classe sert à obtenir
 *                                                   les types de visite
 *                                                  existants selon le protocol
 * le protocol du patient
 *
 * @version 1.0.0 * *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

public class TypeVisit {

    /**
     * @since dbConnection
     */
    DBConnection connection ;

    /**
     *
     * @param codePatient Filtre pout obtenir les visites d'un patient via son
     * code de patient
     * @return tableau avec les types de visite qui existent
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.TypeVisit[] getTypesVisite(String codePatient) throws SQLException {
        connection = new DBConnection();
        return connection.getTypesVisit(codePatient);
    }
}
