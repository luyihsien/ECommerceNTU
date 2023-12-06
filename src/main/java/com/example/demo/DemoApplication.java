package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	String hello(){
		System.out.println("hello function 被透過網頁驅動");
		//SQL
		return "index";
	}
	@GetMapping("/Hello")
	public String sayHello(){
		return  "index1";
	}
}
class Person {
	private int age;
	private String name;
	private boolean gender;

	public Person(int age, String name, boolean gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String display() {
		System.out.println("Age: " + getAge());
		System.out.println("Name: "+getName());
		System.out.println("Gender: "+isGender());
		return "Age: " + getAge()+" Name: "+getName()+" Gender: "+isGender();
	}}
