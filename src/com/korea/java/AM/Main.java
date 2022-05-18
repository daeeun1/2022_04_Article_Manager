package com.korea.java.AM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		List<Article> articles = new ArrayList<>();
		int num = 0;
		

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				continue;
			}
			
			if (command.equals("system exit")) {
				break;
			}
			else if (command.equals("article list")) {
				if (articles.size() == 0 ) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				else {
					System.out.println("게시글 있다.");
				}
				
			}
			else if (command.equals("article write")) {
				int id = num + 1;
				num = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				
				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번글이 생성되었습니다.\n", num);
			}
			else  {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}

		sc.close();
		System.out.println("==프로그램 끝==");
	}
}

class Article{
	int id; 
	String title;
	String body;
	Article(int id, String title, String body){
		this.id = id;
		this.title = title;
		this.body = body;
		
	}
}
