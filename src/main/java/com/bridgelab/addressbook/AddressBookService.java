package com.bridgelab.addressbook;

import java.util.List;

public class AddressBookService {
    public enum IOService {DB_IO, REST_IO}

    private List<Person> personList;

    private AddressBookDatabase addressBookDatabase;

    public AddressBookService () {
        addressBookDatabase = AddressBookDatabase.getInstance();
    }

    public AddressBookService(List<Person> personList) {
        this();
        this.personList = personList;
    }

    public List<Person> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            this.personList = addressBookDatabase.readData();
        return personList;
    }
    public static void main(String[] args){
        System.out.println("Welcome to Address Book Service Database");

    }
}
