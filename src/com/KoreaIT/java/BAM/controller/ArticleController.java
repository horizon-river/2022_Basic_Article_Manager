package com.KoreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.util.Util;

public class ArticleController extends Controller {
	
	private Scanner scan;
	private List<Article> articles;
	
	public ArticleController(Scanner scan, List<Article> articles){
		this.scan = scan;
		this.articles = articles;
	}
	
	public void doAction(String cmd) {
		
	}

	public void doWrite() {
		
		int id = articles.get(articles.size() - 1).id + 1;
		String regDate = Util.getNowDateStr();
		System.out.printf("제목 : ");
		String title = scan.nextLine();
		System.out.printf("내용 : ");
		String body = scan.nextLine();
		
		Article article = new Article(id, regDate, title, body);
		articles.add(article);
		
		System.out.printf("%d번글이 생성되었습니다.\n", id);
		
	}
	
	public void showList(String cmd) {
		
		if(articles.size() == 0) {
			System.out.println("게시물이 없습니다.");
			return;
		}
		
		String searchKeyword = cmd.substring("article list".length()).trim();
		
		List<Article> forPrintArticles = articles;
		
		if(searchKeyword.length() > 0) {
			forPrintArticles = new ArrayList<>();
			
			for(Article article : articles) {
				if(article.title.contains(searchKeyword)) {
					forPrintArticles.add(article);
				}
			}
			
			if(forPrintArticles.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
		}
		
		System.out.printf("번호    |     제목     |            %7s            |    조회\n", "날짜");
		for(int i = forPrintArticles.size() - 1; i >= 0; i--) {
			Article article = forPrintArticles.get(i);
			
			System.out.printf("%7d |   %6s     |       %5s       |   %5d\n", article.id, article.title, article.regDate, article.hit);
		}
		
	}
	
	public void showDetail(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		} else {
			foundArticle.increaseHit();
			
			System.out.printf("번호 : %d\n", foundArticle.id);
			System.out.printf("날짜 : %s\n", foundArticle.regDate);
			System.out.printf("제목 : %s\n", foundArticle.title);
			System.out.printf("내용 : %s\n", foundArticle.body);
			System.out.printf("조회 : %d\n", foundArticle.hit);
		}
		
	}
	
	public void doDelete(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);
		
		int foundIndex = getArticleIndexById(id);
		
		if(foundIndex == -1) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		}
		
		articles.remove(foundIndex);	
		System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
	}
	
	public void doModify(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = Integer.parseInt(cmdBits[2]);
		
		Article foundArticle = getArticleById(id);
		
		if(foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
			return;
		}
		
		System.out.printf("제목 : ");
		String title = scan.nextLine();
		System.out.printf("내용 : ");
		String body = scan.nextLine();
		
		foundArticle.title = title;
		foundArticle.body = body;
		
		System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
		
	}
	
	private Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		
		if(index != -1) {
			return articles.get(index);
		}
		
		return null;
	}
	
	private int getArticleIndexById(int id) {
		int i = 0;
		for(Article article : articles) {
			
			if(article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
}