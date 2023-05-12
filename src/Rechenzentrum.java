import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Rechenzentrum {
	private String currentType;
	private String firstType;
	private String secondType;
	private ArrayList<ArrayList<String>> allCompareTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> allComparedTypes = new ArrayList<ArrayList<String>>();
	private ArrayList<String> comparedTypes = new ArrayList<String>();
	private ArrayList<String> compareTypes = new ArrayList<String>();
	private ArrayList<String> usedTypes = new ArrayList<String>();

	private ArrayList<String> types = new ArrayList<String>();
	private double[] multiplicator0 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private double[] multiplicator1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private ArrayList<Double> overallMultiplicator = new ArrayList<Double>();
	private ArrayList<Integer> MultiplicatorIndex = new ArrayList<Integer>();
	private ArrayList<Double> pressedMultiplicator = new ArrayList<Double>();

	private Random rand = new Random();
	private int random;
	private int panelMode;
	private int mode = 0;
	private int guessTries = 0;
	private int nothingButtonPressed = 0;
	private String resultPressedText = "<html><b>";
	private String resultShouldPressedText = "<html><b>";
	private String usedTypeText = "<html><b>";
	private String[] nameMode = { "Effective", "Not Effective", "Immune" };
	private String[] attackerOrDefender = { "", "Attacker: ", "Defender: " };
	private Fenster fenster;
	private int currentPanel = 0;

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
			Datenbank.getTypes(getCurrentType(), 1, getPanelMode());

			clearCompareTypes();
			addCompareTypes(1);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
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
			Datenbank.getTypes(getCurrentType(), 2, getPanelMode());

			clearCompareTypes();
			addCompareTypes(2);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
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
			Datenbank.getTypes(getCurrentType(), 3, getPanelMode());

			clearCompareTypes();
			addCompareTypes(3);

			fenster.getEffectiveButton().setVisible(false);
			fenster.getNotEffectiveButton().setVisible(false);
			fenster.getImmuneButton().setVisible(false);
			fenster.getNothingButton().setVisible(true);
			for (int i = 0; i < 18; i++) {
				fenster.getTypesbuttons().get(i).setVisible(true);
			}

		}
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
				int i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						;
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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
				int i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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
				int i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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

	public void backButton_ActionPerformedMethod(ActionEvent evt) {
		
		setMode(0);
		
		clearCompareTypes();
		clearComparedTypes();
		clearAllCompareTypes();
		clearAllComparedTypes();
		usedTypeText ="<html><b>";
		resultPressedText ="<html><b>";
		resultShouldPressedText ="<html><b>";
		System.out.println("Pressed:                      " + getAllComparedTypes());
		System.out.println("What you should have pressed: " + getAllCompareTypes());
		clearUsedTypes();
		
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getMenuPanel());	
		currentPanel = 0;
		fenster.revalidate();
	}

	public void nothingButton_ActionPerformedMethod(ActionEvent evt) {

		if (getNothingButtonPressed() == 1) {
			System.out.println("You already Pressed Nothing!");
			return;
		}

		int i = getRand(Datenbank.Types.size());
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
				i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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
				i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();

						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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
				i = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(i, 0));
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

				while (getUsedTypes().contains(getCurrentType())) {
					i = getRand(Datenbank.Types.size());
					setCurrentType(Datenbank.getTypes(i, 0));
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + getCurrentType());

					if (getUsedTypes().size() == 18) {
						clearUsedTypes();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), getMode(), getPanelMode());

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
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getAttackerPanel());	
		panelMode = 1;
		currentPanel = 1;		
		fenster.setCurrentPanel(currentPanel);		
		fenster.revalidate();
		
	}

	public void defenderSideButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getChooseSumOfTypesPanel());
		currentPanel = 3;
		fenster.setCurrentPanel(currentPanel);	
		fenster.revalidate();
		
	}

	public void battleModeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getChooseOpponentPanel());
		currentPanel = 5;
		fenster.setCurrentPanel(currentPanel);
		fenster.revalidate();
	}

	public void oneTypeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getDefenderPanel());
		panelMode = 2;
		currentPanel = 2;
		fenster.setCurrentPanel(currentPanel);
		fenster.revalidate();
		
	}

	public void twoTypeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getTwoTypesDefenderPanel());
		panelMode = 2;
		currentPanel = 4;
		fenster.setCurrentPanel(currentPanel);
		fenster.revalidate();
		
		do {
			Datenbank.getTypes("", 0, 0);
			int i = getRand(Datenbank.Types.size());
			setCurrentType(Datenbank.getTypes(i, 0));
			firstType = getCurrentType();
			int j = getRand(Datenbank.Types.size());
			while (j == i) {
				j = getRand(Datenbank.Types.size());
			}
			setCurrentType(Datenbank.getTypes(j, 0));
			secondType = getCurrentType();
			Datenbank.getPokemonNumber(firstType, secondType);

		} while (Datenbank.PokemonNumbers.size() <= 0);
		fenster.getTypeLabel().setText("Defender: " + firstType + "/" + secondType);
		System.out.println(firstType + "/" + secondType);
		for (int tempcount = 0; tempcount < 18; tempcount++) {
			multiplicator0[tempcount] = 1;
			multiplicator1[tempcount] = 1;
		}

		Datenbank.getTypes(firstType, 1, 2);
		Datenbank.getTypes(firstType, 2, 2);
		Datenbank.getTypes(firstType, 3, 2);
		for (int tempcount = 0; tempcount < Datenbank.Types.size(); tempcount++) {
			types.add(Datenbank.getTypes(tempcount, 0));
		}

		for (int tempcount = 0; tempcount < Datenbank.effective_against_Types.size(); tempcount++) {
			multiplicator0[types.indexOf(Datenbank.getTypes(tempcount, 1))] = 2;
		}
		for (int tempcount = 0; tempcount < Datenbank.not_effective_against_Types.size(); tempcount++) {
			multiplicator0[types.indexOf(Datenbank.getTypes(tempcount, 2))] = 0.5;
		}
		for (int tempcount = 0; tempcount < Datenbank.immune_Types.size(); tempcount++) {
			multiplicator0[types.indexOf(Datenbank.getTypes(tempcount, 3))] = 0;
		}
		Datenbank.getTypes(secondType, 1, 2);
		Datenbank.getTypes(secondType, 2, 2);
		Datenbank.getTypes(secondType, 3, 2);

		for (int tempcount = 0; tempcount < Datenbank.effective_against_Types.size(); tempcount++) {
			multiplicator1[types.indexOf(Datenbank.getTypes(tempcount, 1))] = 2;
		}
		for (int tempcount = 0; tempcount < Datenbank.not_effective_against_Types.size(); tempcount++) {
			multiplicator1[types.indexOf(Datenbank.getTypes(tempcount, 2))] = 0.5;
		}
		for (int tempcount = 0; tempcount < Datenbank.immune_Types.size(); tempcount++) {
			multiplicator1[types.indexOf(Datenbank.getTypes(tempcount, 3))] = 0;
		}
		overallMultiplicator.clear();
		for (int tempcount = 0; tempcount < 18; tempcount++) {
			overallMultiplicator.add(multiplicator0[tempcount] * multiplicator1[tempcount]);
			System.out.println(types.get(tempcount) + ": " + overallMultiplicator.get(tempcount));

		}
		int rand = getRand(Datenbank.Types.size());
		setCurrentType(Datenbank.getTypes(rand, 0));
		MultiplicatorIndex.add(rand);

		fenster.getAttackTypeLabel().setText("Attack with: " + currentType);

		int poke = getRand(Datenbank.PokemonNumbers.size());
		fenster.setPicLabel(Datenbank.PokemonNumbers.get(poke));

	}
	
	public void trainerButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		fenster.setContentPane(fenster.getBuildTeamPanel());
		panelMode = 2;
		currentPanel = 6;
		fenster.setCurrentPanel(currentPanel);
		fenster.revalidate();
		
	}

	public void multiplicatorButtons_ActionPerformedMethod(ActionEvent evt, double tempMultiplicator) {
		int rand = getRand(Datenbank.Types.size());
		pressedMultiplicator.add(tempMultiplicator);
		if (comparedTypes.size() < 6) {
			comparedTypes.add(currentType);

			while (comparedTypes.contains(currentType)) {
				rand = getRand(Datenbank.Types.size());
				setCurrentType(Datenbank.getTypes(rand, 0));
			}
			MultiplicatorIndex.add(rand);
			fenster.getAttackTypeLabel().setText("Attack with: " + currentType);
		} else {
			comparedTypes.add(currentType);
			fenster.getAttackTypeLabel().setVisible(false);
			fenster.getTypeLabel().setVisible(false);
			for (int i = 0; i < 6; i++) {
				fenster.getMultiplicatorButtons(i).setVisible(false);
			}
			for (int i = 0; i < 7; i++) {
				if (pressedMultiplicator.get(i).equals(overallMultiplicator.get(MultiplicatorIndex.get(i)))) {
					resultPressedText = resultPressedText + "<font face=\"arial\" color=\"green\"> "
							+ pressedMultiplicator.get(i) + "<hr>" + "<b>";
				} else {
					resultPressedText = resultPressedText + "<font face=\"arial\" color=\"red\"> "
							+ pressedMultiplicator.get(i) + "<hr>" + "<b>";
				}
				resultShouldPressedText = resultShouldPressedText + "<font face=\"arial\" color=\"black\"> "
						+ overallMultiplicator.get(MultiplicatorIndex.get(i)) + "<hr>" + "<b>";
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + comparedTypes.get(i) + "<hr>"
						+ "<b>";
			}

			resultPressedText = resultPressedText + "</b></font></html>";
			resultShouldPressedText = resultShouldPressedText + "</b></font></html>";
			usedTypeText = usedTypeText + "</b></font></html>";
			fenster.getResultsPressed().setVisible(true);
			fenster.getResultsPressed().setText(resultPressedText);
			fenster.getResultsShouldPressed().setVisible(true);
			fenster.getResultsShouldPressed().setText(resultShouldPressedText);
			fenster.getUsedType().setVisible(true);
			fenster.getUsedType().setText(usedTypeText);
		}

		System.out.println(comparedTypes);
	}

	public void done() {
		int tempMode = getMode() - 1;
		setMode(0);
		fenster.getModeLabel().setVisible(false);
		fenster.getNothingButton().setVisible(false);
		fenster.getDefenderType().setVisible(false);
		clearCompareTypes();
		clearComparedTypes();
		System.out.println("Pressed:                      " + getAllComparedTypes());
		System.out.println("What you should have pressed: " + getAllCompareTypes());
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
		clearUsedTypes();
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

	public int getRand(int i) {
		random = rand.nextInt(i);
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

	public int getPanelMode() {
		return panelMode;
	}

	public void setPanelMode(int panelMode) {
		this.panelMode = panelMode;
	}

}
