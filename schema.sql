CREATE TABLE tb_clients (
    id SERIAL PRIMARY KEY,
    country VARCHAR(255),
    cpf VARCHAR(14),
    passport VARCHAR(255),
    full_name VARCHAR(255) NOT NULL,
    birth_date DATE,
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(255) NOT NULL
);

CREATE TABLE tb_services (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2),
    type VARCHAR(255)
);

CREATE TABLE tb_bookings (
    id SERIAL PRIMARY KEY,
    id_client INTEGER REFERENCES tb_clients(id),
    check_in_date DATE,
    check_out_date DATE,
    total_value NUMERIC(10, 2),
    guests INTEGER
);

CREATE TABLE services_booked (
    book_id INTEGER REFERENCES tb_bookings(id),
    service_id INTEGER REFERENCES tb_services(id),
    PRIMARY KEY (book_id, service_id)
);