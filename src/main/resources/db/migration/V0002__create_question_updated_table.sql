CREATE TABLE `question_updated_record`
(
    `question_id`      bigint      NOT NULL,
    `update_type`      varchar(50) NOT NULL,
    `updater_id`       varchar(50) NOT NULL,
    `updated_at`       datetime(3) NOT NULL,
    `reason`           text,
    `create_title`     text,
    `create_detail`    text,
    `edited_title`     text,
    `un_edited_title`  text,
    `edited_detail`    text,
    `un_edited_detail` text,
    `detail`           text,
    KEY `idx_question_id_hash` (`question_id`, `updated_at`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
