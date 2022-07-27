package com.KoreaIT.java.BAM.dao;

public class Dao {
	protected int lastId;
	
	Dao(){
		lastId = 0;
	}
	
	public int getLasdId() {
		return lastId;
	}
	
	public int setNewId() {
		return lastId + 1;
	}
}