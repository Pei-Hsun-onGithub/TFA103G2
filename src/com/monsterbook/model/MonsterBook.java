package com.monsterbook.model;

import java.io.Serializable;

public class MonsterBook implements Serializable {
	
	private Integer monsterId;
	private Integer minDemandLevel;
	private String monsterName;
	private String monsterAbility;
	private byte[] monsterPic;
	
	public MonsterBook() {
	}

	public MonsterBook(Integer monsterId, Integer minDemandLevel, String monsterName, String monsterAbility,
			byte[] monsterPic) {
		this.monsterId = monsterId;
		this.minDemandLevel = minDemandLevel;
		this.monsterName = monsterName;
		this.monsterAbility = monsterAbility;
		this.monsterPic = monsterPic;
	}

	public Integer getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(Integer monsterId) {
		this.monsterId = monsterId;
	}

	public Integer getMinDemandLevel() {
		return minDemandLevel;
	}

	public void setMinDemandLevel(Integer minDemandLevel) {
		this.minDemandLevel = minDemandLevel;
	}

	public String getMonsterName() {
		return monsterName;
	}

	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	public String getMonsterAbility() {
		return monsterAbility;
	}

	public void setMonsterAbility(String monsterAbility) {
		this.monsterAbility = monsterAbility;
	}

	public byte[] getMonsterPic() {
		return monsterPic;
	}

	public void setMonsterPic(byte[] monsterPic) {
		this.monsterPic = monsterPic;
	}

}
