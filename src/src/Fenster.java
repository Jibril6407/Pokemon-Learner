import java.awt.*;
import javax.swing.*;

public class Fenster extends JFrame {
  // Anfang Attribute
  // Ende Attribute
  
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
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Fenster
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Fenster();
  } // end of main
  
  // Ende Methoden
} // end of class Fenster

