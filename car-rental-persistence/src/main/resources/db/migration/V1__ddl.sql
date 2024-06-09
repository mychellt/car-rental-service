CREATE TABLE IF NOT EXISTS customers (
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    id UUID PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS cars (
     id UUID PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     phone VARCHAR(20) NOT NULL,
     number_of_rooms INT NOT NULL,
     available_rooms INT
);


CREATE TABLE IF NOT EXISTS rentals(
   id UUID PRIMARY KEY,
   status VARCHAR(50) NOT NULL,
   car_id CHAR(36) NOT NULL,
   customer_id CHAR(36) NOT NULL,
   number_of_days INT NOT NULL,
   check_in_date DATE,
   check_out_date DATE,
   FOREIGN KEY (car_id) REFERENCES cars(id),
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);