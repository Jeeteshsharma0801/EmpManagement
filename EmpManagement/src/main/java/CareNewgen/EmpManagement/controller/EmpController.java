package CareNewgen.EmpManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import CareNewgen.EmpManagement.entity.Employee;
import CareNewgen.EmpManagement.service.EmpService;
//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/") 
	public String home(Model m)
	{
		List<Employee> emp= service.getAllEmp();
		m.addAttribute("employees1" ,emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e , HttpSession session)
	{
		
		service.addEmp(e);
		session.setAttribute("msg","Employee Added Successfully !!");
		
		//System.out.println("Data from user is : "+e);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id , Model m)
	{
		
		Employee e= service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e , HttpSession session)
	{
		service.addEmp(e);
	    session.setAttribute("msg", "Employee Updated successfylly !!");
	    return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}") 
	public String deleteEmp(@PathVariable int id , HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg","Employee Data Deleted Successfully !!");
		return "redirect:/";
	}

}
