/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author schramm
 */
public class Patient {
    
    private int ohipNumber;
    private String surname;
    private String firstName;
    
    public Patient(int ohipNumber, String firstName, String surname) {
        this.ohipNumber = ohipNumber;
        this.firstName = firstName;
        this.surname = surname;
    }
    public int getOhipNumber() { return this.ohipNumber; }
    public String getSurname() { return this.surname; }
    public String getFirstName() { return this.firstName; }
    
    public String toString() { return this.firstName + "." + this.surname + "[" + this.ohipNumber + "]"; }
    
    public int hashCode() { return ohipNumber + surname.hashCode() + firstName.hashCode(); }
    
    public boolean equals(Object o) {
        System.out.println("Equals");
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Patient obj = (Patient)o;
        return this.ohipNumber == obj.ohipNumber && this.surname.equals(obj.surname) && this.firstName.equals(obj.firstName);
    }
    
}
    