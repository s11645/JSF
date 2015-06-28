package beans;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.richfaces.model.Filter;


@SessionScoped
@ManagedBean(name = "filBean")
public class ForFilter implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private unit.PatientFilterUnit unit = new unit.PatientFilterUnit();

    public unit.PatientFilterUnit getFilter() {
        return unit;
    }

    public void setFilter(unit.PatientFilterUnit unit) {
        this.unit = unit;
    }
    
    public Filter<?> getBirthdayFromFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				Date birthdayFrom = unit.getBirthdayFrom();
				if(birthdayFrom == null || birthdayFrom.equals(patientUnit.getBirthday())) return true;
                                else if(birthdayFrom != null && birthdayFrom.before(patientUnit.getBirthday()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getBirthdayToFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				Date birthdayTo = unit.getBirthdayTo();
				if(birthdayTo == null || birthdayTo.equals(patientUnit.getBirthday())) return true;
                                else if(birthdayTo != null && birthdayTo.after(patientUnit.getBirthday()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getAddFromFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				Date addFrom = unit.getAddFrom();
				if(addFrom == null || addFrom.equals(patientUnit.getAdd())) return true;
                                else if(addFrom != null && addFrom.before(patientUnit.getAdd()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getAddToFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				Date addTo = unit.getAddTo();
				if(addTo == null || addTo.equals(patientUnit.getAdd())) return true;
                                else if(addTo != null && addTo.after(patientUnit.getAdd()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getWeightFromFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				double weightFrom = unit.getWeightFrom();
				if(weightFrom==0) return true;
                                else if((weightFrom != 0) && (weightFrom <= patientUnit.getWeight()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getWeightToFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				double weightTo = unit.getWeightTo();
				if(weightTo == 0) return true;
                                else if((weightTo != 0) && (weightTo >= patientUnit.getWeight()))return true;
				return false;
			}
			
		};
    }
    
        public Filter<?> getHeightFromFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				double heightFrom = unit.getHeightFrom();
				if(heightFrom==0) return true;
                                else if((heightFrom != 0) && (heightFrom <= patientUnit.getHeight()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getHeightToFilter() {
		return new Filter<unit.PatientUnit>() {
			@Override
			public boolean accept(unit.PatientUnit patientUnit) {
				double heightTo = unit.getHeightTo();
				if(heightTo == 0) return true;
                                else if((heightTo != 0) && (heightTo >= patientUnit.getHeight()))return true;
				return false;
			}
			
		};
    }
}
