-- auto-generated definition
create table oauth_client_details
(
    client_id               varchar(256)  not null
        primary key,
    resource_ids            varchar(256)  null,
    client_secret           varchar(256)  null,
    scope                   varchar(256)  null,
    authorized_grant_types  varchar(256)  null,
    web_server_redirect_uri varchar(256)  null,
    authorities             varchar(256)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
)
    charset = utf8mb4;

insert into oauth_client_details values ('sanjiaomao','user','{bcrypt}$2a$10$rKiOqfW/8OzFUAQQNlimdewK1I5WF3xqQLEldwNqBtwr9b3b7/ff6','all','password,refresh_token',null,null,1200,50000,null,null);