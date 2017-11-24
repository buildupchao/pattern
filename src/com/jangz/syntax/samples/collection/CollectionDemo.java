package com.jangz.syntax.samples.collection;

import java.util.ArrayList;
import java.util.List;

import com.jangz.syntax.samples.entity.Article;

public class CollectionDemo {
	
	private List<Article> articles = new ArrayList<>();
	
	public static void main(String[] args) {
		CollectionDemo demo = new CollectionDemo();
		demo.initData();
		System.out.println(demo.getAllJavaArticle());
	}
	
	public void initData() {
		List<String> tags = new ArrayList<>();
		tags.add("Java");
		tags.add("Linux");
		
		articles.add(new Article("Head First Java", "Jang", tags));
		articles.add(new Article("Head First 设计模式", "Jang", tags));
		articles.add(new Article("鸟叔的Linux私房菜", "Jang", tags));
		articles.add(new Article("Java与模式", "Zychao", tags));
	}
	
	public List<Article> getAllJavaArticle() {
		List<Article> result = new ArrayList<>();
		
		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				result.add(article);
			}
		}
		return result;
	}
}
