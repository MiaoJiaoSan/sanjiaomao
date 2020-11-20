create table account
(
    id                      bigint unsigned primary key auto_increment,
    username                varchar(24)  not null comment '用户名',
    password                varchar(255) not null comment '密码',
    enable                  boolean      not null default true,
    non_expired             boolean      not null default true,
    non_locked              boolean      not null default true,
    credentials_non_expired boolean      not null default true
) charset = utf8mb4;

create table oauth_access_token
(
    token_id          varchar(256) null comment '加密的access_token的值',
    token             blob         null comment 'OAuth2AccessToken.java对象序列化后的二进制数据',
    authentication_id varchar(256) not null comment '加密过的username,client_id,scope'
        primary key,
    user_name         varchar(256) null comment '登录的用户名',
    client_id         varchar(256) null comment '客户端ID',
    authentication    blob         null comment 'OAuth2Authentication.java对象序列化后的二进制数据',
    refresh_token     varchar(256) null comment '加密后的refresh_token的值'
)
    comment '访问令牌' charset = utf8;

create table oauth_approvals
(
    userId         varchar(256) null comment '登录的用户名',
    clientId       varchar(256) null comment '客户端ID',
    scope          varchar(256) null comment '申请的权限',
    status         varchar(10)  null comment '状态(Approve或Deny)',
    expiresAt      datetime     null comment '过期时间',
    lastModifiedAt datetime     null comment '最终修改时间'
)
    comment '授权记录' charset = utf8;

create table oauth_client_details
(
    client_id               varchar(128)  not null comment '客户端ID'
        primary key,
    resource_ids            varchar(256)  null comment '资源ID集合，多个资源时用英文逗号分隔',
    client_secret           varchar(256)  null comment '客户端密匙',
    scope                   varchar(256)  null comment '客户端申请的权限范围',
    authorized_grant_types  varchar(256)  null comment '客户端支持的grant_type',
    web_server_redirect_uri varchar(256)  null comment '重定向URI',
    authorities             varchar(256)  null comment '客户端所拥有的SpringSecurity的权限值，多个用英文逗号分隔',
    access_token_validity   int           null comment '访问令牌有效时间值(单位秒)',
    refresh_token_validity  int           null comment '更新令牌有效时间值(单位秒)',
    additional_information  varchar(4096) null comment '预留字段',
    autoapprove             varchar(256)  null comment '用户是否自动Approval操作'
)
    comment '客户端信息' charset = utf8;

create table oauth_client_token
(
    token_id          varchar(256) null comment '加密的access_token值',
    token             blob         null comment 'OAuth2AccessToken.java对象序列化后的二进制数据',
    authentication_id varchar(128) not null comment '加密过的username,client_id,scope'
        primary key,
    user_name         varchar(256) null comment '登录的用户名',
    client_id         varchar(256) null comment '客户端ID'
)
    comment '该表用于在客户端系统中存储从服务端获取的token数据' charset = utf8;

create table oauth_code
(
    code           varchar(256) null comment '授权码(未加密)',
    authentication blob         null comment 'AuthorizationRequestHolder.java对象序列化后的二进制数据'
)
    comment '授权码' charset = utf8;

create table oauth_refresh_token
(
    token_id       varchar(256) null comment '加密过的refresh_token的值',
    token          blob         null comment 'OAuth2RefreshToken.java对象序列化后的二进制数据',
    authentication blob         null comment 'OAuth2Authentication.java对象序列化后的二进制数据'
)
    comment '更新令牌' charset = utf8;

create table oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);

create table oauth_client_token
(
    token_id          VARCHAR(256),
    token LONGVARBINARY,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256)
);

create table oauth_access_token
(
    token_id          VARCHAR(256),
    token LONGVARBINARY,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication LONGVARBINARY,
    refresh_token     VARCHAR(256)
);

create table oauth_refresh_token
(
    token_id VARCHAR(256),
    token LONGVARBINARY,
    authentication LONGVARBINARY
);

create table oauth_code
(
    code VARCHAR(256),
    authentication LONGVARBINARY
);

create table oauth_approvals
(
    userId         VARCHAR(256),
    clientId       VARCHAR(256),
    scope          VARCHAR(256),
    status         VARCHAR(10),
    expiresAt      TIMESTAMP,
    lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails
(
    appId                  VARCHAR(256) PRIMARY KEY,
    resourceIds            VARCHAR(256),
    appSecret              VARCHAR(256),
    scope                  VARCHAR(256),
    grantTypes             VARCHAR(256),
    redirectUrl            VARCHAR(256),
    authorities            VARCHAR(256),
    access_token_validity  INTEGER,
    refresh_token_validity INTEGER,
    additionalInformation  VARCHAR(4096),
    autoApproveScopes      VARCHAR(256)
);