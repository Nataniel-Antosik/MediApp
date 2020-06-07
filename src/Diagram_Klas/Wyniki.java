package Diagram_Klas;

import java.util.Random;
import java.util.Scanner;

public class Wyniki {
	private static Scanner scan = new Scanner(System.in);
	Badania Badanie;
	Historia_Chorob_Pacjenta Historia;
	public int ID_Wyniki;
	public String Opis;
	public String Data_Wynikow;
	public String imie;
	public String nazwisko;
	public int ID_Badania;
	/**
	 *
	 * @param ID_Wyniki
	 * @param Opis
	 */
	public Wyniki(Pacjent p, Badania b, int ID_Wyniki, String Opis, String Data_Wynikow) {
		// TODO - implement Wyniki.Wyniki
		Random generator = new Random();
		this.ID_Wyniki = generator.nextInt(1000000);
		this.Opis = Opis;
		this.Data_Wynikow=Data_Wynikow;
		this.imie = p.getImie();
		this.nazwisko = p.getNazwisko();
		this.ID_Badania = b.getID_Badania();
	}

	//public void setBadanie(Badania badanie) { Badanie = badanie; }
	public void setOpis(String opis) { Opis = opis; }
	public void setData_Wynikow(String in) { Data_Wynikow = in; }

	//public Badania getBadanie() { return Badanie; }
	public int getID_Wyniki() { return ID_Wyniki; }
	public String getOpis() { return Opis; }
	public String getData_Wynikow() { return Data_Wynikow; }
	public String getImie() { return imie; }
	public String getNazwisko() { return nazwisko; }
	public int getID_Badania() { return ID_Badania; }

	public static void Sprawdz_Wynikow() {
		// TODO - implement Wyniki.Sprawdz_Wynikow
		Pacjent tmp = new Pacjent();
		System.out.println("Wpisz pesel pacjenta: ");
		String pesel = scan.next();
		Main.walidacjaPesel(pesel);
		tmp = Main.znajdzPacjent(pesel);
		if(tmp==null){
			System.out.println("Nie ma pacjenta o takim peselu");
		}else {
			System.out.println("Pobieranie wynikow z bazy...");
			System.out.println("Pobrano");
		}
	}

}