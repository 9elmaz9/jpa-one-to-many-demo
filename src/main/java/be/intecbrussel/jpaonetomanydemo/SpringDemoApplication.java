package be.intecbrussel.jpaonetomanydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing  // Аннотация @EnableJpaAuditing включает поддержку автоматического аудита JPA.

@SpringBootApplication  // Аннотация @SpringBootApplication объединяет несколько аннотаций для удобства конфигурации Spring Boot приложения.

public class SpringDemoApplication {

    public static void main(String[] args) {
        // Основной метод, который запускает приложение Spring.
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
