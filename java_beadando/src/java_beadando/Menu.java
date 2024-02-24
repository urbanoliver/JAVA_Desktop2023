package java_beadando;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Menu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnQuit;
	private JButton btnListSoldiers;
	private JButton btnInsertSoldier;
	private JButton btnModifySoldier;
	private JButton btnDeleteSoldier;
	private SoldierTable soldtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(249, 11, 67, 25);
		contentPane.add(lblNewLabel);
		
		btnListSoldiers = new JButton("List Soldiers");
		btnListSoldiers.setForeground(Color.BLACK);
		btnListSoldiers.setBackground(new Color(0, 255, 0));
		btnListSoldiers.setBounds(204, 78, 152, 25);
		contentPane.add(btnListSoldiers);
		
		btnInsertSoldier = new JButton("Insert New Soldier");
		btnInsertSoldier.setForeground(Color.BLACK);
		btnInsertSoldier.setBackground(new Color(0, 255, 0));
		btnInsertSoldier.setBounds(204, 114, 152, 25);
		contentPane.add(btnInsertSoldier);
		
		btnModifySoldier = new JButton("Modify Soldier");
		btnModifySoldier.setBackground(new Color(0, 255, 0));
		btnModifySoldier.setForeground(Color.BLACK);
		btnModifySoldier.setBounds(204, 150, 152, 25);
		contentPane.add(btnModifySoldier);
		
		btnDeleteSoldier = new JButton("Delete Soldier");
		btnDeleteSoldier.setBackground(new Color(0, 255, 0));
		btnDeleteSoldier.setForeground(Color.BLACK);
		btnDeleteSoldier.setBounds(204, 186, 152, 25);
		contentPane.add(btnDeleteSoldier);
		
		btnQuit = new JButton("Quit");
		btnQuit.setForeground(new Color(255, 255, 255));
		btnQuit.setBackground(new Color(255, 0, 0));
		btnQuit.setBounds(235, 283, 89, 23);
		contentPane.add(btnQuit);
		
		
		Object soldtmn[] = {"ID", "Name", "Rank", "Age", "Begin of Service"};
		soldtm = new SoldierTable(soldtmn,0);
		
		this.btnQuit.addActionListener(this);
		this.btnListSoldiers.addActionListener(this);
		this.btnInsertSoldier.addActionListener(this);
		this.btnDeleteSoldier.addActionListener(this);
		this.btnModifySoldier.addActionListener(this);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Quit")) {
			dispose();
		}
		
		if(e.getActionCommand().equals("List Soldiers")) {
			soldtm = FileManager.CsvReader();
			SoldList sl = new SoldList(Menu.this, soldtm);
			
			sl.setVisible(true);
			
		}
		if(e.getActionCommand().equals("Insert New Soldier")) {
			NewSold newsold = new NewSold();
			newsold.setVisible(true);
			
		}
		
		if(e.getActionCommand().equals("Modify Soldier")) {
			soldtm = FileManager.CsvReader();
			ModSold ms = new ModSold(Menu.this, soldtm);
			
			ms.setVisible(true);
			
			
		}
		
		if(e.getActionCommand().equals("Delete Soldier")) {
			soldtm = FileManager.CsvReader();
			DelSold ds = new DelSold(Menu.this, soldtm);
			
			ds.setVisible(true);
		}
	}
	
}
