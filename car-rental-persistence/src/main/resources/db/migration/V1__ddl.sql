CREATE TABLE IF NOT EXISTS cars (
     id UUID PRIMARY KEY,
     plate VARCHAR(255) NOT NULL,
     model VARCHAR(255),
     available BOOLEAN NOT NULL,
     price_per_day NUMERIC
);


CREATE TABLE IF NOT EXISTS rentals(
   id UUID PRIMARY KEY,
   status VARCHAR(50) NOT NULL,
   car_id UUID NOT NULL,
   travel_reservation_id UUID NOT NULL,
   pickup_date DATE,
   return_date DATE,
   FOREIGN KEY (car_id) REFERENCES cars(id)
);