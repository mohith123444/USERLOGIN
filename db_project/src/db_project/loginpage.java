package db_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class loginpage {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel.setBounds(199, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel_1.setBounds(104, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		lblNewLabel_2.setBounds(104, 168, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tb1 = new JTextField();
		tb1.setBounds(225, 84, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(225, 165, 86, 20);
		frame.getContentPane().add(p1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tb1.getText();
				String pwd=p1.getText();
				try {
				Connection con=DriverManager.getConnection
						("jdbc:mysql://localhost:3306/mydb","root","mrec");
				PreparedStatemant stn=con.prepareStatrmant
						("select namr,pwd from user where name=? and pwd+=?");
				stn.setString(1, name);
				stn.setString(2, pwd);
				ResultSet rs=stn.executeQuery();
				if(rs,next())
				{
					JOPtionPane.showMessageDialog(btnNewButton,"valid user");
				}
				else
				{
					JOPtionPane.showMessageDialog(btnNewButton,"invalid user");
				}
				}
				catch(SQLException e1)
				{
					e1.printStackTtace();
					
		
				
				}
				}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		btnNewButton.setBounds(156, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
