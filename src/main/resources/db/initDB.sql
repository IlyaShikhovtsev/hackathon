DROP TABLE IF EXISTS user_roles CASCADE ;
DROP TABLE  IF EXISTS users CASCADE ;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS sites;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  login TEXT NOT NULL,
  name TEXT NOT NULL,
  password TEXT NOT NULL
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  roles    TEXT PRIMARY KEY,
  CONSTRAINT user_roles_idx UNIQUE (user_id, roles),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE tickets
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id INTEGER NOT NULL,
  date_time TIMESTAMP  NOT NULL,
  description TEXT NOT NULL,
  site_id INTEGER NOT NULL,
  state BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE sites
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  domain_name TEXT NOT NULL,
  user_id INTEGER,
  roles_name TEXT,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (roles_name) REFERENCES user_roles (roles) ON DELETE CASCADE
);