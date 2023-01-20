import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Fenster extends JFrame {
	
	private JTextField jTextField1 = new JTextField();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
 
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
    
    jTextField1.setBounds(150, 140, 350, 50);
    cp.add(jTextField1);
    jButton1.setBounds(150, 200, 100, 50);
    jButton1.setText("Effective");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(275, 200, 100, 50);
    jButton2.setText("Not Effective");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(400, 200, 100, 50);
    jButton3.setText("Immune");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    
    setVisible(true);
  } // end of public Fenster
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
	  String Type = jTextField1.getText();
	  if(jButton1.getText() == "Effective") {
	  Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"+Type+"'");
	  int size = Datenbank.Typen.size();
	  for(int i = 0; i < size; i++) {
		  System.out.println(Datenbank.getTypen(i));
	  }
	  }
	    
	  } // end of jButton1_ActionPerformed
  public void jButton2_ActionPerformed(ActionEvent evt) {
	  String Type = jTextField1.getText();
	  if(jButton2.getText() == "Not Effective") {
		  Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"+Type+"'");
		  int size = Datenbank.Typen.size();
		  for(int i = 0; i < size; i++) {
			  System.out.println(Datenbank.getTypen(i));
		  }
		  }
  }
  public void jButton3_ActionPerformed(ActionEvent evt) {
	  String Type = jTextField1.getText();
	  if(jButton3.getText() == "Immune") {
		  Datenbank.getTypes("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '"+Type+"'");
		  int size = Datenbank.Typen.size();
		  for(int i = 0; i < size; i++) {
			  System.out.println(Datenbank.getTypen(i));
		  }
		  }
  }
  
  // Ende Methoden
} // end of class Fenster
