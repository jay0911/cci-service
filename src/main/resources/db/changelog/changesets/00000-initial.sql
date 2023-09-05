-- liquibase formatted sql

-- changeset johnoliveros:001-1
CREATE TABLE hibernate_sequence (next_val BIGINT NULL);

-- changeset johnoliveros:001-2
INSERT INTO hibernate_sequence (next_val) VALUES (1);

-- changeset johnoliveros:001-3
CREATE TABLE tbl_user (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_name varchar(255) null,
  first_name varchar(255) null,
  last_name varchar(255) null,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP
);

-- changeset johnoliveros:001-4
CREATE INDEX idx_username ON tbl_user(first_name,last_name,deleted_at);

-- changeset johnoliveros:001-5
CREATE TABLE tbl_task (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id bigint NOT NULL,
  task_name varchar(255) null,
  task_description varchar(255) null,
  date_time datetime DEFAULT NULL,
  `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `updated_at` DATETIME ON UPDATE CURRENT_TIMESTAMP
);

-- changeset johnoliveros:001-6
CREATE INDEX idx_task ON tbl_task(user_id,deleted_at);

