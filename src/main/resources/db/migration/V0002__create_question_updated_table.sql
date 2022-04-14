CREATE TABLE question_updated_record
(
    question_id      bigint      not null,
    update_type      varchar(50) not null,
    updater_id       varchar(50) not null,
    updated_at       datetime    not null,
    reason           text,
    create_title     text,
    create_detail    text,
    edited_title     text,
    un_edited_title  text,
    edited_detail    text,
    un_edited_detail text,
    detail           text
);
create index idx_question_id_hash using btree on question_updated_record (question_id, updated_at);
