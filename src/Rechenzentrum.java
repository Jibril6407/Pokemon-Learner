import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Rechenzentrum {
	private String currentType;
	private ArrayList<ArrayList<String>> allCompareTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> allComparedTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<String> comparedTypes = new ArrayList<String>();
	private ArrayList<String> compareTypes = new ArrayList<String>();
	private ArrayList<String> usedTypes = new ArrayList<String>();
	private Random rand = new Random();
	private int random;
	private int mode = 0;
	private int guessTries = 0;
	private int nothingButtonPressed = 0;
	private String resultPressedText = "<html><b>";
	private String resultShouldPressedText = "<html><b>";
	private String usedTypeText = "<html><b>";
	private String[] nameMode = {"Effective", "Not Effective", "Immune"} ;
	private Fenster fenster;

	public void init_Gui(Fenster Fenster) {
		this.fenster = Fenster;
	}

	public Rechenzentrum() {

	}

	public void effectiveButton_ActionPerformedMethode() {
		setMode(1);
		if (fenster.getEffectiveButton().getText() == "Effective") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
		Datenbank.getTypes(getCurrentType(), 1);

			clearCompareTypes();
			addCompareTypes(1);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
			fenster.getRandomButton().setVisible(false);
			fenster.getNothingButton().setVisible(true);
			for (int i = 0; i < 18; i++) {
				fenster.getTypesbuttons().get(i).setVisible(true);
			}
		}
	}

	public void notEffectiveButton_ActionPerformedMethod() {
		setMode(2);
		if (fenster.getNotEffectiveButton().getText() == "Not Effective") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
			Datenbank.getTypes(getCurrentType(), 2);

			clearCompareTypes();
			addCompareTypes(2);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
			fenster.getRandomButton().setVisible(false);
			fenster.getNothingButton().setVisible(true);
			for (int i = 0; i < 18; i++) {
				fenster.getTypesbuttons().get(i).setVisible(true);
			}
		}
	}

	public void immuneButton_ActionPerformedMethod() {
		setMode(3);
		if (fenster.getImmuneButton().getText() == "Immune") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
			Datenbank.getTypes(getCurrentType(), 3);

			clearCompareTypes();
			addCompareTypes(3);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
			fenster.getRandomButton().setVisible(false);
			fenster.getNothingButton().setVisible(true);
			for (int i = 0; i < 18; i++) {
				fenster.getTypesbuttons().get(i).setVisible(true);
			}

		}
	}

	public void randomButton_ActionPerformedMethod() {
		Datenbank.getTypes("", 0);
		int i = getRand();
		setCurrentType(Datenbank.getTypes(i, 0));
		fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());
	}

	public void typesbuttons_ActionPerformedMethod(ActionEvent evt, String tempTypes) {

		if (getComparedTypes().contains(tempTypes)) {
			System.out.println("That type was already guessed!");
			return;
		}
		setGuessTries(getGuessTries() + 1);
		switch (getMode()) {
		case 1:
			if (getCompareTypes().contains(tempTypes)) {
				setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				setComparedTypes(tempTypes);
			}
			if (getCompareTypes().size() == 0) {
				setCompareTypes("Nothing");
			}

			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				int i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						;
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				;
				addCompareTypes(1);
				setGuessTries(0);
				setNothingButtonPressed(0);
			}

			break;
		case 2:
			System.out.println(getCompareTypes());
			if (getCompareTypes().contains(tempTypes)) {
				setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				setComparedTypes(tempTypes);
			}
			if (getCompareTypes().size() == 0) {
				getCompareTypes().add("Nothing");
			}

			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				int i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				addCompareTypes(2);
				setGuessTries(0);
				setNothingButtonPressed(0);
			}

			break;
		case 3:
			System.out.println(getCompareTypes());
			if (getCompareTypes().contains(tempTypes)) {
				setComparedTypes(tempTypes);

				System.out.println("Right");
			} else {
				System.out.println("Wrong");
				setComparedTypes(tempTypes);
			}
			if (getCompareTypes().size() == 0) {
				getCompareTypes().add("Nothing");
			}

			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				int i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				addCompareTypes(3);
				setGuessTries(0);
				setNothingButtonPressed(0);

			}

			break;
		default:
			System.out.println("Default");
		}
	}

	public void backButton_ActionPerformedMethod(ActionEvent evt, int done) {
		int tempMode = getMode() -1;
		setMode(0);
		fenster.getModeLabel().setVisible(false);
		fenster.getNothingButton().setVisible(false);
		fenster.getDefenderType().setVisible(false);
		clearCompareTypes();
		clearComparedTypes();
		System.out.println("Pressed:                      " + getAllComparedTypes());
		System.out.println("What you should have pressed: " + getAllCompareTypes());
		if (done == 0) {
			resultPressedText = "<html><b>";
			resultShouldPressedText = "<html><b>";
			usedTypeText = "<html><b>";
			fenster.getCurrentTypeLabel().setVisible(false);
			fenster.getEffectiveButton().setVisible(true);
			fenster.getNotEffectiveButton().setVisible(true);
			fenster.getImmuneButton().setVisible(true);
			fenster.getRandomButton().setVisible(true);
			fenster.getResultsPressed().setVisible(false);
			fenster.getResultsShouldPressed().setVisible(false);
			fenster.getUsedType().setVisible(false);
			fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());
		}

		for (int i = 0; i < 18; i++) {
			fenster.getTypesbuttons().get(i).setVisible(false);
		}

		if (done == 1) {
			fenster.getCurrentTypeLabel().setText("Results:");
			fenster.getCurrentTypeLabel().setBounds(150, 140, 350, 50);
			
			fenster.getModeLabel().setText(nameMode[tempMode]);
			fenster.getModeLabel().setVisible(true);
			
			for (int i = 0; i < 18; i++) {
				fenster.getTypesbuttons().get(i).setVisible(false);

				for (int j = 0; j < getAllComparedTypes().get(i).size(); j++) {
					if (getAllCompareTypes().get(i).contains(getAllComparedTypes().get(i).get(j))) {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"green\"> "
								+ getAllComparedTypes().get(i).get(j);
					} else {
						resultPressedText = resultPressedText + "<font face=\"arial\" color=\"red\"> "
								+ getAllComparedTypes().get(i).get(j);
					}
					resultShouldPressedText = resultShouldPressedText + "<font face=\"arial\" color=\"black\"> "
							+ getAllCompareTypes().get(i).get(j);
				}
				resultPressedText = resultPressedText + "<hr>" + "<b>";
				resultShouldPressedText = resultShouldPressedText + "<hr>" + "<b>";
			}
			resultPressedText = resultPressedText + " </b></font></html>";
			fenster.getResultsPressed().setText(resultPressedText);
			resultShouldPressedText = resultShouldPressedText + " </b></font></html>";
			fenster.getResultsShouldPressed().setText(resultShouldPressedText);
			usedTypeText = usedTypeText + " </b></font></html>";
			fenster.getUsedType().setText(usedTypeText);
			clearAllComparedTypes();
			clearAllCompareTypes();
			fenster.getResultsPressed().setVisible(true);
			fenster.getResultsShouldPressed().setVisible(true);
			fenster.getUsedType().setVisible(true);
		}

		clearUsedTypes();
	}

	public void nothingButton_ActionPerformedMethod(ActionEvent evt) {

		if (getNothingButtonPressed() == 1) {
			System.out.println("You already Pressed Nothing!");
			return;
		}

		int i = getRand();
		setGuessTries(getGuessTries() + 1);
		setNothingButtonPressed(getNothingButtonPressed() + 1);

		switch (getMode()) {
		case 1:

			setComparedTypes("Nothing");
			if (getCompareTypes().size() == 0) {
				setCompareTypes("Nothing");
			}

			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				addCompareTypes(1);
				setGuessTries(0);
				setNothingButtonPressed(0);
			}

			break;
		case 2:
			setComparedTypes("Nothing");
			if (getCompareTypes().size() == 0) {
				setCompareTypes("Nothing");
			}
			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				addCompareTypes(2);
				setGuessTries(0);
				setNothingButtonPressed(0);
			}

			break;
		case 3:
			setComparedTypes("Nothing");
			if (getCompareTypes().size() == 0) {
				setCompareTypes("Nothing");
			}
			System.out.println(getUsedTypes());

			if (getGuessTries() >= getCompareTypes().size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + getCurrentType() + "<hr>"
						+ "<b>";
				setAllCompareTypes(getCompareTypes());
				setAllComparedTypes(getComparedTypes());
				setUsedTypes();
				clearComparedTypes();
				i = getRand();
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand();
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText("Attacker: " + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						fenster.backButton_ActionPerformed(evt, 1);
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode());

				clearCompareTypes();
				addCompareTypes(3);
				setGuessTries(0);
				setNothingButtonPressed(0);
			}

			break;
		default:
			System.out.println("Default");
		}

	}

	public void attackerSideButton_ActionPerformedMethod() {
		fenster.getCp().remove(fenster.getMenuPanel());
		fenster.getCp().add(fenster.getAttackerPanel());
		fenster.revalidate();
	}

	public void defenderSideButton_ActionPerformedMethod() {
		fenster.getCp().remove(fenster.getMenuPanel());
		fenster.getCp().add(fenster.getDefenderPanel());
		fenster.revalidate();
	}

	public void battleModeButton_ActionPerformedMethod() {
		fenster.getCp().remove(fenster.getMenuPanel());
		fenster.getCp().add(fenster.getBattlePanel());
		fenster.revalidate();
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public void clearAllCompareTypes() {
		allCompareTypes.clear();
	}

	public ArrayList<ArrayList<String>> getAllCompareTypes() {
		return allCompareTypes;
	}

	public void setAllCompareTypes(ArrayList<String> compareTypes) {
		allCompareTypes.add(new ArrayList<>(compareTypes));
	}

	public void clearAllComparedTypes() {
		allComparedTypes.clear();
	}

	public ArrayList<ArrayList<String>> getAllComparedTypes() {
		return allComparedTypes;
	}

	public void setAllComparedTypes(ArrayList<String> comparedTypes) {
		allComparedTypes.add(new ArrayList<>(comparedTypes));
	}

	public void clearComparedTypes() {
		comparedTypes.clear();
	}

	public ArrayList<String> getComparedTypes() {
		return comparedTypes;
	}

	public void setComparedTypes(String tempTypes) {
		comparedTypes.add(tempTypes);
	}

	public void addCompareTypes(int i) {
		switch (i) {
		case 1:
			compareTypes.addAll(Datenbank.effective_against_Types);
			break;
		case 2:
			compareTypes.addAll(Datenbank.not_effective_against_Types);
			break;
		case 3:
			compareTypes.addAll(Datenbank.immune_Types);
			break;
		}
	}

	public void clearCompareTypes() {
		compareTypes.clear();
	}

	public ArrayList<String> getCompareTypes() {
		return compareTypes;
	}

	public void setCompareTypes(String tempTypes) {
		compareTypes.add(tempTypes);
	}

	public void clearUsedTypes() {
		usedTypes.clear();
	}

	public ArrayList<String> getUsedTypes() {
		return usedTypes;
	}

	public void setUsedTypes() {
		usedTypes.add(currentType);
	}

	public int getRand() {
		random = rand.nextInt(Datenbank.Types.size());
		return random;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public int getGuessTries() {
		return guessTries;
	}

	public void setGuessTries(int guessTries) {
		this.guessTries = guessTries;
	}

	public int getNothingButtonPressed() {
		return nothingButtonPressed;
	}

	public void setNothingButtonPressed(int nothingButtonPressed) {
		this.nothingButtonPressed = nothingButtonPressed;
	}

}
