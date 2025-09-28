-- Schema: core
CREATE SCHEMA IF NOT EXISTS core;

CREATE TABLE IF NOT EXISTS core.owners (
  owner_id SERIAL PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  phone VARCHAR(20),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Schema: booking
CREATE SCHEMA IF NOT EXISTS booking;

CREATE TABLE IF NOT EXISTS core.pets (
   pet_id SERIAL PRIMARY KEY,
   owner_id INT REFERENCES core.owners(owner_id) ON DELETE CASCADE,
   name VARCHAR(50) NOT NULL,
   species VARCHAR(50),
   breed VARCHAR(50),
   age INT,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS booking.vets (
  vet_id SERIAL PRIMARY KEY,
  full_name VARCHAR(100) NOT NULL,
  specialization VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  phone VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS booking.appointments (
  appointment_id SERIAL PRIMARY KEY,
  pet_id INT REFERENCES core.pets(pet_id) ON DELETE CASCADE,
  vet_id INT REFERENCES booking.vets(vet_id) ON DELETE SET NULL,
  appointment_time TIMESTAMP NOT NULL,
  notes TEXT,
  status VARCHAR(20) DEFAULT 'SCHEDULED'
);

-- Seed
INSERT INTO core.owners (full_name, email, phone) VALUES
('John Smith','john.smith@email.com','555-0101'),
('Sarah Johnson','sarah.j@email.com','555-0102'),
('Mike Wilson','mike.w@email.com','555-0103');

INSERT INTO core.pets (owner_id,name,species,breed,age) VALUES
(1,'Buddy','Dog','Golden Retriever',3),
(1,'Whiskers','Cat','Persian',2),
(2,'Max','Dog','German Shepherd',5),
(3,'Luna','Cat','Siamese',1);

INSERT INTO booking.vets (full_name,specialization,email,phone) VALUES
('Dr. Emily Brown','General Practice','dr.brown@vetclinic.com','555-0201'),
('Dr. James Davis','Surgery','dr.davis@vetclinic.com','555-0202'),
('Dr. Lisa Garcia','Dermatology','dr.garcia@vetclinic.com','555-0203');

INSERT INTO booking.appointments (pet_id,vet_id,appointment_time,notes,status) VALUES
(1,1,'2025-10-01 10:00:00','Annual checkup','SCHEDULED'),
(2,2,'2025-10-02 14:30:00','Vaccination','SCHEDULED'),
(3,1,'2025-10-03 09:15:00','Health examination','COMPLETED'),
(4,3,'2025-10-04 16:00:00','Skin condition check','SCHEDULED');
