package gft.challenge.car.rental.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"gft.challenge.car.rental.persistence"})
@EntityScan(basePackages = {"gft.challenge.car.rental.persistence.model"})
@EnableJpaRepositories(basePackages = {"gft.challenge.car.rental.persistence"})
@EnableTransactionManagement
public class PersistenceConfiguration {

}
