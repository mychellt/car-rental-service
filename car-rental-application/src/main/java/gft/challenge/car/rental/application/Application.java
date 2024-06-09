package gft.challenge.car.rental.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "gft.challenge.car.rental")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
