DROP TABLE IF EXISTS person;
CREATE TABLE person
(
    id serial constraint id primary key,
    given_name varchar(50),
    sure_name varchar(50)
);