package Diagram_Klas;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static HashMap<String, Pracownik> Baza = new HashMap<>();
    public static HashMap<String, Pacjent> Baza2 = new HashMap<>();

    public void dodaj_Pacjenta() {
        System.out.println("Podaj ID: ");
        int ID = scan.nextInt();
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
        System.out.println("Wpisz ID pacjenta");
        int ID_p = scan.nextInt();
        String obraz = "5";
        Pacjent pacjent = new Pacjent(ID, imie, nazwisko, pesel, obraz, n_telefonu, data_urodzenia, ID_p);
        pacjent.dodajPacjenta(Baza2, pacjent);
        //trzeba dodać do bazy
    }

    public void dodaj_Pracownika() {
        System.out.println("Podaj ID: ");
        int ID = scan.nextInt();
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
        String obraz = "5";
        System.out.println("Wpisz numer telefonu: ");
        String n_telefonu = scan.next();
        System.out.println("Wpisz date urodzenia: ");
        String data_urodzenia = scan.next();
        System.out.println("Wpisz ID pracownika");
        int ID_p = scan.nextInt();
        System.out.println("Wpisz stanowisko: ");
        String stanowisko = scan.next();
        System.out.println("Wpisz login: ");
        String login = scan.next();
        System.out.println("Wpisz haslo: ");
        String haslo = scan.next();
        Pracownik pracownik = new Pracownik(ID, imie, nazwisko, pesel, obraz, n_telefonu, data_urodzenia, ID_p, stanowisko, login, haslo);
        pracownik.dodajPracownika(Baza, pracownik);
        //trzeba dodać do bazy
    }

    public static void wypiszPracownika(Osoba o) {
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

    public static void menuLekarz() {
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
                    switch (w2) {
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

    public static void menuDyrektor() {

    }

    public static void menuPacjent() {

    }

    public static boolean znajdz(String klucz) {
        final boolean[] flag = {false};
        Baza.forEach((k, v) ->
                {
                    if (k.equals(klucz)) {
                        flag[0] = true;
                        System.out.println("Haslo jest dyrektora");
                    }
                }
        );
        return flag[0]; //zwróć zmienną
    }
    public static void znajdzLogin(String login) {
        //Notka: login dyrektora zaczyna się od litery "D" lekarza od "L" pacjenta od "P"
        final boolean[] brak = {false};
        Baza.forEach((k, v) ->
                {
                    if (v.getLogin() == login) {
                        if (v.getLogin().startsWith("D")){
                            System.out.println("Haslo jest dyrektora");
                            brak[0] = true;
                        }
                        else if (v.getLogin().startsWith("L")){
                            System.out.println("Haslo jest lekarza");
                            brak[0] = true;
                        }
                        else if (v.getLogin().startsWith("P")){
                            System.out.println("Haslo jest pacjenta");
                            brak[0] = true;
                        }
                    }
                }
        );
        if (brak[0] == false){
            System.out.println("Loginu nie ma w systemie!");
        }
    }

    public static void main(String[] args) {
        //Dodanie dyrektora
        Pracownik test = new Pracownik();
        Pracownik d = new Pracownik(68, "Stefan", "Kowalski", "99062506018", "jpg", "999-000-000", "25.06.99", 1, "Dyrektor", "D168", "123456");
        test.dodajPracownika(Baza, d);
        d = new Pracownik(69, "Michal", "Kowalski", "97011306112", "jpg", "111-421-000", "13.01.97", 2, "Dermatolog", "L168", "654321");
        test.dodajPracownika(Baza, d);

        //test wypisu pracowników
        Baza.forEach((k, v) ->
                wypiszPracownika(v)
        );
        //test szukania do hasła aktualnie działa pesel
        //znajdz("Dyrektor");
        znajdzLogin("D168");

        znajdzLogin("L168");

        znajdzLogin("P678678");

        //znajdz("99062506018");
        //Wpisywanie loginu i hasla
        /*
        while (true) {
            System.out.println("Podaj login: ");
            String login = scan.next();
            if (!)
            System.out.println("Podaj haslo: ");
            String haslo = scan.next();
            break;
        }*/

    }
}

