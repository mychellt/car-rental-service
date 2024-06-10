package gft.challenge.car.rental.messaging.rabbitmq.publishers;

import gft.challenge.car.rental.core.messaging.CarReservationConfirmationPublisherPort;
import gft.challenge.car.rental.domain.Rental;
import gft.challenge.car.rental.messaging.rabbitmq.model.CarReservationConfirmationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class CarReservationConfirmationPublisherAdapter implements CarReservationConfirmationPublisherPort {
  @Value(value = "${app.messaging.car-reservation-confirmation-queue}")
  private String queue;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public CarReservationConfirmationPublisherAdapter(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(final Rental reservation) {
    CarReservationConfirmationMessage message =
        CarReservationConfirmationMessage.builder()
            .travelReservationId(reservation.getTravelReservationId())
            .date(LocalDateTime.now())
            .days(ChronoUnit.DAYS.between(reservation.getPickupDate(), reservation.getReturnDate()))
            .build();
    rabbitTemplate.convertAndSend(queue, message);
  }
}
