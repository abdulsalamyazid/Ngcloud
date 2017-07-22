package tru;
import javafx.scene.*;

import javax.swing.*;
import java.awt.*;


public class gui extends test {
	public static void main(String[] args) throws Exception {
		
		String url=JOptionPane.showInputDialog("Enter the URL text");
		String xml=JOptionPane.showInputDialog("Enter the xml text");
		
	String result=postRequest(xml,url);	
	JOptionPane.showMessageDialog(null, "The response is \n"+result,"Ngcould",JOptionPane.PLAIN_MESSAGE);
		
		
	}

}

/*JFrame j1=new JFrame("WELCOM TO NGCLOUDTEST");
JTextField url=new JTextField(8);
j1.add(url);
j1.setForeground(Color.white);
j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
j1.setLocation(300,50);
j1.setSize(500, 500);
j1.setVisible(true);  */