package com.codefactory.utils;

/**
 * Created by Gao.WenLong on 2017/3/29.
 */
public class StringUtils {


    /**
     * 根据传入的字段构建驼峰式命名规则
     * @param name
     * @return
     */
    public static String buildFieldName(String name){
        if(isEmpty(name))return name;
        if(!name.contains("-"))return name;
        String []names = name.toLowerCase().split("-");
        StringBuilder sb = new StringBuilder(names[0]);
        for(int i=1;i<names.length;i++){
            sb.append(names[i].substring(0,1).toUpperCase()+names[i].substring(1)) ;
        }
        return sb.toString();
    }

    /**
     * 首字母小写
     * @param name
     * @return
     */
    public static String firstNameLower(String name){
        if(isEmpty(name))return name;
        return  name.substring(0,1).toUpperCase()+name.substring(1);
    }

    /**
     * 返回数据库类型对应的java类型
     * @param type
     * @return
     */
    public static String getJavaType(String type){
        if(isEmpty(type))return null;
        if(type.startsWith("varchar"))
            return "String";
        if(type.startsWith("date"))
            return "Date";
        if(type.startsWith("char"))
            return "String";
        if(type.startsWith("int"))
            return "Integer";
        if(type.startsWith("bigint"))
            return "Integer";
        if(type.startsWith("integer"))
            return "Integer";
        if(type.startsWith("double"))
            return "Double";
        if(type.startsWith("float"))
            return "Double";
        if(type.startsWith("text"))
            return "String";
        if(type.startsWith("decimal"))
            return "Double";
        return "";
    }

    /**
     * 返回数据库类型对应mybatis的数据类型
     * @param type
     * @return
     */
    public static String getMyBatisType(String type){
        if(isEmpty(type))return null;
        if(type.startsWith("varchar"))
            return "VARCHAR";
        if(type.startsWith("date"))
            return "TIMESTAMP";
        if(type.startsWith("char"))
            return "VARCHAR";
        if(type.startsWith("int"))
            return "NUMERIC";
        if(type.startsWith("bigint"))
            return "NUMERIC";
        if(type.startsWith("integer"))
            return "NUMERIC";
        if(type.startsWith("double"))
            return "NUMERIC";
        if(type.startsWith("float"))
            return "NUMERIC";
        if(type.startsWith("text"))
            return "VARCHAR";
        if(type.startsWith("decimal"))
            return "NUMERIC";
        if(type.startsWith("number"))
            return "NUMERIC";
        return "";

    }


    /**
     * 判断字符串是否是空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(null == str || str.length()==0)return true;
        return false;
    }


}
