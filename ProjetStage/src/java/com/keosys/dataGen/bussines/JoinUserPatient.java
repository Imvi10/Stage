/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                           Join User Patient                    *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 20/06/2016                           *
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

public class JoinUserPatient {

    DBConnection connection = null;

    /**
     * Méthode qui permet d'insérer la rélation entre un utilisateur et un
     * patient dans le tableau joinUserPatient
     *
     * @param joinUserPatient
     * @throws SQLException
     */
    public void insertUserPatient(com.keosys.dataGen.bean.JoinUserPatient joinUserPatient) throws SQLException {
        connection = new DBConnection();
        connection.insertUserPatient(joinUserPatient);
    }

}
