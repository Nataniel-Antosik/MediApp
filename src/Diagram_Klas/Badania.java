package Diagram_Klas;

import javax.xml.crypto.Data;
import java.util.Random;
import java.util.Scanner;

public class Badania {
	private static Scanner scan = new Scanner(System.in);

	Pracownik Wykonujacy;
	Wyniki Wynik;
	public int ID_Badania;
	public String Badanie;
	public String Opis;
	public String Data_Badania;
	public String imie;
	public String nazwisko;

	/**
	 *
	 * @param Badanie
	 * @param Opis
	 * @param Data_Badania
	 */
	public Badania(Pacjent p, String Badanie, String Opis, String Data_Badania) {
		// TODO - implement Badania.Badania
		Random generator = new Random();
		this.imie = p.getImie();
		this.nazwisko = p.getNazwisko();
		this.Badanie = Badanie;
		this.ID_Badania = generator.nextInt(1000000);
		this.Opis = Opis;
		this.Data_Badania = Data_Badania;
	}

	public void setBadanie(String in) { Badanie = in; }
	public void setOpis(String in) { Opis = in; }
	public void setData_Badania(String in) { Data_Badania = in; }

	public String getBadanie() { return Badanie; }
	public int getID_Badania() { return ID_Badania; }
	public String getOpis() { return Opis; }
	public String getData_Badania() { return Data_Badania; }
	public String getImie() { return imie; }
	public String getNazwisko() { return nazwisko; }

	public static void dodaj_Badanie(String pesel){
		Pacjent tmp1 = new Pacjent();
		tmp1 = Main.znajdzPacjent(pesel);
		if (tmp1 == null){
			System.out.println("Nie ma takiego pacjenta w bazie");
		} else {
			System.out.println("Podaj nazwe badania: ");
			String badanie = scan.next();
			System.out.println("Podaj opis badania: ");
			String opis = scan.next();
			System.out.println("Podaj date badania: ");
			String data_Badania = scan.next();
			Badania tmp2 = new Badania(tmp1, badanie, opis, data_Badania);
		}
	}

	public static void wypisz_Badanie(Badania b){
		System.out.println("Imie: " + b.getImie());
		System.out.println("Nazwisko: " + b.getNazwisko());
		System.out.println("Nazwa badania: " + b.getBadanie());
		System.out.println("ID badania: " + b.getID_Badania());
		System.out.println("Opis badania: " + b.getOpis());
		System.out.println("Data badania: " + b.getData_Badania());
	}
}