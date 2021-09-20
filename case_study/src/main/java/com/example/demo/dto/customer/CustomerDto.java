package com.example.demo.dto.customer;

import com.example.demo.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class CustomerDto {
    private int customerId;
    @Pattern(regexp = "^(KH-)[\\d]{4}$", message = "Pattern KH-XXXX")
    @NotBlank(message = "Must write here")
    private String codeCustomer;
    @NotEmpty(message = "Must write here")
    @NotBlank(message = "Must write here")
    private String customerName;
    private Date customerBirthDay;
    private int customerGender;
    @Pattern(regexp = "^((\\d){12}||(\\d){9})$", message = "Pattern of field: XXXXXXXXX have 9 or 12 number(0-9)")
    private String customerIdCard;
    @Pattern(regexp = "^((\\(84\\)\\+(90))|(090)|(091)|(\\(84\\)\\+(91)))[\\d]{7}$", message = "Phone have pattern 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx")
    private String customerPhone;
    @Email
    @NotBlank(message = "Must write here")
    private String customerEmail;
    @NotBlank(message = "Must write here")
    private String customerAddress;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(Date customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
