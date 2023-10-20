package ru.netology.vsurin;

import java.util.Arrays;
public class Operation implements ConsolePrintable {
    private int id;
    private int sum;
    private String currency;
    private String merchant;

    public Operation(int id, int sum, String currency, String merchant) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
    }

    public int getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMerchant() {
        return merchant;
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
        return "{id=" + this.id + ", sum=" + this.sum + ", currency=" + this.currency + ", merchant=" + this.merchant + "}";
    }

    public void printToConsole() {
        System.out.println("{id=" + this.id + ", sum=" + this.sum + ", currency=" + this.currency + ", merchant=" + this.merchant + "}");
    }
}