drop table if exists account;
create table account
(
    id       bigint unsigned primary key auto_increment,
    username varchar(20) not null comment '账号',
    password varchar(64) not null comment '密码',
    nickname varchar(20) not null comment 'nickname'
) charset = utf8mb4;


create unique index uk_account on account (username);
