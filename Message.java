package com.louis.xml.json;

import java.util.ArrayList;

public class Message {
    private long Id;
    private String text;
    private ArrayList<Double> geo;
    private User user;

    public Message(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Double> getGeo() {
        return geo;
    }

    public void setGeo(ArrayList<Double> geo) {
        this.geo = geo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + Id +
                ", text='" + text + '\'' +
                ", geo=" + geo +
                ", user=" + user +
                '}';
    }

    public Message(long Id, String text, ArrayList<Double> geo, User user) {
        this.Id = Id;
        this.text = text;
        this.geo = geo;
        this.user = user;
    }
}
