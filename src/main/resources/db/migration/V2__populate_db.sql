INSERT INTO CLIENT(NAME)
VALUES ('Flora'),
       ( 'Fauna'),
       ( 'John'),
       ( 'Emma'),
       ( 'Liam'),
       ( 'Olivia'),
       ( 'William'),
       ( 'Sophia'),
       ( 'James'),
       ('Isabella'),
       ('Michael');

INSERT INTO PLANET (ID, NAME)
VALUES ('MARS', 'Mars'),
       ('VEN', 'Venera'),
       ('JUP', 'Jupiter'),
       ('SAT', 'Saturn'),
       ('URA', 'Uranus'),
       ('NEP', 'Neptune'),
       ('EAR', 'Earth'),
       ('PLU', 'Pluto');



INSERT INTO TICKET (CREATED_AT, CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID)
VALUES
  ('2023-08-10 12:00:00', 1, 'MARS', 'VEN'),
  ('2023-08-10 13:00:00', 2, 'VEN', 'MARS'),
  ('2023-08-10 14:00:00', 3, 'EAR', 'MARS'),
  ('2023-08-10 15:00:00', 4, 'SAT', 'JUP'),
  ('2023-08-10 16:00:00', 5, 'MARS', 'EAR'),
  ('2023-08-10 17:00:00', 6, 'JUP', 'SAT'),
  ('2023-08-10 18:00:00', 7, 'VEN', 'EAR'),
  ('2023-08-10 19:00:00', 8, 'MARS', 'SAT'),
  ('2023-08-10 20:00:00', 9, 'EAR', 'VEN'),
  ('2023-08-10 21:00:00', 10, 'SAT', 'VEN');


