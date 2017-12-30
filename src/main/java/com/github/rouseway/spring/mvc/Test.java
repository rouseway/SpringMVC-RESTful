package com.github.rouseway.spring.mvc;


//This is a Test Class which shows example of ex-Class used in web-service
//if this class in another project, you should add the project into build/deploy path
public class Test {
	private String testName = "";
	private int testAge = 0;
	
	public Test(String name, int age) {
		testName = name;
		testAge = age;
	}
	
	//if the Class is used to store return and will be convert to JSON
	//you must define SET/GET methods for JSON constructor
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestAge() {
		return testAge;
	}

	public void setTestAge(int testAge) {
		this.testAge = testAge;
	}

	//if the Class is used to implement some functions
	public String mergeNameAge() {
		return testName+Integer.toString(testAge);
	}
	
}
