DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM tickets;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (login, role, name, password) VALUES

  ('User', 'User', 'Ivan', 'password'),
  ('Admin', 'Admin', 'Andrey', 'password');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO tickets (user_id, date_time, description, site) VALUES
  (100000, '2015-05-30 10:00:00', 'Example', 'vk.com'),
  (100000, '2015-05-30 13:00:00', 'Test', 'github.com'),
  (100000, '2015-05-30 15:00:00', 'Test', 'ok.ru'),
  (100000, '2015-05-30 17:00:00', 'Test', 'google.com'),
  (100000, '2015-05-31 12:00:00', 'Test', 'yandex.ru'),
  (100000, '2015-05-31 15:00:00', 'Test', 'youtube.com'),
  (100000, '2015-06-29 12:00:00', 'Test', 'github.com'),
  (100000, '2015-06-30 18:00:00', 'Test', 'github.com');