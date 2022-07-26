package com.KoreaIT.java.BAM.controller;

import java.util.List;

import com.KoreaIT.java.BAM.dto.Member;

public abstract class Controller {
	
	public static Member loginedMember;

	public static boolean isLogined() {
		return loginedMember != null;
	}
	
	public abstract void doAction(String cmd, String actionMethodName);

	public abstract void makeTestData();
	
}