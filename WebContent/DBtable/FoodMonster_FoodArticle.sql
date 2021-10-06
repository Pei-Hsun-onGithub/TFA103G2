CREATE DATABASE IF NOT EXISTS fm01;

use fm01;

Drop table if exists MemberInFo;#測試
Drop table if exists Restaurant;#測試
Drop table if exists FavoFoodArticle;
Drop table if exists Message;
Drop table if exists PictureBase;
Drop table if exists FoodArticle;
#Drop table if exists MemberInFo;#測試
#Drop table if exists Restaurant;#測試

#MemberInFo-test
create table MemberInFo(
	userid int not null primary key
);
insert into MemberInFo(userid) value(1111);
insert into MemberInFo(userid) value(2332);

create table Restaurant(
	restautantid int not null primary key
);

#insert into Restaurant(restaurantid) value(55590);
#insert into Restaurant(restaurantid) value(55591);


#食記區

#食記table
create table FoodArticle(
	articleno int not null auto_increment primary key,
    userid int,
    restaurantid int,
    articletitle varchar(50) not null,
    articledate datetime,
    articlecontent text not null,
    sta int comment"狀態"
    #constraint FoodArticle_userid_FK foreign key(userid) references MemberInFo (userid),
    #constraint FoodArticle_restaurantid_FK foreign key(restaurantid)references Restaurant (restaurantid)
    );
insert into FoodArticle (userid,restaurantid,articletitle,articledate,articlecontent,sta)
values(1111,55590,'賣噹噹好好吃',now(),'薯條酥脆,炸雞好辣哈哈哈哈哈哈',1),(1112,55591,'肯德基好好吃',now(),'青花椒麻雞香辣,太辣!!!!',1)
	,(1113,55593,'迷克夏好喝到爆',now(),'紅茶拿鐵太好喝啦,好喝到不行',1);
    
    #圖片庫table
    create table PictureBase(
		picno int not null auto_increment primary key,
        articleno int,
        pic mediumblob
		constraint PictureBase_articleno_FK foreign key(articleno)references FoodArticle (articleno),
        
	);
    
    
    
    #留言
    create table Message(
		msgno int not null auto_increment primary key,
		articleno int,
        userid int,
		msgdate datetime,
		msgcontent varchar(100),
		sta int
		#constraint Message_articleno_FK foreign key(articleno) references FoodArticle (articleno),
		#constraint Message_userid_FK foreign key(userid) references MemberInFo (userid)
    );    
    insert into Message (articleno,userid,msgdate,msgcontent,sta) values(1,1113,now(),"好吃讚讚",1),(1,1111,now(),"流口水ing",1),(2,1111,now(),"難吃",1),(2,1112,now(),"太辣啦",1);
    
    
    
    #收藏食記table
    create table FavoFoodArticle(
		userid int,
        articleno int,
        #constraint FavoFoodArticle_userid_FK foreign key(articleno) references FoodArticle (articleno),
		#constraint FavoFoodArticle_articleno_FK foreign key(userid) references MemberInFo (userid),
		primary key(userid,articleno)
    
    );
    
    insert into FavoFoodArticle (userid,articleno) values (1111,1),(1111,2);