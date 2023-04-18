
CREATE TABLE IF NOT EXISTS customer (
id int PRIMARY KEY,
name text,
locationX int,
locationY int,
rideId int,
driverId int
);

CREATE TABLE IF NOT EXISTS driver (
    id int PRIMARY KEY,
    name text,
    locationX int,
    locationY int,
    customerId int,
    rideId int
);

CREATE TABLE IF NOT EXISTS geolocation (
    id int PRIMARY KEY,
    x int,
    y int,
    driverId int,
    customerId int
);

CREATE TABLE IF NOT EXISTS ride (
    id int PRIMARY KEY,
    customerId int,
    driverId int,
    driverXLocation int,
    driverYLocation int,
    driverName text,
    destination text,
    driverAccepted boolean
);


INSERT INTO the_ride.customer (id, name)
VALUES (1000, 'customer1')
IF NOT EXISTS;

INSERT INTO the_ride.customer (id, name)
VALUES (2000, 'customer2')
IF NOT EXISTS;

INSERT INTO the_ride.customer (id, name)
VALUES (3000, 'customer3')
IF NOT EXISTS;


INSERT INTO the_ride.driver (id, name)
VALUES (1000, 'driver1')
IF NOT EXISTS;

INSERT INTO the_ride.driver (id, name)
VALUES (2000, 'driver2')
IF NOT EXISTS;

INSERT INTO the_ride.driver (id, name)
VALUES (3000, 'driver3')
IF NOT EXISTS;

