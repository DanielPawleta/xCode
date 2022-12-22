package com.example.xCode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Test
	public void sortTestAscendingOrder() throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,1,2,7,6,3,4,9,5));

		NumbersPostRequest numbersPostRequest = new NumbersPostRequest();
		numbersPostRequest.setOrder("ASC");
		numbersPostRequest.setNumbers(numbers);

		NumbersPostResponse expectedNumbersPostResponse = new NumbersPostResponse();
		expectedNumbersPostResponse.setNumbers(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9)));

		NumbersPostResponse numbersPostResponse;
		numbersPostResponse = this.testRestTemplate.postForObject("http:" +
				"//localhost:" + port + "/numbers/sort-command",
				numbersPostRequest,NumbersPostResponse.class);

		assertThat(numbersPostResponse.getNumbers().equals
				(expectedNumbersPostResponse.getNumbers()));
	}

	@Test
	public void sortTestDescendingOrder() throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(8,1,2,7,6,3,4,9,5));

		NumbersPostRequest numbersPostRequest = new NumbersPostRequest();
		numbersPostRequest.setOrder("DESC");
		numbersPostRequest.setNumbers(numbers);

		NumbersPostResponse expectedNumbersPostResponse = new NumbersPostResponse();
		expectedNumbersPostResponse.setNumbers(new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1)));

		NumbersPostResponse numbersPostResponse;
		numbersPostResponse = this.testRestTemplate.postForObject("http:" +
						"//localhost:" + port + "/numbers/sort-command",
				numbersPostRequest,NumbersPostResponse.class);

		assertThat(numbersPostResponse.getNumbers().equals
				(expectedNumbersPostResponse.getNumbers()));
	}

	@Test
	public void getCurrencyValueTest() throws Exception {
		CurrencyPostRequest currencyPostRequest = new CurrencyPostRequest();
		currencyPostRequest.setCurrency("EUR");

		CurrencyPostResponse currencyPostResponse;
		currencyPostResponse = this.testRestTemplate.postForObject("http:" +
						"//localhost:" + port +
						"/currencies/get-current-currency-value-command",
				currencyPostRequest, CurrencyPostResponse.class);

		assertThat(currencyPostResponse.getValue()!=null);
	}
}
