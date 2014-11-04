package com.github.yjj.test;

public class Person {
	
	public Person(){}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "name:" + name;
	}

}
