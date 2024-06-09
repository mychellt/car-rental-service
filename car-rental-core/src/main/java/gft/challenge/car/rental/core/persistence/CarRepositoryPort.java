package gft.challenge.car.rental.core.persistence;

import gft.challenge.car.rental.domain.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepositoryPort {
  void save(final Car obj);
  Optional<Car> get(final UUID id);
  List<Car> getAll();
}
