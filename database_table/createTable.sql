use appliances;

drop table if exists role,userlogin,userInfo;

-- 用户角色
CREATE table role
(
    roleId   int         not null,
    roleName VARCHAR(12) not null,
    CONSTRAINT PK_roleId PRIMARY KEY (roleId)
);

INSERT into role
VALUES (1, '客户'),
       (2, '客服'),
       (3, '维修人员'),
       (4, '系统管理员');

-- 用户登录信息
CREATE table userlogin
(
    userId  int auto_increment,
    userPwd VARCHAR(128) not null,
    CONSTRAINT PK_userId PRIMARY KEY (userId)
) AUTO_INCREMENT 1001;

INSERT into userlogin
VALUES (DEFAULT, MD5('123')),
       (DEFAULT, MD5('123')),
       (DEFAULT, MD5('123')),
       (DEFAULT, MD5('456')),
       (DEFAULT, mD5('456')),
       (DEFAULT, MD5('456')),
       (DEFAULT, MD5('789')),
       (DEFAULT, MD5('789')),
       (DEFAULT, MD5('789'));


-- 用户基本信息
CREATE table userInfo
(
    userId     int         not null,
    roleId     int         not null,
    userName   varchar(32) not null,
    userPhone  varchar(32),
    userGender char(1) check (userGender = '男' or userGender = '女'),
    userBirth  VARCHAR(32),
    createDate datetime DEFAULT NOW(),
    updateDate datetime DEFAULT NOW(),
    CONSTRAINT FK_userId FOREIGN KEY (userId) REFERENCES userlogin (userId),
    CONSTRAINT FK_roleID FOREIGN KEY (roleId) REFERENCES role (roleId)
);

INSERT into userInfo
VALUES (1001, 1, '客户1', '14782577866', '男', '2020-02-03', DEFAULT, DEFAULT);
INSERT into userInfo(userId, roleId, userName)
VALUES (1002, 1, '客户2'),
       (1003, 3, '维修人员1'),
       (1004, 1, '客户3'),
       (1005, 1, '客户4'),
       (1006, 3, '维修人员2'),
       (1007, 4, '系统管理员'),
       (1008, 2, '客服1'),
       (1009, 2, '客服2');

# 产品表(固定)
create table goods
(
    goodsId   int auto_increment primary key,
    goodsName varchar(32),
    goodsInfo varchar(128)
) auto_increment 500;

#用户产品绑定
create table haveGoods
(
    goodsId int     not null,
    userId  int     not null,
    status  char(1) not null #1，已购买
);

# 请求维修的订单
create table requestPage(
    goodsId int not null ,
    userId int not null ,
    userAddr varchar(128) not null ,
    requestTime date not null
);

# 地址
create table userAddr(
    addrId int auto_increment,
    userId int not null ,
    省 varchar(8),
    市 varchar(8),
    区 varchar(8),
    详细 varchar(32),
    联系电话 varchar(32),
    CONSTRAINT PK_ADDRID primary key (addrId)
);







