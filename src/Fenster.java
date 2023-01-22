import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Fenster extends JFrame {

	private JLabel currentType = new JLabel();
	private JButton backButton = new JButton();
	private JButton effectiveButton = new JButton();
	private JButton notEffectiveButton = new JButton();
	private JButton immuneButton = new JButton();
	private JButton RandomButton = new JButton();
	private ArrayList<JButton> Typesbuttons = new ArrayList<JButton>();
	private ArrayList<String> compareTypes = new ArrayList<String>();
	private ArrayList<String> usedTypes = new ArrayList<String>();
	private ArrayList<String> comparedTypes = new ArrayList<String>();
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

		currentType.setBounds(150, 140, 350, 50);
		cp.add(currentType);

		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		int randType = rand.nextInt(Datenbank.Types.size());
		currentType.setText(Datenbank.getTypes(randType, 0));
		backButton.setBounds(0, 0, 100, 50);
		backButton.setText("Back");
		backButton.setMargin(new Insets(2, 2, 2, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				backButton_ActionPerformed(evt);
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

		RandomButton.setBounds(275, 275, 100, 50);
		RandomButton.setText("Random");
		RandomButton.setMargin(new Insets(2, 2, 2, 2));
		RandomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				RandomButton_ActionPerformed(evt);
			}
		});
		cp.add(RandomButton);

		int count = 0;

		for (int i = 0; i < 18; i++) {
			Typesbuttons.add(new JButton());
		}
		// Typen Ersteller der Buttons
		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				String tempTypes = Datenbank.getTypes(count, 0);
				Typesbuttons.get(count).setBounds(100 * j + 50, 30 * i + 350, 85, 25);
				Typesbuttons.get(count).setMargin(new Insets(2, 2, 2, 2));
				Typesbuttons.get(count).setText(Datenbank.getTypes(count, 0));
				Typesbuttons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						Typesbuttons_ActionPerformed(evt, tempTypes);
					}
				});
				cp.add(Typesbuttons.get(count));

				Typesbuttons.get(count).setVisible(false);
				count++;
			}
		}

		setVisible(true);
	} // end of public Fenster

	// Anfang Methoden
	public void effectiveButton_ActionPerformed(ActionEvent evt) {
		String Type = currentType.getText();
		if (effectiveButton.getText() == "Effective") {
			Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '" + Type + "'", 1);
			int size = Datenbank.effective_against_Types.size();
			compareTypes.clear();
			for (int i = 0; i < size; i++) {
//				System.out.println(i + " " + Datenbank.getTypes(i, 1));
				compareTypes.add(Datenbank.getTypes(i, 1));
			}
			notEffectiveButton.setVisible(false);
			immuneButton.setVisible(false);
			RandomButton.setVisible(false);
			for (int i = 0; i < 18; i++) {
				Typesbuttons.get(i).setVisible(true);
			}
		}
	} // end of jButton1_ActionPerformed

	public void notEffectiveButton_ActionPerformed(ActionEvent evt) {
		String Type = currentType.getText();
		if (notEffectiveButton.getText() == "Not Effective") {
			Datenbank.getTypes("SELECT Not_Effective FROM Pokemon_Type_Not_Effective WHERE Type LIKE '" + Type + "'",
					2);
			int size = Datenbank.not_effective_against_Types.size();
			compareTypes.clear();
			for (int i = 0; i < size; i++) {
//				System.out.println(i + " " + Datenbank.getTypes(i, 2));
				compareTypes.add(Datenbank.getTypes(i, 2));
			}
//			System.out.println(compareTypes);
			effectiveButton.setVisible(false);
			immuneButton.setVisible(false);
			RandomButton.setVisible(false);
			for (int i = 0; i < 18; i++) {
				Typesbuttons.get(i).setVisible(true);
			}
		}
	}

	public void immuneButton_ActionPerformed(ActionEvent evt) {
		String Type = currentType.getText();
		if (immuneButton.getText() == "Immune") {
			Datenbank.getTypes("SELECT Immune FROM Pokemon_Type_Immune WHERE Type LIKE '" + Type + "'", 3);
			int size = Datenbank.immune_Types.size();
			compareTypes.clear();
			for (int i = 0; i < size; i++) {
//				System.out.println(i + " " + Datenbank.getTypes(i, 3));
				compareTypes.add(Datenbank.getTypes(i, 3));

			}
			effectiveButton.setVisible(false);
			notEffectiveButton.setVisible(false);
			RandomButton.setVisible(false);
			for (int i = 0; i < 18; i++) {
				Typesbuttons.get(i).setVisible(true);
			}
		}
	}

	public void RandomButton_ActionPerformed(ActionEvent evt) {
		Datenbank.getTypes("SELECT Types FROM Pokemon_Types", 0);
		int i = rand.nextInt(Datenbank.Types.size());
		currentType.setText(Datenbank.getTypes(i, 0));
	}

	public void Typesbuttons_ActionPerformed(ActionEvent evt, String tempTypes) {
		if (comparedTypes.size() != 0) {
			for (int j = 0; j < comparedTypes.size(); j++) {
				if (comparedTypes.get(j).equals(tempTypes)) {
					return;
				}
			}
		}
		for (int i = 0; i < compareTypes.size(); i++) {

			if (tempTypes.equals(compareTypes.get(i))) {

				comparedTypes.add(tempTypes);
				System.out.println("Right");

			}
		}

		if (comparedTypes.size() == compareTypes.size()) {
			System.out.println("That was all");
			usedTypes.add(currentType.getText());
			comparedTypes.clear();
			Datenbank.Types.remove(Datenbank.Types.indexOf(currentType.getText()));
			int i = rand.nextInt(Datenbank.Types.size());
			currentType.setText(Datenbank.getTypes(i, 0));
//			for(int j = 0; j < usedTypes.size(); j++) {
//				if (usedTypes.get(j).equals(Datenbank.getTypes(i, 0))) {
//					i = rand.nextInt(Datenbank.Types.size());
//					currentType.setText(Datenbank.getTypes(i, 0));
//					j = 0;
//				}
//			}
//
			Datenbank.getTypes("SELECT Effective FROM Pokemon_Type_Effective WHERE Type LIKE '" + Datenbank.getTypes(i, 0) + "'",1);
			
			compareTypes.clear();
			for (int j = 0; j < Datenbank.effective_against_Types.size(); j++) {
				compareTypes.add(Datenbank.getTypes(j, 1));
			}
			System.out.println(usedTypes);
			
		}

	}

	public void backButton_ActionPerformed(ActionEvent evt) {
		effectiveButton.setVisible(true);
		notEffectiveButton.setVisible(true);
		immuneButton.setVisible(true);
		RandomButton.setVisible(true);
		for (int i = 0; i < 18; i++) {
			Typesbuttons.get(i).setVisible(false);
		}
	}

	// Ende Methoden
} // end of class Fenster
