CREATE TABLE question
(
    id            bigint primary key auto_increment,
    questioner_id varchar(32) not null,
    title         TEXT        not null,
    detail        TEXT
);

create index idx_question_id_hash using hash on question (questioner_id);
