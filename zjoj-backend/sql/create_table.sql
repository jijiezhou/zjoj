# Initialization of Database

-- Create database
create database if not exists zjoj;

-- Change database
use zjoj;

-- User table
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment 'user account',
    userPassword varchar(512)                           not null comment 'password',
    unionId      varchar(256)                           null comment 'wechat union id',
    mpOpenId     varchar(256)                           null comment 'openId',
    userName     varchar(256)                           null comment 'username',
    userAvatar   varchar(1024)                          null comment 'user avatar',
    userProfile  varchar(512)                           null comment 'user profile',
    userRole     varchar(256) default 'user'            not null comment 'user role：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'create time',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete     tinyint      default 0                 not null comment 'flag of is delete',
    index idx_unionId (unionId)
) comment 'user' collate = utf8mb4_unicode_ci;

-- post table
create table if not exists post
(
    id         bigint auto_increment comment 'id' primary key,
    title      varchar(512)                       null comment 'title',
    content    text                               null comment 'content',
    tags       varchar(1024)                      null comment 'tag array（json array）',
    thumbNum   int      default 0                 not null comment 'like number',
    favourNum  int      default 0                 not null comment 'favour number',
    userId     bigint                             not null comment 'user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'create time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    isDelete   tinyint  default 0                 not null comment 'flag of delete or not',
    index idx_userId (userId)
) comment 'post' collate = utf8mb4_unicode_ci;

-- post_thumb (hard delete)
create table if not exists post_thumb
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'create time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post thumb';

-- post_favour(hard delete)
create table if not exists post_favour
(
    id         bigint auto_increment comment 'id' primary key,
    postId     bigint                             not null comment 'post id',
    userId     bigint                             not null comment 'user id',
    createTime datetime default CURRENT_TIMESTAMP not null comment 'create time',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'update time',
    index idx_postId (postId),
    index idx_userId (userId)
) comment 'post favour';
