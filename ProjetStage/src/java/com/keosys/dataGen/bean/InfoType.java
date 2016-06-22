/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * *****************************************************************************
 * Class Name                           InfoType                               *
 * @author                              Ivan Emmanuel VILLEGAS LIRA            *
 * Date                                 17/06/2016                             *
 * @version                             1.0.0                                  *
 *                                                                             *
 * *****************************************************************************
 */
public class InfoType {
    private int id = 0;
    private String name = null;
    private int editable = 0;
    private String entityType = null;
    private String label = null;
    private int accesLevel = 0;
    private int needed = 0;
    private String regex = null;
    private int fkDefaultValueId = 0;
    private int version = 0;

    public InfoType() {

    }

    @Override
    public String toString() {
        return label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEditable() {
        return editable;
    }

    public void setEditable(int editable) {
        this.editable = editable;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAccesLevel() {
        return accesLevel;
    }

    public void setAccesLevel(int accesLevel) {
        this.accesLevel = accesLevel;
    }

    public int getNeeded() {
        return needed;
    }

    public void setNeeded(int needed) {
        this.needed = needed;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getFkDefaultValueId() {
        return fkDefaultValueId;
    }

    public void setFkDefaultValueId(int fkDefaultValueId) {
        this.fkDefaultValueId = fkDefaultValueId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
