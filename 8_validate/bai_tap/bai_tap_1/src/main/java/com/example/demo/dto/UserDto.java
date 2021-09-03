package com.example.demo.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    private int id;
    @NonNull
    @Size(min = 5, max = 45, message = "Tối thiểu 5 ký tự, tối đa 45 kí tự")
    private String firstName;

    @NonNull
    @Size(min = 5, max = 45, message = "Tối thiểu 5 ký tự, tối đa 45 kí tự")
    private String lastName;

    @Pattern(regexp = "^(090)[0-9]{8}$", message = "SDT bao gồm 11 số - 090xxxxxxxx")
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi trên 18")
    private int age;

    @Email
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
