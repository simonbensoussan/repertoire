package Projets;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * @author sbensous
 *
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Login_field;
	private JPasswordField password_field;
	Connection conn =null;
	ResultSet rs = null;
	PreparedStatement prst = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor
	 */
	public Login() {
		init();
		conn = SqliteContact.dbConnector();
	}
	/**
	 * Create the frame.
	 */
	private void getVerification() {
		String sql = "select * from Access where Login=? and Password =?";
		try {
			prst = conn.prepareStatement(sql);
			prst.setObject(1,Login_field.getText());
			prst.setObject(2,password_field.getText());
			rs = prst.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(null, "Login and Password is correct");
				
				Test test = new Test();
				test.setVisible(true);
				dispose();
				System.out.println("[CONNEXION]-OK");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Login and Password is incorrect");
			}
			rs.close();
			prst.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void closeWindow(){
		WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 292);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Administrator");
		contentPane.setLayout(null);
		
		JPanel Administrator = new JPanel();
		Administrator.setBounds(165, 31, 241, 170);
		Administrator.setBackground(new Color(255, 239, 213));
		Administrator.setForeground(new Color(0, 0, 0));
		Administrator.setToolTipText("");
		Administrator.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Administrator", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
		contentPane.add(Administrator);
		Administrator.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(6, 39, 62, 14);
		Administrator.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(6, 70, 62, 14);
		Administrator.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		Login_field = new JTextField();
		Login_field.setBounds(78, 36, 102, 20);
		Administrator.add(Login_field);
		Login_field.setColumns(10);
		
		password_field = new JPasswordField();
		password_field.setBounds(78, 67, 102, 20);
		Administrator.add(password_field);
		
		JButton btnOK = new JButton(" Validez");
		btnOK.setIcon(new ImageIcon("C:\\Users\\simon_bens\\Pictures\\circle-apply-icon (1).png"));
		btnOK.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				getVerification();
			}
		});
		btnOK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOK.setBounds(78, 121, 102, 23);
		Administrator.add(btnOK);
		
		JLabel imgLogin = new JLabel("");
		imgLogin.setBounds(37, 56, 94, 117);
		imgLogin.setIcon(new ImageIcon("C:\\Users\\simon_bens\\Pictures\\circle-lock-icon.png"));
		contentPane.add(imgLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-41, 83, 118, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Developed by Simon CopyRight");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 236, 182, 27);
		contentPane.add(label);
	}
}
