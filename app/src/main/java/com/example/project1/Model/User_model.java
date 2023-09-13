package com.example.project1.Model;

public class User_model {

    String name="";
    String roll="";
    String pass="";
    String uid="";
    String pic="";
    String address="";
    String cls="";
    String shift="";
    String sex="";
    String blood="";
    String attendence="t";

    public User_model(String name, String roll, String pass, String uid, String pic, String address, String cls, String shift, String sex, String blood, String attendence) {
        this.name = name;
        this.roll = roll;
        this.pass = pass;
        this.uid = uid;
        this.pic = pic;
        this.address = address;
        this.cls = cls;
        this.shift = shift;
        this.sex = sex;
        this.blood = blood;
        this.attendence = attendence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }

    public User_model(){}
}
