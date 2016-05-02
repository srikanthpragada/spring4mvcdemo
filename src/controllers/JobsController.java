package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Job;
import service.JobService;

@Controller 
public class JobsController {
	
	@Autowired 
	private JobService jobService;
	
	@RequestMapping("/jobs")
	public String list(Model model) {
		
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job("PROG","Programmer"));
		jobs.add(new Job("DBA","Database Adminstrator"));
		jobs.add(new Job("SA","System Analyst"));
		model.addAttribute("jobs", jobs);
		return "jobs";
		
	}
	
	@RequestMapping("/hrjobs")
	public String listHrJobs(Model model) {
		model.addAttribute("jobs",  jobService.getJobs());
		return "hrjobs";
	}
	
	@RequestMapping("/searchJobs")
	public String searchJobs(Model model, @RequestParam("title") String title) {
		model.addAttribute("jobs",  jobService.search(title));
		return "hrjobs";
	}
	
	@RequestMapping("/search/{title}")
	public String searchJobs2(Model model, @PathVariable("title") String title) {
		model.addAttribute("jobs",  jobService.search(title));
		return "hrjobs";
	}

}
