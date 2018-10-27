DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS sites;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 100000;

CREATE TABLE user_roles
(
  id         INTEGER PRIMARY KEY DEFAULT nextval(' global_seq '),
  roles_name VARCHAR NOT NULL,
  CONSTRAINT user_roles_idx UNIQUE (roles_name)
);

CREATE TABLE users
(
  id       INTEGER PRIMARY KEY DEFAULT nextval(' global_seq '),
  login    VARCHAR    NOT NULL,
  name     VARCHAR    NOT NULL,
  password VARCHAR    NOT NULL,
  role_id  INTEGER NOT NULL,
  FOREIGN KEY (role_id) REFERENCES user_roles (id) ON DELETE CASCADE
);

CREATE TABLE sites
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq '),
  domain_name VARCHAR NOT NULL,
  user_id     INTEGER,
  role_id     INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES user_roles (id)
);

CREATE TABLE tickets
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq '),
  user_id     INTEGER   NOT NULL,
  date_time   TIMESTAMP NOT NULL,
  description TEXT      NOT NULL,
  site_id     INTEGER   NOT NULL,
  state       BOOLEAN             DEFAULT TRUE,
  FOREIGN KEY (site_id) REFERENCES sites(id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
