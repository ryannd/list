package com.ryannd.list_api.domain;

import com.ryannd.list_api.entity.Entry;
import java.util.ArrayList;

public class UserList {
    public ArrayList<Entry> all = new ArrayList<Entry>();
    public ArrayList<Entry> planning = new ArrayList<Entry>();
    public ArrayList<Entry> watching = new ArrayList<Entry>();
    public ArrayList<Entry> completed = new ArrayList<Entry>();

    public UserList() {}

    public ArrayList<Entry> getPlanning() {
        return this.planning;
    }

    public void setPlanning(ArrayList<Entry> planning) {
        this.planning = planning;
    }

    public ArrayList<Entry> getWatching() {
        return this.watching;
    }

    public void setWatching(ArrayList<Entry> watching) {
        this.watching = watching;
    }

    public ArrayList<Entry> getCompleted() {
        return this.completed;
    }

    public void setCompleted(ArrayList<Entry> completed) {
        this.completed = completed;
    }

    public ArrayList<Entry> getAll() {
        return this.all;
    }

    public void setAll(ArrayList<Entry> all) {
        this.all = all;
    }
}
