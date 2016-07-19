package com.springapp.mvc.dataAccess;

import com.springapp.mvc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rajiv on 7/18/2016.
 */

public class UserAccess {
    public User getUser(String userName) throws SQLException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("datasource.xml");
        MySqlConnection dataSource = (MySqlConnection) context.getBean("mySqlConnection");
        Connection connection = dataSource.getConnection();
        String query = "select * from user where userName=?";
        PreparedStatement ps = connection.prepareStatement(query);
        User user = null;
        ps.setString(1,userName);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            user = new User(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("userName"),
                    rs.getString("password")
            );
        }
        dataSource.closeConnection();
        return user;
    }
}
