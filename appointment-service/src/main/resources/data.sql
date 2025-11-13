CREATE TABLE IF NOT EXISTS patients
(
    id UUID PRIMARY KEY,
    first_name varchar(128) NOT NULL,
    last_name varchar(128) NOT NULL,
    gender varchar(16) NOT NULL,
    weight double precision NOT NULL,
    height double precision NOT NULL,
    email varchar(128) UNIQUE  NOT NULL,
    phone_number varchar(128) UNIQUE NOT NULL,
    date_of_birth DATE NOT NULL,
    address varchar(128) NOT NULL,
    registered_date DATE
);

CREATE TABLE IF NOT EXISTS doctor
(
    id UUID PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    gender varchar(16) NOT NULL,
    email varchar(128) UNIQUE NOT NULL,
    phone_number varchar(64) NOT NULL,
    specialization text NOT NULL,
    rating numeric(2,1) NOT NULL DEFAULT 0.0,
    schedule text NOT NULL
);

CREATE TABLE IF NOT EXISTS appointment
(
    appointment_id UUID PRIMARY KEY,
    patient_id UUID NOT NULL,
    doctor_id UUID NOT NULL,
    reason text NOT NULL,
    date text NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctor(id)
);