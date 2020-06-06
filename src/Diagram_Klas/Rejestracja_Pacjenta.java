package Diagram_Klas;


import java.util.HashMap;
import java.util.Scanner;

public class Rejestracja_Pacjenta {

	/**
	 * 
	 * @param pacjent
	 * @param ID_Pracownik
	 */
	public Rejestracja_Pacjenta(Diagram_Klas.Pacjent pacjent, Diagram_Klas.Pracownik ID_Pracownik) {

	}

	/**
	 * 
	 * @param pacjent
	 * @param ID_Pracownik
	 */
	public void Usuwanie_Pacjenta(Diagram_Klas.Pacjent pacjent, Diagram_Klas.Pracownik ID_Pracownik) {
	}

	public static void dodaj_Pacjenta(HashMap<String, Osoba> Baza) {
		Scanner stringinput = new Scanner(System.in);
		Pacjent nowy = new Pacjent();
		System.out.println("Podaj imie pacjenta:");
		while(true){
			String name = stringinput.nextLine();
			if(name.isEmpty()){
				continue;
			}
			nowy.setImie(name);
			break;
		}
		System.out.println("Podaj nazwisko pacjenta:");
		while(true){
			String surname = stringinput.nextLine();
			if(surname.isEmpty()){
				continue;
			}
			nowy.setNazwisko(surname);
			break;
		}
		System.out.println("Podaj PESEL pacjenta:");
		while(true){
			String id = stringinput.nextLine();
			if(id.isEmpty()){
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
			if(birth.isEmpty()){
				continue;
			}
			nowy.setImie(birth);
			break;
		}
		System.out.println("Podaj adres zamieszkania pacjenta:");
		while(true){
			String adress = stringinput.nextLine();
			if(adress.isEmpty()){
				continue;
			}
			nowy.setImie(adress);
			break;
		}
		System.out.println("Podaj kod pocztowy pacjenta:");
		while(true){
			String postCode = stringinput.nextLine();
			if(postCode.isEmpty()){
				continue;
			}
			nowy.setImie(postCode);
			break;
		}
		System.out.println("Podaj numer telefonu pacjenta:");
		while(true){
			String phoneNumber = stringinput.nextLine();
			if(phoneNumber.isEmpty()){
				continue;
			}
			nowy.setImie(phoneNumber);
			break;
		}
		System.out.println("Podaj adres e-mail pacjenta:");
		while(true){
			String email = stringinput.nextLine();
			if(email.isEmpty()){
				continue;
			}
			nowy.setImie(email);
			break;
		}
		System.out.println("Zatwierdz(1)/Anuluj(0)");

		while(true){
			String choice;
			choice =stringinput.nextLine();
			if(choice.equals("1")){
				nowy.dodajOsoba(Baza,nowy);
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