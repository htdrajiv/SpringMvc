package com.springapp.mvc.service;

import com.springapp.mvc.dataAccess.MySqlConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;

/**
 * Created by Rajiv on 7/18/2016.
 */
@Service
public class userService {
    private static final ApplicationContext context =
            new ClassPathXmlApplicationContext("datasource.xml");
    private final MySqlConnection dataSource = (MySqlConnection) context.getBean("mySqlConnection");
    public void add(){

    }
    public void update(){

    }
    public void delete(){

    }
    public ResultSet select(){
        ResultSet rs = null;
        return rs;
    }
}
