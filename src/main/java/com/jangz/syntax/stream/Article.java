package com.jangz.syntax.stream;

public class Article {
	private String author;
	private String title;
	private String content;

	public Article(String author, String title, String content) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [author=" + author + ", title=" + title + ", content=" + content + "]";
	}

}
