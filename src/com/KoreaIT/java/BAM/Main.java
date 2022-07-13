package com.KoreaIT.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("==프로그램 시작==");
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.printf("명령어 ) ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("exit")) {
				break;
			}
		}
		
		System.out.println("==프로그램 종료==");
		
		scan.close();
	}
}
