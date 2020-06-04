package Diagram_Klas;

import java.util.*;

public class Pracownik extends Osoba {

	Collection<Badania> Badanie;
	Collection<Recepta_Elektorniczna> Recepta_Elektroniczna;
	Collection<Skierowanie> Skierowanie;
	Collection<Wizyta> Wizyta;
	public int ID_Pracownik;
	public String Stanowisko;

	/**
	 *
	 * @param ID_Pracownik
	 * @param Stanowisko
	 */
	public Pracownik(int ID, String Imie,String Nazwisko,String Pesel, String Obraz, String Numer_Telefonu, String Data_Urodzenia, int ID_Pracownik, String Stanowisko) {
		super(ID, Imie, Nazwisko, Pesel, Obraz, Numer_Telefonu, Data_Urodzenia);
		// TODO - implement Pracownik.Pracownik
		this.ID_Pracownik = ID_Pracownik;
		this.Stanowisko = Stanowisko;
		throw new UnsupportedOperationException();
	}

	public void setID_Pracownik(int in) { ID_Pracownik = in; }
	public void setStanowisko(String in) { Stanowisko = in; }

	public int getID_Pracownik() { return ID_Pracownik; }
	public String getStanowisko() { return Stanowisko; }

}