CREATE TABLE IF NOT EXISTS doctor
(
    doctor_id UUID PRIMARY KEY,
    first_name varchar(32) NOT NULL,
    last_name varchar(32) NOT NULL,
    gender varchar(16) NOT NULL,
    email varchar(128) UNIQUE NOT NULL,
    phone_number varchar(64) NOT NULL,
    specialization text NOT NULL,
    rating numeric(2,1) NOT NULL DEFAULT 0.0,
    schedule text NOT NULL
);

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'a0288931-e496-4211-9f09-0b9962256579',
       'Will',
       'Otkins',
       'MALE',
       'otkindr@example.com',
       '+1 (442) 803-9122',
       'Cardiologist',
       0.0,
       'From Monday to Friday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'a0288931-e496-4211-9f09-0b9962256579');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       'Lesley',
       'Grey',
       'FEMALE',
       'thelesley@example.com',
       '+1 (040) 431-9920',
       'Dermatologist',
       0.0,
       'From Monday to Tuesday, From 9:00 AM to 16:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '56a3f48c-bca3-4b60-ac48-6db4ed9382ad');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       'Debra',
       'Winslow',
       'FEMALE',
       'debrrradr@example.com',
       '+1 (391) 671-9332',
       'Ophthalmologist',
       0.0,
       'From Monday to Friday, From 9:00 AM to 17:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '9fd8827b-7bd9-49a0-b58b-85fdb11548ff');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       'Harvey',
       'Duma',
       'MALE',
       'harveyjob@example.com',
       '+1 (201) 920-4352',
       'Dentist',
       0.0,
       'From Monday to Friday, From 10:00 AM to 17:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'c088b336-b7a1-4aca-a6be-e7d48ab3109f');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'bffe3ab9-973c-4d04-9363-5f754ad228d6',
       'Emma',
       'Montgomery',
       'FEMALE',
       'emmabaddie@example.com',
       '+1 (328) 030-1392',
       'Neurologist',
       0.0,
       'From Monday to Friday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'bffe3ab9-973c-4d04-9363-5f754ad228d6');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       'Michael',
       'De Veil',
       'MALE',
       'jobmail3michael@example.com',
       '+1 (320) 934-1220',
       'Orthopedic',
       0.0,
       'From Tuesday to Friday, From 11:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'bffe3ab9-973c-4d04-9363-5f754ad228d6');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '657cd99a-9657-4cf8-983a-5447334c4d92',
       'Becky',
       'Norse',
       'FEMALE',
       'mailforbecky3@example.com',
       '+1 (442) 945-0390',
       'Gastroenterologist',
       0.0,
       'From Monday to Thursday, From 10:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '657cd99a-9657-4cf8-983a-5447334c4d92');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       'Mitch',
       'Wilnowski',
       'MALE',
       'mitchfor@example.com',
       '+1 (040) 117-7437',
       'Surgeon',
       0.0,
       'From Tuesday to Friday, From 11:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '329ddbb2-8b50-4ecb-8455-0aeaed91216c');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'bd3eb373-dd02-4a82-a892-8559cff3f2bf',
       'Sarah',
       'Tober',
       'FEMALE',
       'lilsh@example.com',
       '+1 (040) 267-4409',
       'Pediatrician',
       0.0,
       'From Monday to Friday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'bd3eb373-dd02-4a82-a892-8559cff3f2bf');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       'Jamal',
       'Novis',
       'MALE',
       'hood4life@example.com',
       '+1 (201) 071-9213',
       'Nephrologist',
       0.0,
       'From Monday to Wednesday, Friday, From 10:00 AM to 16:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'a9450e5a-5a4e-4c50-9a11-823ba37f7c33',
       'Chun',
       'Ki',
       'FEMALE',
       'yellowinblood@example.com',
       '+1 (399) 129-2925',
       'Oncologist',
       0.0,
       'From Monday to Wednesday, From 10:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'a9450e5a-5a4e-4c50-9a11-823ba37f7c33');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5',
       'Kyle',
       'Norrington',
       'MALE',
       'gigaman@example.com',
       '+1 (440) 870-3625',
       'Oncologist',
       0.0,
       'From Thursday to Friday, From 10:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '792b60bc-f394-4eb5-ad44-90fc9e142ca8',
       'Nora',
       'De Santa',
       'FEMALE',
       'bestdr@example.com',
       '+1 (440) 029-8885',
       'Pulmonologist',
       0.0,
       'From Tuesday to Wednesday, From 9:00 AM to 16:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '792b60bc-f394-4eb5-ad44-90fc9e142ca8');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'd7975181-a93b-4a81-85fe-64067c44ff02',
       'Evelynn',
       'Anzer',
       'FEMALE',
       'deutcshstill@example.com',
       '+1 (201) 855-0945',
       'Gynaecologist',
       0.0,
       'From Monday to Friday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'd7975181-a93b-4a81-85fe-64067c44ff02');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '25f4e613-af3b-41f4-8f99-f4b619b642d1',
       'Mark',
       'Hollow',
       'MALE',
       'mrkforjobonly@example.com',
       '+1 (440) 447-0349',
       'Hepatologist',
       0.0,
       'From Tuesday to Wednesday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '25f4e613-af3b-41f4-8f99-f4b619b642d1');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '4809e1a7-7dec-43b0-b5f2-d2eb303455b8',
       'Derek',
       'Whales',
       'MALE',
       'mrkfjfcjobonly@example.com',
       '+1 (440) 410-0559',
       'Hepatologist',
       0.0,
       'From Thursday to Friday, From 9:00 AM to 18:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '4809e1a7-7dec-43b0-b5f2-d2eb303455b8');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '9943502e-0c8d-48e7-a610-f0c990c02b4e',
       'Courtney',
       'Bright',
       'FEMALE',
       'asbrightassun@example.com',
       '+1 (201) 202-4399',
       'Psychiatrist',
       0.0,
       'From Monday to Friday, From 9:00 AM to 17:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '9943502e-0c8d-48e7-a610-f0c990c02b4e');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT 'df5e1e5a-857e-4d7a-83ad-66f211af9a61',
       'Brian',
       'Locks',
       'MALE',
       'pulmforjob@example.com',
       '+1 (440) 293-4342',
       'Pulmonologist',
       0.0,
       'From Thursday to Friday, From 9:00 AM to 16:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'df5e1e5a-857e-4d7a-83ad-66f211af9a61');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, schedule)
SELECT '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       'Agnieszka',
       'Biawa',
       'FEMALE',
       'thelesley@example.com',
       '+1 (399) 443-7229',
       'Dermatologist',
       0.0,
       'From Thursday to Friday, From 9:00 AM to 16:00 PM'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '56a3f48c-bca3-4b60-ac48-6db4ed9382ad');
