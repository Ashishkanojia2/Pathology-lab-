package com.example.proj1;

import java.sql.Connection;
import java.sql.DriverManager;

public class dataBase {
    public static Connection connectionDB(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "Rootuser2023";
            String url ="jdbc:mysql://localhost:3306/student_manage?autoReconnect=true&useSSL=false";
            Connection connect = DriverManager.getConnection(url,user,password);
            System.out.println("Connection made");

            return connect;


        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
