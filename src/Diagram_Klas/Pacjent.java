package Diagram_Klas;

import java.util.*;

public class Pacjent extends Osoba {

	Skierowanie Skierowanie;
	Collection<Wizyta> Wizyta;
	Recepta_Elektorniczna Recepta;
	Historia_Chorob_Pacjenta Historia;
	public int ID_Pacjenta;

	/**
	 *
	 * @param ID_Pacjenta
	 */
	public Pacjent(int ID,String Imie,String Nazwisko,String Pesel, String Obraz, String Numer_Telefonu, String Data_Urodzenia, int ID_Pacjenta) {
		super(ID, Imie, Nazwisko, Pesel, Obraz, Numer_Telefonu, Data_Urodzenia);
		// TODO - implement Pacjent.Pacjent
		this.ID_Pacjenta = ID_Pacjenta;
		throw new UnsupportedOperationException();
	}

	public void setID_Pacjenta(int in) { ID_Pacjenta = in; }

	public int getID_Pacjenta() { return ID_Pacjenta; }

	/**
	 * 
	 * @param ID_Recepty_Elektronicznej
	 */
	public void Sprawdz_Elektroniczna_Recepte(Diagram_Klas.Recepta_Elektorniczna ID_Recepty_Elektronicznej) {
		// TODO - implement Pacjent.Sprawdz_Elektroniczna_Recepte
		throw new UnsupportedOperationException();
	}
	public static boolean dodajPacjenta(HashMap<String, Pacjent> Baza2, Pacjent p) {
		if (Baza2.get(p.getPesel()) == null) {
			Baza2.put(p.getPesel(), p);
			return true;
		}
		return false;
	}
}