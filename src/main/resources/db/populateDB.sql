DELETE FROM roles;
DELETE FROM users;
DELETE FROM tickets;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO roles (name) VALUES
  ('Admin'),
  ('User');

INSERT INTO users (login, name, password, role_id) VALUES
  ('User', 'Ivan', 'password', 100000),
  ('Admin', 'Andrey', 'password', 100001);


INSERT INTO sites (name, user_id, role_id) VALUES
  ('vk.com', null, 100000),
  ('github.com', null, 100001),
  ('google.com', null, 100000),
  ('google.com', null, 100001),
  ('youtube.com', null, 100000),
  ('zoo.com', null, 100001);


INSERT INTO tickets (user_id, date_time, description, site_id) VALUES
  (100002, '2015-05-30 10:00:00', 'Example', 100005),
  (100002, '2015-05-30 15:00:00', 'Test', 100005),
  (100002, '2015-05-31 15:00:00', 'Test', 100006),
  (100002, '2015-06-30 18:00:00', 'Test', 100006);

