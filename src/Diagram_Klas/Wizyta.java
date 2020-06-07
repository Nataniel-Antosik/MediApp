package Diagram_Klas;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Wizyta {

	Pracownik Pracownik;
	public int ID_Wizyta;
	public String Data_Wizyty;
	public boolean Status_Wizyty;

	public Wizyta(String Data_Wizyty, boolean Status_Wizyty, int ID_Wizyta) {
		// TODO - implement Wizyta.Wizyta
		this.Data_Wizyty = Data_Wizyty;
		this.Status_Wizyty = Status_Wizyty;
		this.ID_Wizyta = ID_Wizyta;
	}

	//public void setID_Pacjent(Pacjent ID_Pacjent) { ID_Pacjent = ID_Pacjent; }
	public void setData_Wizyty(String in) {  Data_Wizyty = in; }
	public void setStatus_Wizyty(boolean in) { Status_Wizyty = in; }
	//public void setPracownik(Pracownik ID_Pracownik) { ID_Pracownik = ID_Pracownik; }
	public void setID_Wizyta(int ID_Wizyta) { this.ID_Wizyta = ID_Wizyta; }


	public int getID_Wizyta() { return ID_Wizyta; }
	public boolean getStatus_Wizyty() { return Status_Wizyty; }
	public String getData_Wizyty() { return Data_Wizyty; }

	public void Odwolywanie_Wizyty(Wizyta w) {
		w.Status_Wizyty=false;
	}

	public static void umowWizyte(Pracownik pracownik, Pacjent pacjent){
		printCalendarMonthYear(Calendar. getInstance(). get(Calendar. MONTH)+1,Calendar. getInstance(). get(Calendar.YEAR));

		Scanner scan = new Scanner(System.in);
		String day="";
		String hour;
		boolean stop_main = true;
		while(stop_main) {
			System.out.println("\nPodaj dzien umowienia wizyty(liczbowo):");
			boolean stop = true;
			while (stop) {
				day = scan.nextLine();
				if (Integer.parseInt(day) < 1 || Integer.parseInt(day) < LocalDate.now().getDayOfMonth() || Integer.parseInt(day) > Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
					System.out.println("Podano zly dzien, podaj jeszcze raz");
					continue;
				} else {
					stop = false;
				}
			}
			if (!pracownik.Wizyta.containsKey(day + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)))) {
				HashMap<String, Wizyta> temp = new HashMap<>();
				Wizyta numer1 = new Wizyta("10:00", true, 1);
				Wizyta numer2 = new Wizyta("11:00", true, 2);
				Wizyta numer3 = new Wizyta("12:00", true, 3);
				temp.put(numer1.Data_Wizyty, numer1);
				temp.put(numer2.Data_Wizyty, numer2);
				temp.put(numer3.Data_Wizyty, numer3);
				pracownik.Wizyta.put(day + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), temp);
				if(wypiszDostepne(pracownik.Wizyta.get(day + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))))){
					stop_main = false;
				}
			} else {
				if(wypiszDostepne(pracownik.Wizyta.get(day + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))))){
					stop_main = false;
				}
			}
		}
	}

	private static void printCalendarMonthYear(int month, int year) {
		Calendar cal = new GregorianCalendar();
		cal.clear();
		cal.set(year, month - 1, 1); // setting the calendar to the month and year provided as parameters
		System.out.println("Calendar for "+ cal.getDisplayName(Calendar.MONTH, Calendar.LONG,
				Locale.US) + " " + cal.get(Calendar.YEAR));//to print Calendar for month and year
		int firstWeekdayOfMonth = cal.get(Calendar.DAY_OF_WEEK);//which weekday was the first in month
		int numberOfMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //lengh of days in a month
		printCalendar(numberOfMonthDays, firstWeekdayOfMonth);
	}
	private static void printCalendar(int numberOfMonthDays, int firstWeekdayOfMonth) {
		int weekdayIndex = 0;
		System.out.println("Su  MO  Tu  We  Th  Fr  Sa"); // The order of days depends on your calendar

		for (int day = 1; day < firstWeekdayOfMonth; day++) {
			System.out.print("    "); //this loop to print the first day in his correct place
			weekdayIndex++;
		}
		for (int day = 1; day <= numberOfMonthDays; day++) {

			if (day<10) // this is just for better visialising because unit number take less space of course than 2
				System.out.print(day+" ");
			else System.out.print(day);
			weekdayIndex++;
			if (weekdayIndex == 7) {
				weekdayIndex = 0;
				System.out.println();
			} else {
				System.out.print("  ");
			}}}
	public static boolean wypiszDostepne(HashMap<String,Wizyta> godziny){
		Scanner scanner = new Scanner(System.in);

		int counter = 0;
		List<String> keys = new ArrayList<String>();
		for(String key : godziny.keySet()){
			if(godziny.get(key).Status_Wizyty){
				counter++;
				System.out.println(counter + " " + godziny.get(key).Data_Wizyty);
				keys.add(key);
			}
		}
		System.out.println(counter+1 + "Powrot");
		System.out.println("Wybierz termin lub wroc:");

		if(counter == 0){
			System.out.println("Brak dostepnych godzin");
			return false;
		}
		else if(counter == 1){
			int wybor = scanner.nextInt();

			switch(wybor){
				case 1:{
					godziny.get(keys.get(0)).setStatus_Wizyty(false);
					return true;
				}
				case 2:{
					return false;
				}

				default:{
					return false;
				}

			}
		}
		else if(counter == 2){
			int wybor = scanner.nextInt();
			switch(wybor){
				case 1:{
					godziny.get(keys.get(0)).setStatus_Wizyty(false);
					return true;
				}
				case 2:{
					godziny.get(keys.get(1)).setStatus_Wizyty(false);
					return true;
				}
				case 3:{
					return false;
				}
				default:{
					return false;
				}
			}
		}
		else if(counter ==3){
			int wybor = scanner.nextInt();
			switch(wybor){
				case 1:{
					godziny.get(keys.get(0)).setStatus_Wizyty(false);
					return true;
				}
				case 2:{
					godziny.get(keys.get(1)).setStatus_Wizyty(false);
					return true;

				}
				case 3:{
					godziny.get(keys.get(2)).setStatus_Wizyty(false);
					return true;

				}
				case 4:{
					return false;
				}
				default:{
					return false;
				}
			}
		}
				return false;
	}
}

