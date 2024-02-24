package java_beadando;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;


public class FileManager {

	public static SoldierTable CsvReader() {
		Object soldtmn[] = {"Sign","ID","Name","Rank","Age","Begin of Service"};
		SoldierTable soldtm = new SoldierTable(soldtmn, 0);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("soldiers.csv"));
			String s = in.readLine();
			s = in.readLine();
			while(s != null) {
				
				String[] st = s.split(";");
				soldtm.addRow(new Object[] {false, st[0], st[1], st[2], st[3], st[4]});
				
				s=in.readLine();
				
			}
		in.close();	
		}catch(IOException ioe) {
			System.out.println("CsvReader: " + ioe.getMessage());
		}
		return soldtm;
	}
	
	public static void Insert(String id, String name, String rank, String age, String beginOfService) {
		String x = ";";
		try {
			PrintStream out = new PrintStream(new FileOutputStream("soldiers.csv", true));
			out.println(id+x+name+x+rank+x+age+x+beginOfService);
			out.close();
			SM("Insert successful!", 1);
		}catch(IOException ioe) {
			SM("FM.Insert: "+ioe.getMessage(),0);
		}
	}
	
	public static void Insert(SoldierTable soldtm) 
	{
		String x=";";
		try {
			PrintStream out = new PrintStream(new FileOutputStream("soldiers.csv"));
			out.println("Sign;ID;Name;Rank;Age;Begin of Service");
			for(int i = 0; i< soldtm.getRowCount();i++) {
				String id = soldtm.getValueAt(i, 1).toString();
				String name = soldtm.getValueAt(i, 2).toString();
				String rank = soldtm.getValueAt(i, 3).toString();
				String age = soldtm.getValueAt(i, 4).toString();
				String bos = soldtm.getValueAt(i, 5).toString();
				
				out.println(id+x+name+x+rank+x+age+x+bos);
				
			}
			out.close();
			
		}catch(IOException ioe) {
			SM("Insert error!"+ioe.getMessage(),0);
		}
	}
	
	public static void SM(String msg,int tipus) {
		JOptionPane.showMessageDialog(null, msg, "Program message", tipus);
	}
}
