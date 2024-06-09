package gft.challenge.car.rental.core.command;

public interface Command<R> {
    R process(final Context context);
}
