/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           Serie                                *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Serie {

    private int id = 0;
    private String description = null;
    private  String UIID = null;
    private String Accession_no = null;
    private int status = 0;
    private String insertDate = null;
    private String updateDate = null;
    private String uploadDate = null;
    private int uploadFormat = 0;
    private int authorId = 0;
    private int fkVisitSeriesId = 0;
    private int version = 0;

    public Serie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUIID() {
        return UIID;
    }

    public void setUIID(String uIID) {
        UIID = uIID;
    }

    public String getAccession_no() {
        return Accession_no;
    }

    public void setAccession_no(String accession_no) {
        Accession_no = accession_no;
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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getUploadFormat() {
        return uploadFormat;
    }

    public void setUploadFormat(int uploadFormat) {
        this.uploadFormat = uploadFormat;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getFkVisitSeriesId() {
        return fkVisitSeriesId;
    }

    public void setFkVisitSeriesId(int fkVisitSeriesId) {
        this.fkVisitSeriesId = fkVisitSeriesId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
