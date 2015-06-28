package other;

import java.util.ArrayList;
import unit.PatientUnit;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Manager {
	private ArrayList<PatientUnit> patientUnit = new ArrayList<PatientUnit>();
	
	public void addPatient(PatientUnit unit){
		patientUnit.add(unit);
	}
	
	public void deletePatient(PatientUnit unit){
		for(PatientUnit patient : patientUnit){
			if(unit.getPesel().equals(patient.getPesel())){
                                patientUnit.remove(unit);
				break;
			}
		}
	}
		public ArrayList<PatientUnit> getAll(){
			return patientUnit;
	}
	
}
