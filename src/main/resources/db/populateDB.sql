DELETE FROM roles;
DELETE FROM users;
DELETE FROM tickets;
DELETE FROM sites;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO roles (name) VALUES
  ('Admin'),
  ('User');

INSERT INTO users (login, name, password, role_id) VALUES
  ('User1', 'Ivan', 'password', 100001),
  ('User2', 'Ivan', 'password', 100001),
  ('Admin', 'Andrey', 'password', 100000);


INSERT INTO sites (name, user_id, role_id) VALUES
  ('vk.com', null, 100000),
  ('google.com', null, 100000),
  ('google.com', null, 100001),
  ('youtube.com', null, 100000),
  ('zoo.com', null, 100001);


INSERT INTO tickets (user_id, date_time, description, site_id) VALUES
  (100002, '2015-05-30 10:00:00', 'Example', 100005),
  (100002, '2015-06-30 18:00:00', 'Test', 100006),
  (100003, '2015-05-30 15:00:00', 'Test3', 100005),
  (100003, '2015-06-30 18:00:00', 'Test3', 100006);

