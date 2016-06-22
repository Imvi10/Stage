/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           JoinUserPatient                      *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class JoinUserPatient {

    private int userId =0 ;
    private int idPatient = 0;
    private int version = 0;

    public JoinUserPatient() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
