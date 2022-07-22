package com.KoreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Member;
import com.KoreaIT.java.BAM.util.Util;

public class MemberController extends Controller {

	private Scanner scan;
	private List<Member> members;
	private String cmd;
	private String actionMethodName;
	private Member loginedMember;
	
	public void doAction(String cmd, String actionMethodName) {
		this.cmd = cmd;
		this.actionMethodName = actionMethodName;
		
		switch(actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "profile":
			showProfile();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	public MemberController(Scanner scan) {
		this.scan = scan;
		
		members = new ArrayList<>();
	}
	
	private void doJoin() {
		int id = members.size() + 1;
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
	
	private void doLogin() {
		System.out.printf("로그인 아이디 : ");
		String loginId = scan.nextLine();
		System.out.printf("로그인 비밀번호 : ");
		String loginPw = scan.nextLine();
		
		Member member = getMemberByLoginId(loginId);
		
		if(member == null) {
			System.out.println("일치하는 회원이 없습니다");
			return;
		}
		
		if(loginPw.equals(member.loginPw) == false) {
			System.out.println("비밀번호를 다시 입력해주세요");
			return;
		}
		
		loginedMember = member;
		System.out.printf("로그인 성공! %s님 환영합니다.\n", loginedMember.name);
		
	}
	
	private void showProfile() {
		if(loginedMember != null) {
			System.out.printf("로그인 아이디 : %s\n", loginedMember.loginId);
			System.out.printf("이름 : %s\n", loginedMember.name);
		}else {
			System.out.println("로그아웃 상태입니다");
		}
	}
	
	private Member getMemberByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);
		
		if(index == -1) {
			return null;
		}
		
		return members.get(index);
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
