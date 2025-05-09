package com.wsboot;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.wsboot.openbrowser;
@SpringBootTest
class WsbootApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void loadUrl() throws IOException{
		String url = "http://localhost:9999/personasListAngular";
		openbrowser op = new openbrowser();
		op.openbrowser(url);	

	}	
}
