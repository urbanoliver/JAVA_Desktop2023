package java_beadando;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;



import java.awt.Color;
import javax.swing.JButton;

public class NewSold extends JDialog implements ActionListener{
	private JTextField id;
	private JTextField name;
	private JTextField rank;
	private JTextField age;
	private JTextField bos;
	private JButton btnInsert;
	private JButton btnReset;
	private JButton btnClose;


	/**
	 * Create the dialog.
	 */
	public NewSold() {
		getContentPane().setBackground(new Color(128, 128, 128));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(new Color(0, 255, 0));
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(10, 11, 101, 14);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 255, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(10, 36, 101, 14);
		getContentPane().add(lblName);
		
		JLabel lblRank = new JLabel("Rank:");
		lblRank.setForeground(new Color(0, 255, 0));
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRank.setBounds(10, 61, 101, 14);
		getContentPane().add(lblRank);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(new Color(0, 255, 0));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(10, 86, 101, 14);
		getContentPane().add(lblAge);
		
		JLabel lblBoS = new JLabel("Begin of Service:");
		lblBoS.setForeground(new Color(0, 255, 0));
		lblBoS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBoS.setBounds(10, 111, 101, 14);
		getContentPane().add(lblBoS);
		
		id = new JTextField();
		id.setBounds(121, 9, 86, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(121, 34, 188, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		rank = new JTextField();
		rank.setColumns(10);
		rank.setBounds(121, 59, 188, 20);
		getContentPane().add(rank);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(121, 84, 62, 20);
		getContentPane().add(age);
		
		bos = new JTextField();
		bos.setColumns(10);
		bos.setBounds(121, 109, 138, 20);
		getContentPane().add(bos);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBackground(new Color(0, 255, 0));
		btnInsert.setBounds(10, 160, 89, 23);
		getContentPane().add(btnInsert);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.GREEN);
		btnReset.setBounds(121, 160, 89, 23);
		getContentPane().add(btnReset);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBackground(Color.RED);
		btnClose.setBounds(335, 227, 89, 23);
		getContentPane().add(btnClose);
		
		this.btnInsert.addActionListener(this);
		this.btnClose.addActionListener(this);
		this.btnReset.addActionListener(this);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Checker c = new Checker();
		if (e.getActionCommand().equals("Insert")) {
			if (c.is_number(id, "ID")) {

				if (c.is_empty(name, "Name")) {

					if (c.is_empty(rank, "Rank")) {

						if (c.is_number(age, "Age")) {

							if (c.is_valid_date(bos, "Begin of Service")) {

								FileManager.Insert(RTF(id), RTF(name), RTF(rank), RTF(age), RTF(bos));
							}
						}
					}
				}
			}

		}
		if (e.getActionCommand().equals("Reset")) {
			id.setText(null);
			name.setText(null);
			rank.setText(null);
			age.setText(null);
			bos.setText(null);

		}
		if (e.getActionCommand().equals("Close")) {
			dispose();
		}

	}

	public String RTF(JTextField jtf) {
		return jtf.getText();
	}
}
