DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM tickets;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (login, name, password) VALUES

  ('User', 'Ivan', 'password'),
  ('Admin', 'Andrey', 'password');

INSERT INTO user_roles (roles, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO sites (domain_name, user_id, roles_name) VALUES
  ('vk.com', null , 'ROLE_USER'),
  ('github.com',null,'ROLE_ADMIN'),
  ('google.com',null,'ROLE_USER'),
  ('yandex.ru',null,'ROLE_USER'),
  ('youtube.com',null,'ROLE_ADMIN');


INSERT INTO tickets (user_id, date_time, description, site_id) VALUES
  (100000, '2015-05-30 10:00:00', 'Example', 100003),
  (100000, '2015-05-30 13:00:00', 'Test', 100004),
  (100000, '2015-05-30 15:00:00', 'Test', 100005),
  (100000, '2015-05-30 17:00:00', 'Test', 100006),
  (100000, '2015-05-31 12:00:00', 'Test', 100003),
  (100000, '2015-05-31 15:00:00', 'Test', 100006),
  (100000, '2015-06-29 12:00:00', 'Test', 100004),
  (100000, '2015-06-30 18:00:00', 'Test', 100006);

