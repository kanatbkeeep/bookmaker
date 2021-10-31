package com.example.bookmaker.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequest {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private int age;
    private int UIN;
    private int balance;

    public UserRequest() {
    }

    public UserRequest(String email, String password, String firstName, String secondName, int age, int UIN, int balance) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.UIN = UIN;
        this.balance = balance;
    }

    public UserRequest(int id, String email, String password, String firstName, String secondName, int age, int UIN, int balance) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.UIN = UIN;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUIN() {
        return UIN;
    }

    public void setUIN(int UIN) {
        this.UIN = UIN;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
