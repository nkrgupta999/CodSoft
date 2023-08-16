package PhoneBook;

import java.awt.*;


import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchDatatable extends JFrame {
	
	String x[]= {"Id","Name","phone","email","address"};
	String y[][]=new String[20][10];
	
	int i=0,j=0;
	JTable t;
	Font f;
	
	SearchDatatable()
	{
		
	}
	
	SearchDatatable(String name1)
	{
		super(" Contact Information");
		setLocation(1,1);
		setSize(800,400);
		
		f=new Font("Arial",Font.PLAIN,15);
		
		try
		{
			ConnectionClass obj = new ConnectionClass ();
			String q="select * from contact where name ='"+name1+"'";
			ResultSet rest = obj.stm.executeQuery(q);
			
			while(rest.next()) {
				
				y[i][j++]=rest.getString("id");
				y[i][j++]=rest.getString("name");
				y[i][j++]=rest.getString("phone");
				y[i][j++]=rest.getString("email");
				y[i][j++]=rest.getString("address");
				
				i++;
				j=0;
				
				
			}
			t=new JTable(y,x);
			t.setFont(f);
			
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		
	}
	
	public static void main(String[] args) 
	{
		
		new  SearchDatatable().setVisible(true);
	}

	
}
