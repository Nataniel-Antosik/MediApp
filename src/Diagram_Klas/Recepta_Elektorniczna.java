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
	public static String[][] Lek = new String[2][10];
	public int klucz;
	public String Pesel;
	public String Opis;

	public Recepta_Elektorniczna(Pacjent p) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, String Data_Waznosci, String[] Lek, int Klucz
		Random generator = new Random();
		this.klucz = generator.nextInt(1000000);
		this.ID_Recepty_Elektronicznej = generator.nextInt(1000000);
		this.Pesel = p.getPesel();
	}
	public void setData_Wizyty(String in) { Data_Waznosci = in; }
	public void setLekarstwo(String[][] le) {Lek=le;}
	public int getID_Recepty_Elektronicznej(){ return ID_Recepty_Elektronicznej; }
	public String getData_Waznosci() { return Data_Waznosci; }
	public int getKlucz() { return klucz; }
	public String getPesel() { return Pesel; }

	public static void dodaj_Recepte(){
		Pacjent tmp = new Pacjent();
		System.out.println("Wpisz pesel pacjenta: ");
		String pesel = scan.next();
		tmp = Main.znajdzPacjent(pesel);
		Recepta_Elektorniczna tmp2 = new Recepta_Elektorniczna(tmp);
		System.out.println("Pesel, ID i klucz pacjenta zostal wpisany");
		int i=0;
		while(true) {
			System.out.println("Wpisz lekarstwo: ");
			Lek[0][i] = scan.next();
			System.out.println("Wpisz dawkowanie: ");
			Lek[1][i] = scan.next();
			System.out.println("Czy chcesz dodac nastepne lekarstwo Tak[1]/Nie[0]");
			int k=scan.nextInt();
			if(k==0 || i==9){
				break;
			}
			i=i+1;
		}
		System.out.println("Wpisz date waznosci: ");
		String data_Waznosci = scan.next();
	}

	public void Drukuj_Recepte(Recepta_Elektorniczna re) {
		//Diagram_Klas.Pacjent Pesel, int ID_Recepty_Elektronicznej, Data Data_Waznosci, String Opis
		Pacjent pacjent = new Pacjent();
		pacjent = Main.znajdzPacjent(re.getPesel());
		System.out.println("Recepta");
		System.out.println("Imie: " + pacjent.getImie());
		System.out.println("Nazwisko: " + pacjent.getNazwisko());
		System.out.println("Adres zamieszkania: " + pacjent.adresZamieszkania);
		System.out.println("ID recepty elektronicznej: "+ re.getID_Recepty_Elektronicznej());
		System.out.println("Data waznosci: " + re.getData_Waznosci());

	}

}