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



public class DelSold extends JDialog implements ActionListener{
	private JButton btnClose;
	private JTable table;
	private SoldierTable soldtm;
	private JButton btnDel;
	Checker c = new Checker();

	
	public DelSold(JFrame f, SoldierTable soldtmb) {
		super(f,"Delete Soldier",true);
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
		scrollPane.setBounds(10, 11, 480, 218);
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
		
		btnDel = new JButton("Delete");
		btnDel.setForeground(Color.BLACK);
		btnDel.setBackground(new Color(0, 255, 0));
		btnDel.setBounds(93, 240, 89, 23);
		getContentPane().add(btnDel);
		TableRowSorter<SoldierTable> trs = (TableRowSorter<SoldierTable>) table.getRowSorter();
		trs.setSortable(0, false);
		
		
		this.btnClose.addActionListener(this);
		this.btnDel.addActionListener(this);
		
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Delete")) {
			int db = 0, sign = 0, i = 0;
			for(i = 0; i < soldtm.getRowCount();i++) {
				if((Boolean)soldtm.getValueAt(i, 0)) {
					db++;
					sign = i;
				}
			}
			if(db > 1 ) {
				c.SM("Only one record can be deleted", 0);
			}
			if( db == 0 ) {
				c.SM("None of the record is selected!", 0);
			}
			if(db == 1) {
				soldtm.removeRow(sign);
				FileManager.Insert(soldtm);
				dispose();
				c.SM("Record deleted!", 1);
			}
			
		}
		
		
		if(e.getActionCommand().equals("Close")) {
			dispose();
		}
		
	}
}
