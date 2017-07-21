/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
public class login extends HttpServlet {


 
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String s=request.getParameter("user");
        String s1=request.getParameter("password");
        
        if(Validate.checkUser(s,s1))
        {
            RequestDispatcher rs=request.getRequestDispatcher("Welcome");
            rs.forward(request, response);
        }
        else
        {
            out.println("****UserName or PassWord is Incorrect****");
            RequestDispatcher rs=request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }
       
    }


}
