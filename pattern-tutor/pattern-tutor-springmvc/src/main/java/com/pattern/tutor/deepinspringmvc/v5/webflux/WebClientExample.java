package com.pattern.tutor.deepinspringmvc.v5.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientExample {

	public static void main(String[] args) {
		WebClient webClient = WebClient.create();
	/*	Mono person = webClient.get()
			.uri("http://localhost:8080/movie/42")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.exchange()
			.then(response -> response.bodyToMono(Movie.class));*/
	}
}
