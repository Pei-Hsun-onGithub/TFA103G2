package com.monsterbook.model;

import java.io.Serializable;

public class MonsterBook implements Serializable {
	
	private int monsterId;
	private int minDemandLevel;
	private String monsterName;
	private String monsterAbility;
	private byte[] monsterPic;
	
	public MonsterBook() {
	}

	public MonsterBook(int monsterId, int minDemandLevel, String monsterName, String monsterAbility,
			byte[] monsterPic) {
		this.monsterId = monsterId;
		this.minDemandLevel = minDemandLevel;
		this.monsterName = monsterName;
		this.monsterAbility = monsterAbility;
		this.monsterPic = monsterPic;
	}

	public int getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(int monsterId) {
		this.monsterId = monsterId;
	}

	public int getMinDemandLevel() {
		return minDemandLevel;
	}

	public void setMinDemandLevel(int minDemandLevel) {
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
