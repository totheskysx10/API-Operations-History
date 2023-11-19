package ru.netology.vsurin;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomerService {
    private final ArrayList<Customer> customers;

    public CustomerService(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getCustomersCount() {
        return customers.size();
    }

    public void setCustomer(Customer item) {
        customers.add(item);
    }
}
