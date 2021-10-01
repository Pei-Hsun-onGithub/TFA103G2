package com.levelexp.model;

import java.io.Serializable;

public class LevelExp implements Serializable {
	
	private int Lv;
	private int expLow;
	private int expUp;
	
	public LevelExp() {
	}

	public LevelExp(int lv, int expLow, int expUp) {
		Lv = lv;
		this.expLow = expLow;
		this.expUp = expUp;
	}

	public int getLv() {
		return Lv;
	}

	public void setLv(int lv) {
		Lv = lv;
	}

	public int getExpLow() {
		return expLow;
	}

	public void setExpLow(int expLow) {
		this.expLow = expLow;
	}

	public int getExpUp() {
		return expUp;
	}

	public void setExpUp(int expUp) {
		this.expUp = expUp;
	}
	
}
