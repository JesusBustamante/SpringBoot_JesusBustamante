package com.requests.demo.model;

public class Customer {
    private Long id;
    private String firstname;
    private String lastName;
    private String email;

    public Customer(Long id, String firstname, String lastName, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

