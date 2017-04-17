package com.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	private List<Employee> data;
	
	HelloController(){
		data= new ArrayList<Employee>();
		data.add(new Employee("Budi","Male"));
		data.add(new Employee("Santi","Female"));
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	@ResponseBody
	public List<String> employeeGet( @RequestParam("gender") String gender) {
		
		List<String> tampung= new ArrayList<String>();
		
		for (int i=0;i<data.size();i++)
		{
			if (data.get(i).getGender().equals(gender)==true)
			{
				tampung.add(data.get(i).getName());
			}
			
		}
		
		System.out.println(tampung);
		return tampung;
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@ResponseBody
	public String test() {
		return "True";
	}
	
	@RequestMapping (value="/employees",method=RequestMethod.POST)
	@ResponseBody
	public Employee employeePost(@RequestBody Employee newEmployee) {
		data.add(newEmployee);
		return newEmployee;
	}
	
	
}
