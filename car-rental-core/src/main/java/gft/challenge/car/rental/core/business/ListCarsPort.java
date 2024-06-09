package gft.challenge.car.rental.core.business;

import gft.challenge.car.rental.core.command.Command;
import gft.challenge.car.rental.domain.Car;

import java.util.List;

public interface ListCarsPort extends Command<List<Car>> {

}
