create table int_lock
(
    lock_key     varchar(36)  not null
        primary key,
    region       varchar(100) not null,
    client_id    varchar(36)  null,
    created_date datetime     null,
    constraint lock_pk
        unique (lock_key, region)
);