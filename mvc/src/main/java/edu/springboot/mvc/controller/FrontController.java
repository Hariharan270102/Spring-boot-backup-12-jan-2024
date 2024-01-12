package edu.springboot.mvc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.springboot.mvc.model.Employee;
import edu.springboot.mvc.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FrontController {
	@Autowired
	Employee emp;
	
	@Autowired
	EmployeeService eService;
	
	@RequestMapping("/")
	public String homepage() {
		return "index.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/employee")
	public String addEmployee(Employee emp) 
	{
		String result=eService.addEmployee(emp);
		return result;	
	}
	
	@ResponseBody
	@RequestMapping("/view")
	public ModelAndView viewEmployees(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView("display.jsp");
		ArrayList<Employee> vl=new ArrayList<>();
		vl=eService.viewEmployees();
//		mv.addObject("vl", vl);
		request.setAttribute("vl", vl);
		return mv;
	}
	
	

}
