package com.springapp.mvc.dataAccess;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Rajiv on 7/18/2016.
 */
public class MySqlConnection {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    Connection connection;
    public Connection getConnection(){
        try{
            connection = dataSource.getConnection();
        }catch(SQLException e){
            System.out.println("cannot get connection for data source");
        }finally {

        }
        return connection;
    }

    public void closeConnection(){
        if(connection!=null){
            try{
                this.connection.close();
            }catch (SQLException e){
                System.out.println("Error in closing connection");
            }
        }
    }

}
