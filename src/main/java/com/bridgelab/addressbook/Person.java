package com.bridgelab.addressbook;

import java.time.LocalDate;

public class Person {
    private int PersonID;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate entryDate;

    public Person(int PersonID, String firstName, String lastName, String address,String phoneNumber, String email, LocalDate entryDate) {
        this.PersonID = PersonID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        String persondetails;
        persondetails = "\nID: " + PersonID +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAddress: " + address +
                "\nMobile Number: " + phoneNumber +
                "\nEmail: " + email +
                "\nEntry Date: " + entryDate;
        return persondetails;
    }
}
