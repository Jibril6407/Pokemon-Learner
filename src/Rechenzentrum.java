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
	private boolean trainerOrGym;
	private Fenster fenster;
	private int currentPanel = 0;

	private ArrayList<Integer> chosenPokemon = new ArrayList<Integer>();
	private ArrayList<String> type1 = new ArrayList<String>();
	private ArrayList<String> type2 = new ArrayList<String>();
	private ArrayList<Double> pokemonKP = new ArrayList<Double>(); 

	private ArrayList<Integer> opponentPokemon = new ArrayList<Integer>();
	private ArrayList<String> opponentType1 = new ArrayList<String>();
	private ArrayList<String> opponentType2 = new ArrayList<String>();
	private ArrayList<Double> opponentPokemonKP = new ArrayList<Double>();

	public void init_Gui(Fenster Fenster) {
		this.fenster = Fenster;
	}

	public Rechenzentrum() {
	}

	public void effectiveButton_ActionPerformedMethod() {
		mode = 1;
		if (fenster.getEffectiveButton().getText() == "Effective") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
			Datenbank.getTypes(currentType, 1, panelMode);

			compareTypes.clear();
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
		mode = 2;
		if (fenster.getNotEffectiveButton().getText() == "Not Effective") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
			Datenbank.getTypes(currentType, 2, panelMode);

			compareTypes.clear();
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
		mode = 3;
		if (fenster.getImmuneButton().getText() == "Immune") {
			fenster.getCurrentTypeLabel().setVisible(true);
			fenster.getDefenderType().setVisible(true);
			Datenbank.getTypes(currentType, 3, panelMode);

			compareTypes.clear();
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

	public void typesbuttons_ActionPerformedMethod(String tempTypes) {

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
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				;
				addCompareTypes(1);
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
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				addCompareTypes(2);
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
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				int i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				addCompareTypes(3);
				guessTries = 0;
				nothingButtonPressed = 0;

			}

			break;
		default:
			System.out.println("Default");
		}
	}

	public void backButton_ActionPerformedMethod() {

		mode = 0;
		chosenPokemon.clear();
		compareTypes.clear();
		comparedTypes.clear();
		allCompareTypes.clear();
		allComparedTypes.clear();
		usedTypeText = "<html><b>";
		resultPressedText = "<html><b>";
		resultShouldPressedText = "<html><b>";
		System.out.println("Pressed:                      " + getAllComparedTypes());
		System.out.println("What you should have pressed: " + getAllCompareTypes());
		usedTypes.clear();

		fenster.getCp().removeAll();
		currentPanel = 0;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.revalidate();
	}

	public void nothingButton_ActionPerformedMethod() {

		if (nothingButtonPressed == 1) {
			System.out.println("You already Pressed Nothing!");
			return;
		}

		int i = getRand(Datenbank.Types.size());
		guessTries++;
		nothingButtonPressed++;

		switch (mode) {
		case 1:

			comparedTypes.add("Nothing");
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}

			if (guessTries >= compareTypes.size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				addCompareTypes(1);
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
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();

						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				addCompareTypes(2);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		case 3:
			comparedTypes.add("Nothing");
			if (compareTypes.size() == 0) {
				compareTypes.add("Nothing");
			}
			System.out.println(usedTypes);

			if (guessTries >= compareTypes.size()) {
				usedTypeText = usedTypeText + "<font face=\"arial\" color=\"black\"> " + currentType + "<hr>" + "<b>";
				setAllCompareTypes(compareTypes);
				setAllComparedTypes(comparedTypes);
				usedTypes.add(currentType);
				comparedTypes.clear();
				i = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(i, 0);
				fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

				while (usedTypes.contains(currentType)) {
					i = getRand(Datenbank.Types.size());
					currentType = Datenbank.getTypes(i, 0);
					fenster.getCurrentTypeLabel().setText(attackerOrDefender[panelMode] + currentType);

					if (usedTypes.size() == 18) {
						usedTypes.clear();
						done();
						continue;
					}
				}

				Datenbank.getTypes(Datenbank.getTypes(i, 0), mode, panelMode);

				compareTypes.clear();
				addCompareTypes(3);
				guessTries = 0;
				nothingButtonPressed = 0;
			}

			break;
		default:
			System.out.println("Default");
		}

	}

	public void attackerSideButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		panelMode = 1;
		currentPanel = 1;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

	}

	public void defenderSideButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		currentPanel = 3;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

	}

	public void battleModeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		currentPanel = 5;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

	}

	// von
	public void fightButton0_ActionPerformedMethod(String s) {
		if (s == "Angriff") {
			fenster.getFightButton0().setText(type1.get(0) + " Angriff");
			fenster.getFightButton1().setText(type2.get(0) + " Angriff");	
		}
		
		if(s.equals( type1.get(0) + " Angriff")) {
			System.out.println(getMultiplicator(type1.get(0),opponentType1.get(0),opponentType2.get(0)));
			
		}
		
	}

	public void fightButton1_ActionPerformedMethod(String t) {
		if (t == "Tauschen") {
			fenster.getCp().removeAll();
			currentPanel = 9;
			fenster.setContentPane(fenster.getPanel(currentPanel));
			fenster.setPanel(currentPanel);
			fenster.revalidate();
		}
		
		if(t.equals( type2.get(0) + " Angriff")) {
			System.out.println(getMultiplicator(type2.get(0),opponentType1.get(0),opponentType2.get(0)));
		}
	}
	// bis

	public void oneTypeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		panelMode = 2;
		currentPanel = 2;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

	}

	public void twoTypeButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		panelMode = 2;
		currentPanel = 4;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

		do {
			Datenbank.getTypes("", 0, 0);
			int i = getRand(Datenbank.Types.size());
			currentType = Datenbank.getTypes(i, 0);
			firstType = currentType;
			int j = getRand(Datenbank.Types.size());
			while (j == i) {
				j = getRand(Datenbank.Types.size());
			}
			currentType = Datenbank.getTypes(j, 0);
			secondType = currentType;
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
		currentType = Datenbank.getTypes(rand, 0);
		MultiplicatorIndex.add(rand);

		fenster.getAttackTypeLabel().setText("Attack with: " + currentType);

		int poke = getRand(Datenbank.PokemonNumbers.size());
		fenster.setPicLabel(Datenbank.PokemonNumbers.get(poke), 0);

	}

	public void trainerButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		panelMode = 2;
		currentPanel = 6;
		trainerOrGym = false;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		fenster.setPanel(currentPanel);
		fenster.revalidate();

		int rand = getRand(1008);

		for (int x = 0; x < 6; x++) {

			while (opponentPokemon.contains(rand)) {
				rand = getRand(1008);
			}

			opponentPokemon.add(rand);

			Datenbank.getPokemonTypes(rand);
			opponentType1.add(Datenbank.type1);
			opponentType2.add(Datenbank.type2);
			opponentPokemonKP.add(10.0);
			pokemonKP.add(10.0);

		}
		fenster.getInfoOpponentPokemonLabel().setText(opponentType1.get(0) +"/"+ opponentType2.get(0) +" "+opponentPokemonKP.get(0) +" KP");

	}

	public void multiplicatorButtons_ActionPerformedMethod(double tempMultiplicator) {
		int rand = getRand(Datenbank.Types.size());
		pressedMultiplicator.add(tempMultiplicator);
		if (comparedTypes.size() < 6) {
			comparedTypes.add(currentType); 

			while (comparedTypes.contains(currentType)) {
				rand = getRand(Datenbank.Types.size());
				currentType = Datenbank.getTypes(rand, 0);
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

	public void gymLeaderButton_ActionPerformedMethod() {
		fenster.getCp().removeAll();
		panelMode = 2;
		currentPanel = 6;
		fenster.setContentPane(fenster.getPanel(currentPanel));
		trainerOrGym = true;
		fenster.setPanel(currentPanel);
		fenster.revalidate();
	}

	public void pokeListPressed(int i, int index){
		if(i == 0){
			fenster.getChoosePokeNumber().setSelectedIndex(index);
		}else if(i == 1){
			fenster.getChoosePokeName().setSelectedIndex(index);
		}
		fenster.setPicLabel(index+1, 1);
		Datenbank.getPokemonTypes(index+1);
		fenster.setType1Label(Datenbank.type1);
		fenster.setType2Label(Datenbank.type2);
		
	}

	public void chooseButton_ActionPerformedMethod(int i) {
		if (chosenPokemon.size() < 6 && !chosenPokemon.contains(i)) {
			chosenPokemon.add(i);
			type1.add(Datenbank.type1);
			type2.add(Datenbank.type2);
		} else if (!(chosenPokemon.size() < 6)) {
			System.out.println("You cannot choose more than 6 Pokemon!");
		} else {
			System.out.println("You can pick every Pokemon only one Time!");
		}
	}

	public void confirmButton_ActionPerformedMethod() {
		if(chosenPokemon.size() == 0){
			System.out.println("W�hl bitte nen Pokemon Ralf!");
			return;
		}
		fenster.getInfoPokemonLabel().setText(type1.get(0)+"/"+ type2.get(0) +" "+ pokemonKP.get(0) +" KP");
		fenster.setFightPics(chosenPokemon.get(0),opponentPokemon.get(0));
		if (!trainerOrGym) {
			fenster.getCp().removeAll();
			currentPanel = 7;
			fenster.setContentPane(fenster.getPanel(currentPanel));
			fenster.setPanel(currentPanel);
			fenster.revalidate();
		} else if (trainerOrGym) {
			fenster.getCp().removeAll();
			currentPanel = 8;
			fenster.setContentPane(fenster.getPanel(currentPanel));
			fenster.setPanel(currentPanel);
			fenster.revalidate();
		}
		// hier
	}

	public void done() {
		int tempMode = mode - 1;
		mode = 0;
		fenster.getModeLabel().setVisible(false);
		fenster.getNothingButton().setVisible(false);
		fenster.getDefenderType().setVisible(false);
		compareTypes.clear();
		comparedTypes.clear();
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
		allComparedTypes.clear();
		allCompareTypes.clear();
		fenster.getResultsPressed().setVisible(true);
		fenster.getResultsShouldPressed().setVisible(true);
		fenster.getUsedType().setVisible(true);
		usedTypes.clear();
	}

	public ArrayList<ArrayList<String>> getAllCompareTypes() {
		return allCompareTypes;
	}

	public void setAllCompareTypes(ArrayList<String> compareTypes) {
		allCompareTypes.add(new ArrayList<>(compareTypes));
	}

	public ArrayList<ArrayList<String>> getAllComparedTypes() {
		return allComparedTypes;
	}

	public void setAllComparedTypes(ArrayList<String> comparedTypes) {
		allComparedTypes.add(new ArrayList<>(comparedTypes));
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

	public int getRand(int i) {
		random = rand.nextInt(i);
		return random;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String s) {
		currentType = s;
	}

	public ArrayList<String> getOpponentType1() {
		return opponentType1;
	}

	public ArrayList<String> getOpponentType2() {
		return opponentType2;
	}
	
	public ArrayList<String> getType1() {
		return type1;
	}

	public ArrayList<String> getType2() {
		return type2;
	}
	public double getMultiplicator(String attackType, String defenderType1, String defenderType2){
		double multiplicator1;
		double multiplicator2;
		
		double multiplicator;					
		Datenbank.getTypes(attackType,1,1);
		Datenbank.getTypes(attackType,2,1);
		Datenbank.getTypes(attackType,3,1);
		if(Datenbank.effective_against_Types.contains(defenderType1)) {
			multiplicator1 = 2;
		}else if(Datenbank.not_effective_against_Types.contains(defenderType1)) {
			multiplicator1 = 0.5;
		}else if(Datenbank.immune_Types.contains(defenderType1)) {
			multiplicator1 = 0;
		}else {
			multiplicator1 = 1;
		}
		if(Datenbank.effective_against_Types.contains(defenderType2)) {
			multiplicator2 = 2;
		}else if(Datenbank.not_effective_against_Types.contains(defenderType2)) {
			multiplicator2 = 0.5;
		}else if(Datenbank.immune_Types.contains(defenderType2)) {
			multiplicator2 = 0;
		}else {
			multiplicator2 = 1;
		}
		multiplicator = multiplicator1 * multiplicator2;
		
		return multiplicator;
	}

	
}
