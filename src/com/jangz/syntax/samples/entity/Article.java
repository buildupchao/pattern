package com.jangz.syntax.samples.entity;

import java.util.List;

/**
 * @author jangz
 *
 */
public class Article {

	private String title;

	private String author;

	private List<String> tags;

	public Article(String title, String author, List<String> tags) {
		super();
		this.title = title;
		this.author = author;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", author=" + author + ", tags=" + tags + "]";
	}

}
