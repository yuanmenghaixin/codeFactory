package com.codefactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldType {

    /**
     * 默认字符在数据库中的字段名称
     * @return
     */
    public String value() default "";

    /**
     * 当前字段在数据库中默认的字段类型
     * @return
     */
    public String type() default "";

    /**
     * 当前字段在数据库中默认长度
     * @return
     */
    public String length() default "";

    /**
     * 当前字段在数据库中的注释
     * @return
     */
    public String comment() default "";

    /**
     * 当前字段是否是主键0-否，1-是
     * @return
     */
    public int pk() default 0;

    /**
     * 是否是查询条件
     * @return
     */
    public int search() default 0;

    /**
     * 是否必填,默认非必填
     * @return
     */
    public int required() default 0;

    /**
     * 是否在页面上显示 1-显示，0-不显示
     * @return
     */
    public int show() default 1;
}
