/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keosys.dataGen.bean;

/**
 * ***************************************************************************
 * Class Name                           User                                 *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class User {

    private int id = 0;
    private String surName = null;
    private String firstName = null;
    private String email = null;
    private String phone = null;
    private String login = null;
    private String viewerId = null;
    private String password = null;
    private int isTempPassword = 0;
    private String passwordPrev1 = null;
    private String passwordPrev2 = null;
    private String passwordExpiration = null;
    private String firstConnectionDate = null;
    private String lastConnectionDate = null;
    private String lastConnectionIp = null;
    private int status = 0;
    private int activeConnections = 0;
    private int isSuperAdmin = 0;
    private String insertDate = null;
    private String updateDate = null;
    private int version = 0;

    public User() {

    }

    @Override
    public String toString() {
        return surName + " " +firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getViewerId() {
        return viewerId;
    }

    public void setViewerId(String viewerId) {
        this.viewerId = viewerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsTempPassword() {
        return isTempPassword;
    }

    public void setIsTempPassword(int isTempPassword) {
        this.isTempPassword = isTempPassword;
    }

    public String getPasswordPrev1() {
        return passwordPrev1;
    }

    public void setPasswordPrev1(String passwordPrev1) {
        this.passwordPrev1 = passwordPrev1;
    }

    public String getPasswordPrev2() {
        return passwordPrev2;
    }

    public void setPasswordPrev2(String passwordPrev2) {
        this.passwordPrev2 = passwordPrev2;
    }

    public String getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(String passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    public String getFirstConnectionDate() {
        return firstConnectionDate;
    }

    public void setFirstConnectionDate(String firstConnectionDate) {
        this.firstConnectionDate = firstConnectionDate;
    }

    public String getLastConnectionDate() {
        return lastConnectionDate;
    }

    public void setLastConnectionDate(String lastConnectionDate) {
        this.lastConnectionDate = lastConnectionDate;
    }

    public String getLastConnectionIp() {
        return lastConnectionIp;
    }

    public void setLastConnectionIp(String lastConnectionIp) {
        this.lastConnectionIp = lastConnectionIp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActiveConnections() {
        return activeConnections;
    }

    public void setActiveConnections(int activeConnections) {
        this.activeConnections = activeConnections;
    }

    public int getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(int isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
