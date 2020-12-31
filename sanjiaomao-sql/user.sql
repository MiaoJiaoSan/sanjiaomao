create table user
(
    id      bigint unsigned auto_increment primary key,
    name    varchar(20)     default '' not null comment '姓名',
    age     int unsigned    default 0  not null comment '年龄',
    gender  int unsigned comment '性别',
    id_card varchar(64)     default '' not null comment '身份证',
    version bigint unsigned default 0  not null comment 'version'
) charset utf8mb4 comment '用户';

drop table account;
create table account
(
    id       bigint unsigned auto_increment primary key,
    username varchar(20)                not null comment '账号',
    password varchar(20)                not null comment '密码',
    nickname varchar(20)                not null comment 'nickname',
    email    varchar(64)     default '' not null comment '邮箱',
    phone    varchar(64)     default '' not null comment '电话',
    photo    blob comment '图片',
    version  bigint unsigned default 0  not null comment 'version'
) charset utf8mb4 comment '账号';


create table act_user_rel
(
    id      bigint unsigned auto_increment primary key,
    user_id bigint unsigned           not null,
    act_id  bigint unsigned           not null,
    version bigint unsigned default 0 not null comment 'version'
) charset utf8mb4 comment '账号用户关系';

create table role
(
    id      bigint unsigned auto_increment primary key,
    name    varchar(20)               not null comment '角色名称',
    version bigint unsigned default 0 not null comment 'version'
) charset utf8mb4 comment '角色';

create table act_role_rel
(
    id      bigint unsigned auto_increment primary key,
    act_id  bigint unsigned           not null comment '账号',
    role_id bigint unsigned           not null comment '角色id',
    version bigint unsigned default 0 not null comment 'version'
) charset utf8mb4 comment '账号角色关系';