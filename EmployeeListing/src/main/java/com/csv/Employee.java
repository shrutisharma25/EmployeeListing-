package com.csv;

public class Employee {
	
	private String name;
	private String role;
	private String division;
	
	public Employee(String name, String role, String division) {
		super();
		this.name = name;
		this.role = role;
		this.division = division;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + ", division=" + division + "]";
	}

}
