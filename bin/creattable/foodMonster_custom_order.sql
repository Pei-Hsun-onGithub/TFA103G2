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
VALUES (1),(2),(3),(4),(5),(6),(7),(8);

CREATE TABLE MemberInfo(
	userid  INT NOT NULL,
    CONSTRAINT MemberInfo_userid_PK PRIMARY KEY (userid)
) ;
INSERT INTO MemberInfo (userid)  
VALUES (1),(2),(3),(4),(5),(6),(7),(8);

CREATE TABLE Restaurant(
	restaurantid  INT NOT NULL,
    CONSTRAINT Restaurant_restaurantid_PK PRIMARY KEY (restaurantid)
) ;
INSERT INTO Restaurant(restaurantid)  
VALUES (1);

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

-- INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
-- VALUES (1, '月亮', 0222983345, '台北市', '火大樓', '我要加辣', 1);
-- INSERT INTO Address ( userid, customername, deliverphone, deliveraddress, buildingname, note,  sta)  
-- VALUES (1, '李剛', 0222983345, '台北市', '水大樓', '我不要辣', 2);

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

-- INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
-- 	VALUES(1, '鄭伊健', 1234567812345678, '2023-12-31', 466, '雲林縣虎尾鎮虎興西三街27號', 632, 1);
-- INSERT INTO Card (userid, cardholder, cardnumber, deadline, cvv, billaddress, zipcode, sta)
-- 	VALUES(2, '謝霆鋒', 8765432187654321, '2023-12-31', 689, '宜蘭縣冬山鄉慈惠路29號', 269, 1);
	
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
(userid, restaurantid ,cardid ,deliveryaddid ,deliverymethods, orderday ,resstrtime ,resendtime ,delstrtime ,delendtime ,count ,texts, sta) 
	VALUES 
(1, 1 ,1 ,1 ,0 ,'1000-01-01 08:00:00', '1000-01-01 21:30:00' ,'1000-01-01 08:00:00', '1000-01-01 21:30:00','1000-01-01 21:30:00' ,5 ,null, 1); 
    
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




	 