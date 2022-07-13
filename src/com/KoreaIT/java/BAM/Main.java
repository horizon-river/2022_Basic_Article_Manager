package com.KoreaIT.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("==프로그램 시작==");
		
		Scanner scan = new Scanner(System.in);
		
		int lastArticleId = 0;
		String[] articleTitle = new String[100];
		String[] articleContent = new String[100];
		
		while(true) {
			System.out.printf("명령어 ) ");
			String cmd = scan.nextLine();
			
			if(cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("article write")) {
				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.printf("제목 : ");
				articleTitle[lastArticleId] = scan.nextLine();
				System.out.printf("내용 : ");
				articleContent[lastArticleId] = scan.nextLine();
				System.out.printf("%d번글이 생성되었습니다.\n", lastArticleId);
			} else if(cmd.equals("article list")) {
				System.out.println("게시물이 없습니다.");
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		
		System.out.println("==프로그램 종료==");
		
		scan.close();
	}
}
