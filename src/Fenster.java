import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

import java.util.*;

public class Fenster extends JFrame {

	private JLabel currentTypeLabel = new JLabel();
	private JLabel defenderType = new JLabel();
	private JTextPane resultsPressed = new JTextPane();
	private JTextPane resultsShouldPressed = new JTextPane();
	private String currentType;
	private JButton backButton = new JButton();
	private JButton effectiveButton = new JButton();
	private JButton notEffectiveButton = new JButton();
	private JButton immuneButton = new JButton();
	private JButton randomButton = new JButton();
	private JButton nothingButton = new JButton();
	private ArrayList<JButton> typesbuttons = new ArrayList<JButton>();
	private ArrayList<ArrayList<String>> allCompareTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> allComparedTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<String> comparedTypes = new ArrayList<String>();
	private ArrayList<String> compareTypes = new ArrayList<String>();
	private ArrayList<String> usedTypes = new ArrayList<String>();
	private Random rand = new Random();
	private int mode = 0;
	private int guessTries = 0;
	private int nothingButtonPressed = 0;

	public Fenster() {
		// Frame-Initialisierung
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 1000;
		int frameHeight = 650;
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

		resultsPressed.setBounds(100, 200, 420, 350);
		cp.add(resultsPressed);
		resultsPressed.setFont(new Font("Dialog", Font.BOLD, 14));
		resultsPressed.setVisible(false);
		resultsPressed.setEditable(false);
		resultsPressed.setEditorKit(new HTMLEditorKit());

		resultsShouldPressed.setBounds(550, 200, 420, 350);
		cp.add(resultsShouldPressed);
		resultsShouldPressed.setFont(new Font("Dialog", Font.BOLD, 14));
		resultsShouldPressed.setVisible(false);
		resultsShouldPressed.setEditable(false);
		resultsShouldPressed.setEditorKit(new HTMLEditorKit());

		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		int randType = rand.nextInt(Datenbank.Types.size());
		currentType = Datenbank.getTypes(randType, 0);
		currentTypeLabel.setText("Attacker: " + currentType);
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
		mode = 1;
		if (effectiveButton.getText() == "Effective") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '" + currentType + "'", 1);

			compareTypes.clear();
			compareTypes.addAll(Datenbank.effective_against_Types);

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
		mode = 2;
		if (notEffectiveButton.getText() == "Not Effective") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes(
					"SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '" + currentType + "'", 2);

			compareTypes.clear();
			compareTypes.addAll(Datenbank.not_effective_against_Types);

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
		mode = 3;
		if (immuneButton.getText() == "Immune") {
			currentTypeLabel.setVisible(true);
			defenderType.setVisible(true);
			Datenbank.getTypes("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + currentType + "'", 3);

			compareTypes.clear();
			compareTypes.addAll(Datenbank.immune_Types);

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
		int i = rand.nextInt(Datenbank.Types.size());
		currentType = Datenbank.getTypes(i, 0);
		currentTypeLabel.setText("Attacker: " + currentType);
	}

	public void typesbuttons_ActionPerformed(ActionEvent evt, String tempTypes) {
		if (comparedTypes.contains(tempTypes)) {
			System.out.println("That type was already guessed!");
			return;
		}
		guessTries++;
		switch (mode) {
		case 1:
			if (compareTypes.contains(tempTypes)) {
				comparedTypes.add(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				comparedTypes.add(tempTypes);
			}
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}

			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 1);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.effective_against_Types);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		case 2:
			System.out.println(compareTypes);
			if (compareTypes.contains(tempTypes)) {
				comparedTypes.add(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				comparedTypes.add(tempTypes);
			}
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}

			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 2);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.not_effective_against_Types);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		case 3:
			System.out.println(compareTypes);
			if (compareTypes.contains(tempTypes)) {
				comparedTypes.add(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				comparedTypes.add(tempTypes);
			}
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}

			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(
						"SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + Datenbank.getTypes(i, 0) + "'", 3);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.immune_Types);
				guessTries = 0;
				nothingButtonPressed = 0;

			}

			break;
		default:
			System.out.println("Default");
		}

	}

	public void backButton_ActionPerformed(ActionEvent evt, int done) {
		mode = 0;
		nothingButton.setVisible(false);
		defenderType.setVisible(false);
		compareTypes.clear();
		usedTypes.clear();
		comparedTypes.clear();
		System.out.println("Pressed:                      " + allComparedTypes);
		System.out.println("What you should have pressed: " + allCompareTypes);
		if (done == 0) {
			currentTypeLabel.setVisible(false);
			effectiveButton.setVisible(true);
			notEffectiveButton.setVisible(true);
			immuneButton.setVisible(true);
			randomButton.setVisible(true);
			resultsPressed.setVisible(false);
			resultsShouldPressed.setVisible(false);
			currentTypeLabel.setText("Attacker: " + currentType);
		}

		for (int i = 0; i < 18; i++) {
			typesbuttons.get(i).setVisible(false);
		}

		if (done == 1) {
			currentTypeLabel.setText("Results:");
			currentTypeLabel.setBounds(150, 140, 350, 50);
			String resultPressedText = "<html><b>";
			String resultShouldPressedText = "<html><b>";
			for (int i = 0; i < 18; i++) {
				typesbuttons.get(i).setVisible(false);

				for (int j = 0; j < allComparedTypes.get(i).size(); j++) {
					if (allCompareTypes.get(i).contains(allComparedTypes.get(i).get(j))) {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"green\"> "
								+ allComparedTypes.get(i).get(j);
					} else {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"red\"> "
								+ allComparedTypes.get(i).get(j);
					}
					resultShouldPressedText = resultShouldPressedText + "<font face=\"arial\" color=\"black\"> "
							+ allCompareTypes.get(i).get(j);
				}
				resultPressedText = resultPressedText + "<br />";
				resultShouldPressedText = resultShouldPressedText + "<br />";
			}
			resultPressedText = resultPressedText + " </b></font></html>";
			resultsPressed.setText(resultPressedText);
			resultShouldPressedText = resultShouldPressedText + " </b></font></html>";
			resultsShouldPressed.setText(resultShouldPressedText);
			allComparedTypes.clear();
			allCompareTypes.clear();
			resultsPressed.setVisible(true);
			resultsShouldPressed.setVisible(true);
		}

	}

	public void nothingButton_ActionPerformed(ActionEvent evt) {

		if (nothingButtonPressed == 1) {
			System.out.println("You already Pressed Nothing!");
			return;
		}

		int i = rand.nextInt(Datenbank.Types.size());
		guessTries++;
		nothingButtonPressed++;

		switch (mode) {
		case 1:
			comparedTypes.add("Nothing");
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}
			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 1);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.effective_against_Types);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		case 2:
			comparedTypes.add("Nothing");
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}
			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '"
						+ Datenbank.getTypes(i, 0) + "'", 2);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.not_effective_against_Types);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		case 3:
			comparedTypes.add("Nothing");
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}

			if (guessTries >= compareTypes.size()) {
				allCompareTypes.add(new ArrayList<>(compareTypes));
				allComparedTypes.add(new ArrayList<>(comparedTypes));
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = rand.nextInt(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				currentTypeLabel.setText("Attacker: " + currentType);

				while (usedTypes.contains(currentType)) {
					i = rand.nextInt(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					currentTypeLabel.setText("Attacker: " + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(
						"SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + Datenbank.getTypes(i, 0) + "'", 3);

				compareTypes.clear();
				compareTypes.addAll(Datenbank.immune_Types);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		default:
			System.out.println("Default");
		}

	}
	// Ende Methoden
} // end of class Fenster
