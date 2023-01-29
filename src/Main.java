
public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		Datenbank Datenbank = new Datenbank();
		Rechenzentrum Rechenzentrum = new Rechenzentrum();
		Fenster Fenster = new Fenster(Rechenzentrum);
		
		Rechenzentrum.init_Gui(Fenster);
	}

}
