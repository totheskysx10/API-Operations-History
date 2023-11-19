package ru.netology.vsurin;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
@Service
public class AsyncInputOperationService {

    private final StatementService statementService;
    private Queue<Operation> queue = new LinkedList<>();

    public AsyncInputOperationService(StatementService statementService) {
        this.statementService = statementService;
    }

    public boolean offerOperation(Operation operation) {
        return queue.offer(operation);
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation:" + operation);
                statementService.addOperation(operation);
                statementService.AddToStatement(operation.getClientId());
            }
        }
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();
            }
        };
        t.start();
    }

}
