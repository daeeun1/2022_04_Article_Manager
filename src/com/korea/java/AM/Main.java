package com.korea.java.AM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);
		System.out.printf("명령어 ) ");
		String command = sc.nextLine();
		System.out.println("입력된 명령어 : " + command);


		sc.close();
		System.out.println("==프로그램 끝==");
	}
}
