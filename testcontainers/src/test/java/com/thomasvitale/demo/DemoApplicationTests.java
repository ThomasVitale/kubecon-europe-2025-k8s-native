package com.thomasvitale.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void chat() {
		webTestClient.get()
			.uri("/chat")
			.accept(MediaType.TEXT_PLAIN)
			.exchange()
			.expectStatus().isOk()
			.expectBody(String.class)
			.value(response -> assertThat(response).containsIgnoringCase("London"));
	}

}
