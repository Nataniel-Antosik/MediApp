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
	/**
	 * 
	 * @param ID_Recepty_Elektronicznej
	 */
	public void Sprawdz_Elektroniczna_Recepte(Diagram_Klas.Recepta_Elektorniczna ID_Recepty_Elektronicznej) {
		// TODO - implement Pacjent.Sprawdz_Elektroniczna_Recepte
	}

}