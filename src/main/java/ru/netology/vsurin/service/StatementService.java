package ru.netology.vsurin.service;

import org.springframework.stereotype.Component;
import ru.netology.vsurin.domain.Customer;
import ru.netology.vsurin.domain.Operation;

import java.util.*;

@Component
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

    public boolean deleteOperationById(int id) {
        boolean deleted = false;

        Iterator<Operation> operationIterator = operations.iterator();
        while (operationIterator.hasNext()) {
            Operation operation = operationIterator.next();
            if (operation.getId() == id) {
                operationIterator.remove();
                deleted = true;
                System.out.println("Deleted operation: " + operation);
            }
        }

        Iterator<Map.Entry<Customer, List<Operation>>> statementIterator = statement.entrySet().iterator();
        while (statementIterator.hasNext()) {
            Map.Entry<Customer, List<Operation>> entry = statementIterator.next();
            List<Operation> customerOperations = entry.getValue();

            Iterator<Operation> customerOperationIterator = customerOperations.iterator();
            while (customerOperationIterator.hasNext()) {
                Operation operation = customerOperationIterator.next();
                if (operation.getId() == id) {
                    customerOperationIterator.remove();
                    deleted = true;
                }
            }
        }
        return deleted;
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

    public Map<Customer, List<Operation>> getStatement() {
        return statement;
    }
}
