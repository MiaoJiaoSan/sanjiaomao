drop table if exists `user`;
create table `user`(
    id bigint unsigned primary key auto_increment,
    account varchar(20) not null comment '账号',
    id_card varchar(20) not null comment 'idCard'
) charset=utf8mb4;