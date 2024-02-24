package java_beadando;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JCheckBox;

public class LogIn extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwField;
	private JButton btnSignIn;
	private JButton btnReset;
	private JLabel lblMessage;
	private JCheckBox chckbxShowPsw;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setTitle("Log In");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(0, 255, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(80, 64, 113, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassw = new JLabel("Password:");
		lblPassw.setForeground(new Color(0, 255, 0));
		lblPassw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassw.setBounds(80, 100, 113, 25);
		contentPane.add(lblPassw);
		
		usernameField = new JTextField();
		usernameField.setBounds(203, 70, 211, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwField = new JPasswordField();
		passwField.setColumns(10);
		passwField.setBounds(203, 106, 211, 20);
		contentPane.add(passwField);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setBackground(new Color(0, 255, 0));
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignIn.setBounds(152, 197, 89, 23);
		contentPane.add(btnSignIn);
		
		btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(new Color(0, 255, 0));
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(325, 197, 89, 23);
		contentPane.add(btnReset);
		
		chckbxShowPsw = new JCheckBox("Show Password");
		chckbxShowPsw.setForeground(new Color(0, 255, 0));
		chckbxShowPsw.setBackground(new Color(128, 128, 128));
		chckbxShowPsw.setBounds(203, 131, 141, 23);
		contentPane.add(chckbxShowPsw);
		
		JLabel lblAppLogIn = new JLabel("Army LogIn");
		lblAppLogIn.setForeground(new Color(0, 255, 0));
		lblAppLogIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAppLogIn.setBounds(231, 11, 133, 25);
		contentPane.add(lblAppLogIn);
		
		lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblMessage.setForeground(new Color(0, 255, 0));
		lblMessage.setBounds(152, 242, 262, 25);
		contentPane.add(lblMessage);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(476, 276, 89, 23);
		contentPane.add(btnExit);
		
		this.btnSignIn.addActionListener(this);
		this.btnReset.addActionListener(this);
		this.chckbxShowPsw.addActionListener(this);
		this.btnExit.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getActionCommand().equals("Sign In")) {
			/*String msg = "Log In success!";
			lblMessage.setText(msg);*/
			String userText = usernameField.getText();
			String pwdText = passwField.getText();
			
			if(userText.equals("admin") && pwdText.equals("admin")) {
				lblMessage.setText("You successfully logged in!");
				Menu menu = new Menu();
				menu.setVisible(true);
				
				
			}
			else {
				lblMessage.setText("Invalid username or password!");
			}

		}
		
		if (e.getActionCommand().equals("Reset")) {
			usernameField.setText(null);
			passwField.setText(null);

		}
		
		if (e.getActionCommand().equals("Show Password")) {
			if (chckbxShowPsw.isSelected()) {
				((JPasswordField) passwField).setEchoChar((char) 0);
			} else {
				((JPasswordField) passwField).setEchoChar('*');
			}
		}
		
		if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
			
			
		}
		
	}
}
