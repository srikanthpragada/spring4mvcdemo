package controllers;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@RequestMapping("/today")
	public String getDate() {
		return "today";  // view name
	}
	

	@RequestMapping("/now")
	public @ResponseBody  String getNow() {
		return  LocalTime.now().toString();  // output to be sent directly to client
	}
}
