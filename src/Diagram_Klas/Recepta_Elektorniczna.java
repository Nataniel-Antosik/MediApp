package Diagram_Klas;

import javax.sound.midi.Receiver;
import javax.xml.crypto.Data;
import java.util.*;
import Diagram_Klas.Main;

public class Recepta_Elektorniczna {
	private static Scanner scan = new Scanner(System.in);
	Main m = new Main();

	Collection<Pacjent> Pacjent;
	Pracownik Wydajacy;
	public int ID_Recepty_Elektronicznej;
	public String Data_Waznosci;
	public String[] Lek;
	public int klucz;
	public String Pesel;
	public String Opis;
	private int k;
	private int ID;


	public Recepta_Elektorniczna(Pacjent p) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, String Data_Waznosci, String[] Lek, int Klucz
		Random generator = new Random();
		int k = generator.nextInt(1000000);
		int ID = generator.nextInt(1000000);
		this.klucz = klucz;
		this.ID_Recepty_Elektronicznej = ID;
		this.Pesel = p.getPesel();
	}
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
		Pacjent tmp = new Pacjent();
		System.out.println("Wpisz pesel pacjenta: ");
		String pesel = scan.next();
		tmp = m.znajdzPacjent(pesel);
		Recepta_Elektorniczna tmp2 = new Recepta_Elektorniczna(tmp);
		System.out.println("Pesel, ID i klucz pacjenta zostal wpisany");
		System.out.println("Wpisz date waznosci: ");
		String data_Waznosci = scan.next();

	}

	public void Drukuj_Recepte(Recepta_Elektorniczna re) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, Data Data_Waznosci, String Opis
		System.out.println("Recepta");
		System.out.println("ID recepty elektronicznej: "+ re.getID_Recepty_Elektronicznej());
		System.out.println("Data waznosci: " + re.getData_Waznosci());

	}

}