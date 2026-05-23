CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,

    name VARCHAR(100),

    email VARCHAR(100) UNIQUE NOT NULL,

    password VARCHAR(255),

    role VARCHAR(20),

    phone_number VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE passengers (
    id BIGINT PRIMARY KEY,

    home_address VARCHAR(255),

    CONSTRAINT fk_passenger_user
    FOREIGN KEY (id)
    REFERENCES users(id)
);

CREATE TABLE drivers (
    id BIGINT PRIMARY KEY,

    license_number VARCHAR(100),

    aadhaar_card VARCHAR(100),

    vehicle_number VARCHAR(100),

    vehicle_type VARCHAR(100),

    available BOOLEAN,

    CONSTRAINT fk_driver_user
    FOREIGN KEY (id)
    REFERENCES users(id)
);