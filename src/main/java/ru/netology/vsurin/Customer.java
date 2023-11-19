package ru.netology.vsurin;

public class Customer {
    private int id;
    private String name;

    public Customer (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString()
    {
        return "{id=" + this.id + ", name=" + this.name + "}";
    }
}