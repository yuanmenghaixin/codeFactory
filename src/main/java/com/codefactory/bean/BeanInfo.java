package com.codefactory.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public class BeanInfo {

    /**
     * 当前类的包名
     */
    private String packageName;
    /**
     * 类名
     */
    private String className;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 文件基础路径
     */
    private String basePath;
    /**
     * 项目路径
     */
    private String codePath;
    /**
     * 基础包名
     */
    private String basePackage;

    /**
     * 是否创建创建人和修改人信息
     */
    private boolean create;

    /**
     * 页面路径
     */
    private String pagePath;

    /**
     * 页面相对路径
     */
    private String relativePath;
    /**
     * 功能名称
     */
    private String comment;

    private List<Property> proList;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Property> getProList() {
        return proList;
    }

    public void setProList(List<Property> proList) {
        this.proList = proList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
