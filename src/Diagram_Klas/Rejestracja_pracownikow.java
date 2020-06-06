package Diagram_Klas;

import java.util.Scanner;

public class Rejestracja_pracownikow {
	private static Scanner scan = new Scanner(System.in);

	public static void dodaj_Pracownika() {
		System.out.println("Wpisz login: ");
		String login = scan.next();
		System.out.println("Wpisz haslo: ");
		String haslo = scan.next();
		System.out.println("Podaj imie:  ");
		String imie = scan.next();
		System.out.println("Podaj nazwisko:  ");
		String nazwisko = scan.next();
		System.out.println("Wpisz PESEL: ");
		String pesel = scan.next();
		System.out.print("\n");
		if (pesel.length() != 11) //sprawdzamy długość peselu
		{
			throw new NumberFormatException("Wrong PESEL length");
		}
		try { //sprawdza czy pesel ma poprawny formay czyli mesiące lata miesiące dni
			int wart = Integer.parseInt(pesel.substring(2, 4));
			wart %= 20;
			if (wart > 12) throw new NumberFormatException("Zly pesel");
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Zly pesel");
		}
		System.out.println("Wpisz numer telefonu: ");
		String n_telefonu = scan.next();
		System.out.println("Wpisz date urodzenia: ");
		String data_urodzenia = scan.next();
		System.out.println("Wpisz stanowisko: ");
		String stanowisko = scan.next();
		System.out.println("Wpisz maila: ");
		String mail = scan.next();
		System.out.println("1) Zatwierdz");
		System.out.println("2) Anuluj");
		int wybor = scan.nextInt();

		switch (wybor) {
			case 1:
				Pracownik pracownik = new Pracownik(login, haslo, imie, nazwisko, pesel, n_telefonu, data_urodzenia, stanowisko, mail);
				pracownik.dodajPracownika(Main.Baza_Pracownikow, pracownik);
				break;
			case 2:
				System.out.println("Anulowano");
				break;
		}
	}

	public static boolean usun_Pracownika(String login) {
		if (Main.znajdzPracownika(login).equals(true)){
			Main.Baza_Pracownikow.remove(login);
			return true;
		} else {
			return false;
		}
	}

	public static void modyfikuje_Dane_Pracownika() {
		Pracownik tmp = new Pracownik();
		System.out.println("Wpisz login");
		String login = scan.next();
		tmp = Main.znajdzPracownika(login);
		Main.wypiszOsoba(tmp);
		System.out.println("Edycja pracownika");
		boolean s=true;
		while(s) {
			System.out.println("1) Zmiana nazwiska");
			System.out.println("2) Zmiana nr_telefonu");
			System.out.println("3) Zmiana stanowiska");
			System.out.println("4) Zmiana maila");
			System.out.println("5) Wyjdz");
			int wybor2 = scan.nextInt();
			switch (wybor2) {
				case 1:
					String nazwisko = scan.next();
					tmp.setNazwisko(nazwisko);
					break;
				case 2:
					String nr_telefonu = scan.next();
					tmp.setNumer_Telefonu(nr_telefonu);
					break;
				case 3:
					String stanowisko = scan.next();
					tmp.setStanowisko(stanowisko);
					break;
				case 4:
					String mail = scan.next();
					tmp.setMail(mail);
					break;
				case 5:
					s=false;
			}
		}
	}
}