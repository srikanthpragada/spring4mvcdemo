package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/names")
public class NamesController {
	
	@RequestMapping("/list")
	public String list(HttpSession session) 
	{
		List<String> names = (List<String>) session.getAttribute("names");
		if (names == null)
			  session.setAttribute("names",new ArrayList<String>());
		return "listNames";
	}
	
	@RequestMapping(value = "/clear") 
	public String clear(HttpSession session) 
	{
		List<String> names = (List<String>) session.getAttribute("names");
		names.clear();
		return "redirect:list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(HttpSession session, @RequestParam("name") String name) 
	{
		List<String> names = (List<String>) session.getAttribute("names");
		names.add(name);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpSession session,  @RequestParam("name") String name) 
	{
		List<String> names = (List<String>) session.getAttribute("names");
		names.remove(name);
		return "redirect:list";
	}
}
