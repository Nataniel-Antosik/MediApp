package Diagram_Klas;

import java.util.*;

public class Pacjent extends Osoba {

	Skierowanie Skierowanie;
	Collection<Wizyta> Wizyta;
	Recepta_Elektorniczna Recepta;
	Historia_Chorob_Pacjenta Historia;

	/**
	 *

	 */
	public Pacjent(String Imie,String Nazwisko,String Pesel, String Numer_Telefonu, String Data_Urodzenia, String Mail, String adresZamieszkania) {
		super(Imie, Nazwisko, Pesel, Numer_Telefonu, Data_Urodzenia, Mail, adresZamieszkania);
		// TODO - implement Pacjent.Pacjent
	}
	public Pacjent(){}
	public Pacjent(Pacjent pacjent){
		this.Imie = pacjent.Imie;
		this.Nazwisko = pacjent.Nazwisko;
		this.Pesel = pacjent.Pesel;
		this.Data_Urodzenia = pacjent.Data_Urodzenia;
		this.Numer_Telefonu = pacjent.Numer_Telefonu;
		this.Mail = pacjent.Mail;
		this.adresZamieszkania = pacjent.adresZamieszkania;

	}

	public static Pacjent copy(Pacjent other){
		Pacjent nowyPacjent = new Pacjent();
		nowyPacjent.setImie(String.valueOf(other.Imie));
		nowyPacjent.setNazwisko(String.valueOf(other.Nazwisko));
		nowyPacjent.setPesel(String.valueOf(other.Pesel));
		nowyPacjent.setData_Urodzenia(String.valueOf(other.Data_Urodzenia));
		nowyPacjent.setNumer_Telefonu(String.valueOf(other.Numer_Telefonu));
		nowyPacjent.setMail(String.valueOf(other.Mail));
		return nowyPacjent;
	}


}