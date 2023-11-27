package ru.netology.vsurin.service;

import org.springframework.stereotype.Component;
import ru.netology.vsurin.configuration.OperationProperties;
import ru.netology.vsurin.controller.dto.OperationDTO;
import ru.netology.vsurin.domain.Operation;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;
@Component
public class AsyncInputOperationService {

    private final StatementService statementService;
    private final OperationProperties operationProperties;
    private Queue<Operation> queue = new LinkedList<>();

    public AsyncInputOperationService(StatementService statementService, OperationProperties operationProperties) {
        this.statementService = statementService;
        this.operationProperties = operationProperties;
    }

    public Operation offerOperation(Operation operation) {
        queue.offer(operation);
        return operation;
    }

    @PostConstruct
    public void init(){
        this.startAsyncOperationProcessing();
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();
            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(operationProperties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation: " + operation);
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
