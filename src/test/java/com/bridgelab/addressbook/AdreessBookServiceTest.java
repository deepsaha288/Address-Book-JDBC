package com.bridgelab.addressbook;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AdreessBookServiceTest {
    @Test
    public void givenAddressBookDatabseBWhenRetrivedShouldMatchPersonEntriesCount() {
        AddressBookService addressBookService = new AddressBookService();
        List<Person> addressBookDataList = addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
        Assertions.assertEquals(3, addressBookDataList.size());
    }
}
