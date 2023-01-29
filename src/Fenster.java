import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

import java.util.*;

public class Fenster extends JFrame {

	private JLabel currentTypeLabel = new JLabel();
	private JLabel defenderType = new JLabel();
	private JTextPane usedType = new JTextPane();
	private JTextPane resultsPressed = new JTextPane();
	private JTextPane resultsShouldPressed = new JTextPane();
	
	private JButton backButton = new JButton();
	private JButton effectiveButton = new JButton();
	private JButton notEffectiveButton = new JButton();
	private JButton immuneButton = new JButton();
	private JButton randomButton = new JButton();
	private JButton nothingButton = new JButton();
	private ArrayList<JButton> typesbuttons = new ArrayList<JButton>();
	private Rechenzentrum rech = null;
	

	public Fenster(Rechenzentrum r) {
		// Frame-Initialisierung
		super();
		rech = r;
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 1000;
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

		currentTypeLabel.setBounds(150, 140, 350, 50);
		cp.add(currentTypeLabel);
		currentTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		currentTypeLabel.setVisible(false);

		defenderType.setBounds(50, 310, 350, 50);
		cp.add(defenderType);
		defenderType.setText("Defender:");
		defenderType.setFont(new Font("Dialog", Font.BOLD, 18));
		defenderType.setVisible(false);

		usedType.setBounds(20,200,70,450);
		cp.add(usedType);
		usedType.setVisible(false);
		usedType.setEditable(false);
		usedType.setEditorKit(new HTMLEditorKit());
		
		resultsPressed.setBounds(100, 200, 420, 450);
		cp.add(resultsPressed);
		resultsPressed.setVisible(false);
		resultsPressed.setEditable(false);
		resultsPressed.setEditorKit(new HTMLEditorKit());

		resultsShouldPressed.setBounds(530, 200, 420, 450);
		cp.add(resultsShouldPressed);
		resultsShouldPressed.setVisible(false);
		resultsShouldPressed.setEditable(false);
		resultsShouldPressed.setEditorKit(new HTMLEditorKit());

		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		rech.setCurrentType(Datenbank.getTypes(rech.getRand(), 0));
		currentTypeLabel.setText("Attacker: " + rech.getCurrentType());
		backButton.setBounds(0, 0, 100, 50);
		backButton.setText("Back");
		backButton.setMargin(new Insets(2, 2, 2, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				backButton_ActionPerformed(evt, 0);
			}
		});
		cp.add(backButton);

		effectiveButton.setBounds(150, 200, 100, 50);
		effectiveButton.setText("Effective");
		effectiveButton.setMargin(new Insets(2, 2, 2, 2));
		effectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				effectiveButton_ActionPerformed(evt);
			}
		});
		cp.add(effectiveButton);

		notEffectiveButton.setBounds(275, 200, 100, 50);
		notEffectiveButton.setText("Not Effective");
		notEffectiveButton.setMargin(new Insets(2, 2, 2, 2));
		notEffectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				notEffectiveButton_ActionPerformed(evt);
			}
		});
		cp.add(notEffectiveButton);

		immuneButton.setBounds(400, 200, 100, 50);
		immuneButton.setText("Immune");
		immuneButton.setMargin(new Insets(2, 2, 2, 2));
		immuneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				immuneButton_ActionPerformed(evt);
			}
		});
		cp.add(immuneButton);

		randomButton.setBounds(275, 275, 100, 50);
		randomButton.setText("Random");
		randomButton.setMargin(new Insets(2, 2, 2, 2));
		randomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				randomButton_ActionPerformed(evt);
			}
		});
		cp.add(randomButton);

		int count = 0;

		for (int i = 0; i < 18; i++) {
			typesbuttons.add(new JButton());
		}
		// Typen Ersteller der Buttons
		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		Datenbank.getTypes("SELECT Type_color FROM Pokemon_Types", 4);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				String tempTypes = Datenbank.getTypes(count, 0);
				typesbuttons.get(count).setBounds(100 * j + 50, 30 * i + 350, 85, 25);
				typesbuttons.get(count).setMargin(new Insets(2, 2, 2, 2));
				typesbuttons.get(count).setText(Datenbank.getTypes(count, 0));
				typesbuttons.get(count).setBackground(Color.decode(Datenbank.types_color.get(count)));
				typesbuttons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						typesbuttons_ActionPerformed(evt, tempTypes);
					}
				});
				cp.add(typesbuttons.get(count));

				typesbuttons.get(count).setVisible(false);
				count++;
			}
		}
		nothingButton.setBounds(50, 440, 585, 25);
		nothingButton.setText("Nothing");
		nothingButton.setMargin(new Insets(2, 2, 2, 2));
		nothingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nothingButton_ActionPerformed(evt);
			}
		});
		nothingButton.setBackground(Color.WHITE);
		nothingButton.setVisible(false);
		cp.add(nothingButton);

		setVisible(true);
	} // end of public Fenster

	// Anfang Methoden
	public void effectiveButton_ActionPerformed(ActionEvent evt) {
		
		rech.effectiveButton_ActionPerformedMethode(); 

	} // end of jButton1_ActionPerformed

	public void notEffectiveButton_ActionPerformed(ActionEvent evt) {
		
		rech.notEffectiveButton_ActionPerformedMethod();

	}

	public void immuneButton_ActionPerformed(ActionEvent evt) {
		
		rech.immuneButton_ActionPerformedMethod();
		
	}

	public void randomButton_ActionPerformed(ActionEvent evt) {
		
		rech.randomButton_ActionPerformedMethod();

	}

	public void typesbuttons_ActionPerformed(ActionEvent evt, String tempTypes) {
		
		rech.typesbuttons_ActionPerformedMethod( evt,  tempTypes);
	}

	public void backButton_ActionPerformed(ActionEvent evt, int done) {

		rech.backButton_ActionPerformedMethod(evt, done);
	}

	public void nothingButton_ActionPerformed(ActionEvent evt) {
		
		rech.nothingButton_ActionPerformedMethod(evt);
	}
	// Ende Methoden

	// Getter und Setter
	public JLabel getCurrentTypeLabel() {
		return currentTypeLabel;
	}

	public void setCurrentTypeLabel(JLabel currentTypeLabel) {
		this.currentTypeLabel = currentTypeLabel;
	}

	public JLabel getDefenderType() {
		return defenderType;
	}

	public void setDefenderType(JLabel defenderType) {
		this.defenderType = defenderType;
	}

	public JTextPane getUsedType() {
		return usedType;
	}

	public void setUsedType(JTextPane usedType) {
		this.usedType = usedType;
	}

	public JTextPane getResultsPressed() {
		return resultsPressed;
	}

	public void setResultsPressed(JTextPane resultsPressed) {
		this.resultsPressed = resultsPressed;
	}

	public JTextPane getResultsShouldPressed() {
		return resultsShouldPressed;
	}

	public void setResultsShouldPressed(JTextPane resultsShouldPressed) {
		this.resultsShouldPressed = resultsShouldPressed;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}

	public JButton getEffectiveButton() {
		return effectiveButton;
	}

	public void setEffectiveButton(JButton effectiveButton) {
		this.effectiveButton = effectiveButton;
	}

	public JButton getNotEffectiveButton() {
		return notEffectiveButton;
	}

	public void setNotEffectiveButton(JButton notEffectiveButton) {
		this.notEffectiveButton = notEffectiveButton;
	}

	public JButton getImmuneButton() {
		return immuneButton;
	}

	public void setImmuneButton(JButton immuneButton) {
		this.immuneButton = immuneButton;
	}

	public JButton getRandomButton() {
		return randomButton;
	}

	public void setRandomButton(JButton randomButton) {
		this.randomButton = randomButton;
	}

	public JButton getNothingButton() {
		return nothingButton;
	}

	public void setNothingButton(JButton nothingButton) {
		this.nothingButton = nothingButton;
	}

	public ArrayList<JButton> getTypesbuttons() {
		return typesbuttons;
	}

	public void setTypesbuttons(ArrayList<JButton> typesbuttons) {
		this.typesbuttons = typesbuttons;
	}

	public Rechenzentrum getRech() {
		return rech;
	}

	public void setRech(Rechenzentrum rech) {
		this.rech = rech;
	}

	// Ende von Getter und Settern
	
	
} // end of class Fenster
