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
    doctor_status varchar(32) NOT NULL
);

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'a0288931-e496-4211-9f09-0b9962256579',
       'Will',
       'Otkins',
       'MALE',
       'otkindr@example.com',
       '+1 (442) 803-9122',
       'Cardiologist',
       0.0,
       'ACTIVE'

WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'a0288931-e496-4211-9f09-0b9962256579');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       'Lesley',
       'Grey',
       'FEMALE',
       'thelesley@example.com',
       '+1 (040) 431-9920',
       'Dermatologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '56a3f48c-bca3-4b60-ac48-6db4ed9382ad');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       'Debra',
       'Winslow',
       'FEMALE',
       'debrrradr@example.com',
       '+1 (391) 671-9332',
       'Ophthalmologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '9fd8827b-7bd9-49a0-b58b-85fdb11548ff');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       'Harvey',
       'Duma',
       'MALE',
       'harveyjob@example.com',
       '+1 (201) 920-4352',
       'Dentist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'c088b336-b7a1-4aca-a6be-e7d48ab3109f');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'bffe3ab9-973c-4d04-9363-5f754ad228d6',
       'Emma',
       'Montgomery',
       'FEMALE',
       'emmabaddie@example.com',
       '+1 (328) 030-1392',
       'Neurologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'bffe3ab9-973c-4d04-9363-5f754ad228d6');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       'Michael',
       'De Veil',
       'MALE',
       'jobmail3michael@example.com',
       '+1 (320) 934-1220',
       'Orthopedic',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'f29b9a6f-628b-41a7-8816-758a6a3e67a2');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '657cd99a-9657-4cf8-983a-5447334c4d92',
       'Becky',
       'Norse',
       'FEMALE',
       'mailforbecky3@example.com',
       '+1 (442) 945-0390',
       'Gastroenterologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '657cd99a-9657-4cf8-983a-5447334c4d92');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       'Mitch',
       'Wilnowski',
       'MALE',
       'mitchfor@example.com',
       '+1 (040) 117-7437',
       'Surgeon',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '329ddbb2-8b50-4ecb-8455-0aeaed91216c');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'bd3eb373-dd02-4a82-a892-8559cff3f2bf',
       'Sarah',
       'Tober',
       'FEMALE',
       'lilsh@example.com',
       '+1 (040) 267-4409',
       'Pediatrician',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'bd3eb373-dd02-4a82-a892-8559cff3f2bf');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       'Jamal',
       'Novis',
       'MALE',
       'hood4life@example.com',
       '+1 (201) 071-9213',
       'Nephrologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'a9450e5a-5a4e-4c50-9a11-823ba37f7c33',
       'Chun',
       'Ki',
       'FEMALE',
       'yellowinblood@example.com',
       '+1 (399) 129-2925',
       'Oncologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'a9450e5a-5a4e-4c50-9a11-823ba37f7c33');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5',
       'Kyle',
       'Norrington',
       'MALE',
       'gigaman@example.com',
       '+1 (440) 870-3625',
       'Oncologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '792b60bc-f394-4eb5-ad44-90fc9e142ca8',
       'Nora',
       'De Santa',
       'FEMALE',
       'bestdr@example.com',
       '+1 (440) 029-8885',
       'Pulmonologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '792b60bc-f394-4eb5-ad44-90fc9e142ca8');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'd7975181-a93b-4a81-85fe-64067c44ff02',
       'Evelynn',
       'Anzer',
       'FEMALE',
       'deutcshstill@example.com',
       '+1 (201) 855-0945',
       'Gynaecologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'd7975181-a93b-4a81-85fe-64067c44ff02');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '25f4e613-af3b-41f4-8f99-f4b619b642d1',
       'Mark',
       'Hollow',
       'MALE',
       'mrkforjobonly@example.com',
       '+1 (440) 447-0349',
       'Hepatologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '25f4e613-af3b-41f4-8f99-f4b619b642d1');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '4809e1a7-7dec-43b0-b5f2-d2eb303455b8',
       'Derek',
       'Whales',
       'MALE',
       'mrkfjfcjobonly@example.com',
       '+1 (440) 410-0559',
       'Hepatologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '4809e1a7-7dec-43b0-b5f2-d2eb303455b8');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '9943502e-0c8d-48e7-a610-f0c990c02b4e',
       'Courtney',
       'Bright',
       'FEMALE',
       'asbrightassun@example.com',
       '+1 (201) 202-4399',
       'Psychiatrist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '9943502e-0c8d-48e7-a610-f0c990c02b4e');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'df5e1e5a-857e-4d7a-83ad-66f211af9a61',
       'Brian',
       'Locks',
       'MALE',
       'pulmforjob@example.com',
       '+1 (440) 293-4342',
       'Pulmonologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'df5e1e5a-857e-4d7a-83ad-66f211af9a61');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT 'f8428687-779d-432e-908b-8926a267081a',
       'Agnieszka',
       'Biawa',
       'FEMALE',
       'theagnthebest@example.com',
       '+1 (399) 443-7229',
       'Dermatologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = 'f8428687-779d-432e-908b-8926a267081a');

INSERT INTO doctor (doctor_id, first_name, last_name, gender, email, phone_number, specialization, rating, doctor_status)
SELECT '048a27f9-08e1-4032-aac8-bdbd85f051c8',
       'Claude',
       'Fort',
       'OTHER',
       'thespecialone@example.com',
       '+1 (201) 310-7170',
       'Cardiologist',
       0.0,
       'ACTIVE'
WHERE NOT EXISTS (SELECT 1 FROM doctor WHERE doctor_id = '048a27f9-08e1-4032-aac8-bdbd85f051c8');

CREATE TABLE IF NOT EXISTS schedule
(
    schedule_id UUID PRIMARY KEY,
    doctor_id UUID NOT NULL REFERENCES doctor(doctor_id),
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    schedule_date DATE NOT NULL,
    break_start_time TIME NOT NULL,
    break_end_time TIME NOT NULL,
    is_day_off BOOLEAN NOT NULL,
    day_of_week VARCHAR(16) NOT NULL
);

--Will Otkins
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '12915ab0-0193-406c-a3c2-4202ac1d24c5',
       'a0288931-e496-4211-9f09-0b9962256579',
       '08:00:00',
       '16:00:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '12915ab0-0193-406c-a3c2-4202ac1d24c5');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '0c1c3f5a-23b8-4b31-a2d8-4dd8fc85c2f9',
       'a0288931-e496-4211-9f09-0b9962256579',
       '10:00:00',
       '16:00:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '0c1c3f5a-23b8-4b31-a2d8-4dd8fc85c2f9');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'fbd10663-d8f1-434d-bd60-df8369fca291',
       'a0288931-e496-4211-9f09-0b9962256579',
       '10:00:00',
       '16:00:00',
       '2026-02-05',
       '13:00:00',
       '14:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'fbd10663-d8f1-434d-bd60-df8369fca291');

--Lesley Gray
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '19a756a9-a49c-4ed9-9120-ac44ef2dfc57',
       '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       '09:00:00',
       '15:00:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '19a756a9-a49c-4ed9-9120-ac44ef2dfc57');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'b83e7af8-3793-478d-acbe-b8345bc610ca',
       '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       '09:00:00',
       '16:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'b83e7af8-3793-478d-acbe-b8345bc610ca');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'ea9e5268-5bf5-4f6f-a5fc-8dafd9df5d77',
       '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       '08:30:00',
       '15:30:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'ea9e5268-5bf5-4f6f-a5fc-8dafd9df5d77');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '5b6e10e3-3689-4d70-9bce-196266e42644',
       '56a3f48c-bca3-4b60-ac48-6db4ed9382ad',
       '11:00:00',
       '17:00:00',
       '2026-02-05',
       '13:00:00',
       '14:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '5b6e10e3-3689-4d70-9bce-196266e42644');

--Debra Winslow
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'ae4a94c1-0ae0-459b-95b6-797a8b04fda0',
       '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       '09:00:00',
       '16:30:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'ae4a94c1-0ae0-459b-95b6-797a8b04fda0');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '191c4f67-0fa5-47dc-bfd6-24bec3265cee',
       '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       '09:30:00',
       '16:00:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '191c4f67-0fa5-47dc-bfd6-24bec3265cee');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'fbf34eb8-27c4-4f72-aa6c-ff9fcc82999c',
       '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       '09:00:00',
       '16:30:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'fbf34eb8-27c4-4f72-aa6c-ff9fcc82999c');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '7c4aa882-8590-4d91-9612-75c9402991e1',
       '9fd8827b-7bd9-49a0-b58b-85fdb11548ff',
       '12:00:00',
       '16:30:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '7c4aa882-8590-4d91-9612-75c9402991e1');

--Harvey Duma
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '150598ee-4468-4785-af7c-d3c5d630ac44',
       'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       '10:00:00',
       '16:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '150598ee-4468-4785-af7c-d3c5d630ac44');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'be8c4efb-1abd-42ae-82a6-b46124bc0eac',
       'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       '10:00:00',
       '16:30:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'be8c4efb-1abd-42ae-82a6-b46124bc0eac');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'e4c8484f-ee8e-46cd-b208-b66b91952c28',
       'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       '10:00:00',
       '16:30:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'e4c8484f-ee8e-46cd-b208-b66b91952c28');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'fdc8e309-a39b-47d1-b273-69e31e65a470',
       'c088b336-b7a1-4aca-a6be-e7d48ab3109f',
       '11:00:00',
       '16:30:00',
       '2026-02-05',
       '13:00:00',
       '14:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'fdc8e309-a39b-47d1-b273-69e31e65a470');

--Emma Montgomery
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '3d4fa72a-d6dd-463f-933d-69d807b453ac',
       'bffe3ab9-973c-4d04-9363-5f754ad228d6',
       '08:00:00',
       '15:30:00',
       '2026-02-01',
       '12:00:00',
       '13:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '3d4fa72a-d6dd-463f-933d-69d807b453ac');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '67457017-9218-4e62-83a8-1f16f85a724a',
       'bffe3ab9-973c-4d04-9363-5f754ad228d6',
       '08:00:00',
       '15:30:00',
       '2026-02-03',
       '12:00:00',
       '13:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '67457017-9218-4e62-83a8-1f16f85a724a');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '7c38736d-6e6f-4b2b-a476-40f6a867575d',
       'bffe3ab9-973c-4d04-9363-5f754ad228d6',
       '08:00:00',
       '16:30:00',
       '2026-02-05',
       '12:00:00',
       '13:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '7c38736d-6e6f-4b2b-a476-40f6a867575d');

--Michael De Veil
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'bc54adfd-216f-4061-baf0-9db2f5184785',
       'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       '09:00:00',
       '16:00:00',
       '2026-02-01',
       '12:00:00',
       '13:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'bc54adfd-216f-4061-baf0-9db2f5184785');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'd8ec4938-c08a-40e1-a0ff-df1f17d25a90',
       'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       '10:00:00',
       '17:00:00',
       '2026-02-02',
       '14:00:00',
       '15:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'd8ec4938-c08a-40e1-a0ff-df1f17d25a90');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'e4737de8-ef74-43d7-b40b-aec25f6f0aaf',
       'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       '09:00:00',
       '16:00:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'e4737de8-ef74-43d7-b40b-aec25f6f0aaf');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'da490ea1-8b01-4b75-b1e9-82f53447863f',
       'f29b9a6f-628b-41a7-8816-758a6a3e67a2',
       '11:00:00',
       '16:00:00',
       '2026-02-05',
       '14:00:00',
       '15:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'da490ea1-8b01-4b75-b1e9-82f53447863f');

--Becky Norse
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'be667435-2628-457e-ae62-23b1245241d6',
       '657cd99a-9657-4cf8-983a-5447334c4d92',
       '09:20:00',
       '15:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'be667435-2628-457e-ae62-23b1245241d6');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'b470796b-0366-4765-b1cf-8938b3e6c398',
       '657cd99a-9657-4cf8-983a-5447334c4d92',
       '09:00:00',
       '16:30:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'b470796b-0366-4765-b1cf-8938b3e6c398');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '9f996d4c-04c5-48ee-a662-f8ac07811436',
       '657cd99a-9657-4cf8-983a-5447334c4d92',
       '11:00:00',
       '16:30:00',
       '2026-02-04',
       '14:00:00',
       '15:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '9f996d4c-04c5-48ee-a662-f8ac07811436');

--Mitch Wilnowsky
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '9f996d4c-04c5-48ee-a662-f8ac07811436',
       '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       '10:00:00',
       '16:30:00',
       '2026-02-01',
       '14:00:00',
       '15:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '9f996d4c-04c5-48ee-a662-f8ac07811436');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '0b2ecb7f-3732-4217-b180-13e7e00c82a2',
       '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       '10:00:00',
       '16:30:00',
       '2026-02-02',
       '14:00:00',
       '15:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '0b2ecb7f-3732-4217-b180-13e7e00c82a2');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'a8bc4096-388b-4d14-8dd4-0f76a9e9bdc3',
       '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       '10:00:00',
       '16:30:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'a8bc4096-388b-4d14-8dd4-0f76a9e9bdc3');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'ebcd3ce5-2456-421c-a491-b89c2103cd23',
       '329ddbb2-8b50-4ecb-8455-0aeaed91216c',
       '10:00:00',
       '16:30:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'ebcd3ce5-2456-421c-a491-b89c2103cd23');

--Sarah Tober
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'ebcd3ce5-2456-421c-a491-b89c2103cd23',
       'bd3eb373-dd02-4a82-a892-8559cff3f2bf',
       '09:00:00',
       '16:00:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'ebcd3ce5-2456-421c-a491-b89c2103cd23');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '736ae825-0f4b-4d43-8080-a4dbd8cac2ef',
       'bd3eb373-dd02-4a82-a892-8559cff3f2bf',
       '09:00:00',
       '16:00:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '736ae825-0f4b-4d43-8080-a4dbd8cac2ef');

--Jamal Novis
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'be6e04f5-f534-4c6c-a12f-fb51c9647dfb',
       '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       '09:00:00',
       '16:00:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'be6e04f5-f534-4c6c-a12f-fb51c9647dfb');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '776d8e3f-19ee-4f67-8ce7-7901b31e415a',
       '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       '10:00:00',
       '16:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '776d8e3f-19ee-4f67-8ce7-7901b31e415a');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '64804cf0-2897-4614-aa79-8e4524a17a8d',
       '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       '09:00:00',
       '16:00:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '64804cf0-2897-4614-aa79-8e4524a17a8d');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'dc5841b5-08d6-4c63-b536-b43e779858b1',
       '7c49389c-5694-4dea-8cc3-2f2e2db4e1b6',
       '11:00:00',
       '15:30:00',
       '2026-02-05',
       '13:30:00',
       '14:30:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'dc5841b5-08d6-4c63-b536-b43e779858b1');

--Chun Ki
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'f172f2a4-08d5-494e-8936-f26473ccec96',
       'a9450e5a-5a4e-4c50-9a11-823ba37f7c33',
       '09:00:00',
       '15:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'f172f2a4-08d5-494e-8936-f26473ccec96');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'f172f2a4-08d5-494e-8936-f26473ccec96',
       'a9450e5a-5a4e-4c50-9a11-823ba37f7c33',
       '11:00:00',
       '15:30:00',
       '2026-02-05',
       '13:30:00',
       '14:30:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'f172f2a4-08d5-494e-8936-f26473ccec96');

--Kyle Norrington
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '51da0d77-a4bd-4f11-8335-66ffa6d39c67',
       'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5',
       '09:00:00',
       '15:30:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '51da0d77-a4bd-4f11-8335-66ffa6d39c67');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'e5a982ee-c550-4802-982a-50dfd0981e13',
       'b88c1bc0-4b7b-4cf9-836b-e6c176f2f1a5',
       '10:00:00',
       '16:30:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'e5a982ee-c550-4802-982a-50dfd0981e13');

--Nora De Santa
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'd706ffed-62e0-4097-819d-d2c07be16d25',
       '792b60bc-f394-4eb5-ad44-90fc9e142ca8',
       '10:00:00',
       '16:30:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'e5a982ee-c550-4802-982a-50dfd0981e13');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'd8a805a8-550d-4b8f-aef6-7bea1a7d8911',
       '792b60bc-f394-4eb5-ad44-90fc9e142ca8',
       '10:00:00',
       '16:45:00',
       '2026-02-03',
       '13:30:00',
       '14:30:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'd8a805a8-550d-4b8f-aef6-7bea1a7d8911');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '6646f51c-98cb-48dc-8e44-4dad84f7a779',
       '792b60bc-f394-4eb5-ad44-90fc9e142ca8',
       '12:00:00',
       '17:00:00',
       '2026-02-05',
       '14:30:00',
       '15:30:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '6646f51c-98cb-48dc-8e44-4dad84f7a779');

--Evelynn Anzer

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'cb83277a-a839-43c2-bccc-f74dc9be038a',
       'd7975181-a93b-4a81-85fe-64067c44ff02',
       '09:00:00',
       '16:00:00',
       '2026-02-02',
       '13:30:00',
       '14:30:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'cb83277a-a839-43c2-bccc-f74dc9be038a');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '9eb39cb0-ee94-4f1a-b64b-d1754c7d685e',
       'd7975181-a93b-4a81-85fe-64067c44ff02',
       '12:00:00',
       '17:00:00',
       '2026-02-03',
       '14:30:00',
       '15:30:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '9eb39cb0-ee94-4f1a-b64b-d1754c7d685e');

--Mark Hollow
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '61fe30f1-10e0-47a5-a725-b140d49e2013',
       '25f4e613-af3b-41f4-8f99-f4b619b642d1',
       '09:45:00',
       '16:00:00',
       '2026-02-01',
       '13:30:00',
       '14:30:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '61fe30f1-10e0-47a5-a725-b140d49e2013');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '431b4b71-ec20-4b7c-8f0f-ac54cdfd1b3c',
       '25f4e613-af3b-41f4-8f99-f4b619b642d1',
       '12:00:00',
       '16:20:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '431b4b71-ec20-4b7c-8f0f-ac54cdfd1b3c');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '5a4f4f78-1a14-482c-8e45-0638c8053325',
       '25f4e613-af3b-41f4-8f99-f4b619b642d1',
       '09:00:00',
       '16:30:00',
       '2026-02-05',
       '13:00:00',
       '14:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '5a4f4f78-1a14-482c-8e45-0638c8053325');

--Derek Whales
INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '05a9b622-03ee-441b-b4e7-4018f1307e34',
       '4809e1a7-7dec-43b0-b5f2-d2eb303455b8',
       '09:00:00',
       '16:30:00',
       '2026-02-02',
       '13:00:00',
       '14:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '05a9b622-03ee-441b-b4e7-4018f1307e34');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '92c47884-148b-40cd-9952-9272c6f81562',
       '4809e1a7-7dec-43b0-b5f2-d2eb303455b8',
       '09:00:00',
       '16:30:00',
       '2026-02-04',
       '13:00:00',
       '14:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '92c47884-148b-40cd-9952-9272c6f81562');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'c98f0457-93dc-43b8-9fd8-42acb12d1f11',
       '9943502e-0c8d-48e7-a610-f0c990c02b4e',
       '09:00:00',
       '17:00:00',
       '2026-02-01',
       '13:00:00',
       '14:00:00',
       FALSE,
       'MONDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'c98f0457-93dc-43b8-9fd8-42acb12d1f11');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'b8c56d1a-f1f2-4c5a-aef1-60b64c2c9d55',
       '9943502e-0c8d-48e7-a610-f0c990c02b4e',
       '09:00:00',
       '17:00:00',
       '2026-02-03',
       '13:00:00',
       '14:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'b8c56d1a-f1f2-4c5a-aef1-60b64c2c9d55');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '6dc7a523-95dc-4c20-b9d3-0d2a6f7b1b24',
       '9943502e-0c8d-48e7-a610-f0c990c02b4e',
       '10:00:00',
       '14:00:00',
       '2026-02-05',
       '12:00:00',
       '13:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '6dc7a523-95dc-4c20-b9d3-0d2a6f7b1b24');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '9d6c3c7d-2a9d-45da-95d8-1a6e6b21c591',
       'df5e1e5a-857e-4d7a-83ad-66f211af9a61',
       '08:00:00',
       '16:00:00',
       '2026-02-02',
       '12:00:00',
       '13:00:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '9d6c3c7d-2a9d-45da-95d8-1a6e6b21c591');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'd13f72a7-2387-4f2a-99cb-53f9bc3a89b1',
       'df5e1e5a-857e-4d7a-83ad-66f211af9a61',
       '08:00:00',
       '14:00:00',
       '2026-02-04',
       '12:00:00',
       '13:00:00',
       FALSE,
       'THURSDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'd13f72a7-2387-4f2a-99cb-53f9bc3a89b1');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'f0bc94c4-8b47-478f-9efb-26f5e07c30d1',
       'df5e1e5a-857e-4d7a-83ad-66f211af9a61',
       '09:00:00',
       '13:00:00',
       '2026-02-06',
       '12:00:00',
       '13:00:00',
       FALSE,
       'SATURDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'f0bc94c4-8b47-478f-9efb-26f5e07c30d1');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'c341b83d-d46b-4a34-84b2-bf34a9f0e3ee',
       'f8428687-779d-432e-908b-8926a267081a',
       '09:00:00',
       '16:00:00',
       '2026-02-03',
       '12:00:00',
       '13:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'c341b83d-d46b-4a34-84b2-bf34a9f0e3ee');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'f85ad5b0-c91e-4c33-bd72-82b94de9a91f',
       'f8428687-779d-432e-908b-8926a267081a',
       '10:00:00',
       '15:00:00',
       '2026-02-05',
       '12:00:00',
       '13:00:00',
       FALSE,
       'FRIDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'f85ad5b0-c91e-4c33-bd72-82b94de9a91f');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT '135f11ce-db6e-4154-a774-85f3ca567f26',
       '048a27f9-08e1-4032-aac8-bdbd85f051c8',
       '08:25:00',
       '16:00:00',
       '2026-02-02',
       '12:00:00',
       '13:30:00',
       FALSE,
       'TUESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = '135f11ce-db6e-4154-a774-85f3ca567f26');

INSERT INTO schedule (schedule_id, doctor_id, start_time, end_time, schedule_date, break_start_time, break_end_time, is_day_off, day_of_week)
SELECT 'e6a70fa1-7816-4dc0-889e-1bce9a67a385',
       '048a27f9-08e1-4032-aac8-bdbd85f051c8',
       '12:00:00',
       '17:00:00',
       '2026-02-03',
       '14:00:00',
       '15:00:00',
       FALSE,
       'WEDNESDAY'
WHERE NOT EXISTS (SELECT 1 FROM schedule WHERE schedule_id = 'e6a70fa1-7816-4dc0-889e-1bce9a67a385');




