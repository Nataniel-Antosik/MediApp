package Diagram_Klas;


import java.util.HashMap;
import java.util.Scanner;

import static Diagram_Klas.Osoba.dodajOsoba;

public class Rejestracja_Pacjenta {

	public Rejestracja_Pacjenta() {

	}

	public static void usun_Pacjenta(HashMap<String, Pacjent> Baza,String pesel) {
		Baza.remove(pesel);
	}

	public static void dodaj_Pacjenta(HashMap<String, Pacjent> Baza) {
		Scanner stringinput = new Scanner(System.in);
		Pacjent nowy = new Pacjent();
		System.out.println("Podaj imie pacjenta:");
		while(true){
			String name = stringinput.nextLine();
			if(name.isBlank()){
				continue;
			}
			nowy.setImie(name);
			break;
		}
		System.out.println("Podaj nazwisko pacjenta:");
		while(true){
			String surname = stringinput.nextLine();
			if(surname.isBlank()){
				continue;
			}
			nowy.setNazwisko(surname);
			break;
		}
		System.out.println("Podaj PESEL pacjenta:");
		while(true){
			String id = stringinput.nextLine();
			if(id.isBlank()){
				continue;
			}
			try {
				nowy.setPesel(id);
			}catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			break;
		}
		System.out.println("Podaj date urodzenia pacjenta:");
		while(true){
			String birth = stringinput.nextLine();
			if(birth.isBlank()){
				continue;
			}
			nowy.setData_Urodzenia(birth);
			break;
		}
		System.out.println("Podaj adres zamieszkania pacjenta:");
		while(true){
			String adress = stringinput.nextLine();
			if(adress.isBlank()){
				continue;
			}
			nowy.setadresZamieszkania(adress);
			break;
		}

		System.out.println("Podaj numer telefonu pacjenta:");
		while(true){
			String phoneNumber = stringinput.nextLine();
			if(phoneNumber.isBlank()){
				continue;
			}
			nowy.setNumer_Telefonu(phoneNumber);
			break;
		}
		System.out.println("Podaj adres e-mail pacjenta:");
		while(true){
			String email = stringinput.nextLine();
			if(email.isBlank()){
				continue;
			}
			nowy.setMail(email);
			break;
		}
		System.out.println("Zatwierdz(1)/Anuluj(0)");

		while(true){
			String choice;
			choice =stringinput.nextLine();
			if(choice.equals("1")){
				dodajOsoba(Baza,nowy);
				break;
			}else if(choice.equals("0")){
				break;
			}
			else{
				continue;
			}
		}
	}
}