package ru.netology.vsurin;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.vsurin.domain.Customer;
import ru.netology.vsurin.domain.Operation;
import ru.netology.vsurin.service.StatementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementServiceTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private StatementService statementService;

    @Test
    public void AddToStatementTest() {
        Operation operation = new Operation(1, 123, "Rub", "Merch", 1);
        statementService.addOperation(operation);

        statementService.AddToStatement(1);

        Map<Customer, List<Operation>> eqStatement = new HashMap<>();
        Customer customer1 = new Customer(1, "Spring");
        Customer customer2 = new Customer(2, "Boot");
        List<Operation> opers1 = new ArrayList<>();
        opers1.add(operation);
        eqStatement.put(customer1, opers1);
        eqStatement.put(customer2, new ArrayList<>());

        assertEquals(eqStatement, statementService.getStatement());
    }

    @Test
    public void deleteOperationById() {
        Operation operation = new Operation(1, 123, "Rub", "Merch", 1);
        statementService.addOperation(operation);

        statementService.AddToStatement(1);

        Map<Customer, List<Operation>> eqStatement = new HashMap<>();
        Customer customer1 = new Customer(1, "Spring");
        Customer customer2 = new Customer(2, "Boot");
        eqStatement.put(customer1, new ArrayList<>());
        eqStatement.put(customer2, new ArrayList<>());

        statementService.deleteOperationById(1);

        assertEquals(eqStatement, statementService.getStatement());
    }
}
