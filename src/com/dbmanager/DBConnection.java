/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Turab Bajeer
 */
public class DBConnection {
    
    private static Connection conn = null;
    
    public static Connection getConnection() {
        
    
        if(conn == null){
        
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_tuition_centre", "root", "root");
        
            }catch(Exception e){
            
                System.out.println("Connection Error "+e.getMessage());
                e.printStackTrace();
            }
        }
    
        return conn;
    }
}
