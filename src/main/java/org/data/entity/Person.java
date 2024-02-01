package org.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer personId;
    @Column(name="department")
    private String department;

    Person() {

    }
    public static Person of(String department) {
        return new Person(department);
    }

    private Person(String department) {
        this.department = department;
    }
    public Integer getPersonId() {
        return personId;
    }

    public String getDepartment() {
        return department;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
