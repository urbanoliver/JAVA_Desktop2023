package java_beadando;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;



public class ModSold extends JDialog implements ActionListener{
	private JButton btnClose;
	private JTable table;
	private SoldierTable soldtm;
	private JButton btnMod;
	Checker c = new Checker();
	private JTextField id;
	private JTextField name;
	private JTextField rank;
	private JTextField age;
	private JTextField bos;

	
	public ModSold(JFrame f, SoldierTable soldtmb) {
		super(f,"Modify Soldier",true);
		getContentPane().setBackground(new Color(128, 128, 128));
		soldtm = soldtmb;
		
		setBounds(100, 100, 516, 307);
		getContentPane().setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setBounds(317, 240, 89, 23);
		getContentPane().add(btnClose);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 11, 480, 183);
		getContentPane().add(scrollPane);
		
		table = new JTable(soldtm);
		scrollPane.setViewportView(table);
		
		TableColumn tc = null;
		for (int i = 0; i < 6; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i == 0 || i == 4)
				tc.setPreferredWidth(40);
			else if (i == 1)
				tc.setPreferredWidth(70);
			else {
				tc.setPreferredWidth(150);
			}
		}
		
		table.setAutoCreateRowSorter(true);
		
		btnMod = new JButton("Modify");
		btnMod.setForeground(Color.BLACK);
		btnMod.setBackground(new Color(0, 255, 0));
		btnMod.setBounds(93, 240, 89, 23);
		getContentPane().add(btnMod);
		
		id = new JTextField();
		id.setBounds(44, 196, 60, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(114, 196, 111, 20);
		getContentPane().add(name);
		
		rank = new JTextField();
		rank.setColumns(10);
		rank.setBounds(235, 196, 100, 20);
		getContentPane().add(rank);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(345, 196, 35, 20);
		getContentPane().add(age);
		
		bos = new JTextField();
		bos.setColumns(10);
		bos.setBounds(390, 196, 100, 20);
		getContentPane().add(bos);
		TableRowSorter<SoldierTable> trs = (TableRowSorter<SoldierTable>) table.getRowSorter();
		trs.setSortable(0, false);
		
		
		this.btnClose.addActionListener(this);
		this.btnMod.addActionListener(this);
		
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Modify")) {
			int db = 0, sign = 0, i = 0;
			for(i = 0; i < soldtm.getRowCount();i++) {
				if((Boolean)soldtm.getValueAt(i, 0)) {
					db++;
					sign = i;
				}
			}
			if(db > 1 ) {
				c.SM("Only one recard can be modified!", 0);
			}
			if( db == 0 ) {
				c.SM("None of the record is selected!", 0);
			}
			if(db == 1) {
				if(modData() > 0 ) {
					boolean b = true;
					if(filled(id)) {
						b = c.is_number(id,"ID");
					}
					if(b && filled(age)) {
						b = c.is_number(age, "Age");
					}
					if(b) {
						if(filled(id)) {
							soldtm.setValueAt(c.stringToInt(c.RTF(id)), sign, 1);
						}
						if(filled(name)) {
							soldtm.setValueAt(c.RTF(name), sign, 2);
						}
						if(filled(rank)) {
							soldtm.setValueAt(c.RTF(rank), sign, 3);
						}
						if(filled(age)) {
							soldtm.setValueAt(c.stringToInt(c.RTF(age)), sign, 4);
						}
						if(filled(bos)) {
							soldtm.setValueAt(c.RTF(bos), sign, 5);
						}
						FileManager.Insert(soldtm);
						c.SM("record modified successfully!", 1);
						
						
					}
				}
				else {
					c.SM("None of the record is selected!", 1);
				}
			}
			
		}
		
		
		if(e.getActionCommand().equals("Close")) {
			dispose();
		}
		
	}
	public boolean filled(JTextField jtf) {
		String s = c.RTF(jtf);
		if(s.length() > 0 ) {
			return true;
		}
		else {
			return false;
		}
	}
	public int modData() {
		int x = 0;
		if(filled(id)) {
			x++;
		}
		if(filled(name)) {
			x++;
		}
		if(filled(rank)) {
			x++;
		}
		if(filled(age)) {
			x++;
		}
		if(filled(bos)) {
			x++;
		}
		return x;
	}
	
}
