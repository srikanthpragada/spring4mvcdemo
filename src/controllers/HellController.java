package controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HellController {

	 @RequestMapping(value="/hello")
	 public String hello(Model model,
			             @RequestParam(name="name",defaultValue="Srikanth Pragada") String name) {
		 model.addAttribute("name",name.toUpperCase());
		 model.addAttribute("today", LocalDate.now().toString());
		 return "hello"; // logical view name
	 }
}
