/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * *****************************************************************************
 * Class Name                           Information                            *
 * @author                              Ivan Emmanuel VILLEGAS LIRA            *
 * Date                                 17/06/2016                             *
 * @version                             1.0.0                                  *
 *                                                                             *
 * *****************************************************************************
 */
public class Information {
    private int id = 0;
    private String VALUE = null;
    private int FK_TYPE_INFO_TYPE_ID = 0;
    private int FK_USER_MORE_INFOS_ID = 0;
    private int FK_PROTOCOL_MORE_INFOS_ID = 0;
    private int FK_PATIENT_MORE_INFOS_ID = 0;
    private int FK_VISIT_MORE_INFOS_ID = 0;
    private int FK_SERIE_MORE_INFOS_ID = 0;
    private int version = 0;

   
    public Information() {
    
    }
    
    @Override
    public String toString() {
        return VALUE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String vALUE) {
        VALUE = vALUE;
    }

    public int getFK_TYPE_INFO_TYPE_ID() {
        return FK_TYPE_INFO_TYPE_ID;
    }

    public void setFK_TYPE_INFO_TYPE_ID(int fK_TYPE_INFO_TYPE_ID) {
        FK_TYPE_INFO_TYPE_ID = fK_TYPE_INFO_TYPE_ID;
    }

    public int getFK_USER_MORE_INFOS_ID() {
        return FK_USER_MORE_INFOS_ID;
    }

    public void setFK_USER_MORE_INFOS_ID(int fK_USER_MORE_INFOS_ID) {
        FK_USER_MORE_INFOS_ID = fK_USER_MORE_INFOS_ID;
    }

    public int getFK_PROTOCOL_MORE_INFOS_ID() {
        return FK_PROTOCOL_MORE_INFOS_ID;
    }

    public void setFK_PROTOCOL_MORE_INFOS_ID(int fK_PROTOCOL_MORE_INFOS_ID) {
        FK_PROTOCOL_MORE_INFOS_ID = fK_PROTOCOL_MORE_INFOS_ID;
    }

    public int getFK_PATIENT_MORE_INFOS_ID() {
        return FK_PATIENT_MORE_INFOS_ID;
    }

    public void setFK_PATIENT_MORE_INFOS_ID(int fK_PATIENT_MORE_INFOS_ID) {
        FK_PATIENT_MORE_INFOS_ID = fK_PATIENT_MORE_INFOS_ID;
    }

    public int getFK_VISIT_MORE_INFOS_ID() {
        return FK_VISIT_MORE_INFOS_ID;
    }

    public void setFK_VISIT_MORE_INFOS_ID(int fK_VISIT_MORE_INFOS_ID) {
        FK_VISIT_MORE_INFOS_ID = fK_VISIT_MORE_INFOS_ID;
    }

    public int getFK_SERIE_MORE_INFOS_ID() {
        return FK_SERIE_MORE_INFOS_ID;
    }

    public void setFK_SERIE_MORE_INFOS_ID(int fK_SERIE_MORE_INFOS_ID) {
        FK_SERIE_MORE_INFOS_ID = fK_SERIE_MORE_INFOS_ID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
