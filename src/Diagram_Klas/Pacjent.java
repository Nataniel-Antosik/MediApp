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
	public Pacjent(String Imie,String Nazwisko,String Pesel, String Numer_Telefonu, String Data_Urodzenia, String Mail) {
		super(Imie, Nazwisko, Pesel, Numer_Telefonu, Data_Urodzenia, Mail);
		// TODO - implement Pacjent.Pacjent
	}
	public Pacjent(){}


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