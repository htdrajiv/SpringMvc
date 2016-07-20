package com.springapp.mvc.dataAccess;

import com.springapp.mvc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajiv on 7/18/2016.
 */

public class UserAccess {

    private static final ApplicationContext context =
            new ClassPathXmlApplicationContext("datasource.xml");
    private final MySqlConnection dataSource = (MySqlConnection) context.getBean("mySqlConnection");


    public User getUser(String userName) throws SQLException {
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
//        dataSource.closeConnection();
        connection.close();
        return user;
    }

    public boolean addUser(User user) throws SQLException {
        boolean status = true;
        Connection connection = dataSource.getConnection();
        try{
            String query = "insert into user (firstName, lastName, userName, password) values ('"+user.getFirstName()+"', '"+user.getLastName()+"', " +
                    "'"+user.getUserName()+"', '"+user.getPassword()+"')";
            PreparedStatement ps = connection.prepareStatement(query);
            status = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
//            dataSource.closeConnection();
        }

        return status;
    }

    public List<User> getUsers() throws SQLException {
        Connection connection = dataSource.getConnection();
        String query = "select * from user";
        PreparedStatement ps = connection.prepareStatement(query);
        User user = null;
        ResultSet rs = ps.executeQuery();
        List<User> users = new ArrayList<User>();
        while(rs.next()){
            user = new User(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("userName"),
                    rs.getString("password")
            );
            users.add(user);
            user = null;
        }
//        dataSource.closeConnection();
        connection.close();
        return users;
    }

}
