package java_beadando;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Checker {
	
	private SimpleDateFormat RDF = new SimpleDateFormat("yyyy.MM.dd");
	
	public boolean DateFormatChecker(String SDate) {
		try {
			Date date = RDF.parse(SDate);
			if(!RDF.format(date).equals(SDate)) {
				return false;
			}
			else {
				return true;
			}
		} catch(ParseException pf) {
			return false;
		}
		
		
	}
	
	public boolean is_valid_date(JTextField a, String an) {
		String s = RTF(a);
		boolean b = is_empty(a, an);
		if(b && DateFormatChecker(s) ) {
			return true;
		}
		else {
			SM("ERROR: Wrong date format!",0);
			return false;
		}
	}
	
	
	public boolean is_empty(JTextField a, String an) {
		String s = RTF(a);
		if(s.length() > 0 ) {
			return true;
		}
		else {
			SM("ERROR: "+an+" field is empty!",0);
			return false;
		}
	}
	
	public boolean is_number(JTextField a, String an) {
		String s = RTF(a);
		boolean b = is_empty(a, an);
		if(b) try{
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			SM("ERROR: Wrong number in field: "+an,0);
			b = false;
		}
		return b;
	}
	
	public int stringToInt(String s) {
		int x = -1;
		try {
			x=Integer.valueOf(s);
		}catch(NumberFormatException nfe) {
			SM("String to Int: "+ nfe.getMessage(),0);
		}
		return x;
	}
	

	public  void SM(String msg, int tipus) {
		JOptionPane.showMessageDialog(null, msg, "Program message", tipus);
	}

	public String RTF(JTextField jtf) {
		return jtf.getText();
	}

}
