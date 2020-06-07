package Diagram_Klas;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import static Diagram_Klas.Historia_Chorob_Pacjenta.Sprawdzanie_Historie_Chorob;
import static Diagram_Klas.Historia_Chorob_Pacjenta.wpisHistoriaChorob;
import static Diagram_Klas.Osoba.dodajOsoba;

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
        System.out.println("Adres zamieszkania: "+ o.getadresZamieszkania());
        System.out.println("Kod pocztowy" + o.getKodPocztowy());
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
        tmp.set(null);
        Baza_Pracownikow.forEach((k, v) ->
                {
                    if (v.getLogin().equals(login)) {
                        tmp.set(v);
                    }
                }
        );
        return tmp.get();
    }
    public static Pacjent znajdzPacjent(String pesel){
        AtomicReference<Pacjent> tmp = new AtomicReference<>(new Pacjent());
        tmp.set(null);
        Baza.forEach((k, v) ->
                {
                    if (v.getPesel().equals(pesel) ) {
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
                case 1: {
                    Recepta_Elektorniczna.dodaj_Recepte();
                }
                    break;
                case 2: {
                    Skierowanie.dodajSkierowanie();
                }
                    break;
                case 3: {
                    Wyniki.Sprawdz_Wynikow();
                }
                    break;
                case 4: {
                    System.out.println("Podaj PESEL pacjenta, którego historię chorób chcesz wyświetlić:");
                    String pesel;
                    while(true){
                        pesel = scan.nextLine();
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
                    Pacjent pacjent = znajdzPacjent(pesel);
                    if(pacjent == null){
                        System.out.println("Dany pacjent nie znajduje sie w bazie danych");
                    }
                    else{
                        Sprawdzanie_Historie_Chorob(pacjent);
                    }
                }
                    break;
                case 5: {
                    System.out.println("Podaj PESEL pacjenta, u ktorego chcesz dokonac wpisu choroby");
                    String pesel;
                    while(true){
                        pesel = scan.nextLine();
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
                    Pacjent pacjent = znajdzPacjent(pesel);
                    if(pacjent == null){
                        System.out.println("Dany pacjent nie znajduje sie w bazie danych");
                    }
                    else{
                        wpisHistoriaChorob(pacjent);
                    }
                }
                    break;
                case 6: {
                    System.out.println("Zostales wylogowany");
                    weryfikacja();
                }
            }
        }
    }

    public static void menuDyrektor() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("(1) Dodaj pracownika");
            System.out.println("(2) Profil pracownika");
            System.out.println("(3) Wyloguj");

            int wybor = scan.nextInt();
            switch (wybor) {
                case 1: {
                    Rejestracja_pracownikow.dodaj_Pracownika();
                    break;
                }
                case 2: {
                    Rejestracja_pracownikow.modyfikuje_Dane_Pracownika();
                    break;
                    }
                case 3:
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
            System.out.println("(3) Umowione wizyty");
            System.out.println("(4) Profil pracownika");
            System.out.println("(5) Profil pacjenta");
            System.out.println("(6) Wyloguj");
            int wybor = scan.nextInt();
            switch (wybor) {
                case 1: {
                    Rejestracja_Pacjenta.dodaj_Pacjenta(Baza);
                }
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4: {
                    System.out.println("Podaj login pracownika, ktorego chcesz wyszukac:");
                    String login;
                    while (true) {
                        login = scan.nextLine();
                        if (login.isBlank()) {
                            continue;
                        }
                        break;
                    }
                    Pracownik pracownik = znajdzPracownika(login);
                    if (pracownik == null) {
                        System.out.println("Dany pracownik nie znajduje sie w bazie danych");
                    }else{
                        boolean stop3 = true;
                        while(stop3){
                            wypiszOsoba(pracownik);
                            System.out.println("(1)Modyfikuj dane pracownika");
                            System.out.println("(2)Sprawdź harmonogram pracy pracownika");
                            System.out.println("(3)Powrot");
                            int wybor3 = scan.nextInt();
                            switch(wybor3){
                                case 1:
                                {
                                    boolean stop4 = true;
                                    while(stop4) {
                                        System.out.println("(1)Modyfikuj imie");
                                        System.out.println("(2)Modyfikuj nazwisko");
                                        System.out.println("(3)Modyfikuj numer telefonu");
                                        System.out.println("(4)Modyfikuj date urodzenia");
                                        System.out.println("(5)Modyfikuj email");
                                        System.out.println("(6)Modyfikuj adres zamieszkania");
                                        System.out.println("(7)Modyfikuj kod pocztowy");
                                        System.out.println("(8)Powrót");
                                        int wybor4 = scan.nextInt();
                                        switch (wybor4) {
                                            case 1:
                                                System.out.println("Podaj nowe imie:");
                                                while (true) {
                                                    String name = scan.nextLine();
                                                    if (name.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setImie(name);
                                                    break;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Podaj nowe nazwisko:");
                                                while (true) {
                                                    String surname = scan.nextLine();
                                                    if (surname.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setNazwisko(surname);
                                                    break;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Podaj nowy numer telefonu:");
                                                while (true) {
                                                    String phoneNumber = scan.nextLine();
                                                    if (phoneNumber.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setNumer_Telefonu(phoneNumber);
                                                    break;
                                                }
                                                break;
                                            case 4:
                                                System.out.println("Podaj nowa date urodzenia:");
                                                while (true) {
                                                    String birth = scan.nextLine();
                                                    if (birth.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setData_Urodzenia(birth);
                                                    break;
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Podaj nowy mail:");
                                                while (true) {
                                                    String email = scan.nextLine();
                                                    if (email.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setImie(email);
                                                    break;
                                                }
                                                break;
                                            case 6:
                                                System.out.println("Podaj nowy adres zamieszkania");
                                                while (true) {
                                                    String address = scan.nextLine();
                                                    if (address.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setadresZamieszkania(address);
                                                    break;
                                                }
                                                break;
                                            case 7:
                                                System.out.println("Podaj nowy kod pocztowy");
                                                while (true) {
                                                    String ZIP = scan.nextLine();
                                                    if (ZIP.isBlank()) {
                                                        continue;
                                                    }
                                                    pracownik.setKodPocztowy(ZIP);
                                                    break;
                                                }
                                                break;
                                            default:
                                                stop4 = false;
                                                break;
                                        }
                                    }
                                }
                                break;
                                case 2:
                                {

                                }
                                break;
                                case 3:
                                {
                                    stop3 = false;
                                }
                                break;
                                default:
                                {
                                    stop3 = false;
                                }
                                break;

                            }
                        }
                    }
                }
                    break;
                case 5: {
                    System.out.println("Podaj PESEL pacjenta, którego chcesz wyszukać:");
                    String pesel;
                    while(true){
                        pesel = scan.nextLine();
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
                        boolean stop =true;
                        while(stop) {
                            wypiszOsoba(temp);
                            System.out.println("(1)Modyfikuj dane pacjenta");
                            System.out.println("(2)Usuń pacjenta z bazy danych");
                            System.out.println("(3)Powrot");
                            int wybor2 = scan.nextInt();
                            switch(wybor2){
                                case 1: {
                                    boolean stop2 = true;
                                    while (stop2) {
                                        System.out.println("(1)Modyfikuj imie");
                                        System.out.println("(2)Modyfikuj nazwisko");
                                        System.out.println("(3)Modyfikuj numer telefonu");
                                        System.out.println("(4)Modyfikuj date urodzenia");
                                        System.out.println("(5)Modyfikuj email");
                                        System.out.println("(6)Powrót");
                                        int wybor3 = scan.nextInt();
                                        switch (wybor3) {
                                            case 1:
                                                System.out.println("Podaj nowe imie:");
                                                while (true) {
                                                    String name = scan.nextLine();
                                                    if (name.isBlank()) {
                                                        continue;
                                                    }
                                                    temp.setImie(name);
                                                    break;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Podaj nowe nazwisko:");
                                                while (true) {
                                                    String surname = scan.nextLine();
                                                    if (surname.isBlank()) {
                                                        continue;
                                                    }
                                                    temp.setNazwisko(surname);
                                                    break;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Podaj nowy numer telefonu:");
                                                while (true) {
                                                    String phoneNumber = scan.nextLine();
                                                    if (phoneNumber.isBlank()) {
                                                        continue;
                                                    }
                                                    temp.setNumer_Telefonu(phoneNumber);
                                                    break;
                                                }
                                                break;
                                            case 4:
                                                System.out.println("Podaj nowa date urodzenia:");
                                                while (true) {
                                                    String birth = scan.nextLine();
                                                    if (birth.isBlank()) {
                                                        continue;
                                                    }
                                                    temp.setData_Urodzenia(birth);
                                                    break;
                                                }
                                                break;
                                            case 5:
                                                System.out.println("Podaj nowy mail:");
                                                while (true) {
                                                    String email = scan.nextLine();
                                                    if (email.isBlank()) {
                                                        continue;
                                                    }
                                                    temp.setImie(email);
                                                    break;
                                                }
                                                break;
                                            default:
                                                stop2 = false;
                                                break;
                                        }
                                    }
                                }
                                    break;
                                case 2: {
                                    Rejestracja_Pacjenta.usun_Pacjenta(Baza, pesel);
                                    stop = false;
                                }
                                    break;
                                case 3: {
                                    stop = false;
                                }
                                    break;
                                default:{
                                    stop=false;}
                                    break;
                            }
                        }
                    }
                }
                    break;
                case 6: {
                    System.out.println("Zostales wylogowany");
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
        Pracownik d = new Pracownik("D168", "123456", "Stefan", "Kowalski", "99062506018", "999-000-000", "25.06.99", "Dyrektor", "stef@gmail.com" ,"grunwaldzka 4", "72-010");
        test.dodajPracownika(Baza_Pracownikow, d);
        d = new Pracownik("L168", "654321", "Michal", "Nowak", "97011306112", "111-421-000", "13.01.97", "Lekarz", "Nowakowski@gmail.com", "slaska 3", "75-000");
        test.dodajPracownika(Baza_Pracownikow, d);
        d = new Pracownik("R168", "654321", "Karol", "Szczur", "88011706112", "563-421-135", "17.01.88",  "Recepcjonista", "Szurek@gmail.com", "piernikowa 24","70-024");
        test.dodajPracownika(Baza_Pracownikow, d);
        Pacjent p = new Pacjent("Marian","Kowalski","95041201020","931-321-324","12.04.95", "Marian@gmail.com", "hamminga 124", "72-004");
        dodajOsoba(Baza,p);

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

        //weryfikacja();
        //Recepta_Elektorniczna.dodaj_Recepte();

        //weryfikacja();
        //Recepta_Elektorniczna.dodaj_Recepte();

        //menuRecepcjonista();
        menuLekarz();
    }
}

