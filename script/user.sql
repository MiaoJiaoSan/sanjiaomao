drop table if exists `user`;
create table `user`
(
    id         bigint unsigned primary key auto_increment,
    account_id bigint unsigned not null comment '账号',
    name       varchar(20)     not null comment '姓名',
    age        int unsigned    not null comment '年龄',
    gender     varchar(20)     not null comment '性别',
    id_card    varchar(20)     not null comment 'idCard',
    mobile     varchar(20)     not null comment '移动电话',
    email      varchar(20)     not null comment '邮箱'
) charset = utf8mb4;

create index idx_account on user (account_id);