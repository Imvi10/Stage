/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           TypeVisit                            *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class TypeVisit {

    private int id = 0;
    private String name = null;
    private int needed = 0;
    private int status = 0;
    private int needAdjudication = 0;
    private int visitMaxReading = 0;
    private int allowVisiteNotDone = 0;
    private int visitAllowVisitWhitOutSeries = 0;
    private int uploadMailTemplate = 0;
    private int qualityControlMailTemplate = 0;
    private int qualityControlKOMailTemplate = 0;
    private int qualityControlCorrectiveActionMailTemplate = 0;
    private int readingMailTemplate = 0;
    private int adjudicationMailTemplate = 0;
    private int fkReadingFormFormId = 0;
    private int fkAdjuducationFormFormId = 0;
    private  int fkQualityContromFormFormId = 0;
    private int fkUploadFormFormId = 0;
    private int fkProtocolVisitTypes = 0;
    private int idxProtocolVisitTypes = 0;
    private int version = 0;

    public TypeVisit() {

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

    public int getNeeded() {
        return needed;
    }

    public void setNeeded(int needed) {
        this.needed = needed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNeedAdjudication() {
        return needAdjudication;
    }

    public void setNeedAdjudication(int needAdjudication) {
        this.needAdjudication = needAdjudication;
    }

    public int getVisitMaxReading() {
        return visitMaxReading;
    }

    public void setVisitMaxReading(int visitMaxReading) {
        this.visitMaxReading = visitMaxReading;
    }

    public int getAllowVisiteNotDone() {
        return allowVisiteNotDone;
    }

    public void setAllowVisiteNotDone(int allowVisiteNotDone) {
        this.allowVisiteNotDone = allowVisiteNotDone;
    }

    public int getVisitAllowVisitWhitOutSeries() {
        return visitAllowVisitWhitOutSeries;
    }

    public void setVisitAllowVisitWhitOutSeries(int visitAllowVisitWhitOutSeries) {
        this.visitAllowVisitWhitOutSeries = visitAllowVisitWhitOutSeries;
    }

    public int getUploadMailTemplate() {
        return uploadMailTemplate;
    }

    public void setUploadMailTemplate(int uploadMailTemplate) {
        this.uploadMailTemplate = uploadMailTemplate;
    }

    public int getQualityControlMailTemplate() {
        return qualityControlMailTemplate;
    }

    public void setQualityControlMailTemplate(int qualityControlMailTemplate) {
        this.qualityControlMailTemplate = qualityControlMailTemplate;
    }

    public int getQualityControlKOMailTemplate() {
        return qualityControlKOMailTemplate;
    }

    public void setQualityControlKOMailTemplate(int qualityControlKOMailTemplate) {
        this.qualityControlKOMailTemplate = qualityControlKOMailTemplate;
    }

    public int getQualityControlCorrectiveActionMailTemplate() {
        return qualityControlCorrectiveActionMailTemplate;
    }

    public void setQualityControlCorrectiveActionMailTemplate(int qualityControlCorrectiveActionMailTemplate) {
        this.qualityControlCorrectiveActionMailTemplate = qualityControlCorrectiveActionMailTemplate;
    }

    public int getReadingMailTemplate() {
        return readingMailTemplate;
    }

    public void setReadingMailTemplate(int readingMailTemplate) {
        this.readingMailTemplate = readingMailTemplate;
    }

    public int getAdjudicationMailTemplate() {
        return adjudicationMailTemplate;
    }

    public void setAdjudicationMailTemplate(int adjudicationMailTemplate) {
        this.adjudicationMailTemplate = adjudicationMailTemplate;
    }

    public int getFkReadingFormFormId() {
        return fkReadingFormFormId;
    }

    public void setFkReadingFormFormId(int fkReadingFormFormId) {
        this.fkReadingFormFormId = fkReadingFormFormId;
    }

    public int getFkAdjuducationFormFormId() {
        return fkAdjuducationFormFormId;
    }

    public void setFkAdjuducationFormFormId(int fkAdjuducationFormFormId) {
        this.fkAdjuducationFormFormId = fkAdjuducationFormFormId;
    }

    public int getFkQualityContromFormFormId() {
        return fkQualityContromFormFormId;
    }

    public void setFkQualityContromFormFormId(int fkQualityContromFormFormId) {
        this.fkQualityContromFormFormId = fkQualityContromFormFormId;
    }

    public int getFkUploadFormFormId() {
        return fkUploadFormFormId;
    }

    public void setFkUploadFormFormId(int fkUploadFormFormId) {
        this.fkUploadFormFormId = fkUploadFormFormId;
    }

    public int getFkProtocolVisitTypes() {
        return fkProtocolVisitTypes;
    }

    public void setFkProtocolVisitTypes(int fkProtocolVisitTypes) {
        this.fkProtocolVisitTypes = fkProtocolVisitTypes;
    }

    public int getIdxProtocolVisitTypes() {
        return idxProtocolVisitTypes;
    }

    public void setIdxProtocolVisitTypes(int idxProtocolVisitTypes) {
        this.idxProtocolVisitTypes = idxProtocolVisitTypes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Envoie la valeur du type d'information pour le visualiser dans la bo�te
     * de s�lection ou JList
     */
    @Override
    public String toString() {
        return name;
    }
}
