package PhoneBook;

import java.awt.*;
import java.sql.*;

public class ConnectionClass
{
	Connection con;
	Statement stm;
	
	ConnectionClass(){
		String usr = "root";
		String pass = "123456789";
		
		try {
			String url = "jdbc:mysql://localhost:3306/PhoneBookManagement";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, usr, pass);
			 // Initialize the Statement object
            stm = con.createStatement();
			
		}
		
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		new  ConnectionClass();
	}
	
}