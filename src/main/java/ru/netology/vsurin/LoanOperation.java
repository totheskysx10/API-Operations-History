package ru.netology.vsurin;

public class LoanOperation extends Operation implements ConsolePrintable {

    private int loanId;

    public LoanOperation(int id, int sum, String currency, String merchant, int loanId, int clientId) {
        super(id, sum, currency, merchant, clientId);
        this.loanId = loanId;
    }

    @Override
    public void printToConsole() {
        System.out.println("{id=" + getId() + ", sum=" + getSum() + ", currency=" + getCurrency() + ", merchant=" + getMerchant() + ", loan id=" + loanId + "}");
    }

    @Override
    public String toString()
    {
        return "{id=" + getId() + ", sum=" + getSum() + ", currency=" + getCurrency() + ", merchant=" + getMerchant() + ", loan id=" + loanId + "}";
    }
}
