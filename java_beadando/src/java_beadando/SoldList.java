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



public class SoldList extends JDialog implements ActionListener{
	private JButton btnClose;
	private JTable table;
	private SoldierTable soldtm;

	
	public SoldList(JFrame f, SoldierTable soldtmb) {
		super(f,"List of Soldiers",true);
		getContentPane().setBackground(new Color(128, 128, 128));
		soldtm = soldtmb;
		
		setBounds(100, 100, 516, 307);
		getContentPane().setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setBounds(202, 240, 89, 23);
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
		TableRowSorter<SoldierTable> trs = (TableRowSorter<SoldierTable>) table.getRowSorter();
		trs.setSortable(0, false);
		
		
		this.btnClose.addActionListener(this);
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Close")) {
			dispose();
		}
		
	}
}
