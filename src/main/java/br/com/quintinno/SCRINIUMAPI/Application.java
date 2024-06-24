package br.com.quintinno.SCRINIUMAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final String API = "::... SCRINIUM API v1.0.0 IN PORT 8080 ...::";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(API);
	}

	@GetMapping
	public String api() {
		return API;
	}

}
