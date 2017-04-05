package com.codefactory.enums;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public enum OracleBeanSQLEnum {

    INTEGER("INTEGER"),
    STRING("varchar2(40)"),
    DOUBLE("decimal(19,3)"),
    DATE("DATE"),
    INT("INTEGER"),
    LONG("INTEGER"),
    FLOAT("decimal(19,3)");

    OracleBeanSQLEnum(String name) {
    }
}
