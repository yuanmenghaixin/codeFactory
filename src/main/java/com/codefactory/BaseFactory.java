package com.codefactory;

import com.codefactory.annotation.FieldType;
import com.codefactory.annotation.Table;
import com.codefactory.bean.BeanInfo;
import com.codefactory.bean.Property;
import com.codefactory.test.SpotBean;
import com.codefactory.utils.DBUtils;
import com.codefactory.utils.PropertiesUtils;
import com.codefactory.utils.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

/**
 * 基类
 */
public class BaseFactory  {


    /**
     * 获取当前对象的包信息
     * 字段信息
     * @param o
     * @return
     * map:{packageName:包名,fields:字段信息集合(List<Field>),tableName:表名}
     */
    public static BeanInfo getBeanInfo(Class o){
        BeanInfo beanInfo = new BeanInfo();
        Properties properties = PropertiesUtils.readProperty();
        if(null == properties) throw new RuntimeException("读取配置文件失败");
        beanInfo.setBasePackage((String)properties.get("basepackage"));
        beanInfo.setBasePath((String)properties.get("basepath"));
        beanInfo.setCodePath((String)properties.get("codepath"));
        beanInfo.setPagePath((String)properties.get("pagepath"));
        beanInfo.setRelativePath((String)properties.get("relativepath"));
        beanInfo.setCreate(properties.get("create")==null?true:false);
        List<Property> list = new ArrayList<>();
        Field []fields = o.getDeclaredFields();//不考虑存在父类的情况
        Field field = null;
        FieldType fieldType = null;
        Property property = null;
        for (int i = 0; i <fields.length ; i++) {
            field = fields[i];
            field.setAccessible(true);
            fieldType = field.getAnnotation(FieldType.class);
            if (null == fieldType) continue;
            property = new Property();
            property.setDbType(fieldType.type());
            property.setComment(fieldType.comment());
            property.setKey(1 == fieldType.pk());
            property.setSearch(1 == fieldType.search());
            property.setLength(fieldType.length());
            property.setType(field.getType().getSimpleName());
            property.setMybatisType(StringUtils.getMyBatisType(property.getDbType()));
            property.setName(fieldType.value());
            property.setRequired(1==fieldType.required());
            property.setShow(1==fieldType.show());
            list.add(property);
        }

        beanInfo.setProList(list);
        Annotation table = o.getAnnotation(Table.class);
        if(null == table) {
            beanInfo.setTableName(o.getSimpleName());
            beanInfo.setComment("管理");
        }
        else {
            beanInfo.setTableName(((Table) table).value());
            beanInfo.setComment(((Table) table).comment());
        }
        beanInfo.setClassName(o.getSimpleName());
        beanInfo.setCreateDate(new Date());
        return beanInfo;
    }

    /**
     * 获取当前对象的包信息
     * 字段信息
     * @return
     * map:{fields:字段信息集合(List<Property>),tableName:表名}
     */
    private static Map<String,Object> getBeanInfoFromTable(String tableName) {
        Connection con = DBUtils.getConn();
        String sql = " show full columns from "+tableName;
        List<Property> fieldList = new ArrayList<>();
        Property property = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                property = new Property();
                property.setName(StringUtils.buildFieldName(rs.getString("Field")));
                property.setDbType(rs.getString("Type").toLowerCase());
                property.setComment(rs.getString("Comment"));
                property.setKey(StringUtils.isEmpty(rs.getString("Key")));
                property.setMybatisType(StringUtils.getMyBatisType(property.getType()));
                property.setType(StringUtils.getJavaType(property.getType()));
                // System.out.println(rs.getString("Field") + "\t:\t"+  rs.getString("Comment")+ "\t:\t"+rs.getString("Type") );
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        map.put("fields",fieldList);
        map.put("tableName",tableName);
        return map;
    }



    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = getBeanInfo(SpotBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
