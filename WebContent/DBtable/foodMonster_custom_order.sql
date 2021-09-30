CREATE DATABASE IF NOT EXISTS fm01;

use fm01;

DROP TABLE IF EXISTS OrderList; 	-- 訂單明細
DROP TABLE IF EXISTS RsOrder;		-- 餐點訂單
DROP TABLE IF EXISTS Address;   	-- 外送地址 
DROP TABLE IF EXISTS Card;			-- 信用卡 
DROP TABLE IF EXISTS FavoRestaurant;-- 收藏餐廳
DROP TABLE IF EXISTS MemberInfo;	-- test
DROP TABLE IF EXISTS Restaurant;	-- test
DROP TABLE IF EXISTS Meal;          -- test

CREATE TABLE Meal(
	mealId  INT NOT NULL,
    CONSTRAINT Meal_mealId_PK PRIMARY KEY (mealId)
) ;
INSERT INTO Meal (mealId)  
VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

CREATE TABLE MemberInfo(
	userid  INT NOT NULL,
    CONSTRAINT MemberInfo_userid_PK PRIMARY KEY (userid)
) ;
INSERT INTO MemberInfo (userid)  
VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

CREATE TABLE Restaurant(
	restaurantid  INT NOT NULL,
    CONSTRAINT Restaurant_restaurantid_PK PRIMARY KEY (restaurantid)
) ;
INSERT INTO Restaurant(restaurantid)  
VALUES (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

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
 VALUES (1, '陳國恩', '0222983345', '新竹市北區經國路一段238號', '哥倫比亞大樓', '我要加辣', 1);
 INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (2, '林思倫', '0934808576', '台南市安南區安和路一段186巷15號', '聖心大樓', '我不要辣', 2);
INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (3, '王子純', '0919779933', '台中市太平區宜欣路267號', '美安大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (4, '張苑迪', '0987529962', '新北市三峽區大勇路238號', '聖地安哥大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (5, '昌逸禎', '0963428053', '高雄市鳳山區平等路38號', '智冠大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (6, '王威廷', '0924817741', '苗栗縣頭份市信中路105巷8號7樓', '精誠樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (7, '梁瑋蓁', '0919030566', '新竹縣湖口鄉仁樂路190號', '國泰大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (8, '徐怡婷', '0987121140', '台北市內湖區新湖三路244號', '富邦大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (9, '陳宗翰', '0988310059', '雲林縣台西鄉崙豐路46號', '安泰大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (10, '胡威廷', '0961746675', '台中市北屯區軍功路二段177巷11號', '永森大樓', '我要加辣', 1);
  INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (11, '蔡吉友', '0988811498', '新竹縣關西鎮中山東路39號', '永保大樓', '我要加辣', 1);
 INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
 VALUES (12, '陳冠軒', '0932271151', '台北市文山區萬美街一段85巷3號7樓', '安康大樓', '我要加辣', 1);
 
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
 	VALUES(1, '陳國恩', 4716329842362253, '2023-12-31', '466', '新竹市北區經國路一段238號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(2, '林思倫', 2058942978991061, '2024-05-31', '689', '台南市安南區安和路一段186巷15號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(3, '王子純', 9318776636761858, '2023-04-23', '233', '台中市太平區宜欣路267號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(4, '張苑迪', 8765432187654321, '2023-01-31', '006', '新北市三峽區大勇路238號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(5, '昌逸禎', 0538755043873639, '2025-03-31', '643', '高雄市鳳山區平等路38號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(6, '王威廷', 5332056483252861, '2023-11-23', '360', '苗栗縣頭份市信中路105巷8號7樓', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(7, '梁瑋蓁', 2400596074546732, '2022-10-31', '711', '新竹縣湖口鄉仁樂路190號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(8, '徐怡婷', 5950976460340512, '2021-12-31', '885', '台北市內湖區新湖三路244號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(9, '陳宗翰', 1234567812345678, '2024-01-31', '152', '雲林縣台西鄉崙豐路46號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(10, '胡威廷', 9542710573627430, '2025-05-31', '075', '台中市北屯區軍功路二段177巷11號', '269', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(11, '蔡吉友', 6956674759132833, '2024-08-31', '171', '新竹縣關西鎮中山東路39號', '632', 1);
 INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
 	VALUES(12, '陳冠軒', 3597905196233614, '2023-12-31', '044', '台北市文山區萬美街一段85巷3號7樓', '269', 1);
 	
 	
   # 餐點訂單
CREATE TABLE RsOrder (
	orderid 		INT AUTO_INCREMENT NOT NULL,
	userid     		INT NOT NULL,
	restaurantid    INT NOT NULL,
	cardid       	INT NOT NULL,
	deliveryaddid   INT NOT NULL,
	deliverymethods INT,
	orderday      	datetime,
	resstrtime 	    datetime,
    resendtime    	datetime,
    delstrtime    	datetime,
    delendtime    	datetime,
    count    		INT,
    texts    		VARCHAR(50),
    sta    			INT not null,
	CONSTRAINT RsOrder_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
    CONSTRAINT RsOrder_orderid_PK PRIMARY KEY (orderid)
) AUTO_INCREMENT = 1;

INSERT INTO RsOrder 
(userid,restaurantid ,cardid ,deliveryaddid ,deliverymethods, orderday ,resstrtime ,resendtime ,delstrtime ,delendtime ,count ,texts, sta) 
	VALUES 
(1, 1 ,1 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(1, 4 ,2 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(3, 5 ,3 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(4, 7 ,4 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(5, 7 ,5 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(6, 8 ,6 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(7, 2 ,7 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(8, 3 ,8 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(9, 11 ,9 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(10, 2 ,10 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(11, 6 ,11 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1),
(12, 8 ,12 ,1 ,0 ,'2021-05-05 08:00:00', '2021-05-05 09:30:00' ,'2021-05-05 08:00:00', '2021-05-05 21:30:00','2021-05-05 21:30:00' ,5 ,null, 1);

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
	VALUES (1, 1, '錢錢', '一百', 'NULL');


# 收藏餐廳
CREATE TABLE FavoRestaurant (
	userid  		INT NOT NULL,
    restaurantid 	INT NOT NULL,
    
	CONSTRAINT FavoRestaurant_userid_FK FOREIGN KEY (userid) REFERENCES MemberInfo (userid),
    CONSTRAINT FavoRestaurant_restaurantid_FK FOREIGN KEY (restaurantid) REFERENCES restaurant (restaurantid),
	PRIMARY KEY (userid,restaurantid)
) ;

INSERT INTO FavoRestaurant (userid, restaurantid) VALUES (1,1);




	 