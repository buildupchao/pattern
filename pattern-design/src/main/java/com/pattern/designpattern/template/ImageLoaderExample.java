package com.pattern.designpattern.template;

public class ImageLoaderExample {

	public static void main(String[] args) {
		String imageUrl = "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg";
		AbstractImageLoader loader = new WebpImageLoader();
		loader.downloadImage(imageUrl, 200, 200);
	}
}
