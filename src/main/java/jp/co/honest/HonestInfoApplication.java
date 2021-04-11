package jp.co.honest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HonestInfoApplication extends SpringBootServletInitializer { // warファイル作成用: SpringBootServletInitializer

	public static void main(String[] args) {
		SpringApplication.run(HonestInfoApplication.class, args);
	}

}
