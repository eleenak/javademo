/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Eleena
 */
public class Student {

    private int id;
    private String name;
    private long phone;
    private String address;
    private String gender;
    private String interest;

    public Student() {
    }

    public Student(int id, String name, long phone, String address, String gender, String interest) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.interest = interest;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getInterest() {
        return interest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

}
