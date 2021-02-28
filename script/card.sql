drop table if exists `card`;
create table `card`
(
    id        bigint unsigned primary key auto_increment,
    plan_id   bigint unsigned not null comment '账号',
    card_date datetime        not null comment '打卡时间',
    start     datetime        not null comment '开始时间',
    end       datetime comment '结束时间',
    remark    varchar(256)    not null default '' comment '备注'
) charset = utf8mb4;

create index idx_account on card (plan_id);