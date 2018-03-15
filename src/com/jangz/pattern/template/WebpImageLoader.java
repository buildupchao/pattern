package com.jangz.pattern.template;

public class WebpImageLoader extends AbstractImageLoader {

	@Override
	protected String getUrl(String imageUrl, int width, int height) {
		return String.format("%s?imageView2/1/w/%d/h/%d/format/webp", imageUrl, width, height);
	}

}
