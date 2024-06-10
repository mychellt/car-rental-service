package gft.challenge.car.rental.core.persistence;

import gft.challenge.car.rental.domain.Rental;

public interface RentalRepositoryPort {
  Rental save(final Rental rental);
}
