package com.pattern.tutor.syntax.action.newfeature.java8.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseJavaStream {
	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("jangz", "Java8 Stream", "Java8 Stream"));
		articles.add(new Article("jangz", "Design Pattern and Development", "Design Pattern and Development"));
		articles.add(new Article("Zychaowill", "Machine Learning in Action", "Machine Learning in Action"));
		articles.add(new Article("Forward", "Spark in Action", "Spark in Action"));

		/*new UseJavaStream().groupByAuthorWithStream(articles).entrySet().iterator().forEachRemaining(item -> {
			System.out.print(item.getKey() + " : ");
			item.getValue().forEach(System.out::print);
			System.out.println();
		});*/

		new UseJavaStream().groupByAuthorWithStream(articles)
				.forEach((key, value) -> System.out.println(key + " : " + value));
	}

	public Map<String, List<Article>> groupByAuthor(List<Article> articles) {

		Map<String, List<Article>> result = new HashMap<>();

		for (Article article : articles) {
			if (result.containsKey(article.getAuthor())) {
				result.get(article.getAuthor()).add(article);
			} else {
				ArrayList<Article> articleList = new ArrayList<>();
				articleList.add(article);
				result.put(article.getAuthor(), articleList);
			}
		}

		return result;
	}

	public Map<String, List<Article>> groupByAuthorWithStream(List<Article> articles) {
		return articles.stream().collect(Collectors.groupingBy(Article::getAuthor));
	}
}
