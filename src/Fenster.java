import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

import java.util.*;

public class Fenster extends JFrame {

	private JLabel currentTypeLabel = new JLabel();
	private JLabel TypeLabel = new JLabel();
	private JLabel attackTypeLabel = new JLabel();
	private JLabel defenderType = new JLabel();
	private JLabel modeLabel = new JLabel();
	private JLabel picLabel = new JLabel();
	private JLabel type1Label = new JLabel();
	private JLabel type2Label = new JLabel();
	private JLabel infoPokemonLabel = new JLabel();
	private JLabel infoOpponentPokemonLabel = new JLabel();

	private JTextPane usedType = new JTextPane();
	private JTextPane resultsPressed = new JTextPane();
	private JTextPane resultsShouldPressed = new JTextPane();

	private JPanel menuPanel = new JPanel();
	private JPanel attackerPanel = new JPanel();
	private JPanel defenderPanel = new JPanel();
	private JPanel changePokemonPanel = new JPanel();
	private JPanel chooseSumOfTypesPanel = new JPanel();
	private JPanel twoTypesDefenderPanel = new JPanel();
	private JPanel chooseOpponentPanel = new JPanel();
	private JPanel trainerPanel = new JPanel();
	private JPanel gymLeaderPanel = new JPanel();
	private JPanel buildTeamPanel = new JPanel();

	private JButton attackerSide = new JButton();
	private JButton defenderSide = new JButton();
	private JButton battleMode = new JButton();

	private JButton oneTypeButton = new JButton();
	private JButton twoTypeButton = new JButton();

	private JButton trainerButton = new JButton();
	private JButton gymLeaderButton = new JButton();

	private JButton fightButton0 = new JButton();
	private JButton fightButton1 = new JButton();

	private JButton backButton = new JButton();
	private JButton effectiveButton = new JButton();
	private JButton notEffectiveButton = new JButton();
	private JButton immuneButton = new JButton();
	private JButton nothingButton = new JButton();

	private JComboBox<String> choosePokeName = new JComboBox<String>();
	private JComboBox<Integer> choosePokeNumber = new JComboBox<Integer>();
	private JButton selectButton = new JButton();
	private JButton chooseButton = new JButton();
	private JButton confirmButton = new JButton();

	private ArrayList<JButton> typesbuttons = new ArrayList<JButton>();
	private ArrayList<JButton> multiplicatorButtons = new ArrayList<JButton>();
	
	private JLabel pokePic = new JLabel();
	private JLabel pokeOpponentPic = new JLabel();
	
	private ArrayList<JButton> changeButtons = new ArrayList<JButton>();
	private ArrayList<JLabel> pokeLabels = new ArrayList<JLabel>();
	
	private Rechenzentrum rech = null;
	private Container cp;

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

		cp = getContentPane();

		cp.add(menuPanel);

		menuPanel.setLayout(null);
		attackerPanel.setLayout(null);
		defenderPanel.setLayout(null);
		changePokemonPanel.setLayout(null);
		chooseSumOfTypesPanel.setLayout(null);
		twoTypesDefenderPanel.setLayout(null);
		chooseOpponentPanel.setLayout(null);
		trainerPanel.setLayout(null);
		gymLeaderPanel.setLayout(null);
		buildTeamPanel.setLayout(null);

		attackerSide.setBounds(150, 200, 100, 50);
		attackerSide.setText("Attacker");
		attackerSide.setMargin(new Insets(2, 2, 2, 2));
		attackerSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.attackerSideButton_ActionPerformedMethod();
			}
		});
		menuPanel.add(attackerSide);
		attackerSide.setVisible(true);

		defenderSide.setText("Defender");
		defenderSide.setMargin(new Insets(2, 2, 2, 2));
		defenderSide.setBounds(275, 200, 100, 50);
		defenderSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.defenderSideButton_ActionPerformedMethod();
			}
		});
		menuPanel.add(defenderSide);
		defenderSide.setVisible(true);

		battleMode.setBounds(400, 200, 100, 50);
		battleMode.setText("Battle");
		battleMode.setMargin(new Insets(2, 2, 2, 2));
		battleMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.battleModeButton_ActionPerformedMethod();
			}
		});
		menuPanel.add(battleMode);
		battleMode.setVisible(true);

		initPanel();

		setVisible(true);
	} // end of public Fenster

	public JLabel getCurrentTypeLabel() {
		return currentTypeLabel;
	}

	public JLabel getDefenderType() {
		return defenderType;
	}

	public JTextPane getUsedType() {
		return usedType;
	}

	public JTextPane getResultsPressed() {
		return resultsPressed;
	}

	public JTextPane getResultsShouldPressed() {
		return resultsShouldPressed;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton getEffectiveButton() {
		return effectiveButton;
	}

	public JButton getNotEffectiveButton() {
		return notEffectiveButton;
	}

	public JButton getImmuneButton() {
		return immuneButton;
	}

	public JButton getNothingButton() {
		return nothingButton;
	}

	public ArrayList<JButton> getTypesbuttons() {
		return typesbuttons;
	}

	public Rechenzentrum getRech() {
		return rech;
	}

	public JLabel getTypeLabel() {
		return TypeLabel;
	}

	public JLabel getAttackTypeLabel() {
		return attackTypeLabel;
	}

	public JButton getAttackerSide() {
		return attackerSide;
	}

	public JButton getDefenderSide() {
		return defenderSide;
	}

	public JButton getBattleMode() {
		return battleMode;
	}

	public Container getCp() {
		return cp;
	}

	public JLabel getModeLabel() {
		return modeLabel;
	}

	public JButton getOneTypeButton() {
		return oneTypeButton;
	}

	public JButton getTwoTypeButton() {
		return twoTypeButton;
	}

	public JButton getMultiplicatorButtons(int temp) {
		return multiplicatorButtons.get(temp);
	}
	
	

	public JButton getFightButton0() {
		return fightButton0;
	}

	public JButton getFightButton1() {
		return fightButton1;
	}

	public JLabel getInfoPokemonLabel() {
		return infoPokemonLabel;
	}

	public JLabel getInfoOpponentPokemonLabel() {
		return infoOpponentPokemonLabel;
	}

	public JComboBox<String> getChoosePokeName() {
		return choosePokeName;
	}

	public JComboBox<Integer> getChoosePokeNumber() {
		return choosePokeNumber;
	}

	public void initPanel() {

		currentTypeLabel.setBounds(150, 140, 350, 50);
		currentTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		currentTypeLabel.setVisible(false);

		defenderType.setBounds(50, 310, 350, 50);
		defenderType.setFont(new Font("Dialog", Font.BOLD, 18));
		defenderType.setVisible(false);

		modeLabel.setBounds(600, 110, 350, 50);
		modeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		modeLabel.setVisible(false);

		usedType.setBounds(20, 200, 70, 450);
		usedType.setVisible(false);
		usedType.setEditable(false);
		usedType.setEditorKit(new HTMLEditorKit());

		resultsPressed.setBounds(100, 200, 420, 450);
		resultsPressed.setVisible(false);
		resultsPressed.setEditable(false);
		resultsPressed.setEditorKit(new HTMLEditorKit());

		resultsShouldPressed.setBounds(530, 200, 420, 450);
		resultsShouldPressed.setVisible(false);
		resultsShouldPressed.setEditable(false);
		resultsShouldPressed.setEditorKit(new HTMLEditorKit());

		backButton.setBounds(0, 0, 100, 50);
		backButton.setText("Back");
		backButton.setMargin(new Insets(2, 2, 2, 2));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				rech.backButton_ActionPerformedMethod();
			}
		});

		effectiveButton.setBounds(150, 200, 100, 50);
		effectiveButton.setText("Effective");
		effectiveButton.setMargin(new Insets(2, 2, 2, 2));
		effectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.effectiveButton_ActionPerformedMethod();
			}
		});

		notEffectiveButton.setBounds(275, 200, 100, 50);
		notEffectiveButton.setText("Not Effective");
		notEffectiveButton.setMargin(new Insets(2, 2, 2, 2));
		notEffectiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.notEffectiveButton_ActionPerformedMethod();
			}
		});

		immuneButton.setBounds(400, 200, 100, 50);
		immuneButton.setText("Immune");
		immuneButton.setMargin(new Insets(2, 2, 2, 2));
		immuneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.immuneButton_ActionPerformedMethod();
			}
		});

		Datenbank.getTypes("", 0, 0);
		rech.setCurrentType(Datenbank.getTypes(rech.getRand(Datenbank.Types.size()), 0));

		int count = 0;

		for (int i = 0; i < 18; i++) {
			typesbuttons.add(new JButton());
		}
		// Typen Ersteller der Buttons
		Datenbank.getTypes("", 0, 0);
		Datenbank.getTypes("", 4, 0);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				String tempTypes = Datenbank.getTypes(count, 0);
				typesbuttons.get(count).setBounds(100 * j + 50, 30 * i + 350, 85, 25);
				typesbuttons.get(count).setMargin(new Insets(2, 2, 2, 2));
				typesbuttons.get(count).setText(Datenbank.getTypes(count, 0));
				typesbuttons.get(count).setBackground(Color.decode(Datenbank.types_color.get(count)));
				typesbuttons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.typesbuttons_ActionPerformedMethod(tempTypes);
					}
				});
				count++;
			}
		}
		nothingButton.setBounds(50, 440, 585, 25);
		nothingButton.setText("Nothing");
		nothingButton.setMargin(new Insets(2, 2, 2, 2));
		nothingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.nothingButton_ActionPerformedMethod();
			}
		});
		nothingButton.setBackground(Color.WHITE);
		nothingButton.setVisible(false);

		oneTypeButton.setBounds(150, 200, 100, 50);
		oneTypeButton.setText("One Piece");
		oneTypeButton.setMargin(new Insets(2, 2, 2, 2));
		oneTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.oneTypeButton_ActionPerformedMethod();
			}
		});
		oneTypeButton.setVisible(true);

		twoTypeButton.setBounds(275, 200, 100, 50);
		twoTypeButton.setText("Two Piece");
		twoTypeButton.setMargin(new Insets(2, 2, 2, 2));
		twoTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.twoTypeButton_ActionPerformedMethod();
			}
		});
		twoTypeButton.setVisible(true);

		TypeLabel.setBounds(150, 140, 350, 50);
		TypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		TypeLabel.setVisible(true);

		attackTypeLabel.setBounds(150, 350, 350, 50);
		attackTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		attackTypeLabel.setVisible(true);

		for (int i = 0; i < 6; i++) {
			multiplicatorButtons.add(new JButton());
		}
		count = 0;
		for (int j = 0; j < 6; j++) {
			double tempMultiplicator;
			multiplicatorButtons.get(count).setBounds(100 * j + 100, 300, 85, 25);
			multiplicatorButtons.get(count).setMargin(new Insets(2, 2, 2, 2));
			switch (j) {
			case 0:
				multiplicatorButtons.get(count).setText("0");
				tempMultiplicator = 0;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			case 1:
				multiplicatorButtons.get(count).setText("0.25");
				tempMultiplicator = 0.25;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			case 2:
				multiplicatorButtons.get(count).setText("0.5");
				tempMultiplicator = 0.5;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			case 3:
				multiplicatorButtons.get(count).setText("1");
				tempMultiplicator = 1;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			case 4:
				multiplicatorButtons.get(count).setText("2");
				tempMultiplicator = 2;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			case 5:
				multiplicatorButtons.get(count).setText("4");
				tempMultiplicator = 4;
				multiplicatorButtons.get(count).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rech.multiplicatorButtons_ActionPerformedMethod(tempMultiplicator);
					}
				});
				break;
			}
			count++;
		}
		trainerButton.setBounds(150, 200, 100, 50);
		trainerButton.setText("Trainer Battle");
		trainerButton.setMargin(new Insets(2, 2, 2, 2));
		trainerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.trainerButton_ActionPerformedMethod();
			}
		});

		gymLeaderButton.setBounds(275, 200, 100, 50);
		gymLeaderButton.setText("Gym Battle");
		gymLeaderButton.setMargin(new Insets(2, 2, 2, 2));
		gymLeaderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.gymLeaderButton_ActionPerformedMethod();
			}
		});
		// Von
		fightButton0.setBounds(780, 660, 100, 50);
		fightButton0.setText("Angriff");
		fightButton0.setMargin(new Insets(2, 2, 2, 2));
		fightButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.fightButton0_ActionPerformedMethod(fightButton0.getText());
				//System.out.println(fightButton0.getText());
			}
		});

		fightButton1.setBounds(880, 660, 100, 50);
		fightButton1.setText("Tauschen");
		fightButton1.setMargin(new Insets(2, 2, 2, 2));
		fightButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.fightButton1_ActionPerformedMethod(fightButton1.getText());
			}
		});

		// bis
		choosePokeName.setBounds(55, 100, 150, 30);
		choosePokeNumber.setBounds(0, 100, 55, 30);

		Datenbank.getPokemonNames(0, 0);
		for (int i = 0; i < Datenbank.Pokemon_Names.size(); i++) {
			choosePokeName.addItem(Datenbank.Pokemon_Names.get(i));
			choosePokeNumber.addItem(i + 1);
		}
		choosePokeName.setMaximumRowCount(20);
		choosePokeNumber.setMaximumRowCount(20);

		choosePokeName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				rech.pokeListPressed(0, choosePokeName.getSelectedIndex());				
			}
		});
		choosePokeNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.pokeListPressed(1, choosePokeNumber.getSelectedIndex());
			}
		});


		type1Label.setBounds(450, 150, 100, 50);
		type1Label.setFont(new Font("Dialog", Font.BOLD, 18));
		type1Label.setText("Type 1");
		type1Label.setVisible(true);

		type2Label.setBounds(600, 150, 100, 50);
		type2Label.setFont(new Font("Dialog", Font.BOLD, 18));
		type2Label.setText("Type 2");
		type2Label.setVisible(true);

		chooseButton.setBounds(500, 475, 205, 30);
		chooseButton.setText("Choose");
		chooseButton.setMargin(new Insets(2, 2, 2, 2));
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.chooseButton_ActionPerformedMethod(choosePokeNumber.getSelectedIndex() + 1);
			}
		});

		confirmButton.setBounds(885, 0, 100, 50);
		confirmButton.setText("Start Battle");
		confirmButton.setMargin(new Insets(2, 2, 2, 2));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rech.confirmButton_ActionPerformedMethod();
			}
		});

		infoPokemonLabel.setBounds(250, 550, 250, 150);
		infoPokemonLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		infoPokemonLabel.setVisible(true);
		
		infoOpponentPokemonLabel.setBounds(600, 150, 250, 150);
		infoOpponentPokemonLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		infoOpponentPokemonLabel.setVisible(true);
		
		for (int i = 0; i < 6; i++) {
			changeButtons.add(new JButton());
			
			pokeLabels.add(new JLabel());
		}
		for (int j = 0; j < 6; j++) {
				changeButtons.get(j).setBounds(750, 55*j + 100, 100, 50);
				changeButtons.get(j).setMargin(new Insets(2, 2, 2, 2));
				changeButtons.get(j).setText("Change");
				changeButtons.get(j).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
					}
				});
				
				pokeLabels.get(j).setBounds(500, 55*j + 100, 200, 50);
			}
	}

	public void setPanel(int tempCase) {
		switch (tempCase) {
		case 0:
			System.out.println("lil");
			break;
		case 1:
			attackerPanel.add(currentTypeLabel);
			currentTypeLabel.setVisible(false);

			defenderType.setText("Defender:");
			attackerPanel.add(defenderType);
			defenderType.setVisible(false);

			attackerPanel.add(modeLabel);
			modeLabel.setVisible(false);

			attackerPanel.add(usedType);
			usedType.setVisible(false);

			attackerPanel.add(resultsPressed);
			resultsPressed.setVisible(false);

			attackerPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);

			attackerPanel.add(backButton);
			backButton.setVisible(true);

			attackerPanel.add(effectiveButton);
			effectiveButton.setVisible(true);

			attackerPanel.add(notEffectiveButton);
			notEffectiveButton.setVisible(true);

			attackerPanel.add(immuneButton);
			immuneButton.setVisible(true);

			currentTypeLabel.setText("Attacker: " + rech.getCurrentType());

			int count = 0;

			for (int i = 0; i < 18; i++) {
				typesbuttons.add(new JButton());
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {

					attackerPanel.add(typesbuttons.get(count));
					typesbuttons.get(count).setVisible(false);
					count++;
				}
			}

			nothingButton.setVisible(false);
			attackerPanel.add(nothingButton);
			break;
		case 2:
			defenderPanel.add(currentTypeLabel);
			currentTypeLabel.setVisible(false);

			defenderType.setText("Attacker:");
			defenderPanel.add(defenderType);
			defenderType.setVisible(false);

			defenderPanel.add(modeLabel);
			modeLabel.setVisible(false);

			defenderPanel.add(usedType);
			usedType.setVisible(false);

			defenderPanel.add(resultsPressed);
			resultsPressed.setVisible(false);

			defenderPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);

			defenderPanel.add(backButton);
			backButton.setVisible(true);

			defenderPanel.add(effectiveButton);
			effectiveButton.setVisible(true);

			defenderPanel.add(notEffectiveButton);
			notEffectiveButton.setVisible(true);

			defenderPanel.add(immuneButton);
			immuneButton.setVisible(true);

			currentTypeLabel.setText("Defender: " + rech.getCurrentType());

			count = 0;

			for (int i = 0; i < 18; i++) {
				typesbuttons.add(new JButton());
			}
			// Typen Ersteller der Buttons

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 6; j++) {
					defenderPanel.add(typesbuttons.get(count));
					typesbuttons.get(count).setVisible(false);
					count++;
				}
			}

			nothingButton.setVisible(false);
			defenderPanel.add(nothingButton);
			break;
		case 3:
			oneTypeButton.setVisible(true);
			chooseSumOfTypesPanel.add(oneTypeButton);

			twoTypeButton.setVisible(true);
			chooseSumOfTypesPanel.add(twoTypeButton);

			chooseSumOfTypesPanel.add(backButton);
			backButton.setVisible(true);

			break;
		case 4:
			twoTypesDefenderPanel.add(TypeLabel);
			TypeLabel.setVisible(true);

			twoTypesDefenderPanel.add(attackTypeLabel);
			attackTypeLabel.setVisible(true);

			twoTypesDefenderPanel.add(usedType);
			usedType.setVisible(false);

			twoTypesDefenderPanel.add(resultsPressed);
			resultsPressed.setVisible(false);

			twoTypesDefenderPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);

			twoTypesDefenderPanel.add(backButton);
			backButton.setVisible(true);

			for (int j = 0; j < 6; j++) {

				twoTypesDefenderPanel.add(multiplicatorButtons.get(j));
				multiplicatorButtons.get(j).setVisible(true);
			}
			break;
		case 5:
			chooseOpponentPanel.add(backButton);
			backButton.setVisible(true);

			chooseOpponentPanel.add(trainerButton);
			trainerButton.setVisible(true);

			chooseOpponentPanel.add(gymLeaderButton);
			gymLeaderButton.setVisible(true);

			break;
		case 6:
			buildTeamPanel.add(backButton);
			backButton.setVisible(true);

			buildTeamPanel.add(choosePokeName);
			choosePokeName.setVisible(true);

			buildTeamPanel.add(choosePokeNumber);
			choosePokeNumber.setVisible(true);

			buildTeamPanel.add(selectButton);
			selectButton.setVisible(true);

			buildTeamPanel.add(type1Label);
			type1Label.setVisible(true);

			buildTeamPanel.add(type2Label);
			type2Label.setVisible(true);

			buildTeamPanel.add(chooseButton);
			chooseButton.setVisible(true);

			buildTeamPanel.add(confirmButton);
			confirmButton.setVisible(true);

			break;

		case 7:

			trainerPanel.add(backButton);
			backButton.setVisible(true);

			trainerPanel.add(fightButton1);
			fightButton1.setVisible(true);

			trainerPanel.add(fightButton0);
			fightButton0.setVisible(true);

			trainerPanel.add(infoPokemonLabel);
			infoPokemonLabel.setVisible(true);

			trainerPanel.add(infoOpponentPokemonLabel);
			infoOpponentPokemonLabel.setVisible(true);
			
			break;

		case 8:

			gymLeaderPanel.add(backButton);
			backButton.setVisible(true);

			gymLeaderPanel.add(fightButton1);
			fightButton1.setVisible(true);

			gymLeaderPanel.add(fightButton0);
			fightButton0.setVisible(true);
			
			gymLeaderPanel.add(infoPokemonLabel);
			infoPokemonLabel.setVisible(true);

			gymLeaderPanel.add(infoOpponentPokemonLabel);
			infoOpponentPokemonLabel.setVisible(true);


			break;

		case 9:		
			for(int i = 0; i<rech.getType1().size(); i++){
				changePokemonPanel.add(changeButtons.get(i));
				changeButtons.get(i).setVisible(true);
				
				changePokemonPanel.add(pokeLabels.get(i));
				pokeLabels.get(i).setVisible(true);		
				
				pokeLabels.get(i).setText("Type 1: "+rech.getType1().get(i)+ " Type2: "+ rech.getType2().get(i));
			
			}

		}
	}

	public JPanel getPanel(int tempPanel) {
		switch (tempPanel) {
		case 0:
			return menuPanel;
		case 1:
			return attackerPanel;
		case 2:
			return defenderPanel;
		case 3:
			return chooseSumOfTypesPanel;
		case 4:
			return twoTypesDefenderPanel;
		case 5:
			return chooseOpponentPanel;
		case 6:
			return buildTeamPanel;
		case 7:
			return trainerPanel;
		case 8:
			return gymLeaderPanel;
		case 9:
			return changePokemonPanel;
		default:
			System.out.println("Error");
			return null;
		}

	}

	public void setPicLabel(int i, int j) {

		ImageIcon imageIcon = new ImageIcon("Pokemon Pixel Icons/" + i + ".png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_REPLICATE);
		imageIcon = new ImageIcon(newimg);
		picLabel.setVisible(true);
		picLabel.setIcon(imageIcon);

		if (j == 0) {
			twoTypesDefenderPanel.add(picLabel);
			picLabel.setBounds(450, -40, 300, 300);

		}if (j == 1) {
			buildTeamPanel.add(picLabel);
			picLabel.setBounds(220, 50, 300, 300);
			buildTeamPanel.repaint();

		}

	}
	public void setFightPics(int i, int j){
		
		ImageIcon imageIcon = new ImageIcon("Pokemon Pixel Icons/" + i + ".png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_REPLICATE);
		imageIcon = new ImageIcon(newimg);
		pokePic.setVisible(true);
		pokePic.setIcon(imageIcon);
		
		trainerPanel.add(pokePic);
		pokePic.setBounds(250, 400, 300, 300);
		
		imageIcon = new ImageIcon("Pokemon Pixel Icons/" + j + ".png");
		image = imageIcon.getImage();
		newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_REPLICATE);
		imageIcon = new ImageIcon(newimg);
		pokeOpponentPic.setVisible(true);
		pokeOpponentPic.setIcon(imageIcon);
		
		trainerPanel.add(pokeOpponentPic);
		pokeOpponentPic.setBounds(620, -40, 300, 300);
		trainerPanel.repaint();
		
	}

	public void setType1Label(String s) {
		if (s != null) {
			type1Label.setText(s);
		}
	}

	public void setType2Label(String s) {
		if (s != null) {
			type2Label.setText(s);
		} else {
			type2Label.setText("");
		}
	}

	// Ende von Getter und Settern

} // end of class Fenster
