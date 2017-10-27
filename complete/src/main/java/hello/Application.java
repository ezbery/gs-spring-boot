package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");

            log.info("Costumers found by id:");
            for (Customer id1 : repository.findById((long) 2)) {
                log.info(id1.toString());
            }
        };
    }

    @Bean
    public CommandLineRunner testUser(UserRepository leRepository) {
        return (args) -> {
            leRepository.save(new Userer("Test"));
            leRepository.save(new Userer("Test 2"));
            leRepository.save(new Userer("Test 3"));
            // fetch all Users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (Userer userer : leRepository.findAll()) {
                log.info(userer.toString());
            }
            log.info("");

            // fetch an individual userer by ID
            Userer userer = leRepository.findOne(6L);
            log.info("Userer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(userer.toString());
            log.info("");

            // fetch users by last name
            log.info("Userer found with findByLastName('Test'):");
            log.info("--------------------------------------------");
            for (Userer test : leRepository.findByName("Test")) {
                log.info(test.toString());
            }
            log.info("");

            log.info("Users found by id:");
            for (Userer id1 : leRepository.findById((long) 6)) {
                log.info(id1.toString());
            }
        };
    }
}

