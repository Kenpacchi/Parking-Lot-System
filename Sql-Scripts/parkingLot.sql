-- Parking Lot System SQL Scripts --

-- Vehicle Table

CREATE TABLE vehicle (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    vehicle_number VARCHAR(50) UNIQUE,
    length BIGINT,
    width BIGINT
);

select * from vehicles ;

-- Floor Table

CREATE TABLE floor (
    id SERIAL PRIMARY KEY,
    floor_number BIGINT,
    x BIGINT,
    y BIGINT
);

select * from floor;

-- Slot Table

CREATE TABLE slot (
    id SERIAL PRIMARY KEY,
    price_per_hour BIGINT,
    is_available BOOLEAN,
    floor_number BIGINT,
    x BIGINT,
    y BIGINT,
    length BIGINT,
    width BIGINT,
    customer_id BIGINT,
    floor_id BIGINT, -- FK to floor table
    CONSTRAINT fk_floor
        FOREIGN KEY (floor_id)
        REFERENCES floor(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

select * from slot;

-- Customer Table

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    mobile_number VARCHAR(20) UNIQUE,
    password VARCHAR(255),
    vehicle_id BIGINT UNIQUE,
    CONSTRAINT fk_vehicle
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicle(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

select * from customer ;
