package it.me.tae.workaroundboot;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableAdminServer
@SpringBootApplication
public class WorkAroundBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkAroundBootApplication.class, args);
    }

    @Bean
    public SmartInitializingSingleton importProcessor(EmployeeRepository repository) {
        return () -> {
            for (int i = 0; i < 10; i++) {
                Employee employee = new Employee();
                employee.setId(String.valueOf(i));
                employee.setName("name " + i);
                repository.save(employee);
            }
        };
    }

}
