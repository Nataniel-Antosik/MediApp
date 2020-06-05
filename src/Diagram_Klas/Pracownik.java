package Diagram_Klas;

import java.util.*;

public class Pracownik extends Osoba {

	Collection<Badania> Badanie;
	Collection<Recepta_Elektorniczna> Recepta_Elektroniczna;
	Collection<Skierowanie> Skierowanie;
	Collection<Wizyta> Wizyta;
	public int ID_Pracownik;
	public String Stanowisko;
	public String Login;
	public String Haslo;

	/**
	 *
	 * @param ID_Pracownik
	 * @param Stanowisko
	 */
	public Pracownik(){}
	public Pracownik(int ID, String Imie,String Nazwisko,String Pesel, String Obraz, String Numer_Telefonu, String Data_Urodzenia, int ID_Pracownik, String Stanowisko, String Login, String Haslo) {
		super(ID, Imie, Nazwisko, Pesel, Obraz, Numer_Telefonu, Data_Urodzenia);
		// TODO - implement Pracownik.Pracownik
		this.ID_Pracownik = ID_Pracownik;
		this.Stanowisko = Stanowisko;
		this.Login = Login;
		this.Haslo = Haslo;
		//throw new UnsupportedOperationException();
	}

	public void setID_Pracownik(int in) { ID_Pracownik = in; }
	public void setStanowisko(String in) { Stanowisko = in; }
	public void setLogin(String in) { Login = in; }
	public void setHaslo(String in) { Haslo = in; }

	public int getID_Pracownik() { return ID_Pracownik; }
	public String getStanowisko() { return Stanowisko; }
	public String getLogin() { return Login; }
	public String getHaslo() { return Haslo; }

	public static boolean dodajPracownika(HashMap<String, Pracownik> Baza, Pracownik o) {
		if (Baza.get(o.getPesel()) == null) {
			Baza.put(o.getPesel(), o);
			return true;
		}
		return false;
	}


}