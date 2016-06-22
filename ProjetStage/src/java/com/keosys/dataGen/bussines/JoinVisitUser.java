
package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                           Join User Patient                    *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à gérér les 
 *                                      insertions au tableau visit user
 *                                      qui est afait a chaque fois qu'un 
 *                                      utilisateur génére une visite
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

public class JoinVisitUser {

    DBConnection connection = null;

    /**
     *
     * Méthode qui permet d'insérer la rélation entre un utilisateur et un
     * patient dans le tableau joinUserVisit
     *
     * @param joinUserVisit
     * @throws SQLException
     */
    public void insertUserVisit(com.keosys.dataGen.bean.JoinVisitUser joinUserVisit) throws SQLException {
        connection = new DBConnection();
        connection.insertUserVisit(joinUserVisit);
    }

}
