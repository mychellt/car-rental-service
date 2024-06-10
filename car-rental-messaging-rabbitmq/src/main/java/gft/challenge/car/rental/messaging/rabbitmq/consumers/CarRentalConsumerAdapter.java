package gft.challenge.car.rental.messaging.rabbitmq.consumers;

import gft.challenge.car.rental.core.business.CarReservationPort;
import gft.challenge.car.rental.core.command.Context;
import gft.challenge.car.rental.domain.Car;
import gft.challenge.car.rental.domain.Rental;
import gft.challenge.car.rental.messaging.rabbitmq.model.CarReservationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarRentalConsumerAdapter {
  private final CarReservationPort carReservationPort;

  @Autowired
  public CarRentalConsumerAdapter(final CarReservationPort carReservationPort) {
    this.carReservationPort = carReservationPort;
  }

  @RabbitListener(queues = "${app.messaging.car-reservation-queue}")
  public void process(final CarReservationMessage message) {
    final Context context = new Context();

    final Rental rental =
        Rental.builder()
            .pickupDate(message.getPickupDate())
            .returnDate(message.getReturnDate())
            .travelReservationId(message.getTravelReservationId())
            .car(Car.builder()
                .plate(message.getPlate())
                .build())
            .build();

    context.setData(rental);
    carReservationPort.process(context);
  }
}
