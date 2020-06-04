package Diagram_Klas;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    //public static HashMap<String, Pracownik> Baza = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Dodaj osobe");
            System.out.println("(2) Przyklad2");
            System.out.println("(3) Przyklad3");
            System.out.println("(4) Przyklad4");
            System.out.println("(5) Przyklad5");
            System.out.println("(6) Koniec");
            System.out.println("Test");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1:
                    System.out.println("Kogo chcesz dodac?");
                    System.out.println("(1) Pacjenta");
                    System.out.println("(2) Pracownika");
                    int w2 = scan.nextInt();
                    switch (w2){
                        case 1:
                            System.out.println("Opcja Pacjent");
                            break;
                        case 2:
                            System.out.println("Opcja Pracownik");
                            break;
                    }
                    System.out.println("Wybrales opcje nr 1");
                    break;
                case 2:
                    System.out.println("Wybrales opcje nr 2");
                    break;
                case 3:
                    System.out.println("Wybrales opcje nr 3");
                    break;
                case 4:
                    System.out.println("Wybrales opcje nr 4");
                    break;
                case 5:
                    System.out.println("Wybrales opcje nr 5");
                    break;
                case 6: {
                    System.out.println("Koniec pracy systemu");
                    return;
                }
            }
        }
    }
    public void dodaj_Pacjenta(){
        System.out.println("Podaj ID: ");
        int ID = scan.nextInt();
        System.out.println("Podaj imie:  ");
        String imie = scan.next();
        System.out.println("Podaj nazwisko:  ");
        String nazwisko = scan.next();
        System.out.println("Wpisz PESEL: ");
        String Pesel = scan.next();
        System.out.print("\n");
        if (Pesel.length() != 11) //sprawdzamy długość peselu
        {
            throw new NumberFormatException("Wrong PESEL length");
        }
        try { //sprawdza czy pesel ma poprawny formay czyli mesiące lata miesiące dni
            int wart = Integer.parseInt(Pesel.substring(2, 4));
            wart %= 20;
            if (wart > 12) throw new NumberFormatException("Zly pesel");
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Zly pesel");
        }
        System.out.println("Wpisz numer telefonu: ");
        String n_telefonu = scan.next();
        System.out.println("Wpisz date urodzenia: ");
        String data_urodzenia = scan.next();
        System.out.println("Wpisz ID pacjenta");
        int ID_p = scan.nextInt();
        String obraz = "5";
        Pacjent pacjent = new Pacjent(ID,imie,nazwisko,Pesel,obraz,n_telefonu,data_urodzenia,ID_p);
        //trzeba dodać do bazy
    }
    public void dodaj_Pracownika(){
        System.out.println("Podaj ID: ");
        int ID = scan.nextInt();
        System.out.println("Podaj imie:  ");
        String imie = scan.next();
        System.out.println("Podaj nazwisko:  ");
        String nazwisko = scan.next();
        System.out.println("Wpisz PESEL: ");
        String Pesel = scan.next();
        System.out.print("\n");
        if (Pesel.length() != 11) //sprawdzamy długość peselu
        {
            throw new NumberFormatException("Wrong PESEL length");
        }
        try { //sprawdza czy pesel ma poprawny formay czyli mesiące lata miesiące dni
            int wart = Integer.parseInt(Pesel.substring(2, 4));
            wart %= 20;
            if (wart > 12) throw new NumberFormatException("Zly pesel");
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Zly pesel");
        }
        System.out.println("Wpisz numer telefonu: ");
        String n_telefonu = scan.next();
        System.out.println("Wpisz date urodzenia: ");
        String data_urodzenia = scan.next();
        System.out.println("Wpisz ID pracownika");
        int ID_p = scan.nextInt();
        System.out.println("Wpisz stanowisko: ");
        String stanowisko = scan.next();
        String obraz = "5";
        Pracownik pracownik = new Pracownik(ID,imie,nazwisko,Pesel,obraz,n_telefonu,data_urodzenia,ID_p,stanowisko);
        //trzeba dodać do bazy
    }

    public void wypiszPracownika(Osoba o) {
        System.out.println("Imie: " + o.getImie());
        System.out.println("Nazwisko: " + o.getNazwisko());
        System.out.println("Pesel: " + o.getPesel());
        System.out.println("Numer telefonu: " + o.getNumer_Telefonu());
        System.out.println("Data Urodzenia: " + o.getData_Urodzenia());
        Pracownik p = (Pracownik) o;
        System.out.println("ID Pracownika: " + p.getID_Pracownik());
        System.out.println("Stanowisko: " + p.getStanowisko());
        System.out.println("===========================");
    }
    public void wypiszPacjenta(Osoba o) {
        System.out.println("Imie: " + o.getImie());
        System.out.println("Nazwisko: " + o.getNazwisko());
        System.out.println("Pesel: " + o.getPesel());
        System.out.println("Numer telefonu: " + o.getNumer_Telefonu());
        System.out.println("Data Urodzenia: " + o.getData_Urodzenia());
        Pacjent p = (Pacjent) o;
        System.out.println("ID Pacjenta: " + p.getID_Pacjenta());
        System.out.println("===========================");
    }

}

