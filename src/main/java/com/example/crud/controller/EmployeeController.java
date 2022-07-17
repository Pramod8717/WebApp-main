package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// display list of employees

	@GetMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";  

	}
	

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		System.out.println("geted....");
		// create model attribute to bind form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		System.out.println("getting....");
		return "new_employee";  	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		System.out.println("Save...!");
		
		employeeService.saveEmployee(employee);
		System.out.println("Successfully save :- "+employee);
		return "redirect:/";  

	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// set employee from service
		Employee employee = employeeService.getEmployeeById(id);
		// set a employee as a model attribute to pre-populate the form
		model.addAttribute("employee", employee);
		return "update_employee";   // pending..
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
System.out.println("Deleted.....! ");
		// call delete employee method
		this.employeeService.deleteEmployeeById(id);
		System.out.println("Deleted..Data...! ");
		return "redirect:/";   

	}

}
