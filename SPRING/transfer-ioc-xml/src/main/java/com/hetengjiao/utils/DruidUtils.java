package com.hetengjiao.utils;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author 应癫
 */
public class DruidUtils {

    private DruidUtils(){
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();


    static {
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://49.232.146.162:3306/my_batis");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

    }

    public static DruidDataSource getInstance() {
        return druidDataSource;
    }

}
