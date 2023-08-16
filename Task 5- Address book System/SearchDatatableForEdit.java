package PhoneBook;
import java.awt.*;


import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class SearchDatatableForEdit extends JFrame implements ActionListener
{
		String x[]= {"Id","Name","phone","email","address"};
		String y[][]=new String[20][10];

		int i=0,j=0;
		JTable t;
		Font f;
		JLabel l1;
		JTextField tf;
		JButton bt1;
		JPanel p1;
		
		
		SearchDatatableForEdit()
		{
			
		}
		
		SearchDatatableForEdit(String name1)
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
			l1=new JLabel("enter contact id");
			tf=new JTextField();
			bt1=new JButton("Edit");
			
			bt1.addActionListener(this);
			
			p1=new JPanel();
			p1.setLayout(new GridLayout(1,3,10,10));
			p1.add(l1);
			p1.add(tf);
			p1.add(bt1);
			
			setLayout(new BorderLayout(10,10));
			add(p1, BorderLayout.SOUTH);   
			add(sp, BorderLayout.CENTER);
			
			
			
		
}
		
		public void actionPerformed(ActionEvent e)
		{
			int idno=Integer.parseInt(tf.getText());
			
			if(e.getSource()==bt1)
			{
				new EditData(idno).setVisible(true);
				this.setVisible(false);
				
			}
			
		}
		
		public static void main(String[] args)
		{
		
			new SearchDatatableForEdit().setVisible(true);
			
		}
		
			
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
	
	


