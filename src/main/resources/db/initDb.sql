DROP TABLE IF EXISTS records;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE records (
        id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
        account INTEGER,
        call_duration time not null,
        call_id INTEGER,
        call_start timestamp not null,
        called_number varchar(20),
        caller varchar(25),
        continuation boolean,
        dialed_number varchar(20),
        direction varchar(1),
        hold_time INTEGER,
        is_internal bool,
        park_time INTEGER,
        party1_device varchar(5),
        party1_name varchar(15),
        party2_device varchar(5),
        party2_name varchar(15),
        ring_duration INTEGER
)