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
	
	public Rechenzentrum(){
		
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
		switch(i) {
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
