CREATE DATABASE IF NOT EXISTS fm01;

use fm01;

DROP TABLE IF EXISTS RestaurantStyle;
DROP TABLE IF EXISTS ElasticDayoff;
DROP TABLE IF EXISTS Style;
DROP TABLE IF EXISTS Meal;
DROP TABLE IF EXISTS Restaurant;



# 餐廳廠商 
CREATE TABLE Restaurant (
	restaurantId     	INT AUTO_INCREMENT NOT NULL,
	restaurantName      VARCHAR(20),
	boss       			CHAR(10),
	phone   			CHAR(20),
	district       		CHAR(20),
	city      			CHAR(20),
	location    		CHAR(30),
    openTime    		DATETIME,
    closeTime    		DATETIME,
    dayoffId    		INT NOT NULL,
    weeklyLeave    		CHAR(7),
    sta    				INT ,
	CONSTRAINT Restaurant_restaurantId_PK PRIMARY KEY (restaurantId)
) AUTO_INCREMENT = 7001;

INSERT INTO Restaurant (restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta)  VALUES ('饗食天堂', '連勝蚊', '0222983345', '台北市', '內湖區', '中山路二段19號8樓', '1000-01-01 08:00:00', '1000-01-01 21:30:00', 233, '0001000', 4 );
INSERT INTO Restaurant (restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta)  VALUES ('海霸王', '菜蚊鷹', '0944778449', '台北市', '大同區', '承德路三段42號19樓', '1000-01-01 13:00:00', '1000-01-01 22:30:00', 234, '0000000', 5 );
INSERT INTO Restaurant (restaurantName, boss, phone, district, city, location, openTime, closeTime, dayoffId, weeklyLeave, sta)  VALUES ('Ashidori', '藤原拓海', '0935779049', '新北市', '中和區', '巷尾路89號', '1000-01-01 17:00:00', '1000-01-01 00:30:00', 235, '0100010', 4 );


# 餐點
CREATE TABLE Meal (
	mealId         		INT AUTO_INCREMENT NOT NULL,
	mealStatus     		INT,
	mealName       		VARCHAR(30),
	mealType       		CHAR(10),
	unitPrice      		INT,
	launchDate     		DATE,
	launchDays    		INT,
    mealDescription     VARCHAR(150),
    mealImg    			BLOB,
    restaurantId    	INT NOT NULL,
	CONSTRAINT Meal_restaurantId_FK FOREIGN KEY (restaurantId) REFERENCES Restaurant (restaurantId),
	CONSTRAINT Meal_mealId_PK PRIMARY KEY (mealId)
) AUTO_INCREMENT = 501;

INSERT INTO Meal (mealStatus, mealName, mealType, unitPrice, launchDate, launchDays, mealDescription, mealImg, restaurantId)  VALUES(4, '六塊雞桶', '炸物', 199, '2021-04-19', 60, '適合居家和樂享用', null, 7002);
INSERT INTO Meal (mealStatus, mealName, mealType, unitPrice, launchDate, launchDays, mealDescription, mealImg, restaurantId)  VALUES(4, '麻辣藥膳鍋', '火鍋', 450, '2021-07-15', 90, '嗆辣不死鹹', null, 7003);


# 風格類型
CREATE TABLE Style (
	styleId		INT AUTO_INCREMENT NOT NULL,
	styleType   VARCHAR(20),
	CONSTRAINT Style_styleId_PK PRIMARY KEY (styleId)
) AUTO_INCREMENT = 50;

INSERT INTO Style (styleType) VALUES ('燒烤');
INSERT INTO Style (styleType) VALUES ('日式');


# 彈性休假
CREATE TABLE ElasticDayoff (
	dayofftId		INT AUTO_INCREMENT NOT NULL,
	restaurantId  	INT  NOT NULL,
    newWeeklyLeave 	CHAR(7),
    CONSTRAINT ElasticDayoff_restaurantId_FK FOREIGN KEY (restaurantId) REFERENCES Restaurant (restaurantId),
	CONSTRAINT ElasticDayoff_dayofftId_PK PRIMARY KEY (dayofftId)
) AUTO_INCREMENT = 40;

INSERT INTO ElasticDayoff (restaurantId, newWeeklyLeave) VALUES (7001,'0011000');
INSERT INTO ElasticDayoff (restaurantId, newWeeklyLeave) VALUES (7001,'1100000');
INSERT INTO ElasticDayoff (restaurantId, newWeeklyLeave) VALUES (7003,'0000001');
INSERT INTO ElasticDayoff (restaurantId, newWeeklyLeave) VALUES (7002,'0011100');



# 餐廳類型
CREATE TABLE RestaurantStyle (
	restaurantId	INT  NOT NULL,
	styleId	  		INT  NOT NULL,
	CONSTRAINT RestaurantStyle_restaurantId_FK FOREIGN KEY (restaurantId) REFERENCES Restaurant (restaurantId),
	CONSTRAINT RestaurantStyle_styleId_FK FOREIGN KEY (styleId) REFERENCES Style (styleId),
    PRIMARY KEY (restaurantId, styleId)
);

INSERT INTO RestaurantStyle (restaurantId, styleId) VALUES (7001,50);
INSERT INTO RestaurantStyle (restaurantId, styleId) VALUES (7002,51);
