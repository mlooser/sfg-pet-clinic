package com.example.ml.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"","/","index","index.html"})
	public String index(Model model) {
		
		model.addAttribute("title", "Pet Clinic Index Page");
		
		return "index";
	}
}
