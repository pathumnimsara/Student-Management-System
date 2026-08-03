package com.pathum.sms.studentmanagementsystem.database;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {


    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";


    private static final String USER = "root";


    private static final String PASSWORD = "ict23044@VLE";


    public static Connection getConnection(){


        try{

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );


        }catch(Exception e){

            e.printStackTrace();

            return null;

        }

    }

}