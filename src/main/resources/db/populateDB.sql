DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM tickets;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO user_roles (roles_name) VALUES
  ('Admin'),
  ('User');

INSERT INTO users (login, name, password, role_id) VALUES

  ('User', 'Ivan', 'password',100000),
  ('Admin', 'Andrey', 'password',100001);


INSERT INTO sites (domain_name, user_id, role_id) VALUES
  ('vk.com', null , 100000),
  ('github.com',null,100001),
  ('google.com',null,100000),
  ('google.com',null,100001),
  ('youtube.com',100003,100000);


INSERT INTO tickets (user_id, date_time, description, site_id) VALUES
  (100002, '2015-05-30 10:00:00', 'Example', 100004),
  (100003, '2015-05-30 13:00:00', 'Test', 100004),
  (100002, '2015-05-30 15:00:00', 'Test', 100005),
  (100003, '2015-05-30 17:00:00', 'Test', 100006),
  (100003, '2015-05-31 12:00:00', 'Test', 100007),
  (100002, '2015-05-31 15:00:00', 'Test', 100006),
  (100003, '2015-06-29 12:00:00', 'Test', 100004),
  (100002, '2015-06-30 18:00:00', 'Test', 100006);

