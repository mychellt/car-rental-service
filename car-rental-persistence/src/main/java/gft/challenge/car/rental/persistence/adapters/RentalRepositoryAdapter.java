package gft.challenge.car.rental.persistence.adapters;

import gft.challenge.car.rental.core.persistence.RentalRepositoryPort;
import gft.challenge.car.rental.domain.Rental;
import gft.challenge.car.rental.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.car.rental.persistence.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentalRepositoryAdapter implements RentalRepositoryPort {
  private final RentalRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public RentalRepositoryAdapter(final RentalRepository repository, final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Rental save(Rental rental) {
      return mapper.from(repository.save(mapper.from(rental)));
  }
}
