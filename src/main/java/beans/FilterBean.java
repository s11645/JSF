package beans;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import org.richfaces.model.Filter;


@SessionScoped
@ManagedBean(name = "filterBean")
public class FilterBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private entities.Filter filter = new entities.Filter();

    public entities.Filter getFilter() {
        return filter;
    }

    public void setFilter(entities.Filter filter) {
        this.filter = filter;
    }
    
    public Filter<?> getBirthFromFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				Date birthFrom = filter.getBirthDateFrom();
				if(birthFrom == null || birthFrom.equals(person.getBirthDate())) return true;
                                else if(birthFrom != null && birthFrom.before(person.getBirthDate()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getBirthToFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				Date birthTo = filter.getBirthDateTo();
				if(birthTo == null || birthTo.equals(person.getBirthDate())) return true;
                                else if(birthTo != null && birthTo.after(person.getBirthDate()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getAddDateFromFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				Date addDateFrom = filter.getAddDateFrom();
				if(addDateFrom == null || addDateFrom.equals(person.getJoinDate())) return true;
                                else if(addDateFrom != null && addDateFrom.before(person.getJoinDate()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getAddDateToFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				Date addDateTo = filter.getAddDateTo();
				if(addDateTo == null || addDateTo.equals(person.getJoinDate())) return true;
                                else if(addDateTo != null && addDateTo.after(person.getJoinDate()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getWeightFromFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				double weightFrom = filter.getWeightFrom();
				if(weightFrom==0) return true;
                                else if((weightFrom != 0) && (weightFrom <= person.getWeight()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getWeightToFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				double weightTo = filter.getWeightTo();
				if(weightTo == 0) return true;
                                else if((weightTo != 0) && (weightTo >= person.getWeight()))return true;
				return false;
			}
			
		};
    }
    
        public Filter<?> getHeightFromFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				double heightFrom = filter.getHeightFrom();
				if(heightFrom==0) return true;
                                else if((heightFrom != 0) && (heightFrom <= person.getHeight()))return true;
				return false;
			}
			
		};
    }
    
    public Filter<?> getHeightToFilter() {
		return new Filter<entities.Person>() {
			@Override
			public boolean accept(entities.Person person) {
				double heightTo = filter.getHeightTo();
				if(heightTo == 0) return true;
                                else if((heightTo != 0) && (heightTo >= person.getHeight()))return true;
				return false;
			}
			
		};
    }
}
