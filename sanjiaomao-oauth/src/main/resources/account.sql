create table account(
    id bigint unsigned primary key auto_increment,
    username varchar(24) not null comment '用户名',
    password varchar(255) not null comment '密码',
    enable boolean not null default true,
    non_expired boolean not null default true,
    non_locked  boolean not null default true,
    credentials_non_expired boolean not null default true
) charset = utf8mb4;