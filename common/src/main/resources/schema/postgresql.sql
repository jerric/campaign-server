DROP SEQUENCE IF EXISTS user_sequence;

CREATE SEQUENCE IF NOT EXISTS user_sequence AS bigint;


DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    user_id bigint PRIMARY KEY,
	email varchar(20) UNIQUE NOT NULL,
	password varchar(20) NOT NULL,
	user_name varchar(50) NOT NULL,
	is_activated bool,
	registered_time timestamp
);