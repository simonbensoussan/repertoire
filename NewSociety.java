package Projets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Test.SqliteConnect;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewSociety extends JFrame {

	private JPanel contentPane;
	private JTextField tf_nameNew;
	private JTextField tf_cityNew;
	private JTextField tf_AdresseNew;
	private JTextField tf_codeNew;
	private JTextField tf_nbrEmpNew;
	private JTextField tf_caNew;
	private JTextField tf_webSiteNew;
	Connection con;
	Society society;
	Test test;
	JComboBox  comboSector;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSociety frame = new NewSociety();
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowListener() {

			            @Override
			            public void windowClosing(WindowEvent e) {
			                if(JOptionPane.showConfirmDialog(frame, "Are you sure to cancel ?") == JOptionPane.OK_OPTION){
			                	frame.setDefaultCloseOperation(
	                                    JFrame.DISPOSE_ON_CLOSE);
			                	refresh_2();
			                    frame.setVisible(false);
			                    frame.dispose();
			                }
			            }

						@Override
						public void windowActivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowClosed(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowDeactivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowDeiconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowIconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void windowOpened(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}

			        });

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 *  on connect la base de données avec la arraylist qui lui correspond
		ici on veut arrayList de sector on connect avec SqliterSector
	 */
	public NewSociety() throws SQLException {
		init();
		con = SqliteSector.dbConnector();  
		con = SqliteSociety.dbConnector();
		FunctionDatabase.fillComboSector(comboSector);
		
	}

public void createSociety(){

	int idSector = getIdSector();
	society = new Society(0,tf_nameNew.getText(),tf_AdresseNew.getText(),tf_cityNew.getText(),Integer.parseInt(tf_caNew.getText()),Integer.parseInt(tf_codeNew.getText()),Integer.parseInt(tf_nbrEmpNew.getText()),idSector,tf_webSiteNew.getText());

SqliteSociety.insertSociety(society.getName() ,society.getAdress(),society.getCity() ,society.getCA(), society.getCode_city(), society.getNombre_Employee(),society.getSector(),society.getWeb_site() );
}

private int getIdSector() {
	ArrayList<Sector>MesSectors = new ArrayList<Sector>();
	MesSectors = SqliteSector.getSectorList();
	String nomSector = comboSector.getSelectedItem().toString();
	int id =0;
	for (Sector sector : MesSectors) {
		if(sector.getLibeller().equals(nomSector))
			id = sector.getId();	
	}
	return id;
}
private static void refresh_2() {
	new Test().setVisible(true);
	}

private void refresh_1() {
	test = new Test();
	test.invalidate();
	test.validate();
	test.repaint();
	test.setVisible(true);
}
	private void init() {
		setDefaultCloseOperation(JFrame. DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 635, 465);
		setTitle("New Society ");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);  
		
		JLabel lblNewLabel = new JLabel("NEW SOCIETY");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 11, 655, 39);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(46, 53, 562, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 26, 54, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresse.setBounds(10, 70, 83, 20);
		panel.add(lblAdresse);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(282, 26, 44, 20);
		panel.add(lblCity);
		
		JLabel lblCodeCity = new JLabel("Code city:");
		lblCodeCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodeCity.setBounds(282, 70, 83, 20);
		panel.add(lblCodeCity);
		
		tf_nameNew = new JTextField();
		tf_nameNew.setBounds(74, 26, 169, 20);
		panel.add(tf_nameNew);
		tf_nameNew.setColumns(10);
		
		tf_cityNew = new JTextField();
		tf_cityNew.setColumns(10);
		tf_cityNew.setBounds(334, 26, 177, 20);
		panel.add(tf_cityNew);
		
		tf_AdresseNew = new JTextField();
		tf_AdresseNew.setColumns(10);
		tf_AdresseNew.setBounds(74, 70, 169, 20);
		panel.add(tf_AdresseNew);
		
		tf_codeNew = new JTextField();
		tf_codeNew.setColumns(10);
		tf_codeNew.setBounds(355, 70, 106, 20);
		panel.add(tf_codeNew);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Economic", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(116, 159, 429, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCategory = new JLabel("Sector:");
		lblCategory.setBounds(10, 22, 66, 20);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblCategory);
		
		JLabel lblNumberOfEmployees = new JLabel("Number of Employees : >>");
		lblNumberOfEmployees.setBounds(10, 57, 166, 20);
		lblNumberOfEmployees.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNumberOfEmployees);
		
		JLabel lblCa = new JLabel("CA : >>");
		lblCa.setBounds(256, 22, 59, 20);
		lblCa.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblCa);
		
		tf_nbrEmpNew = new JTextField();
		tf_nbrEmpNew.setBounds(174, 57, 129, 20);
		tf_nbrEmpNew.setColumns(10);
		panel_1.add(tf_nbrEmpNew);
		
		tf_caNew = new JTextField();
		tf_caNew.setBounds(298, 22, 95, 20);
		tf_caNew.setColumns(10);
		panel_1.add(tf_caNew);
		
		JLabel lblK = new JLabel("K");
		lblK.setBounds(399, 22, 22, 20);
		lblK.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblK);
	/*	String item = comboSector.getSelectedItem().toString();
		System.out.println( "item click : " +item);*/
		 comboSector = new JComboBox();     //new String[]{"1","2","3"," 4"}
	
		comboSector.setBounds(60, 22, 166, 20);
		panel_1.add(comboSector);
		
		JButton btnCreateNew = new JButton("CREATE");
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create a new society from the form
				createSociety();
				FunctionDatabase.emptyField(new JTextField[] {tf_nameNew,tf_AdresseNew,tf_cityNew,tf_codeNew,tf_caNew,tf_nbrEmpNew,tf_webSiteNew});
			}

	
		});
		btnCreateNew.setForeground(new Color(0, 128, 0));
		btnCreateNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateNew.setBounds(207, 356, 89, 23);
		contentPane.add(btnCreateNew);
		
		JButton btnCancelNew = new JButton("CANCEL");
		btnCancelNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Test().setVisible(false);
				refresh_1();
			}
		});
		btnCancelNew.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelNew.setBounds(360, 356, 89, 23);
		contentPane.add(btnCancelNew);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 1, true), "Web Site", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBounds(161, 258, 358, 76);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAdresseSite = new JLabel("Adresse site :");
		lblAdresseSite.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdresseSite.setBounds(10, 29, 83, 20);
		panel_2.add(lblAdresseSite);
		
		tf_webSiteNew = new JTextField();
		tf_webSiteNew.setColumns(10);
		tf_webSiteNew.setBounds(103, 29, 223, 20);
		panel_2.add(tf_webSiteNew);
		
		JLabel label = new JLabel("Developed by Simon CopyRight");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(0, 399, 190, 27);
		contentPane.add(label);
	}
}
