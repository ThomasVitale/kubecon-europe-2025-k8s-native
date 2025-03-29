package com.thomasvitale.demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@SuppressWarnings("null")
	RouterFunction<ServerResponse> router(ChatClient.Builder chatClientBuilder) {
		var chatClient = chatClientBuilder.build();
		return RouterFunctions.route()
			.GET("/", _ -> ServerResponse.ok().body("London, baby!"))
			.GET("/chat", request -> ServerResponse.ok().body(chatClient
				.prompt(request.param("message").orElse("What is the capital of England?"))
				.call()
				.content()))
			.build();
	}

}
