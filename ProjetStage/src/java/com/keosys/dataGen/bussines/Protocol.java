package com.keosys.dataGen.bussines;
/**
 * ***************************************************************************
 * Class Name                           Protocol                             *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à gérér les 
 *                                      insertions au tableau user patient
 *                                      qui est afait a chaque fois qu'un 
 *                                      utilisateur fait l'insertion 
 *                                      d'un patient
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

public class Protocol {

    com.keosys.dataGen.bean.Protocol lesProtocols[];
    com.keosys.dataGen.db.DBConnection connection;

    /**
     *
     * @return @returnl lesProtocols Tableau des Protocols pour monter dans
     * l'interface et pour associer les patients avec il.
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Protocol[] getProtocols() throws SQLException {
        connection = new DBConnection();
        return connection.getProtocols();
    }
}
