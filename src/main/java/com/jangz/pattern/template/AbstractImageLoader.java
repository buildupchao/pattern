package com.jangz.pattern.template;

public abstract class AbstractImageLoader {

	public final void downloadImage(String imageUrl, int width, int height) {
		String finalImageUrl = getUrl(imageUrl, width, height);
		System.out.println("Start download image from " + finalImageUrl);
	}
	
	protected abstract String getUrl(String imageUrl, int width, int height);
}
