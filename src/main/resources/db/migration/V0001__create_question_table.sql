CREATE TABLE `question`
(
    `id`            bigint      NOT NULL AUTO_INCREMENT,
    `questioner_id` varchar(32) NOT NULL,
    `title`         text        NOT NULL,
    `detail`        text,
    PRIMARY KEY (`id`),
    KEY `idx_question_id_hash` (`questioner_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;