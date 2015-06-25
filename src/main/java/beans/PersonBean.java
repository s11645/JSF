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

import entities.Person;
import entities.Sort;
import managers.PersonManager;
import org.richfaces.component.SortOrder;

@SessionScoped
@ManagedBean(name = "personBean")
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Person person = new Person();
        private Sort sort = new Sort();
	private ListDataModel<Person> personDataModel = new ListDataModel<Person>();
	
	@Inject //może korzystać z wszystkich metod PersonManager, cwaniak
	private PersonManager personManager;

        public Sort getSort() {
            return sort;
        }

        public void setSort(Sort sort) {
            this.sort = sort;
        }

	public Person getPerson() { 
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public ListDataModel<Person> getAllPersons(){
		personDataModel.setWrappedData(personManager.getAllPersons());
		return personDataModel;
	}
	
	public String addPerson(){
		personManager.addPerson(person);
                addMessage("Dodano!");
		return "personSearch?faces-redirect=true";
	}
	
	public String deletePerson(){
		Person personToDelete = personDataModel.getRowData();
		personManager.deletePerson(personToDelete);
		return null;
	}
	
	public void ifPeselExists(FacesContext context, UIComponent component, Object value) {

		String pesel = (String) value;

		for (Person person : personManager.getAllPersons()) {
			if (person.getPesel().equalsIgnoreCase(pesel)) {
				FacesMessage message = new FacesMessage("Osoba o tym numerze Pesel istnieje w bazie");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
        
        public void validateNumber(FacesContext context, UIComponent component, Object value) {
            
            String number = (String) value;
            for(int i=0; i<number.length()-1; i++)
            {
                if((number.charAt(i)!='0')&&(number.charAt(i)!='1')&&(number.charAt(i)!='2')&&(number.charAt(i)!='3')&&(number.charAt(i)!='4')&&(number.charAt(i)!='5')&&(number.charAt(i)!='6')&&(number.charAt(i)!='7')&&(number.charAt(i)!='8')&&(number.charAt(i)!='9'))
                {
                    FacesMessage message = new FacesMessage("Wpisz wartości 0-9");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
            }
	}
	
	public void validatePeselBirth(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pesel = (UIInput) form.findComponent("pesel");
		UIInput birth = (UIInput) form.findComponent("birthDate");

		if (pesel.getValue() != null && birth.getValue() != null && pesel.getValue().toString().length() >= 2) {
                    
			String twoDigitsOfPesel = pesel.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) birth.getValue()));

			String lastDigitsOfBirth = ((Integer) cal.get(Calendar.YEAR)).toString().substring(2);

			if (!twoDigitsOfPesel.equals(lastDigitsOfBirth)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage("Pesel jest niezgodny z datą urodzenia"));
				context.renderResponse();
			}
		}
	}
        public void sortByJoinDate()
        {
            sort.setHeightSort(SortOrder.unsorted);
            sort.setNameSort(SortOrder.unsorted);
            sort.setPeselSort(SortOrder.unsorted);
            sort.setSurnameSort(SortOrder.unsorted);
            sort.setWeightSort(SortOrder.unsorted);
            
            if(sort.getJoinDateSort().equals(SortOrder.ascending)) sort.setJoinDateSort(SortOrder.descending);
            else sort.setJoinDateSort(SortOrder.ascending);
            
        }
        
        public void sortByName()
        {
            sort.setHeightSort(SortOrder.unsorted);
            sort.setJoinDateSort(SortOrder.unsorted);
            sort.setPeselSort(SortOrder.unsorted);
            sort.setSurnameSort(SortOrder.unsorted);
            sort.setWeightSort(SortOrder.unsorted);
            
            if(sort.getNameSort().equals(SortOrder.ascending)) sort.setNameSort(SortOrder.descending);
            else sort.setNameSort(SortOrder.ascending);
            
        }
        
        public void sortBySurname()
        {
            sort.setHeightSort(SortOrder.unsorted);
            sort.setJoinDateSort(SortOrder.unsorted);
            sort.setPeselSort(SortOrder.unsorted);
            sort.setNameSort(SortOrder.unsorted);
            sort.setWeightSort(SortOrder.unsorted);
            
            if(sort.getSurnameSort().equals(SortOrder.ascending)) sort.setSurnameSort(SortOrder.descending);
            else sort.setSurnameSort(SortOrder.ascending);
            
        }
        
        public void sortByPesel()
        {
            sort.setHeightSort(SortOrder.unsorted);
            sort.setJoinDateSort(SortOrder.unsorted);
            sort.setSurnameSort(SortOrder.unsorted);
            sort.setNameSort(SortOrder.unsorted);
            sort.setWeightSort(SortOrder.unsorted);
            
            if(sort.getPeselSort().equals(SortOrder.ascending)) sort.setPeselSort(SortOrder.descending);
            else sort.setPeselSort(SortOrder.ascending);
            
        }
        
        public void sortByWeight()
        {
            sort.setHeightSort(SortOrder.unsorted);
            sort.setJoinDateSort(SortOrder.unsorted);
            sort.setSurnameSort(SortOrder.unsorted);
            sort.setNameSort(SortOrder.unsorted);
            sort.setPeselSort(SortOrder.unsorted);
            
            if(sort.getWeightSort().equals(SortOrder.ascending)) sort.setWeightSort(SortOrder.descending);
            else sort.setWeightSort(SortOrder.ascending);
            
        }
        
        public void sortByHeight()
        {
            sort.setWeightSort(SortOrder.unsorted);
            sort.setJoinDateSort(SortOrder.unsorted);
            sort.setSurnameSort(SortOrder.unsorted);
            sort.setNameSort(SortOrder.unsorted);
            sort.setPeselSort(SortOrder.unsorted);
            
            if(sort.getHeightSort().equals(SortOrder.ascending)) sort.setHeightSort(SortOrder.descending);
            else sort.setHeightSort(SortOrder.ascending);
            
        }
        
        public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
