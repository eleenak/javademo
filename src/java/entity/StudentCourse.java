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
public class StudentCourse {

    private int id;
    private int sid;
    private String name;
    private long phone;
    private String address;
    private int cid;
    private String title;
    private String duration;

    public StudentCourse() {
    }

    public StudentCourse(int id, int sid, String name, long phone, String address, int cid, String title, String duration) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cid = cid;
        this.title = title;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public int getSid() {
        return sid;
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

    public int getCid() {
        return cid;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
