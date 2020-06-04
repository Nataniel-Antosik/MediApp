package Diagram_Klas;

import javax.xml.crypto.Data;
import java.util.*;

public class Recepta_Elektorniczna {

	Collection<Pacjent> Pacjent;
	Pracownik Wydajacy;
	public int ID_Recepty_Elektronicznej;
	public Data Data_Waznosci;
	public String[] Lek;
	public int Klucz;

	/**
	 * 
	 * @param ID_Pacjenta
	 * @param ID_Recepty_Elektronicznej
	 * @param Data_Waznosci
	 * @param Lek
	 * @param Klucz
	 */
	public Recepta_Elektorniczna(Diagram_Klas.Pacjent ID_Pacjenta, int ID_Recepty_Elektronicznej, Data Data_Waznosci, String[] Lek, int Klucz) {
		// TODO - implement Recepta_Elektorniczna.Recepta_Elektorniczna
		this.ID_Recepty_Elektronicznej = ID_Recepty_Elektronicznej;
		this.Data_Waznosci = Data_Waznosci;
		this.Klucz = Klucz;
		throw new UnsupportedOperationException();
	}
	public void setID_Recepty_Elektronicznej(int in) { ID_Recepty_Elektronicznej = in; }
	public void setData_Wizyty(Data in) { Data_Waznosci = in; }
	public void setKlucz(int in){ Klucz = in; }

	public int getID_Recepty_Elektronicznej(){ return ID_Recepty_Elektronicznej; }
	public Data getData_Waznosci() { return Data_Waznosci; }
	public int getKlucz() { return Klucz; }
	/**
	 * 
	 * @param ID_Pacjenta
	 * @param ID_Recepty_Elektronicznej
	 * @param Data_Waznosci
	 * @param Opis
	 */
	public void Drukuj_Recepte(Diagram_Klas.Pacjent ID_Pacjenta, int ID_Recepty_Elektronicznej, Data Data_Waznosci, String Opis) {
		// TODO - implement Recepta_Elektorniczna.Drukuj_Recepte
		throw new UnsupportedOperationException();
	}

}