package ru.netology.vsurin;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final int MAX_OPERATIONS = 5;
    public static final int MAX_CUSTOMERS = 5;
    private static Operation[] operations = new Operation[MAX_OPERATIONS];
    private static Customer[] customers = new Customer[MAX_CUSTOMERS];
    private static int[][] statement = new int[MAX_CUSTOMERS][MAX_OPERATIONS];

    private static int[] customerOperationsCount = new int[MAX_CUSTOMERS];

    private static int customersCount = 0;
    private static int operationsCount = 0;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        inputCustomers(scanner);
        inputOperations(scanner);

        System.out.println("Operations: " + Arrays.toString(operations));
        System.out.println("Customers: " + Arrays.toString(customers));
        System.out.println("Statements: " + Arrays.deepToString(statement));
        System.out.println("Customer operations: " + Arrays.toString(customerOperationsCount));
    }

    private static void inputOperations(Scanner scanner) throws Exception {
        while (true) {
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            int cashback;
            int loanId;
            if (sum >= 1000) {
                cashback = sum/100;
                operations[operationsCount] = new CashbackOperation(operationsCount, sum, currency, merchant, cashback);
            }
            System.out.println("Is it a loan operation? Y/N");
            String loanOperation = scanner.nextLine();
            if (loanOperation.equals("Y")) {
                System.out.println("LoanId: ");
                loanId = scanner.nextInt();
                scanner.nextLine();
                operations[operationsCount] = new LoanOperation(operationsCount, sum, currency, merchant, loanId);
            }
            else if (sum < 1000 && loanOperation.equals("N"))
                operations[operationsCount] = new Operation(operationsCount, sum, currency, merchant);

            operationsCount++;

            SaveStatement(scanner);

            if (operationsCount == MAX_OPERATIONS)
                break;

            System.out.println("Do you want to enter one more operation? Y/N");
            String oneMoreOperation = scanner.nextLine();

            if (oneMoreOperation.equals("N"))
                break;
        }
    }

    private static void inputCustomers(Scanner scanner) {
        while (true) {
            System.out.println("Customer name: ");
            String name = scanner.nextLine();

            customers[customersCount] = new Customer(customersCount, name);
            customersCount++;

            if (customersCount == MAX_CUSTOMERS)
                break;

            System.out.println("Do you want to enter one more customer? Y/N");
            String oneMoreCustomer = scanner.nextLine();

            if (oneMoreCustomer.equals("N"))
                break;
        }
    }

    public static Operation[] getOperations(int customerId) {
        int customerOperationsCount = 0;
        Operation[] customerOperations = new Operation[MAX_OPERATIONS];
        for (Operation operation : operations) {
            if (operation.getId() == customerId) {
                customerOperationsCount++;
                customerOperations[customerOperationsCount] = operation;
            }
        }
        return customerOperations;
    }

    public static void SaveStatement(Scanner scanner) throws Exception {
        int customerId = 0;
        do {
            System.out.println("Customer: ");
            customerId = scanner.nextInt();
            scanner.nextLine();
        } while (customerId >= customersCount);

        customerOperationsCount[customerId] += 1;
        if (customerOperationsCount[customerId] > statement[customerId].length)
            throw new CustomerOperationOutOfBoundException(customerId, customerOperationsCount[customerId]);
        statement[customerId][customerOperationsCount[customerId] - 1] = operations[operationsCount - 1].getId();
    }
}