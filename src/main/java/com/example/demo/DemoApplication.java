package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@SpringBootApplication
@Controller
public class DemoApplication{
	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/")
	String hello()
	{
		System.out.println("hello function 被透過網頁驅動");
		//SQL
		return "index";
	}
	@GetMapping("/Hello")
	public String sayHello(){
		return  "index1";
	}
}