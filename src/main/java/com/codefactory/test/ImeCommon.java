package com.codefactory.test;


import java.util.Date;

public class ImeCommon {
    private String siteCode;
    private String languageCode;
    private String createUser;
    private Date createDate;
    private Date createDateTime;
    private String modifyUser;
    private Date modifyDate;
    private Date modifyDateTime;

    public ImeCommon() {
    }

    public String getSiteCode() {
        return this.siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDateTime() {
        return this.createDateTime;
    }

    public void setCreateDateTime(Date createTime) {
        this.createDateTime = createTime;
    }

    public String getModifyUser() {
        return this.modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDateTime() {
        return this.modifyDateTime;
    }

    public void setModifyDateTime(Date modifyTime) {
        this.modifyDateTime = modifyTime;
    }
}
