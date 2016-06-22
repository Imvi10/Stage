/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           Patient                              *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Patient {

    private int id = 0;
    private String code = null;
    private int status = 0;
    private String INSERT_DATE = null;
    private String UPDATE_DATE = null;
    private int FK_PROTOCOL_PATIENTS_ID = 0;
    private int version = 0;

    public Patient() {

    }

    @Override
    public String toString() {
        return code;
    }

    public Patient(int id, String code, int status, String iNSERT_DATE, String uPDATE_DATE, int fK_PROTOCOL_PATIENTS_ID,
            int version) {
        super();
        this.id = id;
        this.code = code;
        this.status = status;
        INSERT_DATE = iNSERT_DATE;
        UPDATE_DATE = uPDATE_DATE;
        FK_PROTOCOL_PATIENTS_ID = fK_PROTOCOL_PATIENTS_ID;
        this.version = version;
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

    public int getFK_PROTOCOL_PATIENTS_ID() {
        return FK_PROTOCOL_PATIENTS_ID;
    }

    public void setFK_PROTOCOL_PATIENTS_ID(int fK_PROTOCOL_PATIENTS_ID) {
        FK_PROTOCOL_PATIENTS_ID = fK_PROTOCOL_PATIENTS_ID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
