

DROP TABLE IF EXISTS flight_details;
  
CREATE TABLE flight_details(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  flight_number VARCHAR(50) NOT NULL,
  airline_name VARCHAR(100) NOT NULL,
  arrival_time VARCHAR(50),
departure_time VARCHAR(50),
duration VARCHAR(50),
stops int,
price int NOT NULL
);