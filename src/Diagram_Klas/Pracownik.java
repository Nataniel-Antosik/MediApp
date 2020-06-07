package Diagram_Klas;

import java.util.*;

public class Pracownik extends Osoba {

	Collection<Badania> Badanie;
	Collection<Recepta_Elektorniczna> Recepta_Elektroniczna;
	Collection<Skierowanie> Skierowanie;
	Map<String,HashMap<String,Wizyta>> Wizyta;
	public String Stanowisko;
	public String Login;
	public String Haslo;

	public Pracownik(){}
	public Pracownik(String Login, String Haslo, String Imie,String Nazwisko,String Pesel, String Numer_Telefonu, String Data_Urodzenia, String Stanowisko, String Mail, String adresZamieszkania, String kodPocztowy) {
		super(Imie, Nazwisko, Pesel, Numer_Telefonu, Data_Urodzenia, Mail, adresZamieszkania, kodPocztowy);
		// TODO - implement Pracownik.Pracownik
		this.Login = Login;
		this.Haslo = Haslo;
		this.Stanowisko = Stanowisko;
		Wizyta = new HashMap<String,HashMap<String,Wizyta>>();
		HashMap<String,Wizyta> temp = new HashMap<>();

	}
	public void setLogin(String in) { Login = in; }
	public void setHaslo(String in) { Haslo = in; }
	public void setStanowisko(String in) { Stanowisko = in; }

	public String getLogin() { return Login; }
	public String getHaslo() { return Haslo; }
	public String getStanowisko() { return Stanowisko; }

	public static boolean dodajPracownika(HashMap<String, Pracownik> Baza_Pracownikow, Pracownik p) {
		if (Baza_Pracownikow.get(p.getLogin()) == null) {
			Baza_Pracownikow.put(p.getLogin(), p);
			return true;
		}
		return false;
	}


}