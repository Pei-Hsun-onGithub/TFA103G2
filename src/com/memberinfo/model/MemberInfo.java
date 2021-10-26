package com.memberinfo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class MemberInfo implements Serializable {
	
	private Integer userId;
	private String email;
	private String pwd;
	private String userName;
	private String gender;
	private Date birthday;
	private String phone;
	private byte[] pic;
	private Date registerDate;
	private Integer gold;
	private Integer feed;
	private Integer monsterId;
	private String monsterNickName;
	private Integer Lv;
	private Integer exp;
	private Integer sta;
	
	public MemberInfo() {
	}

	public MemberInfo(Integer userId, String email, String pwd, String userName, String gender, Date birthday, String phone,
			byte[] pic, Date registerDate, Integer gold, Integer feed, Integer monsterId, String monsterNickName, Integer lv, Integer exp,
			Integer sta) {
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getFeed() {
		return feed;
	}

	public void setFeed(Integer feed) {
		this.feed = feed;
	}

	public Integer getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(Integer monsterId) {
		this.monsterId = monsterId;
	}

	public String getMonsterNickName() {
		return monsterNickName;
	}

	public void setMonsterNickName(String monsterNickName) {
		this.monsterNickName = monsterNickName;
	}

	public Integer getLv() {
		return Lv;
	}

	public void setLv(Integer lv) {
		this.Lv = lv;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getSta() {
		return sta;
	}

	public void setSta(Integer sta) {
		this.sta = sta;
	}
	@Override
	public String toString() {
		return "MemberInfo [userId=" + userId + ", email=" + email + ", pwd=" + pwd + ", userName=" + userName
				+ ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", pic=" + Arrays.toString(pic)
				+ ", registerDate=" + registerDate + ", gold=" + gold + ", feed=" + feed + ", monsterId=" + monsterId
				+ ", monsterNickName=" + monsterNickName + ", Lv=" + Lv + ", exp=" + exp + ", sta=" + sta + "]";
	}
	
}
	