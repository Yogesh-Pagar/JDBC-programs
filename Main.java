package com.database.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Connection connection;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirts_db", "root", "Pagar@3680");

            Statement statement = connection.createStatement();

            //statement.execute("insert into shirts (shirt_id, article, color, shirt_size, last_worn)" + "values(15,'suit','red','S',10)");

            statement.execute("CREATE TABLE IF NOT EXISTS CONTACTS " + "(NAME TEXT, PHONE INTEGER, EMAIL TEXT)");

            statement.execute("INSERT INTO  CONTACTS (NAME,PHONE,EMAIL)" + "VALUES('YOGESH', 9768,'yogesh@email.com')");

            statement.execute("INSERT INTO  CONTACTS (NAME,PHONE,EMAIL)" + "VALUES('Yash', 56847895,'yasg@email.com')");

            statement.execute("INSERT INTO  CONTACTS (NAME,PHONE,EMAIL)" + "VALUES('sumit', 568475895,'sumit@email.com')");

            statement.execute("update contacts set name = 'ram' where name = 'yogesh'");

            statement.execute("DELETE FROM CONTACTS WHERE NAME = 'YASH'");

            statement.execute("select * from contacts");

            ResultSet results = statement.getResultSet();

            while (results.next())

            {
                System.out.println(results.getString("name")  +" " + results.getInt("phone") +" " + results.getString("email"));
            }

            results.close();




            statement.close();
            //statement.close();

            connection.close();

        }

        catch (SQLException | ClassNotFoundException e)
        {
            System.out.println("something went wrong:");
        }

    }
}
