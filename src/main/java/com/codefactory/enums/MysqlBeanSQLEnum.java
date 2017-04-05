package com.codefactory.enums;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public enum  MysqlBeanSQLEnum {

    INTEGER("int"),
    STRING("varchar(40)"),
    DOUBLE("decimal(19,3)"),
    DATE("datetime"),
    INT("int"),
    LONG("bigint"),
    FLOAT("decimal(19,3)");

    MysqlBeanSQLEnum(String name) {
    }
}
