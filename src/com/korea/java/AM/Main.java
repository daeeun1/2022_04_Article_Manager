package com.korea.java.AM;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		List<Article> articles = new ArrayList<>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
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
			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				} else {
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("%d	| %s\n", article.id, article.title);
					}
				}

			} else if (command.equals("article write")) {
				int id = num + 1;
				num = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d번글이 생성되었습니다.\n", num);
			} else if (command.startsWith("article detail")) {
				String[] commands = command.split(" ");
				int id = Integer.parseInt(commands[2]);
				Article foundArticle = null;
				
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if (foundArticle == null) {
					System.out.println(id + "번 게시물은 존재하지 않습니다.");
				}
				System.out.println("번호 : " + foundArticle.id);
				System.out.println("번호 : " + sdf1.format(now));
				System.out.println("제목 : " + foundArticle.title);
				System.out.println("내용 : " + foundArticle.body);

			} else if (command.startsWith("article delete")) {
				String[] commands = command.split(" ");
				int id = -1;
				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == Integer.parseInt(commands[2])) {
						articles.remove(i);
						id = 0;
						System.out.println(article.id + "번 게시물이 삭제되었습니다.");
					}
				}
				if (id == -1) {
					System.out.println(Integer.parseInt(commands[2]) + "번 게시물은 존재하지 않습니다.");
				}

			} else {
				System.out.println("존재하지 않는 명령어입니다.");
			}
		}

		sc.close();
		System.out.println("==프로그램 끝==");
	}
}

class Article {
	int id;
	String title;
	String body;

	Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;

	}
}
