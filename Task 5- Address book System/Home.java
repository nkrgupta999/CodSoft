package PhoneBook;

import java.awt.*;

import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JButton bt1,bt2,bt3,bt4,bt5;
	JPanel p1,p2,p3;
	Font f,f1;
	
	
	Home()
	{
		super("Home Section");
		setLocation(450,250);
		
		setSize(450,400);
		
		f=new Font("Arial",Font.BOLD,20);
		f1=new Font("Arial",Font.BOLD,15);
		
		l1=new JLabel("Phone Book");
		
		bt1=new JButton("Add");
		bt2=new JButton("Search");
		bt3=new JButton("Edit");
		bt4=new JButton("Delete");
		bt5=new JButton("Exit");
		
		l1.setHorizontalAlignment(JLabel.CENTER);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource(""));
		Image img2 = img.getImage().getScaledInstance(10,10,Image.SCALE_AREA_AVERAGING);
		ImageIcon img3 = new ImageIcon(img2);
		
		l2= new JLabel(img);
		
		l1.setFont(f);
		bt1.setFont(f1);
		bt2.setFont(f1);
		bt3.setFont(f1);
		bt4.setFont(f1);
		bt5.setFont(f1);
		
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5,1,10,10));
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		p1.add(bt4);
		p1.add(bt5);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,1,10,10));
		p2.add(l1);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout(1,1,10,10));
		p3.add(l2);
		
		setLayout(new BorderLayout(10,20));
		 add(p2, BorderLayout.NORTH); 
		 add(p3, BorderLayout.EAST);  
		 add(p1, BorderLayout.CENTER);
	
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//when add is pressed---->
		if(e.getSource()==bt1) {
			this.setVisible(false);
			new EntryData().setVisible(true);
			
			
		}
		//when search button is pressed---->
		if(e.getSource()==bt2) {
			this.setVisible(false);
			new SearchData().setVisible(true);
			
		}
		
		//when edit button is pressed---->		
		if(e.getSource()==bt3) {
			this.setVisible(false);
			new SearchNameforEdit().setVisible(true);
			
			
		}
		//when delete button is pressed---->
		if(e.getSource()==bt4)
		{
			this.setVisible(false);
			new DeleteContact().setVisible(true);
			
			
		}
		
		//when exit button is pressed----->
		if(e.getSource()==bt5)
		{
			this.setVisible(false);
			
			
			
		}
		
	}
	
	public static void main(String[] args)
	{
		new Home().setVisible(true);
	}
	
	
}
