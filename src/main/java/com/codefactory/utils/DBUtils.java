package com.codefactory.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public class DBUtils {


    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConn(){
        Properties properties = PropertiesUtils.readProperty();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection((String)properties.get("url"),(String)properties.get("username"),(String)properties.get("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
