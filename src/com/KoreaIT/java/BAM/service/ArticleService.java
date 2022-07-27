package com.KoreaIT.java.BAM.service;

import java.util.List;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.dto.Article;

public class ArticleService {

	public List<Article> getForPrintArticles(String searchKeyword) {
		List<Article> articles = Container.articleDao.getArticles(searchKeyword);
		
		return articles;
	}

	public Article getArticleById(int id) {
		int index = getArticleIndexById(id);
		
		if(index != -1) {
			return Container.articleDao.getArticles().get(index);
		}
				
		return null;
	
	}
	
	private int getArticleIndexById(int id) {
		int i = 0;
		for(Article article : Container.articleDao.getArticles()) {
			
			if(article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
}