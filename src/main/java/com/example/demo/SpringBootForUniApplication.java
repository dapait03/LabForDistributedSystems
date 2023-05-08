package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class SpringBootForUniApplication {

	@GetMapping("/helloWorld/{name}")
	public String helloWorld(@PathVariable String name) {
		return "Hello World " + name;
	}

	@PutMapping("/helloWorld/{name}")
	public String helloWorldPut(@PathVariable String name) {
		return "Hello World Put " + name;
	}

	@DeleteMapping("/helloWorld/{name}")
	public String helloWorldDelete(@PathVariable String name) {
		return "Hello World Delete " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootForUniApplication.class, args);
	}

}
