package Diagram_Klas;

import javax.xml.crypto.Data;
import java.util.*;

public class Wizyta {

	Pracownik Pracownik;
	Collection<Pacjent> Pacjent;
	public int ID_Wizyta;
	public Data Data_Wizyty;
	public boolean Status_Wizyty;

	/**
	 * 
	 * @param ID_pacjent
	 * @param Data_Wizyty
	 * @param Status_Wizyty
	 * @param ID_Pracownika
	 * @param ID_Wizyta
	 */
	public Wizyta(Diagram_Klas.Pacjent ID_pacjent, Data Data_Wizyty, boolean Status_Wizyty, Pracownik ID_Pracownika, int ID_Wizyta) {
		// TODO - implement Wizyta.Wizyta
		this.Data_Wizyty = Data_Wizyty;
		this.Status_Wizyty = Status_Wizyty;
		this.ID_Wizyta = ID_Wizyta;
	}

	//public void setID_Pacjent(Pacjent ID_Pacjent) { ID_Pacjent = ID_Pacjent; }
	public void setData_Wizyty(Data in) { Data_Wizyty = in; }
	public void setStatus_Wizyty(boolean in) { Status_Wizyty = in; }
	//public void setPracownik(Pracownik ID_Pracownik) { ID_Pracownik = ID_Pracownik; }
	public void setID_Wizyta(int ID_Wizyta) { this.ID_Wizyta = ID_Wizyta; }


	public int getID_Wizyta() { return ID_Wizyta; }
	public boolean getStatus_Wizyty() { return Status_Wizyty; }
	public Data getData_Wizyty() { return Data_Wizyty; }
	public
	/**
	 * 
	 * @param ID_Pacjenta
	 * @param Wizyta
	 */
	public void Odwolywanie_Wizyty(Diagram_Klas.Pacjent ID_Pacjenta, Diagram_Klas.Wizyta Wizyta) {
		// TODO - implement Wizyta.Odwolywanie_Wizyty
		throw new UnsupportedOperationException();
	}

}