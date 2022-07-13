package com.KoreaIT.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("==프로그램 시작==");
		
		Scanner scan = new Scanner(System.in);
		
		int command = scan.nextInt();
		
		System.out.printf("입력된 명령어 : %d\n", command);
		
		System.out.println("==프로그램 종료==");
		
		scan.close();
	}
}
