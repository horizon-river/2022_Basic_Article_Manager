package com.KoreaIT.java.BAM;

import java.util.Scanner;

import com.KoreaIT.java.BAM.controller.ArticleController;
import com.KoreaIT.java.BAM.controller.Controller;
import com.KoreaIT.java.BAM.controller.MemberController;

public class App {
	
	public App() {
		
	}
	
	public void run() {
		
		System.out.println("==프로그램 시작==");
		
		Scanner scan = new Scanner(System.in);
		
		MemberController memberController = new MemberController(scan);
		ArticleController articleController = new ArticleController(scan);
		
		articleController.makeTestData();
		memberController.makeTestData();
		
		while(true) {
			System.out.printf("명령어 ) ");
			String cmd = scan.nextLine().trim();
			
			String[] cmdBits = cmd.split(" ");
			
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmdBits.length == 1) {
				System.out.println("명령어를 확인해주세요");
				continue;
			}
			
			String controllerName = cmdBits[0];
			String actionMethodName = cmdBits[1];
			
			Controller controller = null;
			
			if(controllerName.equals("article")) {
				controller = articleController;
			}else if(controllerName.equals("member")) {
				controller = memberController;
			}else {
				System.out.println("존재하지 않는 명렁어입니다.");
				continue;
			}
			
			controller.doAction(cmd, actionMethodName);
		}
		
		System.out.println("==프로그램 종료==");
		scan.close();
	}
	
}
