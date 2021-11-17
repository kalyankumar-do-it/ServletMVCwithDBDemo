package com.techjs.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.techjs.pojo.RegisterUser;
import com.techjs.util.DBConnection;

 
public class RegisterDao { 
     public String registerUser(RegisterUser registerUser)
     {

         String userName = registerUser.getUserName();
         String password = registerUser.getPassword();
          
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into users(username,password) values (?,?)"; 
             preparedStatement = con.prepareStatement(query); 
             preparedStatement.setString(1, userName);
             preparedStatement.setString(2, password);
              
             int i= preparedStatement.executeUpdate();
              
             if (i!=0)  
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  
     }
}