package ru.netology.vsurin;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class StatementService {
    private static ArrayList<Operation> operations = new ArrayList<>();
    private static Map<Customer, List<Operation>> statement = new HashMap<>();
    private static CustomerService customerService;

    public StatementService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public static void addOperation(Operation operation) {
        operations.add(operation);
    }

    public static Map<Customer, List<Operation>> AddToStatement(int clientID) {
        ArrayList<Customer> customers = customerService.getCustomers();
        for (Customer customer : customers) {
            if (!statement.containsKey(customer)) {
                statement.put(customer, new ArrayList<>());
            }
            if (customer.getId() == clientID) {
                statement.get(customer).add(operations.get(operations.size() - 1));
            }
        }
        return statement;
    }
}
