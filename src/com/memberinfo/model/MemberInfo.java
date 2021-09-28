package com.memberinfo.model;

import java.io.Serializable;
import java.sql.Date;

public class MemberInfo implements Serializable {
	
	private int userId;
	private String email;
	private String pwd;
	private String userName;
	private String gender;
	private Date birthday;
	private String phone;
	private byte[] pic;
	private Date registerDate;
	private int gold;
	private int feed;
	private int monsterId;
	private String monsterNickName;
	private int Lv;
	private int exp;
	private int sta;
	
	public MemberInfo() {
	}

	public MemberInfo(int userId, String email, String pwd, String userName, String gender, Date birthday, String phone,
			byte[] pic, Date registerDate, int gold, int feed, int monsterId, String monsterNickName, int lv, int exp,
			int sta) {
		this.userId = userId;
		this.email = email;
		this.pwd = pwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.pic = pic;
		this.registerDate = registerDate;
		this.gold = gold;
		this.feed = feed;
		this.monsterId = monsterId;
		this.monsterNickName = monsterNickName;
		this.Lv = lv;
		this.exp = exp;
		this.sta = sta;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getFeed() {
		return feed;
	}

	public void setFeed(int feed) {
		this.feed = feed;
	}

	public int getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	public String getMonsterNickName() {
		return monsterNickName;
	}

	public void setMonsterNickName(String monsterNickName) {
		this.monsterNickName = monsterNickName;
	}

	public int getLv() {
		return Lv;
	}

	public void setLv(int lv) {
		this.Lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}
	
}
	