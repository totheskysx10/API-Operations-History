package ru.netology.vsurin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        AsyncInputOperationService asyncInputOperationService = applicationContext.getBean(AsyncInputOperationService.class);
        asyncInputOperationService.startAsyncOperationProcessing();
    }
}