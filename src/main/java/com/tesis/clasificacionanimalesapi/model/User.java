package com.tesis.clasificacionanimalesapi.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import org.springframework.data.annotation.Id;

@Container(containerName = "User")
public class User {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    private String lastName;
    private String role;
    private String documentNumber;
    private String email;
    private String password;
    private String rpassword;
    private String phoneNumber;

    public User() {

    }

    public User(String firstName,
                String lastName, String role, String documentNumber, String email, String password, String rpassword, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.documentNumber = documentNumber;
        this.email = email;
        this.password = password;
        this.rpassword = rpassword;
        this.phoneNumber = phoneNumber;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getDocumentNumber() { return documentNumber; }

    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRpassword() { return rpassword; }

    public void setRpassword(String rpassword) { this.rpassword = rpassword; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

}
