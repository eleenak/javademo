/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Eleena
 */
public class Fee {
    private int fid;
    private int sc_id;
    private double amount;
    private LocalDate Date;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getSc_id() {
        return sc_id;
    }

    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public Fee(int fid, int sc_id, double amount, LocalDate Date) {
        this.fid = fid;
        this.sc_id = sc_id;
        this.amount = amount;
        this.Date = Date;
    }

    public Fee() {
    }
}
