package PhoneBook;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class EditData extends JFrame implements ActionListener
{
	

	JLabel l1,l2,l3,l4,l5,l6;
	JButton bt1,bt2;
	JPanel p1,p2;
	Font f,f1;
	JTextField tf1,tf2,tf3,tf4,tf5;
	
	EditData()
	{
		
	}
	
	 EditData(int idno)
	 {
		 
		    super("Update Contact");
			setLocation(450,50);
			setSize(400,400);
			
			f=new Font("Arial",Font.BOLD,20);
			f1=new Font("Arial",Font.BOLD,15);
			
			l1=new JLabel("Update Contact");
			l6=new JLabel("Id");
			l2=new JLabel("Name");
			l3=new JLabel("phone");
			l4=new JLabel("Email");
			l5=new JLabel("Address");
			
			
			
			
			tf1= new JTextField();
			tf2= new JTextField();
			tf3= new JTextField();
			tf4= new JTextField();
			tf5= new JTextField();
			
			bt1= new JButton("add contact");
			bt2=new JButton("Back");
			
			l1.setHorizontalAlignment(JLabel.CENTER);
			
			bt1.addActionListener(this);
			bt2.addActionListener(this);
			
			bt1.setBackground(Color.black);
			bt1.setForeground(Color.red);
			
			l1.setFont(f);
			l2.setFont(f1);
			l3.setFont(f1);
			l4.setFont(f1);
			l5.setFont(f1);
			l6.setFont(f1);
			
			
			tf1.setFont(f1);
			tf2.setFont(f1);
			tf3.setFont(f1);
			tf4.setFont(f1);
			tf5.setFont(f1);
			
			
			bt1.setFont(f1);
			bt2.setFont(f1);
			
			p1=new JPanel();
			p1.setLayout(new GridLayout(1,1,10,10));
			p1.add(l1);
			
			p2=new JPanel();
			p2.setLayout(new GridLayout(6,2,10,10));
			p2.add(l6);
			p2.add(tf5);
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
			
				 
			
			
			try {
				
				ConnectionClass obj1 = new ConnectionClass();
				String q1="select * from contact where id='"+idno+"'";
				ResultSet rest1= obj1.stm.executeQuery(q1);
						
			   while(rest1.next())
			   {
				   tf5.setText(rest1.getString("id"));
				   tf1.setText(rest1.getString("name"));
				   tf2.setText(rest1.getString("phone"));
				   tf3.setText(rest1.getString("email"));
				   tf4.setText(rest1.getString("address"));
				   
				   
			   }
			}
			catch(Exception exx)
			{
				exx.printStackTrace();
			}
			
			tf5.setEditable(false);
			
			setLayout(new BorderLayout(10,20));
			add(p1, BorderLayout.NORTH); 
			add(p2, BorderLayout.CENTER);
				
			
			
	}
	 
	 public void actionPerformed(ActionEvent e)
	 {
		 if(e.getSource()==bt1)
		 {
			 int Cid=Integer.parseInt(tf5.getText());
			 String name =tf1.getText();
			 String	phone=tf2.getText();
			 String email=tf3.getText();
			 String address=tf4.getText();
			 
			 try
			 {
				 ConnectionClass obj3 = new ConnectionClass();
				 String q1="update contact set name='"+name+"',phone='"+phone+"',email='"+email+"',address='"+address+"' where id='"+Cid+"'";
				 
				 int aa=obj3.stm.executeUpdate(q1);
				 if(aa==1)
				 {
					 JOptionPane.showMessageDialog(null,"your data successfully updated");
					 this.setVisible(false);
					 new SearchDatatableForEdit().setVisible(true);
				 }
				 
				 else
				 {
					 JOptionPane.showMessageDialog(null,"please fill all details carefully");
					 
				 }
			 }
			 
			 catch(Exception ee)
			 {
				 ee.printStackTrace();
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
		 new EditData().setVisible(true);
		 
	 }

	

}



























