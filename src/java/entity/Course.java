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
public class Course {
    private int id;
    private String title;
    private double price;
    private String duration;

    public Course() {
    }

    public Course(int id, String title, double price, String duration) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
}
