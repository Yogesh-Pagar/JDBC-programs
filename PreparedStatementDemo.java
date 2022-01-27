package com.database.jdbc;
import java.util.*;
import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection;
        Class.forName("com.mysql.jdbc.Driver");
        connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirts_db","root","Pagar@3680");

        String sqlQuery = "insert into shirts values(?,?,?,?,?)";

        PreparedStatement prd = connection.prepareStatement(sqlQuery);

        Scanner sc = new Scanner(System.in);

        while (true)

        {
            System.out.println("Enter Shirt id:");
            int shirt_id = sc.nextInt();

            System.out.println("Enter article of shirt:");
            String article = sc.next();

            System.out.println("Enter colour of shirt:");
            String color = sc.next();

            System.out.println("Enter Shirt Size:");
            String size = sc.next();

            System.out.println("Enter last worn:");
            int last_worn = sc.nextInt();

            prd.setInt(1,shirt_id);
            prd.setString(2,article);
            prd.setString(3,color);
            prd.setString(4,size);
            prd.setInt(5,last_worn);

            prd.executeUpdate();

            System.out.println("Record inserted successfully:");

            System.out.println("Do you want to continue or not?[yes/no]");
            String option = sc.next();

            if(option.equalsIgnoreCase("no"))
            {
                break;
            }

        } connection.close();
    }
}
