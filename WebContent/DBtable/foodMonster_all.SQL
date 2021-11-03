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
VALUES (1, '小小獸', '偏好食記', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (1, '小小鬼', '訂餐最愛', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (3, '中中怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (3, '中中獸', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (3, '中中鬼', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (6, '大大怪', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (6, '大大獸', '訂單加成', '我是圖片');
INSERT INTO MonsterBook (minDemandLevel, monsterName, monsterAbility, monsterPic)  
VALUES (6, '大大鬼', '訂單加成', '我是圖片');




# 等級經驗
CREATE TABLE LevelExp (
	Lv					INT AUTO_INCREMENT NOT NULL,
    expLow				INT,
    expUp				INT,
    CONSTRAINT LevelExp_Lv_PK PRIMARY KEY (Lv)
) AUTO_INCREMENT = 1;

INSERT INTO LevelExp (expLow, expUp)  VALUES (0, 10);
INSERT INTO LevelExp (expLow, expUp)  VALUES (10, 50);
INSERT INTO LevelExp (expLow, expUp)  VALUES (50, 100);
INSERT INTO LevelExp (expLow, expUp)  VALUES (100, 150);
INSERT INTO LevelExp (expLow, expUp)  VALUES (150, 200);
INSERT INTO LevelExp (expLow, expUp)  VALUES (200, 250);

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
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) 
VALUES ('訂單入門款', '成功完成3筆訂單0筆食記可獲得20個飼料20個金幣', '2021-09-10 00:00:00', 3, 0, 3, 20, 20, '這是圖片');
INSERT INTO Achieve (achiName, descript, openDate, validDays, achiArticle, achiOrder, gainFeed, gainGold, achiPic) 
VALUES ('食記入門款', '成功完成0筆訂單3筆食記可獲得20個飼料20個金幣', '2021-09-10 00:00:00', 3, 3, 0, 20, 20, '這是圖片');

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
VALUES ('4rfv@y.com', '1qaz@WSX', '王宜君', '女', '2006-01-12', '0921618067', '這是大頭貼', '2001-10-26', 20, 100, 1001, '雅亦', 1, 20, 4);
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
VALUES ('SusanJArviso@jourrapide.com', 'pvswkPP3', '蔡民柏', '男', '1978-07-17', '0934263542', '這是大頭貼', '2019-03-07', 1000, 20, 1002, '香琴', 2, 100, 4);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('LeighRPang@armyspy.com', 'V8qG6x8U', '陳財喜', '男', '1991-02-27', '0921090574', '這是大頭貼', '2013-07-08', 20, 100, 1001, '平柔', 1, 20, 5);
INSERT INTO MemberInfo (email, pwd, userName, gender, birthday, phone, pic, registerDate, gold, feed, monsterId, monsterNickName, Lv, exp, sta) 
VALUES ('OdellVOritz@dayrep.com', 'KsxD5ngR', '賴丹泰', '男', '1995-04-29', '0914918600', '這是大頭貼', '2008-10-04', 1000, 20, 1002, '新露', 2, 100, 4);

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

 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(1, '六塊雞桶', '炸物', 199, '2021-04-19 22:12:34', 60, '適合居家和樂享用', null, 7002);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(1, '麻辣藥膳鍋', '火鍋', 450, '2021-07-15 23:04:54', 90, '嗆辣不死鹹', null, 7004);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(1, '阿古豬', '燒烤', 150, '2021-09-15 23:04:54', 90, '來自沖繩的滋味', null, 7003);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(1, '東京豚骨拉麵', '日式', 200, '2005-09-15 23:04:54', 90, '來自東京值人拉麵', null, 7006);
 INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(1, '豪華和菜', '中式', 5000, '2000-09-15 23:04:54', 90, '宴席料理的領導品牌', null, 7002);


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
	quantity       VARCHAR(10) NOT NULL,
	unitprice      VARCHAR(10) NOT NULL,
	note     	   text,

    CONSTRAINT OrderList_orderid_FK FOREIGN KEY (orderid) REFERENCES RsOrder (orderid),
	CONSTRAINT OrderList_mealId_FK FOREIGN KEY (mealId) REFERENCES Meal (mealId),
	CONSTRAINT OrderList_orderlistid_PK PRIMARY KEY (orderlistid)
) AUTO_INCREMENT = 1;

INSERT INTO OrderList (orderid, mealId, quantity, unitprice, note) 
			VALUES (1, 501, '錢錢', '一百', 'NULL');


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
values(20210001,7001,'饗食天堂',now(),'其實中價位Buffet裡面，我個人也很喜歡饗食天堂
吃過京站店、板橋店、大直店，個人比較推京站跟板橋
這次饗食好像進行大規模升級改裝，有牛小排、草蝦、羊排吃到飽
但我最愛的哈根達斯沒有了難過，就帶大家來看看改裝後的饗食有甚麼食材吧
歐然後我要說，現在當月壽星好像都需要先註冊會員且提前領取才有95折
直接EZTABLE訂位刷卡享九折好像比較棒
生魚片區是基本款，切得滿厚的，也很新鮮
有各式握壽司，但我覺得我胃口被旭集養大了，想吃炙燒的
朋友幫我問做壽司的師父有沒有炙燒握壽司，
師傅還直接幫我們燒三個很NICE耶，但小聲地說沒有很好吃
來這邊基本款一定要來一盤生魚片，真的每個都切得很厚很可以
這邊現切牛排會問你要生一點還是熟一點，沒有中間值
我是拿熟一點的，生的真的好生超紅的，牛排有些部位不錯吃有些筋有點多
男友拿生一點的就是紅通通一片，玉米跟馬鈴薯泥配菜不錯
然後有現烤焗烤生蠔，一出爐就被拿光，但吃起來好像少了點味道，有點難形容
最有價值應該還是這一區
天使紅蝦、牛小排、羊排每個人一次限拿兩個，可以重覆排隊
炭火直烤牛小排，肉嫩多汁，我覺得很好吃呢有推
旁邊的奶醬野菇也頗好吃的，奶味很濃我喜歡
天氣冷，一到的時候就先一人來一碗蛤蠣湯，蛤蠣滿大顆的，湯很好喝
烤鴨也是一人一次限拿兩個，可以重覆排隊
師傅會問要不要小黃瓜、蔥，可以客製化還滿棒的，烤鴨夾餅好吃
其實吃了一輪突然有點不知道要吃甚麼，就走來這邊逛逛義大利麵
配菜可以自己夾，有蝦子、透抽、淡菜、海瓜子、花椰菜等
然後醬底青醬、白醬、紅醬三選一
我選了青醬，但師父做成白醬，我本來說沒關係也可以吃
但師父堅持要幫我弄成青醬，所以我這盤超級無敵濃郁是白醬+青醬，覺得很可以
雖然吃義大利麵有點占空間，但這盤頗好吃的說
生食區那邊還有蝦子跟螃蟹。但男友說吃起來還好一般
還有烤蝦，殼稍微有點難撥，但感覺天使紅蝦好像比較好吃又大尾
和風照燒雞腿，烤魚下巴、炸蝦都還不錯，其他沒吃
蛤蠣這邊有炒的，但幾乎都殼跟肉分離。還是喝蛤蠣湯實在
剛好碰上經典粵菜季節，有吃到辣子謝，算表現還不錯
湯品有海鮮巧達濃湯、人參燉豬肚湯、麻油雞湯、海鮮羹、蔬菜濃湯
個人覺得海鮮巧達濃湯好喝
這邊還有鴨粥的配料，還有牛肚、雞肉等小菜
麵包、磅蛋糕這區太佔空間我沒拿，拍給大家看一下
蛋塔現烤的滿好吃的
生巧克力大推，吃了好幾顆，這外面買也不便宜呢
熱茶包種類有夠豐富的，且弄得超美的，粉紅色那個蜜桃百香茶很好喝很香
我真的很愛吃葡萄柚，尤其有焦糖烤過的更好吃，焦糖會蓋過葡萄柚的酸互補
還有焦糖烤布蕾也很好吃，沒哈根達斯了只好怒吃烤布蕾
甜點種類也不少，但沒看到特別想吃的，且我已吃飽戰力不足
水果有鳳梨、火龍果、芭樂、西瓜、番茄，這區我也沒吃
飲料種類也不少，冰箱內有可樂、雪碧、芬達等，也有自製氣泡水，奶茶、紅茶等
另一邊有酒沒拍到，貼心提醒喝酒不開車、開車不喝酒，未滿18歲請勿飲酒
這次是朋友生日我們來吃的，但感覺好像改裝前跟改裝後沒有太大升級感覺
還是因為我之前在台中大遠百吃過饗食有干貝，這邊沒有有點難過
且竟然沒有哈根達斯，怎麼可以拿掉哈根達斯又漲價了安捏母湯
希望可以加回來，以上給大家參考囉',1),

      
      (20210001,7002,'海霸王 長輩記憶中的合菜味',now(),'心得: 一桌8000元的菜色豐富又美味~~
每次經過都以為海霸王已沒落，那天進去才發現裝潢雖然比不上一家一家新開有質感又氣
派的飯店但東西好吃真的沒話說~而且其實生意很好呢
小包廂都是滿的，一個包廂可放六七桌很適合團體開會聚餐地點
食材新鮮、分量絕對足夠，更重要的是服務人員雖都有年紀了但各個經驗老到
服務態度也好，用餐氣氛和食物都很推薦
左上 冷盤，有酸辣花枝 海蜇皮和珊瑚草(第一次看到前菜珊瑚草量如此多!!) 新鮮鮑魚美乃芝
三道前菜味道都很不錯不膩又開胃
右上 彩椒佐螃蟹，很夠味，默默地就啃了三隻螃蟹，炸的連骨頭都很酥脆~
左下 份量超足夠鮮蝦~幾乎每人最後都是滿滿整盤的蝦殼
右下櫻花蝦鰻魚油飯，油飯味道很高好沒有那種口渴死鹹的口味，鰻魚沒有次很軟嫩
第二道上生魚片時，剛好我們這桌大家都不吃生魚片
就麻煩服務員把生的魚片作為其他料理
就變成左邊這道 鮮魚蒸豆腐，不得不錯，海霸王的口味真的很厲害
該有的味道不會缺 整體搭配醬汁比例也剛好 可見廚師功力
變身後的是豆腐+魚片~~很新鮮又沒刺可以放心地吃部用怕噎到
左邊是彩椒炒干貝，干貝雖然不是超大的那種，但看盤裝就知干貝滿滿的打敗其他店啊
雙拼也很有趣~~有好吃的芋泥紅豆二色丸，倒是下面的肉品算是這次比較沒這麼突出的菜
但若是愛吃肉的應該部會錯過
最後大力推荐的菇菇雞湯，湯頭因加了很多菇類進去不會過於油膩，火滾了即可不用一直
滾否則養分被吸收到湯精華中，但這樣喝湯可能會膽固醇飆高，也可能會認為太鹹
多年後再來海霸王吃飯果真又是另一種感覺，希望好吃的店一直都在啊
',1),
      
      
      
      (20210001,7003,'Ashidori好好吃',now(),'這位廚師長的好清秀，傑尼斯型的。
       日本居酒屋文化裡，服務生都會先送上下酒菜，稱之為 “先付” or “付出”(Tsukidashi)。
       結帳時就會多出一筆 “先付” 的費用，也可以算是服務費吧，先付大約在每人 JPY150～JPY500 左右。
       這家的先付算貴的，一人 JPY480。今日先付是醃竹筍和一碗蘿蔔泥～這盤薩摩地雞(炭燒帶皮雞腿肉)原價 JPY840，
       可先下載 coupon 給店家看就可以享用一份免費的好吃雞腿肉。好好吃而且份量頗大，配啤酒很爽，感覺吃完就半飽了，
	   還附上小黃瓜片和高麗菜解膩用。',1),
      
      (20210002,7004,'齊味麻辣火鍋',now(),'最近突然降溫，這麼寒冷的冬天就想要吃麻辣鍋
剛好朋友推薦這間鴛鴦鍋，在中和生活一陣子的慧竟然沒吃過
齊味麻辣火鍋總店在板橋
目前中和、蘆洲、三重、竹北都有分店
店內桌數蠻多的，許多中國風的裝飾物，雖然傳統卻有復古味
自助式的醬料區，但齊味火鍋蠻重口味的，所以我們都沒有沾醬
吃麻辣火鍋一定要配烏梅湯啊
烏梅湯可以降低辣度，而且酸酸甜甜很開胃
一入桌店員就會給單子
單點式火鍋最適合一群人來吃了
但齊味的鍋底、白飯不是無限吃的，要吃鍋底還需要加點
一上桌的鴛鴦鍋，看了馬上開始覺得餓了
我們有請店員幫我們把辣油撈掉一點
白湯鍋底有高麗菜、小貢丸、排骨酥
很少見到白湯鍋底有排骨酥的
建議蔬菜類的都煮白湯，味道會更鮮甜
麻辣鍋底有鴨血、豆腐，豆腐滷到看起來超入味
喜歡吃麻辣鍋的朋友，吃完有時都會腸胃不適
老闆花費多年專研及改良麻辣湯底，嚴選多種辛香料細火熬煮，
再特別加入保護腸胃的藥材，
嚐起來香淳濃郁，麻辣直攻味蕾卻很溫潤
上菜速度非常快，一下子我們桌子已經滿的
以份量來說，菜盤的份量蠻多的
肉盤的份量有點少，人多的話建議點兩份比較夠
傳說中的夢幻鴨血，軟嫩Ｑ彈的口感
滷到鴨血充滿的湯汁，每咬一口都會噴汁
難怪店家的鍋底需要加購，這麼好吃的鴨血還是第一次吃到
光是鴨血豆腐就贏了好多連鎖麻辣鍋
香辣黑鳳爪
店家強力推薦的，只有中和分店才有的招牌私房菜
鳳爪大隻又多肉，每口都是滿滿的膠原蛋白
熱熱的吃滑嫩，涼涼的吃Q彈，讓人允指回味
滷到骨頭都入味，香麻微甜，意猶未盡
齊味麻辣火鍋已經變成慧的私藏名單了
桌數很多、服務也很親切，上菜、清桌都很快速
麻辣湯底濃郁順口不傷喉，單點餐點幾乎沒可挑惕的
夢幻鴨血和招牌香辣鳳爪保證吃了還會回味
這寒冷的冬天，和朋友來餐麻辣鍋，暖心又暖胃',1),

(20210002,7005,'安格士牛排~高CP值沙拉吧',now(),'用餐心得：我覺得安格士牛排真的很適合朋友聚餐，自助吧的種類超多，點最
       便宜的牛排在吃自助吧吃到飽飽飽！真的超划算的，而且大家來這邊都很輕鬆自在的聊天，座位又很大，這樣看來你是不是心動了呢？',1),
       
	(20210002,7004,'齊味麻辣火鍋',now(),'讓我魂縈夢牽的鴨血，不但口感鮮嫩無比...又滷的超入味 !
比較可惜的是，不管是齊味或是詹記，加鴨血、豆腐都是要另外加錢的，不過齊味的價格便宜許多。
之前阿姐十分推薦詹記的豆腐，不過上週我去詹記吃的時候對豆腐沒有特別的感覺，
可能我比較衰，剛好遇到滷的比較不入味的豆腐， 不過這次來齊味，總算讓我給嚐到阿姐口中的美味？',1);


    
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