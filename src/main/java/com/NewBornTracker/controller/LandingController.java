package com.NewBornTracker.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.NewBornTracker.model.User;
import com.NewBornTracker.service.UserService;

@EnableWebMvc
@Controller
public class LandingController {

	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String landing() {
		return "index";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@PostMapping("user")
	public Object login(
			Model model, 
			RedirectAttributes redAtt,
			@RequestParam("luname") String luname,
			@RequestParam("lpword") String lpword) throws IOException {
			
		
		User u = service.findByName(luname);

		if(u != null) {
			if(u.getPassword().equals(lpword)) {
				model.addAttribute("user", u);
				return "dashboard";
			};
		};
		
		redAtt.addFlashAttribute("loginerror", "Username or Password not correct");
		return "redirect:/login";
	}

	@PostMapping("signup")
	public Object signup(
			Model model, 
			RedirectAttributes redAtt,
			@RequestParam Map<String, String> userMap) throws IOException {
			
		User user = service.saveUser(service.mapUser(userMap));
		
		if (user != null) {
			model.addAttribute("user", user);
			return "dashboard";
		}
	
		redAtt.addFlashAttribute("signuperror", "Not valid signup credentials");
		return "redirect:/login";
	}
}
