-- liquibase formatted sql

-- changeset johnoliveros:001-7
ALTER TABLE tbl_task add COLUMN status ENUM('pending','done') default 'pending';

-- changeset johnoliveros:001-8
CREATE TABLE shedlock (
  name VARCHAR(64),
  lock_until TIMESTAMP(3) NULL,
  locked_at TIMESTAMP(3) NULL,
  locked_by VARCHAR(255),
  PRIMARY KEY (name)
);