package pl.itacademy.immutable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Address address;

    private final Set<Certificate> certificates = new HashSet<>();

    public static Person createPerson(String firstName, String lastName, Address address) {
        return new Person(firstName, lastName, address);
    }

    private Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = copyAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return copyAddress(address);
    }

    private Address copyAddress(Address address) {
        return new Address(address.getCity());
    }
}
