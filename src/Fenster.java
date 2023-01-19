import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Fenster extends JFrame {
	
	private JTextField jTextField1 = new JTextField();
	private JButton jButton1 = new JButton();
 
public Fenster() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 750; 
    int frameHeight = 750;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Fenster");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    jTextField1.setBounds(231, 141, 198, 52);
    cp.add(jTextField1);
    jButton1.setBounds(230, 218, 195, 49);
    jButton1.setText("Bestätigen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    
    setVisible(true);
  } // end of public Fenster
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Fenster();
  } // end of main
  public void jButton1_ActionPerformed(ActionEvent evt) {
	  String Type = jTextField1.getText();
	  
	  Datenbank.update1("SELECT Effective FROM 'Pokemon_Type_Effective'WHERE Type = '"+Type+"'");
	  int size = Datenbank.Typen.size();
	  for(int i = 0; i < size; i++) {
		  System.out.println(Datenbank.getTypen(i));
	  }
	    
	  } // end of jButton1_ActionPerformed
 
  // Ende Methoden
} // end of class Fenster
