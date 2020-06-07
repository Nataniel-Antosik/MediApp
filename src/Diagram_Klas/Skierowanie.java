package Diagram_Klas;

import javax.xml.crypto.Data;
import java.util.*;

public class Skierowanie {
	private static Scanner scan = new Scanner(System.in);
	Main m = new Main();

	Pracownik Wydajacy;
	Collection<Pacjent> Pacjent;
	public int ID_Skierowania;
	public String Data_Skierowania;
	public String Nazwa;
	public String Typ;
	public String Piorytet;
	public String Specjalnosc;
	public String Pesel;
	public String Login;
	public String Sugerowany_Realizator;
	public int Kod;

	public Skierowanie(Pacjent p,Pracownik s, String Data_Skierowania, String Nazwa,String Typ, String Piorytet, String Specjalnosc, String Sugerowany_Realizator) {
		// TODO - implement Skierowanie.Skierowanie
		Random generator = new Random();
		this.ID_Skierowania = generator.nextInt(1000000);
		this.Kod= generator.nextInt(1000000);
		this.Data_Skierowania = Data_Skierowania;
		this.Nazwa=Nazwa;
		this.Typ=Typ;
		this.Piorytet=Piorytet;
		this.Specjalnosc=Specjalnosc;
		this.Sugerowany_Realizator=Sugerowany_Realizator;
		this.Pesel=p.getPesel();
		this.Login=s.getLogin();
	}

	public String getNazwa(){ return Nazwa; }
	public String getData_Skierowania() { return Data_Skierowania; }
	public int getKod() { return Kod; }
	public String getPesel() { return Pesel; }
	public String getTyp(){ return Typ; }
	public String getPiorytet() { return Piorytet; }
	public String getSpecjalnosc(){ return Specjalnosc; }
	public String getSugerowany_Realizator(){ return Sugerowany_Realizator; }
	public int getID_Skierowania(){ return ID_Skierowania; }
	public String getLogin() { return Login; }

	public static void dodajSkierowanie(){
		Pacjent tmp = new Pacjent();
		Pracownik tmp3 = new Pracownik();
		System.out.println("Wpisz pesel pacjenta: ");
		String pesel = scan.next();
		Main.walidacjaPesel(pesel);
		tmp = Main.znajdzPacjent(pesel);
		if(tmp==null){
			System.out.println("Nie ma pacjenta o takim peselu");
		}else {
			System.out.println("Wpisz swoj login: ");
			String login = scan.next();
			tmp3 = Main.znajdzPracownika(login);
			System.out.println("Pesel, ID i klucz pacjenta zostal wpisany");
			System.out.println("Data wystawienia: ");
			String Data_Skierowania = scan.next();
			System.out.println("Nazwa: ");
			String Nazwa = scan.next();
			System.out.println("Typ: ");
			String Typ = scan.next();
			System.out.println("Piorytet: ");
			String Piorytet = scan.next();
			System.out.println("Specjalnosc: ");
			String Specjalnosc = scan.next();
			System.out.println("Sugerowany realizator: ");
			String Sugerowany_Realizator = scan.next();
			Skierowanie tmp2 = new Skierowanie(tmp, tmp3, Data_Skierowania, Nazwa, Typ, Piorytet, Specjalnosc, Sugerowany_Realizator);
			Drukuj_Skierowanie(tmp2);
		}
	}

	public static void Drukuj_Skierowanie(Skierowanie sk) {
		// TODO - implement Skierowanie.Drukuj_Skierowanie
		Pacjent pacjent = new Pacjent();
		pacjent = Main.znajdzPacjent(sk.getPesel());
		Pracownik pracownik=new Pracownik();
		pracownik=Main.znajdzPracownika(sk.getLogin());
		System.out.println("Skierowanie");
		System.out.println("Imie: " + pacjent.getImie());
		System.out.println("Nazwisko: " + pacjent.getNazwisko());
		System.out.println("Kod skierowania: " + sk.getKod());
		System.out.println("Wystawca: Lek."+pracownik.getImie()+ " "+  pracownik.getNazwisko());
		System.out.println("Lekarz w Melcormed "+ pracownik.getStanowisko());
		System.out.println("ID skierowania: "+ sk.getID_Skierowania());
		System.out.println("Data wystawienia: " + sk.getData_Skierowania());
		System.out.println("Nazwa: " + sk.getNazwa());
		System.out.println("Typ: " + sk.getTyp());
		System.out.println("Piorytet: " + sk.getPiorytet());
		System.out.println("Specjalnosc: " + sk.getSpecjalnosc());
		System.out.println("Sugerowany realizator: "+ sk.getSugerowany_Realizator());
	}

}