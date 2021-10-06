CREATE DATABASE IF NOT EXISTS fm01;

use fm01;

DROP TABLE IF EXISTS AchieveProgress;
DROP TABLE IF EXISTS Achieve;
DROP TABLE IF EXISTS MemberInfo;
DROP TABLE IF EXISTS LevelExp;
DROP TABLE IF EXISTS MonsterBook;


# 怪獸圖鑑
CREATE TABLE MonsterBook (
	monsterId			INT AUTO_INCREMENT NOT NULL,
	minDemandLevel		INT,
    monsterName			VARCHAR(25),
    monsterAbility		VARCHAR(25),
    monsterPic			MEDIUMBLOB,
    CONSTRAINT MonsterBook_monsterId_PK PRIMARY KEY (monsterId)
) AUTO_INCREMENT = 1001;

INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  VALUES (1, '小小怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  VALUES (10, '中中怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  VALUES (20, '大大怪', '訂單加成', '我是圖片');

# 等級經驗
CREATE TABLE LevelExp (
	Lv					INT AUTO_INCREMENT NOT NULL,
    expLow				INT,
    expUp				INT,
    CONSTRAINT LevelExp_Lv_PK PRIMARY KEY (Lv)
) AUTO_INCREMENT = 1;

INSERT INTO LevelExp (expLow, expUp)  VALUES (0, 10);
INSERT INTO LevelExp (expLow, expUp)  VALUES (10, 100);
INSERT INTO LevelExp (expLow, expUp)  VALUES (100, 1000);

# 成就資料
CREATE TABLE Achieve (
	achiId				INT AUTO_INCREMENT NOT NULL,
    achiName			VARCHAR(20),
    descript			VARCHAR(100),
    openDate			DATETIME,
    validDays			INT,
    achiArticle			INT,
    achiOrder			INT,
    gainFeed			INT,
    gainGold			INT,
    achiPic				MEDIUMBLOB,
    CONSTRAINT Achieve_achiId_PK PRIMARY KEY (achiId)
) AUTO_INCREMENT = 2001;

INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) VALUES ('大胃王', '成功完成50筆訂單可獲得100個飼料', '2021-09-07 00:00:00', 180, 0, 50, 100, 0, '這是圖片');
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) VALUES ('綜合王', '成功完成25筆訂單25筆食記可獲得50個飼料50個金幣', '2021-09-09 00:00:00', 90, 25, 25, 50, 50, '這是圖片');
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) VALUES ('知識王', '成功完成50篇食記可獲得100個金幣', '2021-09-10 00:00:00', 60, 50, 0, 0, 100, '這是圖片');

#會員資料
CREATE TABLE MemberInfo (
	userId				INT AUTO_INCREMENT NOT NULL,
    email				VARCHAR(25),
    pwd					VARCHAR(25),
    userName			VARCHAR(25),
    gender				VARCHAR(10),
    birthday			DATETIME,
    phone				VARCHAR(15),
    pic					MEDIUMBLOB,
    registerDate		DATETIME,
    gold				INT,
    feed				INT,
    monsterId     		INT NOT NULL,
    monsterNickName		VARCHAR(20),
    Lv					INT NOT NULL,
    exp					INT,
    sta					INT,
    CONSTRAINT MemberInfo_userId_PK PRIMARY KEY (userId),
    CONSTRAINT MemberInfo_monsterId_FK FOREIGN KEY (monsterId) REFERENCES MonsterBook (monsterId),
    CONSTRAINT MemberInfo_Lv_FK FOREIGN KEY (Lv) REFERENCES LevelExp (Lv)
) AUTO_INCREMENT = 20210001;

INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) VALUES ('123@gmail.com', 123456, '王大明', '男', '2020-01-03', '0921232323', '這是大頭貼', '1000-01-01 00:00:00', 20, 100, 1001, '小可愛', 1, 20, 1);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) VALUES ('567@hotmail.com', 654321, '孫小美', '女', '1992-10-16', '0924323456', '這是大頭貼', '2021-09-01 00:00:00', 1000, 20, 1002, '胖嘟嘟', 2, 100, 1);

# 成就進度
CREATE TABLE AchieveProgress (
	userId				INT NOT NULL,
	achiId 				INT NOT NULL,
	currentArticle		INT,
    currentOrder		INT,
    beginDate			DATETIME,
    sta					INT,
    CONSTRAINT AchieveProgress_userId_FK FOREIGN KEY (userId) REFERENCES MemberInfo (userId),
    CONSTRAINT AchieveProgress_achiId_FK FOREIGN KEY (achiId) REFERENCES Achieve (achiId),
	PRIMARY KEY (userId, achiId)
);

INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) VALUES (20210001, 2001, 4, 0, '2021-09-09 00:00:00', 1);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) VALUES (20210001, 2002, 10, 4, '2021-09-09 23:59:59', 2);

