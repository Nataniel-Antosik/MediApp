package Diagram_Klas;

import java.util.*;

public class Pacjent extends Osoba {

	Historia_Chorob_Pacjenta Historia;

	/**
	 *

	 */
	public Pacjent(String Imie,String Nazwisko,String Pesel, String Numer_Telefonu, String Data_Urodzenia, String Mail, String adresZamieszkania, String kodPocztowy) {
		super(Imie, Nazwisko, Pesel, Numer_Telefonu, Data_Urodzenia, Mail, adresZamieszkania, kodPocztowy);
		Historia = new Historia_Chorob_Pacjenta();
	}
	public Pacjent(){}



}