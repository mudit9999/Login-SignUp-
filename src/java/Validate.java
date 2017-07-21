/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
import java.sql.*;
public class Validate {
    public static boolean checkUser(String email,String pass)
    {
        boolean st=false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","mudit");
            PreparedStatement ps=con.prepareStatement("select *from REGISTERUSER where name=? and pass=?");
            ps.setString(1,email);
            ps.setString(2, pass);
            ResultSet rs=ps.executeQuery();
            st=rs.next();
            
        }
        catch(Exception e)
        {
            
        }
        return st;
    }
    
}
