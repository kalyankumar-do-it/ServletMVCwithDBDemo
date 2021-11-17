package com.techjs.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techjs.dao.RegisterDao;
import com.techjs.pojo.RegisterUser;
 
public class RegisterServletController extends HttpServlet {
  
     public RegisterServletController() {
     }
 
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	 //Read parameters

         String userName = request.getParameter("username");
         String password = request.getParameter("password");
          
         
         // Create a Pojo to hold data
         
         RegisterUser registerUser = new RegisterUser();
         registerUser.setUserName(userName);
         registerUser.setPassword(password); 
          
         RegisterDao registerDao = new RegisterDao();
          
         // Saving data using DAO
         String userRegistered = registerDao.registerUser(registerUser);
          
         
         if(userRegistered.equals("SUCCESS"))   
         {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
         }
     }
}