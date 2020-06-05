package Diagram_Klas;

import java.awt.font.NumericShaper;
import java.util.HashMap;

public class Osoba {
	public int ID;
	public String Imie;
	public String Nazwisko;
	public String Pesel;
	public String Numer_Telefonu;
	public String Data_Urodzenia;

	/**
	 * 
	 * @param ID
	 * @param Imie
	 * @param Nazwisko
	 * @param Pesel
	 * @param Numer_Telefonu
	 * @param Data_Urodzenia
	 */
	public Osoba(int ID, String Imie, String Nazwisko, String Pesel, String Numer_Telefonu, String Data_Urodzenia) {
		// TODO - implement Osoba.Osoba

		this.ID = ID;
		this.Imie = Imie;
		this.Nazwisko = Nazwisko;
		this.Pesel = Pesel;
		this.Numer_Telefonu = Numer_Telefonu;
		this.Data_Urodzenia = Data_Urodzenia;
		//throw new UnsupportedOperationException();
	}
	public Osoba(){}

	public void setID(int in) { ID = in; }
	public void setImie(String in) { Imie = in; }
	public void setNazwisko(String in) { Nazwisko = in; }
	public void setPesel(String in) {
		if(in.length() != 11){
			throw new NumberFormatException("Zly format peselu");
		}
		try{
			int msc = Integer.parseInt(in.substring(2,4));
			msc %= 20;
			if(msc > 12) throw new NumberFormatException("Zly format peselu");
			int day = Integer.parseInt(in.substring(4,6));
			if (day > 31) throw new NumberFormatException("Zly format peselu");
		}
		catch (NumberFormatException nfe){
			throw new NumberFormatException("Zly format peselu");
		}
		Pesel = in;
	}
	public void setNumer_Telefonu(String in) { Numer_Telefonu = in; }
	public void setData_Urodzenia(String in) { Data_Urodzenia = in; }

	public int getID() { return ID; }
	public String getImie() { return Imie; }
	public String getNazwisko() { return Nazwisko; }
	public String getPesel() { return Pesel; }
	public String getNumer_Telefonu() { return Numer_Telefonu; }
	public String getData_Urodzenia() { return Data_Urodzenia; }

	public static boolean dodajOsoba(HashMap<String, Osoba> Baza, Osoba o) {
		if (Baza.get(o.getPesel()) == null) {
			Baza.put(o.getPesel(), o);
			return true;
		}
		return false;
	}
}