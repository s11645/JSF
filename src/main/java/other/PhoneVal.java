package other;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneV")
public class PhoneVal implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String phone = (String) value;
        if(phone.length()!=9)
        {
            FacesMessage message = new FacesMessage();
            message.setDetail("Numer tel musi być 9-cio cyfrowy");
            message.setSummary("Numer tel musi być 9-cio cyfrowy");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
