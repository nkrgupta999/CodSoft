package PhoneBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteContact extends JFrame implements ActionListener
{
	

	String x[]= {"Id","Name","phone","email","address"};
	String y[][]=new String[20][10];
	
	
	int i=0,j=0;
	JTable t;
	Font f;
	JLabel l1;
	JTextField tf;
	JButton bt;
	JPanel p1,p2;
	JButton bt1;
	
	DeleteContact()
	{
		
		super(" Contact Information");
		setLocation(1,1);
		setSize(800,400);
		
		f=new Font("Arial",Font.PLAIN,15);
		
		try
		{
			ConnectionClass obj = new ConnectionClass ();
			String q="select * from contact ";
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
		l1=new JLabel("enter contact id to delete:");
		tf=new JTextField();
		bt1=new JButton("Delete");
		
		bt1.setBackground(Color.black);
		bt1.setForeground(Color.red);
		
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
		
		if(e.getSource()==bt1)
		{
			int idno=Integer.parseInt(tf.getText());
			
			try
			{	
				ConnectionClass obj1=new ConnectionClass();
				String qu="delete from contact where id='"+idno+"'";
				
				int res=obj1.stm.executeUpdate(qu);
				new EditData(idno).setVisible(true);
				
				if(res==1)
				{
					
					JOptionPane.showMessageDialog(null,"your contact successfully Deleted");
					this.setVisible(false);
					new DeleteContact().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"!!!!an error occurred!!!!");
					this.setVisible(false);
					new DeleteContact().setVisible(true);
				}	
					
			
			}
			
			catch(Exception e12)
			{
				e12.printStackTrace();
			}
			
			
		}
		
	}
	
	public static void main(String[] args)
	{
	
		new DeleteContact().setVisible(true);
		
	}
	
		
}
		
	

	


