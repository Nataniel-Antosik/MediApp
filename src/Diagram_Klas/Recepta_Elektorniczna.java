package Diagram_Klas;

import javax.sound.midi.Receiver;
import javax.xml.crypto.Data;
import java.util.*;

public class Recepta_Elektorniczna {

	Collection<Pacjent> Pacjent;
	Pracownik Wydajacy;
	public int ID_Recepty_Elektronicznej;
	public String Data_Waznosci;
	public String[] Lek;
	public int klucz;
	public String Pesel;

	public Recepta_Elektorniczna(Pacjent p) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, String Data_Waznosci, String[] Lek, int Klucz
		Random generator = new Random();
		this.Pesel = p.getPesel();
		klucz = generator.nextInt(1000000);
		this.klucz = klucz;

	}
	public void setID_Recepty_Elektronicznej(int in) { ID_Recepty_Elektronicznej = in; }
	public void setData_Wizyty(String in) { Data_Waznosci = in; }

	public int getID_Recepty_Elektronicznej(){ return ID_Recepty_Elektronicznej; }
	public String getData_Waznosci() { return Data_Waznosci; }
	public int getKlucz() { return klucz; }
	public String getPesel() { return Pesel; }
	/**
	 * 
	 * @param Pesel
	 * @param ID_Recepty_Elektronicznej
	 * @param Data_Waznosci
	 * @param Opis
	 */

	public void dodaj_Recepte(){

		Recepta_Elektorniczna tmp = new Recepta_Elektorniczna();
	}

	public void Drukuj_Recepte(Recepta_Elektorniczna re) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, Data Data_Waznosci, String Opis
		System.out.println("Recepta");
		System.out.println("ID recepty elektronicznej: "+ re.getID_Recepty_Elektronicznej());
		System.out.println("Data waznosci: " + re.getData_Waznosci());

	}

}