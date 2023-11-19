package ru.netology.vsurin;

import java.util.Arrays;
public class Operation implements ConsolePrintable {
    private int id;
    private int sum;
    private String currency;
    private String merchant;
    private int clientId;

    public Operation(int id, int sum, String currency, String merchant, int clientId) {
        this.id = id;
        this.sum = sum;
        this.currency = currency;
        this.merchant = merchant;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
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
        return "{id=" + this.id + ", sum=" + this.sum + ", currency=" + this.currency + ", merchant=" + this.merchant + ", client=" + this.clientId + "}";
    }

    public void printToConsole() {
        System.out.println("{id=" + this.id + ", sum=" + this.sum + ", currency=" + this.currency + ", merchant=" + this.merchant + "}");
    }
}