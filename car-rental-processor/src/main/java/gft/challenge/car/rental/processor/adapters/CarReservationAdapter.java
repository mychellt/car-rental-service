package gft.challenge.car.rental.processor.adapters;

import gft.challenge.car.rental.core.business.CarReservationPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.core.messaging.CarReservationConfirmationPublisherPort;
import gft.challenge.car.rental.core.persistence.RentalRepositoryPort;
import gft.challenge.car.rental.domain.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarReservationAdapter implements CarReservationPort {
  private final RentalRepositoryPort rentalRepositoryPort;
  private final CarReservationConfirmationPublisherPort carReservationConfirmationPublisherPort;

  @Autowired
  public CarReservationAdapter(final RentalRepositoryPort rentalRepositoryPort,
                               final CarReservationConfirmationPublisherPort carReservationConfirmationPublisherPort) {
    this.rentalRepositoryPort = rentalRepositoryPort;
    this.carReservationConfirmationPublisherPort = carReservationConfirmationPublisherPort;
  }

  @Override
  public Void process(Context context) {
    Rental rental = context.getData(Rental.class);
    rental.confirm();

    rental = rentalRepositoryPort.save(rental);

    return null;
  }
}
