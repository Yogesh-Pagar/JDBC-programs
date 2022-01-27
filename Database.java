package com.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException{

        Connection connection;
        Class.forName("com.mysql.jdbc.Driver");
        connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirts_db","root","Pagar@3680");

        Statement st = connection.createStatement();

        st.executeUpdate("insert into shirts values(11, 'suit', 'black', 'L', 16);");

        connection.close();
    }

}

