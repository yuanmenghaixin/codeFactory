package com.codefactory.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Gao.WenLong on 2017/3/28.
 */
public class PropertiesUtils {


    /**
     * 读取配置文件中的数据
     * @return
     */
    public static Properties readProperty(){
        Properties properties = new Properties();
        try {
            properties.load(PropertiesUtils.class.getClassLoader().getResourceAsStream("factory.properties"));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        readProperty();
    }



}
