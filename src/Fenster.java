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
	

	String resultPressedText = "<html><b>";
	String resultShouldPressedText = "<html><b>";
	String usedTypeText = "<html><b>";

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
		rech.setMode(1);
		if (effectiveButton.getText() == "Effective") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '" + rech.getCurrentType() + "'", 1);

			rech.clearCompareTypes();
			rech.addCompareTypes(1);

			effectiveButton.setVisible(false);
			notEffectiveButton.setVisible(false);
			immuneButton.setVisible(false);
			randomButton.setVisible(false);
			nothingButton.setVisible(true);
			for (int i = 0; i < 18; i++) {
				typesbuttons.get(i).setVisible(true);
			}
		}
	} // end of jButton1_ActionPerformed

	public void notEffectiveButton_ActionPerformed(ActionEvent evt) {
		rech.setMode(2);
		if (notEffectiveButton.getText() == "Not Effective") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes(
					"SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '" + rech.getCurrentType() + "'", 2);

			rech.clearCompareTypes();
			rech.addCompareTypes(2);

			effectiveButton.setVisible(false);
			notEffectiveButton.setVisible(false);
			immuneButton.setVisible(false);
			randomButton.setVisible(false);
			nothingButton.setVisible(true);
			for (int i = 0; i < 18; i++) {
				typesbuttons.get(i).setVisible(true);
			}
		}
	}

	public void immuneButton_ActionPerformed(ActionEvent evt) {
		rech.setMode(3);
		if (immuneButton.getText() == "Immune") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + rech.getCurrentType() + "'", 3);

			rech.clearCompareTypes();
			rech.addCompareTypes(3);

			effectiveButton.setVisible(false);
			notEffectiveButton.setVisible(false);
			immuneButton.setVisible(false);
			randomButton.setVisible(false);
			nothingButton.setVisible(true);
			for (int i = 0; i < 18; i++) {
				typesbuttons.get(i).setVisible(true);
			}

		}
	}

	public void randomButton_ActionPerformed(ActionEvent evt) {
		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		int i = rech.getRand();
		rech.setCurrentType(Datenbank.getTypes(i, 0));
		currentTypeLabel.setText("Attacker: " + rech.getCurrentType());
	}

	public void typesbuttons_ActionPerformed(ActionEvent evt, String tempTypes) {
		if (rech.getComparedTypes().contains(tempTypes)) {
			System.out.println("That type was already guessed!");
			return;
		}
		rech.setGuessTries(rech.getGuessTries()+1);
		switch (rech.getMode()) {
		case 1:
			if (rech.getCompareTypes().contains(tempTypes)) {
				rech.setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				rech.setComparedTypes(tempTypes);
			}
			if (rech.getCompareTypes().size() == 0) {
				rech.setCompareTypes("Nothing");
			}

			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				int i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();;
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 1);

				rech.clearCompareTypes();;
				rech.addCompareTypes(1);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);
			}

			break;
		case 2:
			System.out.println(rech.getCompareTypes());
			if (rech.getCompareTypes().contains(tempTypes)) {
				rech.setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				rech.setComparedTypes(tempTypes);
			}
			if (rech.getCompareTypes().size() == 0) {
				rech.getCompareTypes().add("Nothing");
			}

			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				int i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 2);
				
				rech.clearCompareTypes();
				rech.addCompareTypes(2);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);
			}

			break;
		case 3:
			System.out.println(rech.getCompareTypes());
			if (rech.getCompareTypes().contains(tempTypes)) {
				rech.setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				rech.setComparedTypes(tempTypes);
			}
			if (rech.getCompareTypes().size() == 0) {
				rech.getCompareTypes().add("Nothing");
			}

			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				int i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(
						"SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + Datenbank.getTypes(i, 0) + "'", 3);

				rech.clearCompareTypes();
				rech.addCompareTypes(3);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);

			}

			break;
		default:
			System.out.println("Default");
		}

	}

	public void backButton_ActionPerformed(ActionEvent evt, int done) {
		rech.setMode(0);
		nothingButton.setVisible(false);
		defenderType.setVisible(false);
		rech.clearCompareTypes();
		rech.clearComparedTypes();
		System.out.println("Pressed:                      " + rech.getAllComparedTypes());
		System.out.println("What you should have pressed: " + rech.getAllCompareTypes());
		if (done == 0) {
			currentTypeLabel.setVisible(false);
			effectiveButton.setVisible(true);
			notEffectiveButton.setVisible(true);
			immuneButton.setVisible(true);
			randomButton.setVisible(true);
			resultsPressed.setVisible(false);
			resultsShouldPressed.setVisible(false);
			usedType.setVisible(false);
			currentTypeLabel.setText("Attacker: " + rech.getCurrentType());
		}

		for (int i = 0; i < 18; i++) {
			typesbuttons.get(i).setVisible(false);
		}

		if (done == 1) {
			currentTypeLabel.setText("Results:");
			currentTypeLabel.setBounds(150, 140, 350, 50);
			for (int i = 0; i < 18; i++) {
				typesbuttons.get(i).setVisible(false);

				for (int j = 0; j < rech.getAllComparedTypes().get(i).size(); j++) {
					if (rech.getAllCompareTypes().get(i).contains(rech.getAllComparedTypes().get(i).get(j))) {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"green\"> "
								+ rech.getAllComparedTypes().get(i).get(j);
					} else {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"red\"> "
								+ rech.getAllComparedTypes().get(i).get(j);
					}
					resultShouldPressedText = resultShouldPressedText + "<font face=\"arial\" color=\"black\"> "
							+ rech.getAllCompareTypes().get(i).get(j);
				}
				resultPressedText = resultPressedText + "<hr>" + "<b>";
				resultShouldPressedText = resultShouldPressedText + "<hr>" + "<b>";
			}
			resultPressedText = resultPressedText + " </b></font></html>";
			resultsPressed.setText(resultPressedText);
			resultShouldPressedText = resultShouldPressedText + " </b></font></html>";
			resultsShouldPressed.setText(resultShouldPressedText);
			usedTypeText = usedTypeText + " </b></font></html>";
			usedType.setText(usedTypeText);
			rech.clearAllComparedTypes();
			rech.clearAllCompareTypes();
			resultsPressed.setVisible(true);
			resultsShouldPressed.setVisible(true);
			usedType.setVisible(true);
		}
		rech.clearUsedTypes();

	}

	public void nothingButton_ActionPerformed(ActionEvent evt) {

		if (rech.getNothingButtonPressed() == 1) {
			System.out.println("You already Pressed Nothing!");
			return;
		}

		int i = rech.getRand();
		rech.setGuessTries(rech.getGuessTries()+1);
		rech.setNothingButtonPressed(rech.getNothingButtonPressed()+1);

		switch (rech.getMode()) {
		case 1:
			
			rech.setComparedTypes("Nothing");
			if(rech.getCompareTypes().size() == 0) {
				rech.setCompareTypes("Nothing");
			}
			
			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 1);

				rech.clearCompareTypes();
				rech.addCompareTypes(1);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);
			}

			break;
		case 2:
			rech.setComparedTypes("Nothing");
			if(rech.getCompareTypes().size() == 0) {
				rech.setCompareTypes("Nothing");
			}
			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 2);

				rech.clearCompareTypes();
				rech.addCompareTypes(2);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);
			}

			break;
		case 3:
			rech.setComparedTypes("Nothing");
			if(rech.getCompareTypes().size() == 0) {
				rech.setCompareTypes("Nothing");
			}
			System.out.println(rech.getUsedTypes());

			if (rech.getGuessTries() >= rech.getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + rech.getCurrentType() + "<hr>" + "<b>";
				rech.setAllCompareTypes(rech.getCompareTypes());
				rech.setAllComparedTypes(rech.getComparedTypes());
				rech.setUsedTypes();
				rech.clearComparedTypes();
				i = rech.getRand();
				rech.setCurrentType(Datenbank.getTypes(i, 0));
				currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

				while (rech.getUsedTypes().contains(rech.getCurrentType())) {
					i = rech.getRand();
					rech.setCurrentType(Datenbank.getTypes(i, 0));
					currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

					if (rech.getUsedTypes().size() == 18) {
						rech.clearUsedTypes();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(
						"SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + Datenbank.getTypes(i, 0) + "'", 3);

				rech.clearCompareTypes();
				rech.addCompareTypes(3);
				rech.setGuessTries(0);
				rech.setNothingButtonPressed(0);
			}

			break;
		default:
			System.out.println("Default");
		}

	}
	// Ende Methoden
} // end of class Fenster
