DROP TABLE user_roles IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP TABLE votes IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE restaurants IF EXISTS;

CREATE TABLE users
(
  id               INTEGER IDENTITY PRIMARY KEY,

  name             VARCHAR(255),
  email            VARCHAR(255)         NOT NULL,
  password         VARCHAR(255)         NOT NULL,
  registered       TIMESTAMP DEFAULT now(),
  enabled          BOOLEAN   DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);

CREATE TABLE user_roles
(
  user_id   INTEGER NOT NULL,
  role      VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY ( user_id ) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id          INTEGER IDENTITY PRIMARY KEY,
  name        VARCHAR(255)
);

CREATE TABLE votes
(
  id              INTEGER IDENTITY PRIMARY KEY,
  user_id         INTEGER NOT NULL,
  restaurant_id   INTEGER NOT NULL,
  date            DATE    NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE dishes
(
  id              INTEGER IDENTITY PRIMARY KEY,
  name            VARCHAR(255) NOT NULL,
  price           DOUBLE       NOT NULL,
  date            DATE         NOT NULL,
  restaurant_id   INTEGER      NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
