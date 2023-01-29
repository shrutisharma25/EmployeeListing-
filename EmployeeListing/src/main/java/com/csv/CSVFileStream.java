package com.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CSVFileStream {

	public static void main(String[] args) throws IOException {
		
		Path path=Path.of("src", "main", "resources","employee.csv");

		// For storing data in managers.csv file
		List<Employee> listEmployee1 = Files.lines(path)
				.skip(1)
				.map(CSVFileStream::getEmployee)
				.filter(employee ->
				"Manager".equals(employee.getRole()) && "R&D".equals(employee.getDivision())
						)
				.collect(Collectors.toList());		

		StringBuilder stringBuilder1=new StringBuilder();
		for(Employee emp : listEmployee1) {
			stringBuilder1.append(emp.getName()).append(",").append(emp.getRole()).append(",").append(emp.getDivision()).append("\n");
		}

		try(FileWriter fileWriter1=new FileWriter("src\\main\\resources\\managers.csv")){
			fileWriter1.write(stringBuilder1.toString());
			System.out.println("CSV file Created");
		}catch(Exception e) {
			e.printStackTrace();
		}

		// For storing data in single_name_employees.csv file
		List<Employee> listEmployee2 = Files.lines(path)
				.skip(1)
				.map(CSVFileStream::getEmployee)
				.filter(employee -> 
				employee.getName().split(" ").length==1
						)
				.collect(Collectors.toList());		

		StringBuilder stringBuilder2=new StringBuilder();
		for(Employee emp : listEmployee2) {
			stringBuilder2.append(emp.getName()).append(",").append(emp.getRole()).append(",").append(emp.getDivision()).append("\n");
		}

		try(FileWriter fileWriter2=new FileWriter("src\\main\\resources\\single_name_employees.csv")){
			fileWriter2.write(stringBuilder2.toString());
			System.out.println("CSV file Created");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Employee getEmployee(String line) {
		String[] fields=line.split(",");
		return new Employee(fields[0], fields[1], fields[2]);
	}
}
