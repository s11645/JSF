package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("numberValidator")
public class NumberValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String number = (String) value;
        if(number.length()!=9)
        {
            FacesMessage message = new FacesMessage();
            message.setDetail("Numer musi się składać z 9 cyfr.");
            message.setSummary("Numer musi się składać z 9 cyfr.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
