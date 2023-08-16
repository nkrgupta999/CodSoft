package PhoneBook;

import java.awt.*;


import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JTextField tf;
	JPasswordField pf;
	JPanel p1,p2,p3;
	JButton bt1,bt2;
	
	Font f1,f2;
	
	
	
	Login()
	{
		
		super("Login Phonebook");
		setLocation(400,300);
		setSize(530,250);
		
		f1=new Font("Arial",Font.BOLD,25);
		f2=new Font("Arial",Font.BOLD,18);
		
		l1=new JLabel("welcome to PhoneBook");
		l2=new JLabel("UserName");
		l3=new JLabel("Password");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(f2);
		l2.setFont(f2);
		l3.setFont(f2);
		
		tf = new JTextField();
		pf=new JPasswordField();
		
		tf.setFont(f2);
		tf.setFont(f2); 
		
		bt1 = new JButton("Login");
		bt2= new JButton("Cancel");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		bt1.setFont(f2);
		bt2.setFont(f2);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
		Image img2 = img.getImage().getScaledInstance(200,800,Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		
		l4= new JLabel(img);
		
		
		p1= new JPanel(); 
		p1.setLayout(new GridLayout(3,2,10,10));
		p1.add(l2);
		p1.add(tf);
		p1.add(l3);
		p1.add(pf);
		p1.add(bt1);
		p1.add(bt2);
		
		p2= new JPanel(); 
		p2.setLayout(new GridLayout(1,2,10,10));
		p2.add(l1);
		
		p3= new JPanel(); 
		p3.setLayout(new GridLayout(3,2,10,10));
		p3.add(l4);
		
		setLayout(new BorderLayout(10,20));
		 add(p2, BorderLayout.NORTH); 
		 add(p3, BorderLayout.EAST);  
		 add(p1, BorderLayout.CENTER);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String username = tf.getText();
		String password =pf.getText();
		
		if(e.getSource()==bt1)
			
		{
			try {
				ConnectionClass obj = new ConnectionClass();
				String q="select * from login where username ='"+username+"'and password='"+password+"'";
				ResultSet rest = obj.stm.executeQuery(q);
				
				if(rest.next())
				{
					
					new Home().setVisible(true);
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"your credentials doesn't match");
					this.setVisible(false);
				}
				 
			}
			catch(Exception ex) {
				
				ex.printStackTrace();
			
			}
			
		}
		
		if(e.getSource()==bt2)
		{
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new Login().setVisible(true);
		
	}
	
	

}
