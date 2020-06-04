package Diagram_Klas;

import javax.xml.crypto.Data;

public class Badania {

	Pracownik Wykonujacy;
	Wyniki Wynik;
	public int ID_Badania;
	public String Badanie;
	public String Opis;
	public Data Data_Badania;

	/**
	 * 
	 * @param Badanie
	 * @param ID_Badania
	 * @param Opis
	 * @param Data_Badania
	 */
	public Badania(String Badanie, int ID_Badania, String Opis, Diagram_Klas.Rejestracja_Pacjenta Data_Badania) {
		// TODO - implement Badania.Badania
		this.Badanie = Badanie;
		this.ID_Badania = ID_Badania;
		this.Opis = Opis;
		throw new UnsupportedOperationException();
	}

	public void setBadanie(String in) { Badanie = in; }
	public void setID_Badania(int in) { ID_Badania = in; }
	public void setOpis(String in) { Opis = in; }

	public String getBadanie() { return Badanie; }
	public int getID_Badania() { return ID_Badania; }
	public String getOpis() { return Opis; }
}