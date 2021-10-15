package com.levelexp.model;

import java.io.Serializable;

public class LevelExp implements Serializable {
	
	private Integer Lv;
	private Integer expLow;
	private Integer expUp;
	
	public LevelExp() {
	}

	public LevelExp(Integer lv, Integer expLow, Integer expUp) {
		Lv = lv;
		this.expLow = expLow;
		this.expUp = expUp;
	}

	public Integer getLv() {
		return Lv;
	}

	public void setLv(Integer lv) {
		Lv = lv;
	}

	public Integer getExpLow() {
		return expLow;
	}

	public void setExpLow(Integer expLow) {
		this.expLow = expLow;
	}

	public Integer getExpUp() {
		return expUp;
	}

	public void setExpUp(Integer expUp) {
		this.expUp = expUp;
	}
	
}
