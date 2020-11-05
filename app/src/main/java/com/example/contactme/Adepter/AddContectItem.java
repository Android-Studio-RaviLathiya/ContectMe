package com.example.contactme.Adepter;

public class AddContectItem {

    public String id, fname, mname, lname, mnumber, hnumber, cnumber, haddress, caddress, email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMnumber() {
        return mnumber;
    }

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber;
    }

    public String getHnumber() {
        return hnumber;
    }

    public void setHnumber(String hnumber) {
        this.hnumber = hnumber;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddContectItem(String id, String fname, String mname, String lname, String mnumber, String hnumber, String cnumber, String haddress, String caddress, String email) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.mnumber = mnumber;
        this.hnumber = hnumber;
        this.cnumber = cnumber;
        this.haddress = haddress;
        this.caddress = caddress;
        this.email = email;
    }
}