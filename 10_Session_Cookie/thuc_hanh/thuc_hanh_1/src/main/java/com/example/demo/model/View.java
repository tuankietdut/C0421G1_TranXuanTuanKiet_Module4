package com.example.demo.model;

public class View {
    private int count =1 ;

    public View() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
