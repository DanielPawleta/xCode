package com.example.xCode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTests {
	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getPongTest() throws Exception {
		assertThat(this.testRestTemplate.getForObject("http:" +
				"//localhost:" + port + "/status/ping",String.class)).contains("pong");
	}






}
