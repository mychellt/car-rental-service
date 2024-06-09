package gft.challenge.car.rental.persistence.repository;

import gft.challenge.car.rental.persistence.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, UUID> {

}
