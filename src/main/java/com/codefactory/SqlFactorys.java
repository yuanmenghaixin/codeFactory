package com.codefactory;

import com.codefactory.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Gao.WenLong on 2017/4/1.
 */
public class SqlFactorys {


    public static void main(String[] args) throws Exception{
        Connection con = DBUtils.getConn();
        String sql = "select siteCode from sy_site";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){//追加
            TemplateFactory.createSiteSqlFile(rs.getString("siteCode"));

        }

    }



}
