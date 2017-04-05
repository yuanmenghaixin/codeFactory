package com.codefactory;


import com.codefactory.bean.BeanInfo;
import com.codefactory.test.SpotBean;
import com.codefactory.utils.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据模板构建所需要的类
 */
public class TemplateFactory extends BaseFactory{

    /**
     * 获取freemaker配置信息
     * @return
     */
    public static Configuration configFreemaker() {
        try {
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File(templateDir()));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            return cfg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建对应的bean
     * @param o 模板class
     */
    public static void createBeanCodeFile(Class o){
        System.out.println("bean文件生成开始...");
        createJavaFile(o,"bean.ftl","/model","");
        System.out.println("bean文件生成结束...");
    }

    /**
     * 创建对应的beanCondition
     * @param o 模板class
     */
    public static void createBeanCoditionCodeFile(Class o){
        System.out.println("beancondition文件生成开始...");
        createJavaFile(o,"beanCondition.ftl","/model/condition","Condition");
        System.out.println("beancondition文件生成结束...");
    }

    /**
     * 创建对应的service and serviceimpl
     * @param o 模板class
     */
    public static void createServiceCodeFile(Class o){
        System.out.println("service文件生成开始...");
        createJavaFile(o,"service.ftl","/service","Service");
        createJavaFile(o,"serviceImpl.ftl","/service/impl","ServiceImpl");
        System.out.println("service文件生成结束...");

    }

    /**
     * 创建对应的dao
     * @param o 模板class
     */
    public static void createDaoCodeFile(Class o){
        System.out.println("dao文件生成开始...");
        createJavaFile(o,"dao.ftl","/dao","Dao");
        System.out.println("dao文件生成完成...");
    }

    /**
     * 创建对应的xml
     * @param o 模板class
     */
    public static void createMysqlXmlCodeFile(Class o){
        System.out.println("xml文件生成开始...");
        createXmlFile(o,"mapper_mysql.ftl","/mybatis/mysql");
        System.out.println("xml文件生成完成...");
    }

    /**
     * 创建对应的xml
     * @param o 模板class
     */
    public static void createOracelXmlCodeFile(Class o){
        System.out.println("xml文件生成开始...");
        createXmlFile(o,"mapper_oracle.ftl","/mybatis/oracle");
        System.out.println("xml文件生成完成...");
    }

    /**
     * 创建对应的html
     * @param o 模板class
     */
    public static void createHtmlCodeFile(Class o){
        System.out.println("html文件生成开始...");
        createHtmlFile(o,"page_list.ftl","list");
        createHtmlFile(o,"page_edit.ftl","edit");
        System.out.println("xml文件生成完成...");
    }

    /**
     * 创建对应的controller
     * @param o 模板class
     */
    public static void createControllerCodeFile(Class o){
        System.out.println("controller文件生成开始...");
        createJavaFile(o,"controller.ftl","/controller","Controller");
        System.out.println("controller文件生成完成...");
    }

    /**
     * 创建对应的menu and resource
     * @param o 模板class
     */
    public static void createMenuSql(Class o){
        System.out.println("创建对应的menu开始...");
        createMenuSql(o,"sql.ftl");
        System.out.println("创建对应的menu结束...");
    }

    /**
     * 创建对应的java文件
     * @param o 模板class
     */
    private static void createJavaFile(Class o,String templatName,String packagePath,String type){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate(templatName);
            BeanInfo bean = getBeanInfo(o);
            File dir = new File(bean.getCodePath()+"/java/"+bean.getBasePath()+packagePath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            OutputStream fos = new  FileOutputStream( new File(dir, bean.getClassName()+type+".java")); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            Map<String,BeanInfo> map = new HashMap<>();
            map.put("bean",bean);
            temp.process(map, out);

            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建对应的xml文件
     * @param o 模板class
     */
    private static void createXmlFile(Class o,String templatName,String packagePath){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate(templatName);
            BeanInfo bean = getBeanInfo(o);
            File dir = new File(bean.getCodePath()+"/resources/"+packagePath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            OutputStream fos = new  FileOutputStream( new File(dir, bean.getClassName()+"Dao.xml")); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            Map<String,BeanInfo> map = new HashMap<>();
            map.put("bean",bean);
            temp.process(map, out);

            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建对应的xml文件
     * @param o 模板class
     */
    private static void createHtmlFile(Class o,String templatName,String fileName){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate(templatName);
            BeanInfo bean = getBeanInfo(o);
            File dir = new File(bean.getCodePath()+"/"+bean.getPagePath()+"/"+bean.getRelativePath());
            if(!dir.exists()){
                dir.mkdirs();
            }
            OutputStream fos = new  FileOutputStream( new File(dir,StringUtils.firstNameLower(bean.getClassName())+fileName+".html")); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            Map<String,BeanInfo> map = new HashMap<>();
            map.put("bean",bean);
            temp.process(map, out);

            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建对应的xml文件
     * @param o 模板class
     */
    private static void createMenuSql(Class o,String templatName){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate(templatName);
            BeanInfo bean = getBeanInfo(o);
            Writer out = new OutputStreamWriter(System.out);
            Map<String,BeanInfo> map = new HashMap<>();
            map.put("bean",bean);
            temp.process(map, out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建对应的xml文件
     * @param o 模板class
     */
    private static void createXmlOut(Class o,String templatName){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate(templatName);
            BeanInfo bean = getBeanInfo(o);
            Writer out = new OutputStreamWriter(System.out);
            Map<String,BeanInfo> map = new HashMap<>();
            map.put("bean",bean);
            temp.process(map, out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件包括，bean/serveice/dao/xml/controller/html
     * @param o
     * param dbType 0-mysql 1-oracle
     */
    public static void createAllFiles(Class o,Integer dbType){
        System.out.println("文件生成开始...");

        if(null == dbType)dbType=0;
        createBeanCodeFile(o);
        createBeanCoditionCodeFile(o);
        createDaoCodeFile(o);
        createServiceCodeFile(o);
        if(0 == dbType)
            createMysqlXmlCodeFile(o);
        if(1==dbType)
            createOracelXmlCodeFile(o);
        createControllerCodeFile(o);
        createHtmlCodeFile(o);
        createMenuSql(o);
        System.out.println("文件生成结束...");
    }

    /**
     * 创建文件包括，bean/serveice/dao/xml/controller
     * @param o
     * param dbType 0-mysql 1-oracle
     */
    public static void createAllFilesNoHtmlAndMenu(Class o,Integer dbType){
        System.out.println("文件生成开始...");

        if(null == dbType)dbType=0;
        createBeanCodeFile(o);
        createBeanCoditionCodeFile(o);
        createDaoCodeFile(o);
        createServiceCodeFile(o);
        if(0 == dbType)
            createMysqlXmlCodeFile(o);
        if(1==dbType)
            createOracelXmlCodeFile(o);
        createControllerCodeFile(o);
        //createHtmlCodeFile(o);
        //createMenuSql(o);
        System.out.println("文件生成结束...");
    }


    /**
     * 创建对应的menu文件
     */
    public static void createSiteSqlFile(String siteCode){
        try {
            Configuration cfg = configFreemaker();
            Template temp = cfg.getTemplate("sy_menu.ftl");
            OutputStream fos = new  FileOutputStream( new File("D:\\","sys_menu.sql"),true); //java文件的生成目录
            Writer out = new OutputStreamWriter(fos);
            Map<String,String> map = new HashMap<>();
            map.put("siteCode",siteCode);
            temp.process(map, out);

            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        createAllFiles(SpotBean.class,0);
    }

    private static String templateDir(){
        URL u = Thread.currentThread().getContextClassLoader().getResource("ftl");
        return u.getPath();
    }
}
