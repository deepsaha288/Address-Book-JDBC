package com.bridgelab.addressbook;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDatabase {
    private static AddressBookDatabase addressBookDatabase;

    private AddressBookDatabase() {

    }

    public static AddressBookDatabase getInstance() {
        if (addressBookDatabase == null)
            addressBookDatabase = new AddressBookDatabase();
        return addressBookDatabase;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service?useSSL=false";
        String userName = "root";
        String password = "root123";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }


    public List<Person> readData() {
        String query = "SELECT * from persondetails;";
        return this.getPersonDetailsFromDatabase(query);
    }

    private List<Person> getPersonDetailsFromDatabase(String query) {
        List<Person> personList = new ArrayList<Person>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            personList = this.getPersonData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private List<Person> getPersonData(ResultSet resultSet) {

        List<Person> personList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int PersonID = resultSet.getInt("PersonID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                LocalDate entryDate = resultSet.getDate("entryDate").toLocalDate();
                personList.add(new Person(PersonID, firstName, lastName, address,phoneNumber, email, entryDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;

    }
}
