package ru.netology.vsurin;

public class CashbackOperation extends Operation implements ConsolePrintable {

    private int cashbackAmount;

    public CashbackOperation(int id, int sum, String currency, String merchant, int cashbackAmount) {
        super(id, sum, currency, merchant);
        this.cashbackAmount = cashbackAmount;
    }

    @Override
    public void printToConsole() {
        System.out.println("{id=" + getId() + ", sum=" + getSum() + ", currency=" + getCurrency() + ", merchant=" + getMerchant() + ", cashback=" + cashbackAmount + "}");
    }

    @Override
    public String toString()
    {
        return "{id=" + getId() + ", sum=" + getSum() + ", currency=" + getCurrency() + ", merchant=" + getMerchant() + ", cashback=" + cashbackAmount + "}";
    }
}
