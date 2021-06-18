package com.zensar.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.zensar.beans.Emp;
import com.zensar.dao.EmpDao;
import com.zensar.service.EmpService;  
@Controller  
public class EmpController {  
    @Autowired  
    private EmpDao dao;
    @Autowired
    private EmpService service;
    
    @RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Emp());
    	return "empform"; 
    }  
    
    @PostMapping(value="/save")  
    public String save(@ModelAttribute("emp") Emp emp){  
        service.save(emp);  
        return "redirect:/viewemp";
    }  
      
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Emp> list=service.getEmployees();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
    
    @RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Emp emp=service.getEmpById(id);    
        m.addAttribute("command",emp);  
        return "empeditform";    
    }    
     
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Emp emp){    
        service.update(emp);    
        return "redirect:/viewemp";    
    }    
    
    @GetMapping(value="/deleteemp/{id}")  
    public String delete(@PathVariable int id){  
        service.delete(id);  
        return "redirect:/viewemp";  
    }   
}  