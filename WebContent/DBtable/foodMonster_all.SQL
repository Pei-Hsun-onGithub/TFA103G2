CREATE DATABASE IF NOT EXISTS fm01;
use fm01;

Drop table if exists FavoFoodArticle;
Drop table if exists Message;
Drop table if exists PictureBase;
Drop table if exists FoodArticle;

DROP TABLE IF EXISTS OrderList; 	-- 訂單明細
DROP TABLE IF EXISTS RsOrder;		-- 餐點訂單
DROP TABLE IF EXISTS Address;   	-- 外送地址 
DROP TABLE IF EXISTS Card;			-- 信用卡 
DROP TABLE IF EXISTS FavoRestaurant;-- 收藏餐廳

DROP TABLE IF EXISTS RestaurantStyle;
DROP TABLE IF EXISTS ElasticDayoff;
DROP TABLE IF EXISTS Style;
DROP TABLE IF EXISTS Meal;
DROP TABLE IF EXISTS Restaurant;

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

INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (1, '小小怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (10, '中中怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (20, '大大怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (1, '小小獸', '偏好食記', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (1, '小小鬼', '訂餐最愛', '我是圖片');



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

INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) 
VALUES ('大胃王', '成功完成50筆訂單可獲得100個飼料', '2021-09-07 00:00:00', 180, 0, 50, 100, 0, '這是圖片');
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) 
VALUES ('綜合王', '成功完成25筆訂單25筆食記可獲得50個飼料50個金幣', '2021-09-09 00:00:00', 90, 25, 25, 50, 50, '這是圖片');
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) 
VALUES ('知識王', '成功完成50篇食記可獲得100個金幣', '2021-09-10 00:00:00', 60, 50, 0, 0, 100, '這是圖片');


#會員資料	sta:4,5
CREATE TABLE MemberInfo (
	userId				INT AUTO_INCREMENT NOT NULL,
    email				VARCHAR(50),
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

INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('1qaz@y.com', '1qaz@WSX', '謝依冰', '女', '1966-12-27', '0921562069', '這是大頭貼', '2000-11-26', 20, 100, 1001, '小之', 1, 20, 1);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('2wsx@y.com', '1qaz@WSX', '陳佳燕', '女', '1992-10-16', '0987459122', '這是大頭貼', '2019-09-24', 1000, 20, 1002, '南風', 2, 100, 2);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('SteveMJackson@teleworm.us', 'PR3W9q2f', '王宜君', '女', '2006-01-12', '0921618067', '這是大頭貼', '2001-10-26', 20, 100, 1001, '雅亦', 1, 20, 1);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('stevemjackson@fleckens.hu', 'gNbHkZh3', '潘君聿', '女', '2016-07-16', '0961036280', '這是大頭貼', '2004-04-08', 1000, 20, 1002, '飛琴', 2, 100, 2);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('AmyJWallace@teleworm.us', 'HAa7g3KC', '楊原妹', '女', '1926-07-02', '0961544146', '這是大頭貼', '2007-10-03', 20, 100, 1001, '白蘭', 1, 20, 4);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('TerryABrown@teleworm.us', 'sDchsSUc', '黃曼映', '女', '1950-03-11', '0915724955', '這是大頭貼', '2013-10-16', 1000, 20, 1002, '山白', 2, 100, 4);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('RobertJThornton@armyspy.com', 'S9WpvK9V', '王家豪', '男', '1969-12-13', '0970258018', '這是大頭貼', '2011-05-01', 20, 100, 1001, '醉珍', 1, 20, 5);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('JeffreyBBalling@armyspy.com', 'p8WA9Au5', '沈寶昆', '女', '1922-06-21', '0935929444', '這是大頭貼', '2018-11-10', 1000, 20, 1002, '新巧', 2, 100, 4);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('RandyDSnyder@jourrapide.com', 'bZY9CHxw', '王靖惟', '女', '1926-07-02', '0953417861', '這是大頭貼', '2018-11-16', 20, 100, 1001, '幼雙', 1, 20, 5);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('
SusanJArviso@jourrapide.com', 'pvswkPP3', '蔡民柏', '男', '1978-07-17', '0934263542', '這是大頭貼', '2019-03-07', 1000, 20, 1002, '香琴', 2, 100, 4);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('
LeighRPang@armyspy.com', 'V8qG6x8U', '陳財喜', '男', '1991-02-27', '0921090574', '這是大頭貼', '2013-07-08', 20, 100, 1001, '平柔', 1, 20, 5);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('
OdellVOritz@dayrep.com', 'KsxD5ngR', '賴丹泰', '男', '1995-04-29', '0914918600', '這是大頭貼', '2008-10-04', 1000, 20, 1002, '新露', 2, 100, 4);

# 成就進度	sta13,14,15
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

INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210001, 2001, 4, 0, '2021-09-09 00:00:00', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210002, 2002, 10, 4, '2021-09-09 23:59:59', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210003, 2001, 4, 0, '2021-09-09 00:00:00', 14);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210004, 2002, 10, 4, '2021-09-09 23:59:59', 14);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210005, 2001, 4, 0, '2021-09-09 00:00:00', 15);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210006, 2002, 10, 4, '2021-09-09 23:59:59', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210007, 2001, 4, 0, '2021-09-09 00:00:00', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210008, 2002, 10, 4, '2021-09-09 23:59:59', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210009, 2001, 4, 0, '2021-09-09 00:00:00', 14);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210010, 2002, 10, 4, '2021-09-09 23:59:59', 15);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210011, 2001, 4, 0, '2021-09-09 00:00:00', 13);
INSERT INTO AchieveProgress (userId, achiId, currentArticle, currentOrder, beginDate, sta) 
VALUES (20210012, 2002, 10, 4, '2021-09-09 23:59:59', 14);


# 餐廳廠商 
CREATE TABLE Restaurant (
	restaurantid     	INT AUTO_INCREMENT NOT NULL,
	restaurantname      VARCHAR(20),
	boss       			CHAR(10),
	phone   			CHAR(20),
	district       		CHAR(20),
	city      			CHAR(20),
	location    		CHAR(30),
    opentime    		TIME,
    closetime    		TIME,
    dayoffid    		INT NOT NULL,
    weeklyleave    		CHAR(7),
    sta    				INT ,
	CONSTRAINT Restaurant_restaurantid_PK PRIMARY KEY (restaurantid)
) AUTO_INCREMENT = 7001;

INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('饗食天堂', '連勝蚊', '0222983345', '台北市', '內湖區', '中山路二段19號8樓', '08:00:00', '21:30:00', 233, '0001000', 4 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('海霸王', '菜蚊鷹', '0944778449', '台北市', '大同區', '承德路三段42號19樓', '13:00:00', '22:30:00', 234, '0000000', 5 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('Ashidori', '藤原拓海', '0935779049', '新北市', '中和區', '巷尾路89號', '17:00:00', '00:30:00', 235, '0100010', 4 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('齊味火鍋', '魯夫', '0935779249', '新北市', '蘆洲區', '長榮路89號', '17:00:00', '00:30:00', 235, '0100010', 4 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('安格士', '比爾蓋茲', '0935779888', '台北市', '大安區', '承德路89號', '17:00:00', '22:30:00', 235, '0100011', 5 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('屯京拉麵', '加藤鷹', '0935439249', '新北市', '三重區', '沒有路334號', '12:00:00', '21:30:00', 235, '0000000', 4 );
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('素飄香', '妙禪', '0935346249', '台北市', '東區', '漢口街路89號', '06:00:00', '16:30:00', 235, '0111010', 4 );


# 餐點
CREATE TABLE Meal (
	mealid         		INT AUTO_INCREMENT NOT NULL,
	sta     			INT,
	mealname       		VARCHAR(30),
	mealtype       		CHAR(10),
	unitprice      		INT,
	launchdate     		TIMESTAMP,
	launchdays    		INT,
    mealdescription     VARCHAR(500),
    mealimg    			MEDIUMBLOB,
    restaurantid    	INT NOT NULL,
	CONSTRAINT Meal_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES Restaurant (restaurantid),
	CONSTRAINT Meal_mealid_PK PRIMARY KEY (mealid)
) AUTO_INCREMENT = 501;

 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '六塊雞桶', '炸物', 199, '2021-04-19 22:12:34', 60, '適合居家和樂享用', null, 7002);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '麻辣藥膳鍋', '火鍋', 450, '2021-07-15 23:04:54', 90, '嗆辣不死鹹', null, 7004);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '阿古豬', '燒烤', 150, '2021-09-15 23:04:54', 90, '來自沖繩的滋味', null, 7003);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '東京豚骨拉麵', '日式', 200, '2005-09-15 23:04:54', 90, '來自東京值人拉麵', null, 7006);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '豪華和菜', '中式', 5000, '2000-09-15 23:04:54', 90, '宴席料理的領導品牌', null, 7002);


# 風格類型
CREATE TABLE Style (
	styleid		INT AUTO_INCREMENT NOT NULL,
	styletype   VARCHAR(20),
	CONSTRAINT Style_styleid_PK PRIMARY KEY (styleid)
) AUTO_INCREMENT = 50;

INSERT INTO Style (styletype) VALUES ('燒烤');
INSERT INTO Style (styletype) VALUES ('日式');
INSERT INTO Style (styletype) VALUES ('中式');
INSERT INTO Style (styletype) VALUES ('泰式');
INSERT INTO Style (styletype) VALUES ('西式');
INSERT INTO Style (styletype) VALUES ('速食');
INSERT INTO Style (styletype) VALUES ('素食');
INSERT INTO Style (styletype) VALUES ('火鍋');
INSERT INTO Style (styletype) VALUES ('小吃');
INSERT INTO Style (styletype) VALUES ('炸物');


# 彈性休假
CREATE TABLE ElasticDayoff (
	dayoffid		INT AUTO_INCREMENT NOT NULL,
	restaurantid  	INT  NOT NULL,
    newWeeklyleave 	CHAR(7),
    CONSTRAINT ElasticDayoff_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES Restaurant (restaurantid),
	CONSTRAINT ElasticDayoff_dayoffid_PK PRIMARY KEY (dayoffid)
) AUTO_INCREMENT = 40;

INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7001,'0011000');
INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7001,'1100000');
INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7003,'0000001');
INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7002,'0011100');
INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7004,'0011110');
INSERT INTO ElasticDayoff (restaurantid, newWeeklyleave) VALUES (7006,'1010010');



# 餐廳類型
CREATE TABLE RestaurantStyle (
	restaurantid	INT  NOT NULL,
	styleid	  		INT  NOT NULL,
	CONSTRAINT RestaurantStyle_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES Restaurant (restaurantid),
	CONSTRAINT RestaurantStyle_styleid_FK FOREIGN KEY (styleid) REFERENCES Style (styleid),
    PRIMARY KEY (restaurantid, styleid)
);

#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,50);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,51);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,52);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,55);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,53);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7002,51);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7002,55);
#INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7003,54);


# 外送地址
CREATE TABLE Address (
	deliveryaddid     	INT AUTO_INCREMENT NOT NULL,
	userid      		INT NOT NULL,
	customername       	VARCHAR(25) NOT NULL,
	deliverphone   		VARCHAR(10) NOT NULL,
	deliveraddress      VARCHAR(100) NOT NULL,
	buildingname      	VARCHAR(20),
	note 	    		TEXT,
    sta    				INT ,
	CONSTRAINT Address_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
    CONSTRAINT Address_deliveryaddid_PK PRIMARY KEY (deliveryaddid)
) AUTO_INCREMENT = 1;

 INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210001, '陳國恩', '0922983345', '新竹市北區經國路一段238號', '哥倫比亞大樓', '我要加辣', 1);
 INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210002, '林思倫', '0934808576', '台南市安南區安和路一段186巷15號', '聖心大樓', '我不要辣', 2);
INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210003, '王子純', '0919779933', '台中市太平區宜欣路267號', '美安大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210004, '張苑迪', '0987529962', '新北市三峽區大勇路238號', '聖地安哥大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210005, '昌逸禎', '0963428053', '高雄市鳳山區平等路38號', '智冠大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210006, '王威廷', '0924817741', '苗栗縣頭份市信中路105巷8號7樓', '精誠樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210007, '梁瑋蓁', '0919030566', '新竹縣湖口鄉仁樂路190號', '國泰大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210008, '徐怡婷', '0987121140', '台北市內湖區新湖三路244號', '富邦大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210009, '陳宗翰', '0988310059', '雲林縣台西鄉崙豐路46號', '安泰大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210010, '胡威廷', '0961746675', '台中市北屯區軍功路二段177巷11號', '永森大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210011, '蔡吉友', '0988811498', '新竹縣關西鎮中山東路39號', '永保大樓', '我要加辣', 1);
 INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (20210012, '陳冠軒', '0932271151', '台北市文山區萬美街一段85巷3號7樓', '安康大樓', '我要加辣', 1);
 
# 信用卡
CREATE TABLE Card (
	cardid         	INT AUTO_INCREMENT NOT NULL,
	userid     		INT NOT NULL,
	cardholder      VARCHAR(25) NOT NULL,
	cardnumber      VARCHAR(16) NOT NULL,
	deadline      	date NOT NULL,
	cvv     		VARCHAR(3) NOT NULL,
	billaddress    	VARCHAR(100) NOT NULL,
    zipcode     	VARCHAR(6) NOT NULL,
    sta    			INT NOT NULL,
    
	CONSTRAINT Card_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
	CONSTRAINT Card_cardid_PK PRIMARY KEY (cardid)
) AUTO_INCREMENT = 1;

 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210001, '陳國恩', 4716329842362253, '2023-12-31', '466', '新竹市北區經國路一段238號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210002, '林思倫', 2058942978991061, '2024-05-31', '689', '台南市安南區安和路一段186巷15號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210003, '王子純', 9318776636761858, '2023-04-23', '233', '台中市太平區宜欣路267號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210004, '張苑迪', 8765432187654321, '2023-01-31', '006', '新北市三峽區大勇路238號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210005, '昌逸禎', 0538755043873639, '2025-03-31', '643', '高雄市鳳山區平等路38號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210006, '王威廷', 5332056483252861, '2023-11-23', '360', '苗栗縣頭份市信中路105巷8號7樓', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210007, '梁瑋蓁', 2400596074546732, '2022-10-31', '711', '新竹縣湖口鄉仁樂路190號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210008, '徐怡婷', 5950976460340512, '2021-12-31', '885', '台北市內湖區新湖三路244號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210009, '陳宗翰', 1234567812345678, '2024-01-31', '152', '雲林縣台西鄉崙豐路46號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210010, '胡威廷', 9542710573627430, '2025-05-31', '075', '台中市北屯區軍功路二段177巷11號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210011, '蔡吉友', 6956674759132833, '2024-08-31', '171', '新竹縣關西鎮中山東路39號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210012, '陳冠軒', 3597905196233614, '2023-12-31', '044', '台北市文山區萬美街一段85巷3號7樓', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210012, '賴國滄', 4716390519622253, '2023-12-31', '466', '新竹市北區經國路一段238號', '632', 1);	
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(20210012, '黃志成', 4716329842905192, '2023-12-31', '466', '新竹市北區經國路一段238號', '632', 1);	
   # 餐點訂單
CREATE TABLE RsOrder (
	orderid 		INT AUTO_INCREMENT NOT NULL,
	userid     		INT NOT NULL,
	restaurantid    INT ,
	cardid       	INT NOT NULL,
	deliveryaddid   INT NOT NULL,
	deliverymethods INT,
	orderday      	datetime default current_timestamp,
	resstrtime 	    datetime default current_timestamp,
    resendtime    	datetime default current_timestamp,
    delstrtime    	datetime default current_timestamp,
    delendtime    	datetime default current_timestamp,
    count    		INT,
    texts    		VARCHAR(50),
    sta    			INT null,
	CONSTRAINT RsOrder_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
    CONSTRAINT RsOrder_orderid_PK PRIMARY KEY (orderid)
) AUTO_INCREMENT = 1;

INSERT INTO RsOrder 
(userid,restaurantid ,cardid ,deliveryaddid ,deliverymethods, orderday ,resstrtime ,resendtime ,delstrtime ,delendtime ,count ,texts, sta) 
	VALUES 
(20210001, 1 ,1 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210002, 4 ,2 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210003, 5 ,3 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210004, 7 ,4 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210005, 7 ,5 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210006, 8 ,6 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210007, 2 ,7 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210008, 3 ,8 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210009, 11 ,9 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210010, 2 ,10 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210011, 6 ,11 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(20210012, 8 ,12 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1);

# 訂單明細
CREATE TABLE OrderList (
	orderlistid    INT AUTO_INCREMENT NOT NULL,
	orderid    	   INT NOT NULL,
	mealId         INT NOT NULL,
	quantity       INT NOT NULL,
	unitprice      INT NOT NULL,
	note     	   text,

    CONSTRAINT OrderList_orderid_FK FOREIGN KEY (orderid) REFERENCES RsOrder (orderid),
	CONSTRAINT OrderList_mealId_FK FOREIGN KEY (mealId) REFERENCES Meal (mealId),
	CONSTRAINT OrderList_orderlistid_PK PRIMARY KEY (orderlistid)
) AUTO_INCREMENT = 1;

INSERT INTO OrderList (orderid, mealId, quantity, unitprice, note) 
			VALUES (1, 501, 33, 33, 'NULL');


# 收藏餐廳
CREATE TABLE FavoRestaurant (
	userid  		INT NOT NULL,
    restaurantid 	INT NOT NULL,
    
	CONSTRAINT FavoRestaurant_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
    CONSTRAINT FavoRestaurant_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid),
	PRIMARY KEY (userid,restaurantid)
) ;

INSERT INTO FavoRestaurant (userid, restaurantid) VALUES (20210001,7001);


#食記區

#食記table
create table FoodArticle(
	articleno int not null auto_increment primary key,
    userid int,
    restaurantid int,
    articletitle varchar(50) not null,
    articledate datetime,
    articlecontent text not null,
    sta int comment"狀態",
    constraint FoodArticle_userid_FK foreign key(userid) references MemberInFo (userid),
    constraint FoodArticle_restaurantid_FK foreign key(restaurantid)references Restaurant (restaurantid)
    );
insert into FoodArticle (userid,restaurantid,articletitle,articledate,articlecontent,sta)
values(20210002,7001,'肯德基好好吃',now(),'青花椒麻雞香辣,太辣!!!!',1),
      (20210002,7002,'迷克夏好喝到爆',now(),'紅茶拿鐵太好喝啦,好喝到不行',1),
      (20210003,7003,'Ashidori好好吃',now(),'這位廚師長的好清秀，傑尼斯型的。
       日本居酒屋文化裡，服務生都會先送上下酒菜，稱之為 “先付” or “付出”(Tsukidashi)。
       結帳時就會多出一筆 “先付” 的費用，也可以算是服務費吧，先付大約在每人 JPY150～JPY500 左右。
       這家的先付算貴的，一人 JPY480。今日先付是醃竹筍和一碗蘿蔔泥～這盤薩摩地雞(炭燒帶皮雞腿肉)原價 JPY840，
       可先下載 coupon 給店家看就可以享用一份免費的好吃雞腿肉。好好吃而且份量頗大，配啤酒很爽，感覺吃完就半飽了，
	   還附上小黃瓜片和高麗菜解膩用。',1),
      (20210004,7004,'齊味火鍋',now(),'位在縣民大道跟民權路交叉口的齊味，離板南線的板橋站2號出口很近，交通上算是方便。齊味是愛吃麻辣鍋的好友夫妻檔大力推薦，住新莊的他們都會特地來板橋包齊味回去吃，我自己以前倒是常吃新莊的詹記，
       齊味離我這麼近，怎麼可以錯過，今天就約這家啦~~松阪豬肉及培根豬肉各三百，培根豬肉油花多，口感嫩，但薄了點，松阪豬則是厚度比較夠，吃起來比較有彈性。這裡肉的份量不算少，三個人點二盤肉有點太多。吃完結帳花了一千六百多，三個人吃下來一個人平均超過五百，價格不算便宜，也可能是點太多料。整體吃下來口味不錯，有飽足感，但口味有點太重，白湯不算清淡，
       有一點點偏鹹，不吃辣的朋友說他吃白湯也不用沾醬，而辣湯本身就一定是重口味囉！',1),
      (20210005,7005,'安格士貴!!!!!',now(),'用餐心得：我覺得安格士牛排真的很適合朋友聚餐，自助吧的種類超多，點最
       便宜的牛排在吃自助吧吃到飽飽飽！真的超划算的，而且大家來這邊都很輕鬆自在的聊天，座位又很大，這樣看來你是不是心動了呢？',1);


    
    #圖片庫table
    create table PictureBase(
		picno int not null auto_increment primary key,
        articleno int,
        pic mediumblob,
		constraint PictureBase_articleno_FK foreign key(articleno)references FoodArticle (articleno)
        
	);
    
    
    
    #留言
    create table Message(
		msgno int not null auto_increment primary key,
		articleno int,
        userid int,
		msgdate timestamp default current_timestamp,
		msgcontent varchar(100),
		sta int,
		constraint Message_articleno_FK foreign key(articleno) references FoodArticle (articleno),
		constraint Message_userid_FK foreign key(userid) references MemberInFo (userid)
    );    
    insert into Message (articleno,userid,msgcontent,sta) 
	values(1,20210001,"好吃讚讚",1),
	(1,20210001,"流口水ing",1),
	(2,20210002,"難吃",1),
	(2,20210003,"太辣啦",1);
    
    
    
    #收藏食記table
    create table FavoFoodArticle(
		userid int,
        articleno int,
        constraint FavoFoodArticle_userid_FK foreign key(articleno) references FoodArticle (articleno),
		constraint FavoFoodArticle_articleno_FK foreign key(userid) references MemberInFo (userid),
		primary key(userid,articleno)
    
    );
    
    
    insert into FavoFoodArticle (userid,articleno) values (20210001,1),(20210001,2);