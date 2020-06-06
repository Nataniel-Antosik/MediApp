package Diagram_Klas;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static HashMap<String, Osoba> Baza = new HashMap<>();
    public static HashMap<String, Pracownik> Baza_Pracownikow = new HashMap<>(); //rozwiązanie dla pracowników

    public void dodaj_Pacjenta() {
        System.out.println("Wpisz login: ");
        String login = scan.next();
        System.out.println("Wpisz haslo: ");
        String haslo = scan.next();
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
        Pacjent pacjent = new Pacjent(ID, imie, nazwisko, pesel, n_telefonu, data_urodzenia, ID_p);
        pacjent.dodajOsoba(Baza, pacjent);
        //trzeba dodać do bazy
    }
    public void dodaj_Pracownika() {
        System.out.println("Wpisz login: ");
        String login = scan.next();
        System.out.println("Wpisz haslo: ");
        String haslo = scan.next();
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
        System.out.println("Wpisz ID pracownika");
        int ID_p = scan.nextInt();
        System.out.println("Wpisz stanowisko: ");
        String stanowisko = scan.next();
        Pracownik pracownik = new Pracownik(login, haslo, ID, imie, nazwisko, pesel, n_telefonu, data_urodzenia, ID_p, stanowisko);
        pracownik.dodajPracownika(Baza_Pracownikow, pracownik);
    }

    public static void wypiszOsoba(Osoba o) {
        System.out.println("Imie: " + o.getImie());
        System.out.println("Nazwisko: " + o.getNazwisko());
        System.out.println("Pesel: " + o.getPesel());
        System.out.println("Numer telefonu: " + o.getNumer_Telefonu());
        System.out.println("Data Urodzenia: " + o.getData_Urodzenia());
        if(o instanceof Pracownik) {
            Pracownik p = (Pracownik) o;
            System.out.println("ID Pracownika: " + p.getID_Pracownik());
            System.out.println("Stanowisko: " + p.getStanowisko());
            System.out.println("===========================");
        }
        else if (o instanceof Pacjent){
            Pacjent p = (Pacjent) o;
            System.out.println("ID Pacjenta: " + p.getID_Pacjenta());
            System.out.println("===========================");
        }
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
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Przyklad1");
            System.out.println("(2) Przyklad2");
            System.out.println("(3) Przyklad3");
            System.out.println("(4) Przyklad4");
            System.out.println("(5) Przyklad5");
            System.out.println("(6) Koniec");
            System.out.println("Test");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1:
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

    public static void menuRecepcjonista() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Przyklad1");
            System.out.println("(2) Przyklad2");
            System.out.println("(3) Przyklad3");
            System.out.println("(4) Przyklad4");
            System.out.println("(5) Przyklad5");
            System.out.println("(6) Koniec");
            System.out.println("Test");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1:
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

    public static boolean znajdzLogin(String login) {
        //Notka: login dyrektora zaczyna się od litery "D" lekarza od "L" pacjenta od "P"
        boolean[] flag = {false};
        Baza_Pracownikow.forEach((k, v) ->
                {
                    Pracownik p = (Pracownik) v;
                    if (p.getLogin().equals(login)) {
                        flag[0] = true;
                    }
                }
        );
        return flag[0];
    }
    public static boolean znajdzHaslo(String haslo) {
        boolean[] flag = {false};
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getHaslo().equals(haslo)) {
                        flag[0] = true;
                    }
                }
        );
        return flag[0];
    }
    public static String stanowiskoLogin(String login){
        AtomicReference<String> wynik = null;
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getLogin().equals(login)) {
                        wynik.set(v.getStanowisko());
                    }
                }
        );
        return wynik.get();
    }

    public static void odpowiednieMenu(String login) {
        AtomicReference<String> stanowisko = new AtomicReference<>("");
        Baza_Pracownikow.forEach((k, v) ->
                {
                    stanowisko.set(stanowiskoLogin(login));
                    if (stanowisko.equals("Dyrektor")){
                        menuDyrektor();
                    }
                    else if (stanowisko.equals("Lekarz")){
                        menuLekarz();
                    }
                    else if (stanowisko.equals("Recepcjonista")){
                        menuRecepcjonista();
                    }
                }
        );

    }

    public static void weryfikacja(){
        final boolean[] l = {false};
        final boolean[] h = {false};
        System.out.println("Podaj login: ");
        String login = scan.next();
        System.out.println("Podaj haslo: ");
        String haslo = scan.next();
        l[0] = znajdzLogin(login);
        h[0] = znajdzHaslo(haslo);
        if (l[0] && h[0] == true){
            System.out.println("Zostales zalogowany");
            odpowiednieMenu(login);
        }
        else{
            System.out.println("Login lub haslo jest bledne, wpisz ponownie");
        }
    }
    public static void main(String[] args) {
        //Dodanie testowych osób do systemu Dyrektora Dermatologa i Pacjenta
        Pracownik test = new Pracownik();
        Pacjent test2 = new Pacjent();
        Pracownik d = new Pracownik("D168", "123456",68, "Stefan", "Kowalski", "99062506018", "999-000-000", "25.06.99", 1, "Dyrektor" );
        test.dodajPracownika(Baza_Pracownikow, d);
        d = new Pracownik("L168", "654321",69, "Michal", "Kowalski", "97011306112", "111-421-000", "13.01.97", 2, "Dermatolog");
        test.dodajPracownika(Baza_Pracownikow, d);
        Pacjent p = new Pacjent(62,"Marian","Kowalski","95041201020","931-321-324","12.04.95",13);
        test2.dodajOsoba(Baza,p);

        //test wypisu wszystkich osób (Pracownikow
        Baza_Pracownikow.forEach((k, v) ->
                wypiszOsoba(v)
        );
        //wypisanie pacjentów
        Baza.forEach((k, v) ->
                wypiszOsoba(v)
        );
        //test szukania do hasła aktualnie działa pesel
        //znajdzLogin("D168");
        //znajdzLogin("L168");
        //znajdzLogin("P678678");
        //test funkcji weryfikacji
        weryfikacja();

    }
}

