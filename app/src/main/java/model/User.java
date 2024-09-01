package model;

import java.util.ArrayList;

public class User {
    private  int id;
    private String title;
    private String short_name;
    private String name;
    private ArrayList<Bank> data;

    public User(int id, String title, String short_name, String name, ArrayList<Bank> data) {
        this.id = id;
        this.title = title;
        this.short_name = short_name;
        this.name = name;
        this.data = data;
    }

    public String getShort_name() {
        return short_name;
    }

    public ArrayList<Bank> getData() {
        return data;
    }

    public void setData(ArrayList<Bank> data) {
        this.data = data;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
