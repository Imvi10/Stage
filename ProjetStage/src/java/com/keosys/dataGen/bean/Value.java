/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           Value                                *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Value {

    private int id = 0;
    private String value = null;
    private int FK_ELEMENT_VALUES_ID = 0;
    private int FK_INFO_TYPE_VALUES_ID = 0;
    private int version = 0;

    public Value() {
    }

    @Override
    public String toString() {
        return value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFK_ELEMENT_VALUES_ID() {
        return FK_ELEMENT_VALUES_ID;
    }

    public void setFK_ELEMENT_VALUES_ID(int FK_ELEMENT_VALUES_ID) {
        this.FK_ELEMENT_VALUES_ID = FK_ELEMENT_VALUES_ID;
    }

    public int getFK_INFO_TYPE_VALUES_ID() {
        return FK_INFO_TYPE_VALUES_ID;
    }

    public void setFK_INFO_TYPE_VALUES_ID(int FK_INFO_TYPE_VALUES_ID) {
        this.FK_INFO_TYPE_VALUES_ID = FK_INFO_TYPE_VALUES_ID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
