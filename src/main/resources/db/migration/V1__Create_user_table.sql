CREATE TABLE USER
(
    ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NAME varchar(50),
    TOKEN varchar(36),
    ACCOUNT_ID varchar(100),
    CREATE_TIME bigint,
    UPDATE_TIME bigint
);
COMMENT ON COLUMN USER.ID IS 'id';
COMMENT ON COLUMN USER.NAME IS '名称';
COMMENT ON COLUMN USER.ACCOUNT_ID IS '账户id';
COMMENT ON COLUMN USER.CREATE_TIME IS '创建时间';
COMMENT ON COLUMN USER.UPDATE_TIME IS '修改时间'