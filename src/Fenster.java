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
	private JTextPane usedType = new JTextPane();
	private JTextPane resultsPressed = new JTextPane();
	private JTextPane resultsShouldPressed = new JTextPane();

	private JPanel menuPanel = new JPanel();
	private JPanel attackerPanel = new JPanel();
	private JPanel defenderPanel = new JPanel();
	private JPanel battlePanel = new JPanel();
	private JPanel chooseSumOfTypesPanel = new JPanel();
	private JPanel twoTypesDefenderPanel = new JPanel();

	private JButton attackerSide = new JButton();
	private JButton defenderSide = new JButton();
	private JButton battleMode = new JButton();

	private JButton oneTypeButton = new JButton();
	private JButton twoTypeButton = new JButton();
	private JButton tempButton = new JButton();

	private JButton backButton = new JButton();
	private JButton effectiveButton = new JButton();
	private JButton notEffectiveButton = new JButton();
	private JButton immuneButton = new JButton();
	private JButton randomButton = new JButton();
	private JButton nothingButton = new JButton();
	private ArrayList<JButton> typesbuttons = new ArrayList<JButton>();
	private ArrayList<JButton> multiplicatorButtons = new ArrayList<JButton>();
	private Rechenzentrum rech = null;
	private Container cp;
	private int pokecount = 0;

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
		battlePanel.setLayout(null);
		chooseSumOfTypesPanel.setLayout(null);
		twoTypesDefenderPanel.setLayout(null);

		attackerSide.setBounds(150, 200, 100, 50);
		attackerSide.setText("Attacker");
		attackerSide.setMargin(new Insets(2, 2, 2, 2));
		attackerSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				attackerSideButton_ActionPerformed(evt);
			}
		});
		menuPanel.add(attackerSide);
		attackerSide.setVisible(true);

		defenderSide.setText("Defender");
		defenderSide.setMargin(new Insets(2, 2, 2, 2));
		defenderSide.setBounds(275, 200, 100, 50);
		defenderSide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				defenderSideButton_ActionPerformed(evt);
			}
		});
		menuPanel.add(defenderSide);
		defenderSide.setVisible(true);

		battleMode.setBounds(400, 200, 100, 50);
		battleMode.setText("Battle");
		battleMode.setMargin(new Insets(2, 2, 2, 2));
		battleMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				battleModeButton_ActionPerformed(evt);
			}
		});
		menuPanel.add(battleMode);
		battleMode.setVisible(true);

		setVisible(true);
	} // end of public Fenster

	// Anfang Methoden
	public void attackerSideButton_ActionPerformed(ActionEvent evt) {

		rech.attackerSideButton_ActionPerformedMethod();
	}

	public void defenderSideButton_ActionPerformed(ActionEvent evt) {

		rech.defenderSideButton_ActionPerformedMethod();
	}

	public void battleModeButton_ActionPerformed(ActionEvent evt) {

		rech.battleModeButton_ActionPerformedMethod();
		
	}

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

		rech.typesbuttons_ActionPerformedMethod(evt, tempTypes);
	}

	public void backButton_ActionPerformed(ActionEvent evt, int done) {

		rech.backButton_ActionPerformedMethod(evt, done);
	}

	public void nothingButton_ActionPerformed(ActionEvent evt) {

		rech.nothingButton_ActionPerformedMethod(evt);
	}

	public void oneTypeButton_ActionPerformed(ActionEvent evt) {

		rech.oneTypeButton_ActionPerformedMethod();
	}

	public void twoTypeButton_ActionPerformed(ActionEvent evt) {

		rech.twoTypeButton_ActionPerformedMethod();
	}
	
	public void multiplicatorButtons_ActionPerformed(ActionEvent evt,double tempMultiplicator) {
		rech.multiplicatorButtons_ActionPerformedMethod(evt, tempMultiplicator);
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

	public JPanel getMenuPanel() {
		return menuPanel;
	}

	public void setMenuPanel(JPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public JPanel getAttackerPanel() {
		return attackerPanel;
	}

	public void setAttackerPanel(JPanel attackerPanel) {

	}

	public JPanel getDefenderPanel() {
		return defenderPanel;
	}

	public void setDefenderPanel(JPanel defenderPanel) {
		this.defenderPanel = defenderPanel;
	}

	public JPanel getBattlePanel() {
		return battlePanel;
	}

	public void setBattlePanel(JPanel battlePanel) {
		this.battlePanel = battlePanel;
	}

	public void setCurrentPanel(int tempCase) {
		switch (tempCase) {
		case 1:
			currentTypeLabel.setBounds(150, 140, 350, 50);
			attackerPanel.add(currentTypeLabel);
			currentTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			currentTypeLabel.setVisible(false);

			defenderType.setBounds(50, 310, 350, 50);
			attackerPanel.add(defenderType);
			defenderType.setText("Defender:");
			defenderType.setFont(new Font("Dialog", Font.BOLD, 18));
			defenderType.setVisible(false);

			modeLabel.setBounds(600, 110, 350, 50);
			attackerPanel.add(modeLabel);
			modeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			modeLabel.setVisible(false);

			usedType.setBounds(20, 200, 70, 450);
			attackerPanel.add(usedType);
			usedType.setVisible(false);
			usedType.setEditable(false);
			usedType.setEditorKit(new HTMLEditorKit());

			resultsPressed.setBounds(100, 200, 420, 450);
			attackerPanel.add(resultsPressed);
			resultsPressed.setVisible(false);
			resultsPressed.setEditable(false);
			resultsPressed.setEditorKit(new HTMLEditorKit());

			resultsShouldPressed.setBounds(530, 200, 420, 450);
			attackerPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);
			resultsShouldPressed.setEditable(false);
			resultsShouldPressed.setEditorKit(new HTMLEditorKit());

			Datenbank.getTypes("", 0, 0);
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
			attackerPanel.add(backButton);

			effectiveButton.setBounds(150, 200, 100, 50);
			effectiveButton.setText("Effective");
			effectiveButton.setMargin(new Insets(2, 2, 2, 2));
			effectiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					effectiveButton_ActionPerformed(evt);
				}
			});
			attackerPanel.add(effectiveButton);

			notEffectiveButton.setBounds(275, 200, 100, 50);
			notEffectiveButton.setText("Not Effective");
			notEffectiveButton.setMargin(new Insets(2, 2, 2, 2));
			notEffectiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					notEffectiveButton_ActionPerformed(evt);
				}
			});
			attackerPanel.add(notEffectiveButton);

			immuneButton.setBounds(400, 200, 100, 50);
			immuneButton.setText("Immune");
			immuneButton.setMargin(new Insets(2, 2, 2, 2));
			immuneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					immuneButton_ActionPerformed(evt);
				}
			});
			attackerPanel.add(immuneButton);

			randomButton.setBounds(275, 275, 100, 50);
			randomButton.setText("Random");
			randomButton.setMargin(new Insets(2, 2, 2, 2));
			randomButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					randomButton_ActionPerformed(evt);
				}
			});
			attackerPanel.add(randomButton);

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
							typesbuttons_ActionPerformed(evt, tempTypes);
						}
					});
					attackerPanel.add(typesbuttons.get(count));
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
			attackerPanel.add(nothingButton);
			break;
		case 2:
			currentTypeLabel.setBounds(150, 140, 350, 50);
			defenderPanel.add(currentTypeLabel);
			currentTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			currentTypeLabel.setVisible(false);

			defenderType.setBounds(50, 310, 350, 50);
			defenderPanel.add(defenderType);
			defenderType.setText("Attacker:");
			defenderType.setFont(new Font("Dialog", Font.BOLD, 18));
			defenderType.setVisible(false);

			modeLabel.setBounds(600, 110, 350, 50);
			defenderPanel.add(modeLabel);
			modeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			modeLabel.setVisible(false);

			usedType.setBounds(20, 200, 70, 450);
			defenderPanel.add(usedType);
			usedType.setVisible(false);
			usedType.setEditable(false);
			usedType.setEditorKit(new HTMLEditorKit());

			resultsPressed.setBounds(100, 200, 420, 450);
			defenderPanel.add(resultsPressed);
			resultsPressed.setVisible(false);
			resultsPressed.setEditable(false);
			resultsPressed.setEditorKit(new HTMLEditorKit());

			resultsShouldPressed.setBounds(530, 200, 420, 450);
			defenderPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);
			resultsShouldPressed.setEditable(false);
			resultsShouldPressed.setEditorKit(new HTMLEditorKit());

			Datenbank.getTypes("", 0, 0);
			rech.setCurrentType(Datenbank.getTypes(rech.getRand(), 0));
			currentTypeLabel.setText("Defender: " + rech.getCurrentType());
			backButton.setBounds(0, 0, 100, 50);
			backButton.setText("Back");
			backButton.setMargin(new Insets(2, 2, 2, 2));
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {

					backButton_ActionPerformed(evt, 0);
				}
			});
			defenderPanel.add(backButton);

			effectiveButton.setBounds(150, 200, 100, 50);
			effectiveButton.setText("Effective");
			effectiveButton.setMargin(new Insets(2, 2, 2, 2));
			effectiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					effectiveButton_ActionPerformed(evt);
				}
			});
			defenderPanel.add(effectiveButton);

			notEffectiveButton.setBounds(275, 200, 100, 50);
			notEffectiveButton.setText("Not Effective");
			notEffectiveButton.setMargin(new Insets(2, 2, 2, 2));
			notEffectiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					notEffectiveButton_ActionPerformed(evt);
				}
			});
			defenderPanel.add(notEffectiveButton);

			immuneButton.setBounds(400, 200, 100, 50);
			immuneButton.setText("Immune");
			immuneButton.setMargin(new Insets(2, 2, 2, 2));
			immuneButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					immuneButton_ActionPerformed(evt);
				}
			});
			defenderPanel.add(immuneButton);

			randomButton.setBounds(275, 275, 100, 50);
			randomButton.setText("Random");
			randomButton.setMargin(new Insets(2, 2, 2, 2));
			randomButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					randomButton_ActionPerformed(evt);
				}
			});
			defenderPanel.add(randomButton);

			count = 0;

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
							typesbuttons_ActionPerformed(evt, tempTypes);
						}
					});
					defenderPanel.add(typesbuttons.get(count));
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
			defenderPanel.add(nothingButton);
			break;
		case 3:
			oneTypeButton.setBounds(150, 200, 100, 50);
			oneTypeButton.setText("One Piece");
			oneTypeButton.setMargin(new Insets(2, 2, 2, 2));
			oneTypeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					oneTypeButton_ActionPerformed(evt);
				}
			});
			oneTypeButton.setVisible(true);
			
			chooseSumOfTypesPanel.add(oneTypeButton);
		
			twoTypeButton.setBounds(275, 200, 100, 50);
			twoTypeButton.setText("Two Piece");
			twoTypeButton.setMargin(new Insets(2, 2, 2, 2));
			twoTypeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					twoTypeButton_ActionPerformed(evt);
				}
			});
			twoTypeButton.setVisible(true);
			chooseSumOfTypesPanel.add(twoTypeButton);
			break;
		case 4:
			TypeLabel.setBounds(150, 140, 350, 50);
			twoTypesDefenderPanel.add(TypeLabel);
			TypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			TypeLabel.setVisible(true);
			
			attackTypeLabel.setBounds(150,350,350,50);
			twoTypesDefenderPanel.add(attackTypeLabel);
			attackTypeLabel.setFont(new Font("Dialog", Font.BOLD, 18));
			attackTypeLabel.setVisible(true);
			
			usedType.setBounds(20, 200, 70, 450);
			twoTypesDefenderPanel.add(usedType);
			usedType.setVisible(false);
			usedType.setEditable(false);
			usedType.setEditorKit(new HTMLEditorKit());
			
			resultsPressed.setBounds(100, 200, 420, 450);
			twoTypesDefenderPanel.add(resultsPressed);
			resultsPressed.setVisible(false);
			resultsPressed.setEditable(false);
			resultsPressed.setEditorKit(new HTMLEditorKit());

			resultsShouldPressed.setBounds(530, 200, 420, 450);
			twoTypesDefenderPanel.add(resultsShouldPressed);
			resultsShouldPressed.setVisible(false);
			resultsShouldPressed.setEditable(false);
			resultsShouldPressed.setEditorKit(new HTMLEditorKit());
			
			for (int i = 0; i < 6; i++) {
				multiplicatorButtons.add(new JButton());
			}
			count = 0;
			for (int j = 0; j < 6; j++) {
				double tempMultiplicator;
				multiplicatorButtons.get(count).setBounds(100 * j + 100, 300, 85, 25);
				multiplicatorButtons.get(count).setMargin(new Insets(2, 2, 2, 2));
				switch(j) {
				case 0:
					multiplicatorButtons.get(count).setText("0");
					tempMultiplicator = 0;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				case 1:
					multiplicatorButtons.get(count).setText("0.25");
					tempMultiplicator = 0.25;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				case 2:
					multiplicatorButtons.get(count).setText("0.5");
					tempMultiplicator = 0.5;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				case 3:
					multiplicatorButtons.get(count).setText("1");
					tempMultiplicator = 1;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				case 4:
					multiplicatorButtons.get(count).setText("2");
					tempMultiplicator = 2;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				case 5:
					multiplicatorButtons.get(count).setText("4");
					tempMultiplicator = 4;
					multiplicatorButtons.get(count).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							multiplicatorButtons_ActionPerformed(evt, tempMultiplicator);
						}
					});
					break;
				}
				
				twoTypesDefenderPanel.add(multiplicatorButtons.get(count));
				multiplicatorButtons.get(count).setVisible(true);
				count++;
			}
			break;
		case 5:
			ImageIcon imageIcon = new ImageIcon();
			imageIcon = new ImageIcon("Pokemon Pixel Icons/"+pokecount+".png");
			Image image = imageIcon.getImage(); 
			Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); 
			imageIcon = new ImageIcon(newimg);
			picLabel = new JLabel(imageIcon);
			picLabel.setBounds(100, 100, 300, 300);
			picLabel.setVisible(true);
			
			battlePanel.add(picLabel);
			
			tempButton.setBounds(0, 0, 100, 50);
			tempButton.setText("Temp");
			tempButton.setMargin(new Insets(2, 2, 2, 2));
			tempButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					pokecount++;
					setPicLabel(pokecount);
					
				}
			});
			battlePanel.add(tempButton);

			break;
			
			
//			randomButton.setBounds(275, 275, 100, 50);
//			randomButton.setText("Random");
//			randomButton.setMargin(new Insets(2, 2, 2, 2));
//			randomButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent evt) {
//					randomButton_ActionPerformed(evt);
//				}
//			});
//			twoTypesDefenderPanel.add(randomButton);
			
			
			
		}
	}

	public JLabel getTypeLabel() {
		return TypeLabel;
	}

	public void setFirstTypeLabel(JLabel firstTypeLabel) {
		this.TypeLabel = firstTypeLabel;
	}

	public JLabel getAttackTypeLabel() {
		return attackTypeLabel;
	}

	public void setAttackTypeLabel(JLabel secondTypeLabel) {
		this.attackTypeLabel = secondTypeLabel;
	}

	public JButton getAttackerSide() {
		return attackerSide;
	}

	public void setAttackerSide(JButton attackerSide) {
		this.attackerSide = attackerSide;
	}

	public JButton getDefenderSide() {
		return defenderSide;
	}

	public void setDefenderSide(JButton defenderSide) {
		this.defenderSide = defenderSide;
	}

	public JButton getBattleMode() {
		return battleMode;
	}

	public void setBattleMode(JButton battleMode) {
		this.battleMode = battleMode;
	}

	public Container getCp() {
		return cp;
	}

	public void setCp(Container cp) {
		this.cp = cp;
	}

	public JLabel getModeLabel() {
		return modeLabel;
	}

	public void setModeLabel(JLabel modeLabel) {
		this.modeLabel = modeLabel;
	}

	public JPanel getChooseSumOfTypesPanel() {
		return chooseSumOfTypesPanel;
	}

	public void setChooseSumOfTypesPanel(JPanel chooseSumOfTypesPanel) {
		this.chooseSumOfTypesPanel = chooseSumOfTypesPanel;
	}

	public JButton getOneTypeButton() {
		return oneTypeButton;
	}

	public void setOneTypeButton(JButton oneTypeButton) {
		this.oneTypeButton = oneTypeButton;
	}

	public JButton getTwoTypeButton() {
		return twoTypeButton;
	}

	public void setTwoTypeButton(JButton twoTypeButton) {
		this.twoTypeButton = twoTypeButton;
	}

	public JPanel getTwoTypesDefenderPanel() {
		return twoTypesDefenderPanel;
	}

	public void setTwoTypesDefenderPanel(JPanel twoTypesDefenderPanel) {
		this.twoTypesDefenderPanel = twoTypesDefenderPanel;
	}

	public JButton getMultiplicatorButtons(int temp) {
		return multiplicatorButtons.get(temp);
	}

	public void setMultiplicatorButtons(ArrayList<JButton> multiplicatorButtons) {
		this.multiplicatorButtons = multiplicatorButtons;
	}
	
	public void setPicLabel(int i) {
		ImageIcon imageIcon = new ImageIcon("Pokemon Pixel Icons/"+i+".png");
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_REPLICATE); 
		imageIcon = new ImageIcon(newimg);
		picLabel.setIcon(imageIcon);
		
	}


	// Ende von Getter und Settern

} // end of class Fenster
