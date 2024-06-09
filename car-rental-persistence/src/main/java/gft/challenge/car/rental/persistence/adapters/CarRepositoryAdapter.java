package gft.challenge.car.rental.persistence.adapters;

import gft.challenge.car.rental.core.persistence.CarRepositoryPort;
import gft.challenge.car.rental.domain.Car;
import gft.challenge.car.rental.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.car.rental.persistence.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarRepositoryAdapter implements CarRepositoryPort {
  private final CarRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public CarRepositoryAdapter(final CarRepository repository,
                              final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Car save(Car obj) {
    return mapper.from(repository.save(mapper.from(obj)));
  }

  @Override
  public Optional<Car> get(UUID id) {
    return repository.findById(id).map(mapper::from);
  }

  @Override
  public List<Car> getAll() {
    return repository.findAll()
        .stream()
        .map(mapper::from)
        .toList();
  }
}
