package com.inca.editor;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class EditorApplication {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		SpringApplication.run(EditorApplication.class, args);
	}
}
