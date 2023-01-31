package com.tikalk.workshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Person table entity
 * Created by sigals on 03/03/2018.
 */
@Table("person")
public class Person {

    @Id
    @Column
    private BigInteger id;

    @Column
    private String givenName;

    @Column
    private String sureName;

    @SuppressWarnings("unused")
    public Person() {
    }

    @SuppressWarnings("unused")
    public Person(String givenName, String sureName) {
        this.givenName = givenName;
        this.sureName = sureName;
    }

    public BigInteger getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(givenName, person.givenName) &&
                Objects.equals(sureName, person.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, sureName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", givenName='" + givenName + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }
}
