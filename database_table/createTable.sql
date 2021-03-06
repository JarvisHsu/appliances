use appliances;
drop table if exists PayAccount,haveGoods,requestPage,userAddr;
drop table if exists goods,role,userlogin,userInfo;

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

drop procedure if exists proc_userLogin;
delimiter $
create procedure proc_userLogin()
BEGIN
    DECLARE i int default 1;
    while i < 10
        do
            INSERT into userlogin VALUES (DEFAULT, MD5('192837'));
            set i = i + 1;
        end while;
end;
call proc_userLogin();

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
VALUES (1001, 1, '客户1', '14782577866', '男', '2000-01-15', DEFAULT, DEFAULT),
       (1005, 2, '客服1', '19829817502', '男', '1995-06-23', DEFAULT, DEFAULT),
       (1007, 3, '维修人员1', '18327937220', '男', '2001-12-15', DEFAULT, DEFAULT),
       (1009, 4, '系统管理员', '13387902648', '男', '1982-01-19', DEFAULT, DEFAULT);;
INSERT into userInfo(userId, roleId, userName)
VALUES (1002, 1, '客户2'),
       (1003, 1, '客户3'),
       (1004, 1, '客户4'),
       (1006, 2, '客服2'),
       (1008, 3, '维修人员2');


# 产品表(固定)
create table goods
(
    goodsId   int auto_increment,
    goodsName varchar(32) not null,
    goodsInfo varchar(128),
    CONSTRAINT PK_GOODS primary key (goodsId)
) auto_increment 501;

insert into goods
values (default, '产品1', '公司的首批试行产品,可能经常会出现问题，修理费用很低'),
       (default, '产品2', '公司的二批试行产品,可能经常会出现问题，修理费用也很低'),
       (default, '产品3', '公司的三批试行产品,可能偶尔会出现问题，修理费用较低'),
       (default, '产品4', '公司的四批试行产品,可能偶尔会出现问题，修理费用也较低'),
       (default, '产品5', '公司的五批试行产品,一般不会出现问题，修理费用较高'),
       (default, '产品6', '公司的六批试行产品,基本不再出现问题，修理费用很高');


#用户产品绑定
create table haveGoods
(
    goodsId int     not null,
    userId  int     not null,
    status  char(1) not null, #1，已购买
    CONSTRAINT PK_HAVEGOODS primary key (goodsId, userId)
);

insert into haveGoods
values (501, 1001, '1'),
       (502, 1001, '1'),
       (503, 1001, '1'),
       (501, 1002, '1'),
       (503, 1002, '1'),
       (505, 1002, '1'),
       (501, 1003, '1'),
       (502, 1003, '1'),
       (505, 1003, '1'),
       (505, 1004, '1');

# 地址
create table userAddr
(
    addrId        int auto_increment,
    userId        int not null,
    province      varchar(8),
    city          varchar(8),
    area          varchar(8),
    address       varchar(32),
    contactNumber varchar(32),
    CONSTRAINT PK_ADDRID primary key (addrId),
    CONSTRAINT FK_ADDRUSER FOREIGN KEY (userId) REFERENCES userinfo (userId)
) auto_increment 1001;

drop procedure if exists proc_userAddr;
delimiter $
create procedure proc_userAddr()
BEGIN
    DECLARE i int default 1;
    while i < 4
        do
            insert into userAddr
            values (default, 1001, concat(i, '省'), concat(i, '市'), concat(i, '区'), concat(i, '路', i + 1, '号'),
                    round((13312312312 + RAND() * 1000000), 0));
            set i = i + 1;
        end while;

    set i = 1;
    while i < 5
        do
            insert into userAddr
            values (default, 1002, concat(i + 1, '省'), concat(i + 2, '市'), concat(i - 1, '区'),
                    concat(i - 1, '路', i, '号'), round(13321321212 + RAND() * 1000000, 0));
            set i = i + 1;
        end while;
    set i = 1;
    while i < 2
        do
            insert into userAddr
            values (default, 1003, concat(i + 5, '省'), concat(i + 2, '市'), concat(i - 1, '区'),
                    concat(i - 1, '路', i, '号'), round(13325671212 + RAND() * 1000000, 0));
            set i = i + 1;
        end while;
    set i = 1;
    while i < 3
        do
            insert into userAddr
            values (default, 1004, concat(i + 3, '省'), concat(i + 2, '市'), concat(i - 1, '区'),
                    concat(i - 1, '路', i, '号'), round(13327891212 + RAND() * 1000000, 0));
            set i = i + 1;
        end while;
end;
call proc_userAddr();

# 请求维修的订单
create table requestPage
(
    orderId     int auto_increment,                    #订单Id
    goodsId     int            not null,               #产品Id
    userId      int            not null,               #客户Id
    addrId      int            not null,               #地址Id
    price       decimal(10, 2) not null,               #价格
    status      char(1)        not null,               #0，废弃；1，成功；2，已派单,3，未支付；4，正在进行；5.已评论
    fixId       int,                                   #负责技工
    senderId    int,                                   #负责客服
    comment     varchar(128),                          #评论信息
    requestTime datetime       not null,               #请求时间
    updateTime  datetime       not null default now(), #更新时间
    constraint PK_REQUEST primary key (orderId),
    constraint FK_REUSER foreign key (userId) references userinfo (userId),
    constraint FK_REGOODS foreign key (goodsId) references goods (goodsId),
    constraint FK_READDR foreign key (addrId) references userAddr (addrId),
    constraint FK_REFIX foreign key (fixId) references userinfo (userId),
    constraint FK_RESEND foreign key (senderId) references userinfo (userId)
);

insert into requestPage
values (default, 501, 1001, 1001, 12.5, '1', 1007, 1006, null, now(), default),
       (default, 502, 1001, 1002, 16.0, '5', 1007, 1005, '师傅很专业,不到半个小时就修理完了,给你们点个赞', now(), default),
       (default, 503, 1001, 1001, 15.3, '0', null, null, null, now(), default),
       (default, 502, 1001, 1003, 18.7, '3', null, null, null, now(), default),
       (default, 501, 1001, 1002, 12.1, '4', null, null, null, now(), default);

create table PayAccount
(
    userId  int          not null,
    payPwd  varchar(128) not null,
    balance decimal(10, 2) default 1000.0,
    CONSTRAINT PK_PAYID primary key (userId)
);

insert into PayAccount
values (1001, md5('115200'), default),
       (1002, md5('115200'), default),
       (1003, md5('115200'), default),
       (1004, md5('115200'), default);