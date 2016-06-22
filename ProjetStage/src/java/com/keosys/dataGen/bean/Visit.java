/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           Visit                                *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Visit {
    int id = 0;
    String code = null;
    int status = 0;
    String INSERT_DATE = null;
    String UPDATE_DATE = null;
    int FK_TYPE_VISIT_TYPE_ID = 0;
    int FK_PATIENT_VISITS_ID = 0;
    int version = 0;

    public Visit() {

    }

    @Override
    public String toString() {
        return code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getINSERT_DATE() {
        return INSERT_DATE;
    }

    public void setINSERT_DATE(String iNSERT_DATE) {
        INSERT_DATE = iNSERT_DATE;
    }

    public String getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(String uPDATE_DATE) {
        UPDATE_DATE = uPDATE_DATE;
    }

    public int getFK_TYPE_VISIT_TYPE_ID() {
        return FK_TYPE_VISIT_TYPE_ID;
    }

    public void setFK_TYPE_VISIT_TYPE_ID(int fK_TYPE_VISIT_TYPE_ID) {
        FK_TYPE_VISIT_TYPE_ID = fK_TYPE_VISIT_TYPE_ID;
    }

    public int getFK_PATIENT_VISITS_ID() {
        return FK_PATIENT_VISITS_ID;
    }

    public void setFK_PATIENT_VISITS_ID(int fK_PATIENT_VISITS_ID) {
        FK_PATIENT_VISITS_ID = fK_PATIENT_VISITS_ID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
