package gft.challenge.car.rental.processor.adapters;

import gft.challenge.car.rental.core.business.CreateCarPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.core.persistence.CarRepositoryPort;
import gft.challenge.car.rental.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCarAdapter implements CreateCarPort {
  private final CarRepositoryPort repository;

  @Autowired
  public CreateCarAdapter(final CarRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Car process(Context context) {
    final Car car = context.getData(Car.class);
    return repository.save(car);
  }
}
