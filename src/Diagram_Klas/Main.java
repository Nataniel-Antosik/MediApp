package Diagram_Klas;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    public static HashMap<String, Pacjent> Baza = new HashMap<>();
    public static HashMap<String, Pracownik> Baza_Pracownikow = new HashMap<>(); //rozwiązanie dla pracowników

    public static void wypiszOsoba(Osoba o) {
        System.out.println("Imie: " + o.getImie());
        System.out.println("Nazwisko: " + o.getNazwisko());
        System.out.println("Pesel: " + o.getPesel());
        System.out.println("Numer telefonu: " + o.getNumer_Telefonu());
        System.out.println("Data Urodzenia: " + o.getData_Urodzenia());
        System.out.println("Mail: " + o.getMail());
        if(o instanceof Pracownik) {
            Pracownik p = (Pracownik) o;
            System.out.println("Stanowisko: " + p.getStanowisko());
            System.out.println("===========================");
        }
        else if (o instanceof Pacjent){
            Pacjent p = (Pacjent) o;
            System.out.println("===========================");
        }
    }
    public static Pracownik znajdzPracownika(String login){
        AtomicReference<Pracownik> tmp = new AtomicReference<>(new Pracownik());
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getLogin().equals(login)) {
                        tmp.set(v);
                    } else {
                        tmp.set(null);
                    }
                }
        );
        return tmp.get();
    }

    public static Pacjent znajdzPacjent(String pesel){
        AtomicReference<Pacjent> tmp = new AtomicReference<>(new Pacjent());
        Baza.forEach((k, v) ->
                {
                    if (v.getPesel().equals(pesel)) {
                        tmp.set(v);
                    }
                }
        );
        return tmp.get();
    }
    public static void menuLekarz() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Wypisz recepte");
            System.out.println("(2) Wypisz skierowanie");
            System.out.println("(3) Wyswietl historie badan");
            System.out.println("(4) Wyswietl historie chorob pacjenta");
            System.out.println("(5) Wpis w historie chorob");
            System.out.println("(6) Wyloguj");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6: {

                    return;
                }
            }
        }
    }

    public static void menuDyrektor() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Dodaj pracownika");
            System.out.println("(2) Usun pracownika");
            System.out.println("(3) Profil pracownika");
            System.out.println("(4) Wyloguj");

            int wybor = scan.nextInt();
            switch (wybor) {
                case 1: {
                    Rejestracja_pracownikow.dodaj_Pracownika();
                    break;
                }
                case 2: {
                    System.out.println("Wpisz login: ");
                    String login = scan.next();
                    Rejestracja_pracownikow.usun_Pracownika(Baza_Pracownikow, login);
                    break;
                }
                case 3: {
                        Rejestracja_pracownikow.modyfikuje_Dane_Pracownika();
                    break;
                    }
                case 4:
                    System.out.println("Zostales wylogowany");
                    weryfikacja();
            }
        }
    }

    public static void menuRecepcjonista() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Rejestracja pacjenta");
            System.out.println("(2) Umow wizyte");
            System.out.println("(3) Umowienie wizyty");
            System.out.println("(4) Profil pracownika");
            System.out.println("(5) Profil pacjenta");
            System.out.println("(6) Wyloguj");
            int wybor = scan.nextInt();

            switch (wybor) {
                case 1:
                    Rejestracja_Pacjenta.dodaj_Pacjenta(Baza);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Podaj PESEL pacjenta, którego chcesz wyszukać:");
                    Scanner stringinput = new Scanner(System.in);
                    String pesel;
                    while(true){
                        pesel = stringinput.nextLine();
                        if(pesel.isBlank()){
                            continue;
                        }
                        try {
                            walidacjaPesel(pesel);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;

                    }
                    Pacjent temp = znajdzPacjent(pesel);
                    if(temp == null){
                        System.out.println("Dany pacjent nie znajduje sie w bazie danych");
                    }
                    else{
                        while(true) {
                            wypiszOsoba(temp);
                        }
                    }
                    break;
                case 6: {
                    weryfikacja();

                }
            }
        }
    }
    public static void walidacjaPesel(String pesel){
        if(pesel.length() != 11){
            throw new NumberFormatException("Zly format peselu");
        }
        try{
            int msc = Integer.parseInt(pesel.substring(2,4));
            msc %= 20;
            if(msc > 12) throw new NumberFormatException("Zly format peselu");
            int day = Integer.parseInt(pesel.substring(4,6));
            if (day > 31) throw new NumberFormatException("Zly format peselu");
        }
        catch (NumberFormatException nfe){
            throw new NumberFormatException("Zly format peselu");
        }
    }
    public static boolean znajdzLogin(String login) {
        //Notka: login dyrektora zaczyna się od litery "D" lekarza od "L" pacjenta od "P"
        boolean[] flag = {false};
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getLogin().equals(login)) {
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

    public static void odpowiednieMenu(String login) {
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getLogin().equals(login)) {
                        if (v.getStanowisko().equals("Dyrektor")) {
                            menuDyrektor();
                        }
                        else if (v.getStanowisko().equals("Lekarz")) {
                            menuLekarz();
                        }
                        else if (v.getStanowisko().equals("Recepcjonista")){
                            menuRecepcjonista();
                        }
                    }
                }
        );
    }

    public static void weryfikacja(){
        final boolean[] l = {false};
        final boolean[] h = {false};
        while (true) {
            System.out.println("Podaj login: ");
            String login = scan.next();
            System.out.println("Podaj haslo: ");
            String haslo = scan.next();
            l[0] = znajdzLogin(login);
            h[0] = znajdzHaslo(haslo);
            if (l[0] && h[0] == true) {
                System.out.println("Zostales zalogowany");
                odpowiednieMenu(login);
            } else {
                System.out.println("Login lub haslo jest bledne, wpisz ponownie");
            }
        }
    }
    public static void main(String[] args) {
        //Dodanie testowych osób do systemu Dyrektora Dermatologa i Pacjenta
        Pracownik test = new Pracownik();
        Pacjent test2 = new Pacjent();
        Pracownik d = new Pracownik("D168", "123456", "Stefan", "Kowalski", "99062506018", "999-000-000", "25.06.99", "Dyrektor", "stef@gmail.com" );
        test.dodajPracownika(Baza_Pracownikow, d);
        d = new Pracownik("L168", "654321", "Michal", "Nowak", "97011306112", "111-421-000", "13.01.97", "Lekarz", "Nowakowski@gmail.com");
        test.dodajPracownika(Baza_Pracownikow, d);
        d = new Pracownik("R168", "654321", "Karol", "Szczur", "88011706112", "563-421-135", "17.01.88",  "Recepcjonista", "Szurek@gmail.com");
        test.dodajPracownika(Baza_Pracownikow, d);
        Pacjent p = new Pacjent("Marian","Kowalski","95041201020","931-321-324","12.04.95", "Marian@gmail.com");
        test2.dodajOsoba(Baza,p);

        //test wypisu wszystkich osób (Pracownikow
        /*
        Baza_Pracownikow.forEach((k, v) ->
                wypiszOsoba(v)
        );
        //wypisanie pacjentów
        Baza.forEach((k, v) ->
                wypiszOsoba(v)
        );

        //test funkcji weryfikacji
        weryfikacja();
*/
        weryfikacja();
        //menuRecepcjonista();
    }
}

