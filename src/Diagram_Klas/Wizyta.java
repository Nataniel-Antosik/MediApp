package Diagram_Klas;

import javax.xml.crypto.Data;
import java.util.*;

public class Wizyta {

	Pracownik Pracownik;
	Collection<Pacjent> Pacjent;
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

}