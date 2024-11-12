package com.genpact.fd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.genpact.fd.entity.User;
import com.genpact.fd.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/Users")
	public String listUsers(Model model) {
		model.addAttribute("users",userService.getAllUsers() );
		return "Users";
	}
	
	@GetMapping("/Users/new")
	public String createUser(Model model) {
//		create student object to hold student form data
		User user=new User(); 
		model.addAttribute("user",user);
		return "addnewUser";
		
	}
	
	@PostMapping("/Users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/Users";
	}

	@GetMapping("/Users/edit/{id}")
	public String editUser(@PathVariable Long id,Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edituser";
		
	}
	@PostMapping("/Users/{id}")
	public String updateUser(@PathVariable Long id,@ModelAttribute("user") User user,Model model) {
		User existingUer=userService.getUserById(id);
		existingUer.setId(id);
		existingUer.setFirstName(user.getFirstName());
		existingUer.setLastName(user.getLastName());
		existingUer.setNumber(user.getNumber());
		existingUer.setAddress(user.getAddress());
		existingUer.setPincode(user.getPincode());
		
		userService.saveUser(existingUer);
		return "redirect:/Users";
	}
	
	@GetMapping("/Users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/Users";
	}

}
