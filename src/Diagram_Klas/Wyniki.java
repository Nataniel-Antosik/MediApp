package Diagram_Klas;

public class Wyniki {

	Badania Badanie;
	Historia_Chorob_Pacjenta Historia;
	public int ID_Wyniki;
	public String Opis;

	/**
	 * 
	 * @param ID_Badania
	 * @param ID_Wyniki
	 * @param Opis
	 */
	public Wyniki(Diagram_Klas.Badania ID_Badania, int ID_Wyniki, String Opis) {
		// TODO - implement Wyniki.Wyniki
		this.ID_Wyniki = ID_Wyniki;
		this.Opis = Opis;
		throw new UnsupportedOperationException();
	}

	//public void setBadanie(Badania badanie) { Badanie = badanie; }
	public void setID_Wyniki(int ID_Wyniki) { this.ID_Wyniki = ID_Wyniki; }
	public void setOpis(String opis) { Opis = opis; }

	//public Badania getBadanie() { return Badanie; }
	public int getID_Wyniki() { return ID_Wyniki; }
	public String getOpis() { return Opis; }

	public void Sprawdz_Wynikow() {
		// TODO - implement Wyniki.Sprawdz_Wynikow
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID_Wyniki
	 */
	public void Sprawdz_Wynik(int ID_Wyniki) {
		// TODO - implement Wyniki.Sprawdz_Wynik
		throw new UnsupportedOperationException();
	}

}