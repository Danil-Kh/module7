Create database IF NOT EXISTS MegaSoftTest12;

use MegaSoftTest12;

Create table worker1(
    ID integer auto_increment PRIMARY KEY,
    NAME varchar(1000) not null check (
        LENGTH(NAME) >= 2 and LENGTH(NAME) <= 1000
        ),
    BIRTHDAY year
        check ( BIRTHDAY > 1900),
    LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior'),
    SALARY integer CHECK (SALARY >= 100 and SALARY <= 100000)

);
Create table client1(
    ID integer auto_increment PRIMARY KEY,
    NAME varchar(1000) not null
        check (LENGTH(NAME) >= 2 and LENGTH(NAME) <= 1000)

);
Create table project1(
    ID integer auto_increment PRIMARY KEY,
    CLIENT_ID integer,
    START_DATE DATE,
    FINISH_DATE DATE
);
Create table project_worker1(
    PROJECT_ID integer,
    WORKER_ID integer,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
        FOREIGN KEY (PROJECT_ID) REFERENCES project1(ID),
        FOREIGN KEY (WORKER_ID) REFERENCES worker1(ID)
);

ALTER TABLE project1
ADD CONSTRAINT CLIENT_ID_FK1
FOREIGN KEY (CLIENT_ID)
REFERENCES client1(ID);

