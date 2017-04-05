package com.codefactory;

import com.codefactory.bean.BeanInfo;
import com.codefactory.bean.Property;
import com.codefactory.test.SpotBean;
import com.codefactory.utils.StringUtils;

/**
 * 用来创建实体对应的sql
 */
public class SqlFactory extends BaseFactory{

    /**
     * 根据bean信息创建建表语句
     * @param bean
     * @return
     */
    private static  String createTableSql(BeanInfo bean){
        StringBuilder createSql = new StringBuilder();
        createSql.append(Constant.CREATETABLESQL);
        createSql.append(bean.getTableName())
                .append("( ").append(Constant.BR);
        //主键
        StringBuilder tempPK = new StringBuilder();
        for(Property property:bean.getProList()){
            createSql.append(property.getName())
                    .append(" ").append(property.getDbType());
            if(!StringUtils.isEmpty(property.getLength())) {
                createSql.append("(").append(property.getLength()).append(")");
            }
            createSql.append(" NOT NULL COMMENT '").append(property.getComment())
                    .append("',");
            createSql.append(Constant.BR);
            if(property.isKey())
                tempPK.append(property.getName()).append(",");
        }
        if(bean.isCreate()) {
            createSql.append(Constant.CREATEUSER).append(",").append(Constant.BR)
                    .append(Constant.CREATEDATETIME).append(",").append(Constant.BR)
                    .append(Constant.MODIFYUSER).append(",").append(Constant.BR)
                    .append(Constant.MODIFYDATETIME).append(",").append(Constant.BR)
                    .append(Constant.SITECODE).append(Constant.BR);
        }
        if(tempPK.length()>0) {
            createSql.append("PRIMARY KEY (").append(tempPK.substring(0,tempPK.length() - 1))
                    .append(")").append(Constant.BR);
        }
        createSql.append(") ;");
        return createSql.toString();
    }


    /**
     * 返回主键自增oracle
     * @return
     */
    private static String pkIncrementOracle(String tableName){
      String squence = "CREATE SEQUENCE " +tableName+"_seq \n"+
              "INCREMENT BY 1 \n" +
              "START WITH 1 \n" +
              "MAXVALUE 1000000000000\n" +
              "MINValue 1 \n" +
              "NOCYCLE  \n" +
              "CACHE 10; ";
        return squence;
    }

    /**
     * 设置mysql主键自增长
     * @param tableName
     * @param column
     * @return
     */
    private static String pkIncrementMysql(String tableName,String column){
        StringBuilder sb = new StringBuilder("ALTER TABLE");
        sb.append(tableName).append(" CHANGE COLUMN ")
          .append(column == null ?"ID":column).append(" bigInt(11) NOT NULL AUTO_INCREMENT ; ");
        return sb.toString();
    }

    /**
     * 根据传入的类生成对应的建表语句
     * @param o
     */
    public static String getOracleSql(Class o){
        String sql = createTableSql(getBeanInfo(o));
        System.out.println("建表语句：");
        System.out.println(sql);
        return sql;
    }

    /**
     * 根据传入的类生成对应的sequence
     * @param o
     */
    public static String getOracleSeq(Class o){
        String sql = pkIncrementOracle(getBeanInfo(o).getTableName());
        System.out.println("sequence：");
        System.out.println(sql);
        return sql;
    }
    /**
     * 根据传入的类生成对应的建表和sequence
     * @param o
     */
    public static void getOracleSqlAndSeq(Class o){
        String sql = createTableSql(getBeanInfo(o));
        System.out.println("建表语句：");
        System.out.println(getOracleSql(o));
        System.out.println("sequence：");
        System.out.println(getOracleSeq(o));
    }

    /**
     * 根据传入的类生成对应的建表语句
     * @param o
     */
    public static String getMysqlSql(Class o){
        String sql = createTableSql(getBeanInfo(o));
        System.out.println("建表语句：");
        System.out.println(sql);
        return sql;
    }

    /**
     * 根据传入的类生成对应的建表语句
     * @param o
     */
    public static String getMysqlAutoIncrement(Class o,String column){
        String sql = pkIncrementMysql(getBeanInfo(o).getTableName(),column);
        System.out.println("设置自增：");
        System.out.println(sql);
        return sql;
    }

    public static void main(String[] args) {
        getMysqlSql(SpotBean.class);
    }


}
