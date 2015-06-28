package other;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("peselVal")
public class PESELVal implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		String pesel = (String) value;
		
		if (pesel.length() != 11) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Pesel musi być 11-cyfrowy");
			message.setSummary("Pesel musi być 11-cyfrowy");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
