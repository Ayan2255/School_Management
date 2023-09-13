package com.example.project1.Model;

public class event_model {

    String pic;
    String title;
    String date;

    public event_model(String pic, String title, String date) {
        this.pic = pic;
        this.title = title;
        this.date = date;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public event_model() {}
}
