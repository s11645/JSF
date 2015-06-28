package unit;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class PatientUnit {
        
        private Date add = new Date();
	private String first;
	private String second;
	private String pesel;
	private Date birthday;
	private String living;
	private String phone;
	private double weight;
	private int height;
        

    public Date getAdd() {
        return add;
    }

    public void setAdd(Date add) {
        this.add = add;
    }
    @Size(min = 2, max = 50)
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
    @Size(min = 2, max = 50)
    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
    @Size(min = 11, max = 11)
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    @Past
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
