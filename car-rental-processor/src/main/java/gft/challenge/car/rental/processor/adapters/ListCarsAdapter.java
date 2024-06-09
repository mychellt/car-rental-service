package gft.challenge.car.rental.processor.adapters;

import gft.challenge.car.rental.core.business.ListCarsPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.core.persistence.CarRepositoryPort;
import gft.challenge.car.rental.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCarsAdapter implements ListCarsPort {
  private final CarRepositoryPort repository;

  @Autowired
  public ListCarsAdapter(CarRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public List<Car> process(Context context) {
    return repository.getAll();
  }
}
