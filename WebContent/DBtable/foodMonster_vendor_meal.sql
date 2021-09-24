CREATE DATABASE IF NOT EXISTS fm01;

use fm01;

DROP TABLE IF EXISTS RestaurantStyle;
DROP TABLE IF EXISTS ElasticDayoff;
DROP TABLE IF EXISTS Style;
DROP TABLE IF EXISTS Meal;
DROP TABLE IF EXISTS Restaurant;



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
INSERT INTO Restaurant (restaurantname, boss, phone, district, city, location, opentime, closetime, dayoffid, weeklyleave, sta)  VALUES ('Ashidori', '藤原拓海', '0935779049', '新北市', '中和區', '巷尾路89號', '1000-01-01 17:00:00', '1000-01-01 00:30:00', 235, '0100010', 4 );


# 餐點
CREATE TABLE Meal (
	mealid         		INT AUTO_INCREMENT NOT NULL,
	sta     			INT,
	mealname       		VARCHAR(30),
	mealtype       		CHAR(10),
	unitprice      		INT,
	launchdate     		TIMESTAMP,
	launchdays    		INT,
    mealdescription     VARCHAR(150),
    mealimg    			MEDIUMBLOB,
    restaurantid    	INT NOT NULL,
	CONSTRAINT Meal_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES Restaurant (restaurantid),
	CONSTRAINT Meal_mealid_PK PRIMARY KEY (mealid)
) AUTO_INCREMENT = 501;

INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '六塊雞桶', '炸物', 199, '2021-04-19 22:12:34', 60, '適合居家和樂享用', null, 7002);
INSERT INTO Meal (sta, mealname, mealtype, unitprice, launchdate, launchdays, mealdescription, mealimg, restaurantid)  VALUES(4, '麻辣藥膳鍋', '火鍋', 450, '2021-07-15 23:04:54', 90, '嗆辣不死鹹', null, 7003);


# 風格類型
CREATE TABLE Style (
	styleid		INT AUTO_INCREMENT NOT NULL,
	styletype   VARCHAR(20),
	CONSTRAINT Style_styleid_PK PRIMARY KEY (styleid)
) AUTO_INCREMENT = 50;

INSERT INTO Style (styletype) VALUES ('燒烤');
INSERT INTO Style (styletype) VALUES ('日式');


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



# 餐廳類型
CREATE TABLE RestaurantStyle (
	restaurantid	INT  NOT NULL,
	styleid	  		INT  NOT NULL,
	CONSTRAINT RestaurantStyle_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES Restaurant (restaurantid),
	CONSTRAINT RestaurantStyle_styleid_FK FOREIGN KEY (styleid) REFERENCES Style (styleid),
    PRIMARY KEY (restaurantid, styleid)
);

INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7001,50);
INSERT INTO RestaurantStyle (restaurantid, styleid) VALUES (7002,51);
