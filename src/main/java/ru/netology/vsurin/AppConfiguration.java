package ru.netology.vsurin;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import ru.netology.vsurin.AsyncInputOperationService;
import ru.netology.vsurin.CustomerService;
import ru.netology.vsurin.StatementService;

import java.util.ArrayList;


@Configuration
@ComponentScan("ru.netology.vsurin")
public class AppConfiguration {
//    @Bean
//    public CustomerService customerService() {
//        return new CustomerService(new ArrayList<>());
//    }
//
//    @Bean
//    public AsyncInputOperationService asyncInputOperationService(StatementService statementService) {
//        return new AsyncInputOperationService(statementService);
//    }
//
//    @Bean
//    public StatementService statementService(CustomerService customerService) {
//        return new StatementService(customerService);
//    }
}
