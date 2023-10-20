package ru.netology.vsurin;

public class Customer {
    private int id;
    private String name;

    public Customer (int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString()
    {
        return "{id=" + this.id + ", name=" + this.name + "}";
    }
}