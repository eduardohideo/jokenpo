package com.jokenpo.jokenpo;

import com.jokenpo.jokenpo.application.GameEndpoint;
import com.jokenpo.jokenpo.application.PlayerEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JokenpoApplicationTests {

	@Autowired
	GameEndpoint gameEndpoint;

	@Autowired
	PlayerEndpoint playerEndpoint;

	@Test
	void contextLoads() {
		assertThat(gameEndpoint).isNotNull();
		assertThat(playerEndpoint).isNotNull();
	}

}
