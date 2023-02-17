INSERT INTO profiles (id_profile, profile, phone, address, city) VALUES (default, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '619619619', 'c/ No lo sé, 14', 'Gijón')
INSERT INTO profiles (id_profile, profile, phone, address, city) VALUES (default, 'Nullam nulla nibh, dapibus id commodo a, sagittis vitae odio.', '555555555', 'c/ No lo sé, 14', 'Gijón')

INSERT INTO patients (dni, name, lastname, birthdate, profile_id_profile) VALUES ('1234546578l', 'Uno', 'Dos', '2013-01-01', 1)
INSERT INTO patients (dni, name, lastname, birthdate, profile_id_profile) VALUES ('0999', 'One', 'Two', '2013-02-02', 2)
INSERT INTO patients (dni, name, lastname, birthdate, profile_id_profile) VALUES ('8753221l', 'Une', 'Due', '2013-03-03', null)
INSERT INTO patients (dni, name, lastname, birthdate, profile_id_profile) VALUES ('3434343434l', 'Eleven', 'Twelve', '2013-04-04', null)

INSERT INTO treatments (id_treatment, treatment) VALUES (default, 'Tratamiento 1')
INSERT INTO treatments (id_treatment, treatment) VALUES (default, 'Tratamiento 2')
INSERT INTO treatments (id_treatment, treatment) VALUES (default, 'Tratamiento 3')
INSERT INTO treatments (id_treatment, treatment) VALUES (default, 'Tratamiento 4')
INSERT INTO treatments (id_treatment, treatment) VALUES (default, 'Tratamiento 5')

INSERT INTO patients_treatments (treatments_id_treatment, patient_dni) VALUES (1, '1234546578l')
INSERT INTO patients_treatments (treatments_id_treatment, patient_dni) VALUES (3, '1234546578l')
INSERT INTO patients_treatments (treatments_id_treatment, patient_dni) VALUES (4, '1234546578l')
INSERT INTO patients_treatments (treatments_id_treatment, patient_dni) VALUES (2, '0999')
INSERT INTO patients_treatments (treatments_id_treatment, patient_dni) VALUES (5, '0999')