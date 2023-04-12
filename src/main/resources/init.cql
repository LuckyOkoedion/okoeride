CREATE TABLE customer (
id int PRIMARY KEY,
name text,
locationX int,
locationY int,
rideId int,
driverId int
);

CREATE TABLE driver (
    id int PRIMARY KEY,
    name text,
    locationX int,
    locationY int,
    customerId int,
    rideId int
);

CREATE TABLE geolocation (
    id int PRIMARY KEY,
    x int,
    y int,
    driverId int,
    customerId int
);

CREATE TABLE ride (
    id int PRIMARY KEY,
    customerId int,
    driverId int,
    driverXLocation int,
    driverYLocation int,
    destination text,
    driverAccepted boolean
);