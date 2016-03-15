--CREATE DATABASE "case" ENCODING 'UTF8';
--CREATE USER rss WITH password 'rss';
CREATE SCHEMA rss;
--GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA rss TO rss;
CREATE TABLE rss.category (
  "id" SERIAL PRIMARY KEY,
  "name" varchar(30) DEFAULT NULL
);
insert INTO rss.category (name) VALUES('ыапыап11');
insert INTO rss.category (name) VALUES('sdfad11');
commit;
select * from rss.category;

CREATE SCHEMA rolo;
CREATE TABLE rolo.users (
  id SERIAL PRIMARY KEY,
  name varchar(30) NOT NULL,
  pass varchar(20) NOT NULL,
  mail varchar(50)
);
CREATE TABLE rolo.roles (
  id SERIAL PRIMARY KEY,
  code varchar(10) NOT NULL
 );
 CREATE TABLE rolo.urro (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL references rolo.users(id),
  role_id INTEGER NOT NULL references rolo.roles(id)
 );
 CREATE UNIQUE INDEX urro_unq ON rolo.urro (user_id,role_id);
 CREATE UNIQUE INDEX roles_unq ON rolo.roles (code);