package com.example.xCode;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
class XCodeApplicationTests {
	@Autowired
	private MyController myController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(myController).isNotNull();
	}

	@Test
	public void getNumbersTest() throws Exception {
		NumbersPostRequest numbersPostRequest = new NumbersPostRequest();
		numbersPostRequest.setNumbers(new ArrayList<>(Arrays.asList(8,1,2,7,6,3,4,9,5)));

		numbersPostRequest.setOrder("ASC");
		assertThat(numbersPostRequest.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,6,7,8,9));

		numbersPostRequest.setOrder("DESC");
		assertThat(numbersPostRequest.getNumbers()).isEqualTo(Arrays.asList(9,8,7,6,5,4,3,2,1));
	}


}
