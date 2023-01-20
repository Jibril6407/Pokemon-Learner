import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Fenster extends JFrame {
	
	private JLabel jLabel1 = new JLabel();
	private JButton jButton0 = new JButton();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JButton jButton4 = new JButton();
	private ArrayList<JButton> Typesbuttons = new ArrayList<JButton>();
	Random rand = new Random();
 
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
    
    jLabel1.setBounds(150, 140, 350, 50);
    cp.add(jLabel1);
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
    jButton4.setBounds(275, 275, 100, 50);
    jButton4.setText("Random");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(jButton4);
    int count = 0;
    for(int i=0;i<18;i++) {
    	
		Typesbuttons.add(new JButton());
    }
    Datenbank.getTypes("SELECT Types FROM Pokemon_Types");
    for(int i=0;i<3;i++) {
    	for(int j=0;j<6;j++) {
    		int temp_id = i*6+j;
    		String temp_name = Datenbank.getTypes(count);
    		Typesbuttons.get(count).setBounds(100*j+50,30*i+350,85,25);
    		Typesbuttons.get(count).setMargin(new Insets(2, 2, 2, 2));
    		Typesbuttons.get(count).setText(Datenbank.getTypes(count));
    		Typesbuttons.get(count).addActionListener(new ActionListener() { 
    		      public void actionPerformed(ActionEvent evt) { 
    		        Typesbuttons_ActionPerformed(evt, temp_id, temp_name);
    		      }
    		    });
    		cp.add(Typesbuttons.get(count));
    		count++;
    	}
    }
    
    setVisible(true);
  } // end of public Fenster
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
	  String Type = jLabel1.getText();
	  if(jButton1.getText() == "Effective") {
		  Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"+Type+"'");
		  int size = Datenbank.Types.size();
		  for(int i = 0; i < size; i++) {
			  System.out.println(Datenbank.getTypes(i));
		  }
	  }    
  } // end of jButton1_ActionPerformed
  public void jButton2_ActionPerformed(ActionEvent evt) {
	  String Type = jLabel1.getText();
	  if(jButton2.getText() == "Not Effective") {
		  Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"+Type+"'");
		  int size = Datenbank.Types.size();
		  for(int i = 0; i < size; i++) {
			  System.out.println(Datenbank.getTypes(i));
		  }
		  }
  }
  public void jButton3_ActionPerformed(ActionEvent evt) {
	  String Type = jLabel1.getText();
	  if(jButton3.getText() == "Immune") {
		  Datenbank.getTypes("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '"+Type+"'");
		  int size = Datenbank.Types.size();
		  for(int i = 0; i < size; i++) {
			  System.out.println(Datenbank.getTypes(i));
		  }
	  }
  }
  public void jButton4_ActionPerformed(ActionEvent evt) {
	  Datenbank.getTypes("SELECT Types FROM Pokemon_Types");
	  int i = rand.nextInt(Datenbank.Types.size());
	  jLabel1.setText(Datenbank.getTypes(i));
  }
  public void Typesbuttons_ActionPerformed(ActionEvent evt, int b_id, String abc) {
	  System.out.println(Integer.toString(b_id) + " " + abc);
  } 
  
  // Ende Methoden
} // end of class Fenster
