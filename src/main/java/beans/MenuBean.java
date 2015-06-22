package beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


@SessionScoped
@ManagedBean(name = "menuBean")
public class MenuBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
        public String searchRedirect()
        {
            return "personSearch?faces-redirect=true";
        }
        
        public String addRedirect()
        {
            return "addPerson?faces-redirect=true";
        }
}
