package gft.challenge.car.rental.processor.adapters;

import gft.challenge.car.rental.core.business.ConsultCarPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.core.persistence.CarRepositoryPort;
import gft.challenge.car.rental.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultCarAdapter implements ConsultCarPort {
  private final CarRepositoryPort repository;

  @Autowired
  public ConsultCarAdapter(final CarRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Car> process(Context context) {
    final UUID id = context.getData(UUID.class);
    return repository.get(id);
  }
}
