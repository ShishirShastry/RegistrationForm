package com.example.registrationformassignment;

public class Student {
    private String srn;
    private String name;
    private String sex;
    private String pincode;
    private String email;
    private String phone;

    public Student() {
        // Default constructor required for Firebase
    }

    public Student(String srn, String name, String sex, String pincode, String email, String phone) {
        this.srn = srn;
        this.name = name;
        this.sex = sex;
        this.pincode = pincode;
        this.email = email;
        this.phone = phone;
    }

    // Generate getters and setters for all fields
    public String getSrn() {
        return srn;
    }

    public void setSrn(String srn) {
        this.srn = srn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
