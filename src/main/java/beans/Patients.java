package beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import unit.PatientUnit;
import unit.PatientSortUnit;
import other.Manager;
import org.richfaces.component.SortOrder;

@SessionScoped
@ManagedBean(name = "patBean")
public class Patients implements Serializable {

	private static final long serialVersionUID = 1L;
	private PatientUnit patientUnit = new PatientUnit();
        private PatientSortUnit sortUnit = new PatientSortUnit();
	private ListDataModel<PatientUnit> patientDataModel = new ListDataModel<PatientUnit>();
	
	@Inject //może korzystać z wszystkich metod PersonManager, cwaniak
	private Manager manager;

        public PatientSortUnit getSortUnit() {
            return sortUnit;
        }

        public void setSortUnit(PatientSortUnit sortUnit) {
            this.sortUnit = sortUnit;
        }

	public PatientUnit getPatientUnit() { 
		return patientUnit;
	}

	public void setPatientUnit(PatientUnit patientUnit) {
		this.patientUnit = patientUnit;
	}
	
	public ListDataModel<PatientUnit> getAll(){
		patientDataModel.setWrappedData(manager.getAll());
		return patientDataModel;
	}
	
	public String addPatient(){
		manager.addPatient(patientUnit);
                addMessage("Nowy");
		return "tableSearch?faces-redirect=true";
	}
	
	public String deletePatient(){
		PatientUnit unit = patientDataModel.getRowData();
		manager.deletePatient(unit);
		return null;
	}
	
	public void peselHere(FacesContext context, UIComponent component, Object value) {

		String pesel = (String) value;

		for (PatientUnit unit : manager.getAll()) {
			if (unit.getPesel().equalsIgnoreCase(pesel)) {
				FacesMessage message = new FacesMessage("Pesel już istnieje");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
        
        public void phoneVal(FacesContext context, UIComponent component, Object value) {
            
            String phone = (String) value;
            for(int x=0; x<phone.length()-1; x++)
            {
                if((phone.charAt(x)!='0')&&(phone.charAt(x)!='1')&&(phone.charAt(x)!='2')&&(phone.charAt(x)!='3')&&(phone.charAt(x)!='4')&&(phone.charAt(x)!='5')&&(phone.charAt(x)!='6')&&(phone.charAt(x)!='7')&&(phone.charAt(x)!='8')&&(phone.charAt(x)!='9'))
                {
                    FacesMessage message = new FacesMessage("Niepoprawny numer telefonu");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
            }
	}
	
	public void dateVal(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pesel = (UIInput) form.findComponent("pesel");
		UIInput date = (UIInput) form.findComponent("birthday");

		if (pesel.getValue() != null && date.getValue() != null && pesel.getValue().toString().length() >= 2) {
                    
			String twoDigitsOfPesel = pesel.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) date.getValue()));

			String lastDigitsOfBirth = ((Integer) cal.get(Calendar.YEAR)).toString().substring(2);

			if (!twoDigitsOfPesel.equals(lastDigitsOfBirth)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage("Pesel jest niezgodny z datą urodzenia"));
				context.renderResponse();
			}
		}
	}
        public void addSort()
        {
            sortUnit.setHeightSort(SortOrder.unsorted);
            sortUnit.setFirstSort(SortOrder.unsorted);
            sortUnit.setPeselSort(SortOrder.unsorted);
            sortUnit.setSecondSort(SortOrder.unsorted);
            sortUnit.setWeightSort(SortOrder.unsorted);
            
            if(sortUnit.getAddSort().equals(SortOrder.ascending)) sortUnit.setAddSort(SortOrder.descending);
            else sortUnit.setAddSort(SortOrder.ascending);
            
        }
        
        public void firstSort()
        {
            sortUnit.setHeightSort(SortOrder.unsorted);
            sortUnit.setAddSort(SortOrder.unsorted);
            sortUnit.setPeselSort(SortOrder.unsorted);
            sortUnit.setSecondSort(SortOrder.unsorted);
            sortUnit.setWeightSort(SortOrder.unsorted);
            
            if(sortUnit.getFirstSort().equals(SortOrder.ascending)) sortUnit.setFirstSort(SortOrder.descending);
            else sortUnit.setFirstSort(SortOrder.ascending);
            
        }
        
        public void secondSort()
        {
            sortUnit.setHeightSort(SortOrder.unsorted);
            sortUnit.setAddSort(SortOrder.unsorted);
            sortUnit.setPeselSort(SortOrder.unsorted);
            sortUnit.setFirstSort(SortOrder.unsorted);
            sortUnit.setWeightSort(SortOrder.unsorted);
            
            if(sortUnit.getSecondSort().equals(SortOrder.ascending)) sortUnit.setSecondSort(SortOrder.descending);
            else sortUnit.setSecondSort(SortOrder.ascending);
            
        }
        
        public void peselSort()
        {
            sortUnit.setHeightSort(SortOrder.unsorted);
            sortUnit.setAddSort(SortOrder.unsorted);
            sortUnit.setSecondSort(SortOrder.unsorted);
            sortUnit.setFirstSort(SortOrder.unsorted);
            sortUnit.setWeightSort(SortOrder.unsorted);
            
            if(sortUnit.getPeselSort().equals(SortOrder.ascending)) sortUnit.setPeselSort(SortOrder.descending);
            else sortUnit.setPeselSort(SortOrder.ascending);
            
        }
        
        public void weightSort()
        {
            sortUnit.setHeightSort(SortOrder.unsorted);
            sortUnit.setAddSort(SortOrder.unsorted);
            sortUnit.setSecondSort(SortOrder.unsorted);
            sortUnit.setFirstSort(SortOrder.unsorted);
            sortUnit.setPeselSort(SortOrder.unsorted);
            
            if(sortUnit.getWeightSort().equals(SortOrder.ascending)) sortUnit.setWeightSort(SortOrder.descending);
            else sortUnit.setWeightSort(SortOrder.ascending);
            
        }
        
        public void heightSort()
        {
            sortUnit.setWeightSort(SortOrder.unsorted);
            sortUnit.setAddSort(SortOrder.unsorted);
            sortUnit.setSecondSort(SortOrder.unsorted);
            sortUnit.setFirstSort(SortOrder.unsorted);
            sortUnit.setPeselSort(SortOrder.unsorted);
            
            if(sortUnit.getHeightSort().equals(SortOrder.ascending)) sortUnit.setHeightSort(SortOrder.descending);
            else sortUnit.setHeightSort(SortOrder.ascending);
            
        }
        
        public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
