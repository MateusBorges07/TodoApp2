package org.todoapp2.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {


    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://http://192.168.15.16:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception ex) {
            throw new RuntimeException("erro na conexão com o banco de dados, ", ex);
        }
    }

    public static void closeConecction(Connection connection,PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }

                if (statement != null){
                    statement.close();
                }
        }catch (Exception ex){
            throw new RuntimeException("erro ao fechar a conexão com o banco", ex);

        }
    }
    public static void closeConecction(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }

                if (statement != null){
                    statement.close();
                }
            if(resultSet !=null){
               resultSet.close();
            }

        }catch (Exception ex){
            throw new RuntimeException("erro ao fechar a conexão com o banco", ex);

        }
    }


}
