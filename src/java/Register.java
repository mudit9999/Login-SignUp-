/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author lenovo
 */
public class Register extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String n=request.getParameter("userName");
        String p=request.getParameter("userPass");
        String c=request.getParameter("userCountry");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mudit");
            PreparedStatement ps=con.prepareStatement("insert into REGISTERUSER values(?,?,?)");
            ps.setString(1,n);
            ps.setString(2,p);
            ps.setString(3,c);
            int i=ps.executeUpdate();
            if(i>0)
                out.println("****You are Successfully registered****");
        }
        catch(Exception e)
        {
            out.close();
        }
      
    }

    

}
