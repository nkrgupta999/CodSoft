
package PhoneBook;

import java.awt.*;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class EntryData  extends JFrame implements ActionListener 
{
	
	JLabel l1,l2,l3,l4,l5;
	JButton bt1,bt2;
	JPanel p1,p2;
	Font f,f1;
	JTextField tf1,tf2,tf3,tf4;
	
	EntryData(){
		
		super("Add Contact");
		setLocation(450,50);
		setSize(400,400);
		
		f=new Font("Arial",Font.BOLD,20);
		f1=new Font("Arial",Font.BOLD,15);
		
		l1=new JLabel("Add Contact");
		l2=new JLabel("Name");
		l3=new JLabel("phone");
		l4=new JLabel("Email");
		l5=new JLabel("Address");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		tf1= new JTextField();
		tf2= new JTextField();
		tf3= new JTextField();
		tf4= new JTextField();
		
		bt1= new JButton("add contact");
		bt2=new JButton("Back");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		l1.setFont(f);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		
		tf1.setFont(f1);
		tf2.setFont(f1);
		tf3.setFont(f1);
		tf4.setFont(f1);
		
		
		bt1.setFont(f1);
		bt2.setFont(f1);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,1,10,10));
		p1.add(l1);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(6,2,10,10));
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(bt1);
		p2.add(bt2);
		
		setLayout(new BorderLayout(10,20));
		 add(p1, BorderLayout.NORTH); 
		 add(p2, BorderLayout.CENTER);
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		String name =tf1.getText();
		String phone =tf2.getText();
		String email =tf3.getText();
		String address =tf4.getText();

		if(e.getSource()==bt1)
		{
			try {
				
				ConnectionClass obj = new ConnectionClass();
				String q="insert into contact (name,phone,email,address)values('"+name+"','"+phone+"','"+email+"','"+address+"')";
				int aa=obj.stm.executeUpdate(q);
				
				if(aa==1)
				{
					JOptionPane.showMessageDialog(null,"your data is inserted");
					this.setVisible(false);
					new Home().setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"please fill the deatails correctly");
					
			}
				
	}
			
			
			catch(Exception e1)
				{
					 
					e1.printStackTrace();
				}
				
			
}
		
		if(e.getSource()==bt2)
		{
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args)
	{
		new EntryData().setVisible(true);
	}
}

