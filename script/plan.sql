drop table if exists `plan`;
create table `plan`
(
    id         bigint unsigned primary key auto_increment,
    account_id bigint unsigned not null comment '账号',
    plan_name  varchar(20)     not null comment '姓名',
    content    varchar(512)    not null comment '年龄',
    start      datetime        not null comment '开始时间',
    end        datetime comment '结束时间',
    finished   varchar(20)     not null comment '计划状态'
) charset = utf8mb4;

create index idx_account on plan (account_id);