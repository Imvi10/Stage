package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                                     User
 *
 *
 * @author                                        Ivan Emmanuel VILLEGAS LIRA * 
 * Date                                           20/06/2016
 *
 * @description                                   Cette classe sert à obtenir 
 *                                                les utilisateurs associés à un
 *                                                protocol
 * @version 1.0.0 * *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;

public class User {

    DBConnection connection = new DBConnection();

    /**
     *
     * @param idProtocol
     * @return lesUtilisateurs Tableau des utilisateurs pour montrer dans
     * l'interface
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.User[] getUsers(int idProtocol) throws SQLException {
        return connection.getUsers(idProtocol);

    }
}
