package com.product.controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	 private ProductRepository repository;

	@GetMapping("/")
	public String index(Model model) {
	    // Calling pageAndSorting with default values for sortField and sortDir
	    return pageAndSorting(0, "id", "asc", model); 
	}

	
	@GetMapping("/page/{pid}")
	public String pageAndSorting(
	        @PathVariable int pid,
	        @RequestParam(defaultValue = "id") String sortField,
	        @RequestParam(defaultValue = "asc") String sortDir,
	        Model model) {
	    
	    // Determine the sorting direction
	    Sort.Direction direction = sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
	    
	    // Create a Pageable object with sorting
	    Pageable p = PageRequest.of(pid, 3, Sort.by(direction, sortField));
	    Page<Product> page = repository.findAll(p);
	    List<Product> list = page.getContent();
	    
	    // Add attributes to the model
	    model.addAttribute("pageNo", pid);
	    model.addAttribute("totalelements", page.getTotalElements());
	    model.addAttribute("totalpage", page.getTotalPages());
	    model.addAttribute("show_product", list);
	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	    
	    return "index";
	}

	
	
	@GetMapping("/add")
	public String add()
	{
		return "add";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
	    // Fetch product by ID and throw an exception if not found
	    Product product = repository.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
	    
	    // Add the product to the model
	    model.addAttribute("product", product);
	    
	    // Return the edit template
	    return "edit";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
	    repository.deleteById(id);
	    return "redirect:/";
	}
	

	
	@PostMapping("/save_product")
	public String saveProduct(@ModelAttribute Product product, HttpSession session)
	{
		repository.save(product);
		
		 
		  session.setAttribute("msg", "suucefuully added");
		
		return "redirect:/add";
	}
	
	//remove load
	
	@PostMapping("/clear-message")
	@ResponseBody
	public void clearMessage(HttpSession session) {
	    session.removeAttribute("msg");
	}
	
	@PostMapping("/update_product")
	public String updateProduct(@ModelAttribute Product product, HttpSession session)
	{
		repository.save(product);
		
		 
		  session.setAttribute("msg", "suucefuully updated");
		
		return "redirect:/";
	}
	
}
