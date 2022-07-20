package com.KoreaIT.java.BAM.controller;

import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Member;
import com.KoreaIT.java.BAM.util.Util;

public class MemberController {

	private Scanner scan;
	private List<Member> members;
	
	public MemberController(Scanner scan, List<Member> members) {
		this.scan = scan;
		this.members = members;
	}
	
	public void doJoin() {
		int id = members.size() + 1;
		boolean loginIdCheck = true;
		String regDate = Util.getNowDateStr();
		String loginId = null;
		
		while(true) {
			
			System.out.printf("로그인 아이디 : ");
			loginId = scan.nextLine();
			
			if(isJoinableLoginId(loginId) == false) {		
				System.out.printf("%s은(는) 이미 사용중인 아이디 입니다.\n", loginId);
				continue;
			}
			break;
		}
		
		String loginPw = null;
		String loginPwConfirm = null;
		while(true) {
			
			System.out.printf("로그인 비밀번호 : ");
			loginPw = scan.nextLine();
			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwConfirm = scan.nextLine();
			
			if(loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			break;
		}
		
		System.out.printf("성함을 입력해주세요 : ");
		String name = scan.nextLine();
		
		Member member = new Member(id, regDate, loginId, loginPw, name);
		members.add(member);
		
		System.out.printf("%d번 회원님 환영합니다.\n", id);
		
	}
	
	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		
		if(index == -1) {
			return true;
		}
		
		return false;
	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for(Member member : members) {
			if(member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		
		return -1;
	}

}
