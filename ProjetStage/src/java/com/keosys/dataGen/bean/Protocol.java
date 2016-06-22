/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           Protocol                             *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Protocol {

    private int id = 0;
    private String code = null;
    private String descriptiion = null;
    private int status = 0;
    private String insertDate = null;
    private String updateDate = null;
    private int fk_ulpoad_form_form_id = 0;
    private int fk_details_protocol_detail_id = 0;
    private int fk_reading__form_form_id = 0;
    private int fk_quality_control_form_form_id = 0;
    private int fk_adjudication_form_form_id = 0;
    private int fk_investigation_form_form_id = 0;

    public Protocol() {

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

    public String getDescriptiion() {
        return descriptiion;
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getFk_ulpoad_form_form_id() {
        return fk_ulpoad_form_form_id;
    }

    public void setFk_ulpoad_form_form_id(int fk_ulpoad_form_form_id) {
        this.fk_ulpoad_form_form_id = fk_ulpoad_form_form_id;
    }

    public int getFk_details_protocol_detail_id() {
        return fk_details_protocol_detail_id;
    }

    public void setFk_details_protocol_detail_id(int fk_details_protocol_detail_id) {
        this.fk_details_protocol_detail_id = fk_details_protocol_detail_id;
    }

    public int getFk_reading__form_form_id() {
        return fk_reading__form_form_id;
    }

    public void setFk_reading__form_form_id(int fk_reading__form_form_id) {
        this.fk_reading__form_form_id = fk_reading__form_form_id;
    }

    public int getFk_quality_control_form_form_id() {
        return fk_quality_control_form_form_id;
    }

    public void setFk_quality_control_form_form_id(int fk_quality_control_form_form_id) {
        this.fk_quality_control_form_form_id = fk_quality_control_form_form_id;
    }

    public int getFk_adjudication_form_form_id() {
        return fk_adjudication_form_form_id;
    }

    public void setFk_adjudication_form_form_id(int fk_adjudication_form_form_id) {
        this.fk_adjudication_form_form_id = fk_adjudication_form_form_id;
    }

    public int getFk_investigation_form_form_id() {
        return fk_investigation_form_form_id;
    }

    public void setFk_investigation_form_form_id(int fk_investigation_form_form_id) {
        this.fk_investigation_form_form_id = fk_investigation_form_form_id;
    }

}
