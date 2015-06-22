package managers;

import java.util.ArrayList;
import entities.Person;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonManager {
	private ArrayList<Person> personArray = new ArrayList<Person>();
	
	public void addPerson(Person person){
		personArray.add(person);
	}
	
	public void deletePerson(Person person){
		for(Person p : personArray){
			if(person.getPesel().equals(p.getPesel())){
                                personArray.remove(person);
				break;
			}
		}
	}
		public ArrayList<Person> getAllPersons(){
			return personArray;
	}
	
}
