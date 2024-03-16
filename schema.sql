CREATE TABLE tb_additional (
                               id BIGINT NOT NULL,
                               name VARCHAR(255),
                               description TEXT,
                               price DOUBLE PRECISION,
                               type VARCHAR(255),
                               PRIMARY KEY (id)
);
CREATE TABLE tb_clients (
                            id BIGINT NOT NULL,
                            country VARCHAR(255),
                            cpf VARCHAR(255),
                            passport VARCHAR(255),
                            fullName VARCHAR(255),
                            birthDate DATE,
                            address VARCHAR(255),
                            phone VARCHAR(255),
                            email VARCHAR(255),
                            PRIMARY KEY (id)
);
CREATE TABLE tb_location (
                             id BIGINT NOT NULL,
                             name VARCHAR(255),
                             address VARCHAR(255),
                             zipCode VARCHAR(255),
                             city VARCHAR(255),
                             state VARCHAR(255),
                             PRIMARY KEY (id)
);


CREATE TABLE tb_building (
                             id BIGINT NOT NULL,
                             location_id BIGINT,
                             name VARCHAR(255),
                             PRIMARY KEY (id),
                             FOREIGN KEY (location_id) REFERENCES tb_location(id)
);





CREATE TABLE tb_room (
                         id BIGINT NOT NULL,
                         building_id BIGINT,
                         location_id BIGINT,
                         type VARCHAR(255),
                         totalPeople INT,
                         totalBeds INT,
                         otherFurniture VARCHAR(255),
                         bathroom VARCHAR(255),
                         dailyRate DOUBLE PRECISION,
                         PRIMARY KEY (id),
                         FOREIGN KEY (building_id) REFERENCES tb_building(id),
                         FOREIGN KEY (location_id) REFERENCES tb_location(id)
);

CREATE TABLE tb_bookings (
                             id BIGINT NOT NULL,
                             id_client BIGINT,
                             checkInDate DATE,
                             checkOutDate DATE,
                             totalValue DOUBLE PRECISION,
                             guests INT,
                             PRIMARY KEY (id),
                             FOREIGN KEY (id_client) REFERENCES tb_clients(id)
);

CREATE TABLE rooms_booked (
                              book_id BIGINT NOT NULL,
                              room_id BIGINT NOT NULL,
                              PRIMARY KEY (book_id, room_id),
                              FOREIGN KEY (book_id) REFERENCES tb_bookings(id),
                              FOREIGN KEY (room_id) REFERENCES tb_room(id)
);

CREATE TABLE services_booked (
                                 book_id BIGINT NOT NULL,
                                 service_id BIGINT NOT NULL,
                                 PRIMARY KEY (book_id, service_id),
                                 FOREIGN KEY (book_id) REFERENCES tb_bookings(id),
                                 FOREIGN KEY (service_id) REFERENCES tb_additional(id)
);
