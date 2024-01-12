package edu.springboot.mvc1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.springboot.mvc1.model.Employee;
import edu.springboot.mvc1.repository.EmployeeRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@Controller
public class EmployeeFrontController {
	@Autowired
	EmployeeRepository repo;
	
	@RequestMapping("/")
	public String homepage() {
		return "index.jsp";
	}
	
	@RequestMapping("/add_employee")
	@ResponseBody
	public String addEmployee(Employee emp) {
		repo.save(emp);
		return "Employee added successfully!!!";
	}
	
	@RequestMapping("/view_emp")
	@ResponseBody
	public ModelAndView viewEmployees() {
		ArrayList<Employee> vl=(ArrayList<Employee>) repo.findAll();
		ModelAndView mv=new ModelAndView("viewEmp.jsp");
		mv.addObject("vl", vl);
		return mv;
	}
	
	@RequestMapping("/search_emp")
	public String searchEmployee() {
		return "search.jsp";
	}
	
	@RequestMapping("/searchBy")
	@ResponseBody
	public ModelAndView searchBy(String search)
//	(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		{
			ModelAndView mv = null;
//		String choice=request.getParameter("search");
		if(search.equals("Search By Id"))
		{
			mv = new ModelAndView("id.jsp");
//			RequestDispatcher rd=request.getRequestDispatcher("id.jsp");
//			rd.forward(request, response);
//			return repo.findByEid(2).toString();
		}
		else if(search.equals("Search By Name")) {
			mv = new ModelAndView("name.jsp");

//			RequestDispatcher rd=request.getRequestDispatcher("name.jsp");
//
//			return repo.findByEname("Hari").toString();
		}
		else if(search.equals("Search By Salary")) {
			mv = new ModelAndView("salary.jsp");

//			RequestDispatcher rd=request.getRequestDispatcher("salary.jsp");
//
//			return repo.findBySalary(100000).toString();
		}
		else if(search.equals("Search By Department")) {
			mv = new ModelAndView("dept.jsp");

//			RequestDispatcher rd=request.getRequestDispatcher("dept.jsp");
//
//			return repo.findByDept("Hr").toString();
		}
		else {
			mv = new ModelAndView("search.jsp");

//			return repo.findAll().toString();
		}
		
		return mv;
		
	}
	
	@RequestMapping("/idsearch")
	@ResponseBody
	public ModelAndView idsearch(int search_id) {
		ArrayList<Employee> vl=(ArrayList<Employee>) repo.findByEid(search_id);
		ModelAndView mv=new ModelAndView("display.jsp");
		mv.addObject("vl", vl);
		return mv;
		
//		return repo.findByEid(search_id).toString();

	}
	
	@RequestMapping("/namesearch")
	@ResponseBody
	public ModelAndView idsearch(String search_name) {
		ArrayList<Employee> vl=(ArrayList<Employee>) repo.findByEname(search_name);
		ModelAndView mv=new ModelAndView("display.jsp");
		mv.addObject("vl", vl);
		return mv;
//		return repo.findByEname(search_name).toString();

	}
	
	@RequestMapping("/salarysearch")
	@ResponseBody
	public ModelAndView salarysearch(int search_salary) {
		ArrayList<Employee> vl=(ArrayList<Employee>) repo.findBySalary(search_salary);
		ModelAndView mv=new ModelAndView("display.jsp");
		mv.addObject("vl", vl);
		return mv;
//		return repo.findBySalary(search_salary).toString();

	}
	
	@RequestMapping("/deptsearch")
	@ResponseBody
	public ModelAndView deptsearch(String search_dept) {
		ArrayList<Employee> vl=(ArrayList<Employee>) repo.findByDept(search_dept);
		ModelAndView mv=new ModelAndView("display.jsp");
		mv.addObject("vl", vl);
		return mv;
//		return repo.findByDept(search_dept).toString();

	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteEmp(int eid) {
		System.out.println(eid);
		ModelAndView mv=new ModelAndView();
		repo.deleteById(eid);
		return "Employee deleted";
		
	}

	@RequestMapping("/deleteChoices")
	@ResponseBody
	@Transactional
	public String deleteChoices(String del_choice,String data) {
		if(del_choice.equals("id")) {
			repo.deleteById(Integer.parseInt(data));
		}
		else if(del_choice.equals("name")) {
			repo.deleteByName(data);
		}
		else if(del_choice.equals("dept")) {
			repo.deleteDept(data);
		}
		return "deleted successfully";

		
	}
	
}
