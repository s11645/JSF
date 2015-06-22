package entities;

import java.util.Date;

public class Filter {
    
    private String name;
    private String surname;
    private String pesel;
    private Date birthDateFrom;
    private Date birthDateTo;
    private double weightFrom;
    private double weightTo;
    private double heightFrom;
    private double heightTo;
    private Date addDateFrom;
    private Date addDateTo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getBirthDateFrom() {
        return birthDateFrom;
    }

    public void setBirthDateFrom(Date birthDateFrom) {
        this.birthDateFrom = birthDateFrom;
    }

    public Date getBirthDateTo() {
        return birthDateTo;
    }

    public void setBirthDateTo(Date birthDateTo) {
        this.birthDateTo = birthDateTo;
    }

    public double getWeightFrom() {
        return weightFrom;
    }

    public void setWeightFrom(double weightFrom) {
        this.weightFrom = weightFrom;
    }

    public double getWeightTo() {
        return weightTo;
    }

    public void setWeightTo(double weightTo) {
        this.weightTo = weightTo;
    }

    public double getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(double heightFrom) {
        this.heightFrom = heightFrom;
    }

    public double getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(double heightTo) {
        this.heightTo = heightTo;
    }

    public Date getAddDateFrom() {
        return addDateFrom;
    }

    public void setAddDateFrom(Date addDateFrom) {
        this.addDateFrom = addDateFrom;
    }

    public Date getAddDateTo() {
        return addDateTo;
    }

    public void setAddDateTo(Date addDateTo) {
        this.addDateTo = addDateTo;
    }
    
    
    
}
