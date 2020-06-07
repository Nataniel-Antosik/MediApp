package Diagram_Klas;

import java.time.LocalDate;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Historia_Chorob_Pacjenta {

	public Map<LocalDateTime,String> choroby;


	public Historia_Chorob_Pacjenta() {
		choroby = new TreeMap<>();
	}


	public static void Sprawdzanie_Historie_Chorob(Pacjent pacjent) {
		if (pacjent.Historia.choroby.isEmpty()) {
			System.out.println("Pacjent nie posiada dotychczasowej historii chorob");
		} else {
			for (LocalDateTime key : pacjent.Historia.choroby.keySet()) {
				System.out.println(key.getDayOfMonth() + "/" + key.getMonth() + "/" + key.getYear());
				System.out.println(pacjent.Historia.choroby.get(key));
			}
		}
	}
	public static void wpisHistoriaChorob(Pacjent pacjent){
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String opis_choroby;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Dodaj opis choroby:");
	while (true) {
		opis_choroby = scanner.nextLine();
		if (opis_choroby.isBlank()) {
			continue;
		}
		pacjent.Historia.choroby.put(now,opis_choroby);
		break;
	}

	}

}