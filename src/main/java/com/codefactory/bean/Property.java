package com.codefactory.bean;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public class Property {

    /**
     * 属性名称
     */
    private String name;
    /**
     * 属性类型
     */
    private String type;

    /**
     * mybatis对应的类型
     */
    private String mybatisType;

    /**
     * 数据库对应的类型
     */
    private String dbType;

    /**
     * 数据库类型长度
     */
    private String length;

    /**
     * 主键，true表示是主键
     */
    private boolean key;
    /**
     * 注释
     */
    private String comment;

    /**
     * 是否是查询条件
     */
    private boolean search;

    /**
     * 是否必填
     */
    private boolean required;
    /**
     * 是否显示
     */
    private boolean show;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMybatisType() {
        return mybatisType;
    }

    public void setMybatisType(String mybatisType) {
        this.mybatisType = mybatisType;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
