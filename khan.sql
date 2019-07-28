create table clientdetails
(
    appId                  varchar(128)  not null
        primary key,
    resourceIds            varchar(128)  null,
    appSecret              varchar(128)  null,
    scope                  varchar(128)  null,
    grantTypes             varchar(128)  null,
    redirectUrl            varchar(128)  null,
    authorities            varchar(128)  null,
    access_token_validity  int           null,
    refresh_token_validity int           null,
    additionalInformation  varchar(4096) null,
    autoApproveScopes      varchar(128)  null
)
    collate = utf8mb4_general_ci;

create table menus
(
    id    varchar(32)  not null
        primary key,
    name  varchar(20)  null,
    url   varchar(128) null,
    icon  varchar(256) null,
    state int(1)       null
);

create table oauth_access_token
(
    token_id          varchar(128) null,
    token             blob         null,
    authentication_id varchar(128) not null
        primary key,
    user_name         varchar(128) null,
    client_id         varchar(128) null,
    authentication    blob         null,
    refresh_token     varchar(128) null
)
    collate = utf8mb4_general_ci;

create table oauth_approvals
(
    userId         varchar(128) null,
    clientId       varchar(128) null,
    scope          varchar(128) null,
    status         varchar(10)  null,
    expiresAt      timestamp    null,
    lastModifiedAt timestamp    null
)
    collate = utf8mb4_general_ci;

create table oauth_client_details
(
    client_id               varchar(128)  not null
        primary key,
    resource_ids            varchar(128)  null,
    client_secret           varchar(128)  null,
    scope                   varchar(128)  null,
    authorized_grant_types  varchar(128)  null,
    web_server_redirect_uri varchar(128)  null,
    authorities             varchar(128)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(128)  null
)
    collate = utf8mb4_general_ci;

create table oauth_client_token
(
    token_id          varchar(128) null,
    token             blob         null,
    authentication_id varchar(128) not null
        primary key,
    user_name         varchar(128) null,
    client_id         varchar(128) null
)
    collate = utf8mb4_general_ci;

create table oauth_code
(
    code           varchar(128) null,
    authentication blob         null
)
    collate = utf8mb4_general_ci;

create table oauth_refresh_token
(
    token_id       varchar(128) null,
    token          blob         null,
    authentication blob         null
)
    collate = utf8mb4_general_ci;

create table role_menus
(
    id       varchar(32) not null
        primary key,
    role_id  varchar(32) null,
    menus_id varchar(32) null
);

create table roles
(
    id       varchar(32) not null
        primary key,
    rolename varchar(20) null,
    role_key varchar(20) null
);

create table user_role
(
    id      varchar(32) not null
        primary key,
    user_id varchar(32) null,
    role_id varchar(32) null
);

create table users
(
    id       int auto_increment
        primary key,
    username varchar(20)  null,
    password varchar(128) null,
    enabled  int(1)       null
)
    comment '用户表';

