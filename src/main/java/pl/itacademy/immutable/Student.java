package pl.itacademy.immutable;

import java.util.Objects;

//public class Student extends Person {
public class Student {

    private String groupName;

    public Student(String firstName, String lastName, Address address, String groupName) {
//        super(firstName, lastName, address);
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(groupName, student.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), groupName);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
