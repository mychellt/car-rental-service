package gft.challenge.car.rental.core.messaging;

import gft.challenge.car.rental.domain.Rental;

public interface CarReservationConfirmationPublisherPort {
  void send(final Rental reservation);
}
