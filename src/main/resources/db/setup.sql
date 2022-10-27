create database prod_db;

create user 'prod_user'@'localhost'identified by 'password';

grant all privileges on prod_db.* to 'prod_user'@'localhost';

flush privileges;