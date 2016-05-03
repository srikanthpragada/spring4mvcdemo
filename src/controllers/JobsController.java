package controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Job;
import service.JobService;

@Controller 
public class JobsController {
	
	@Autowired 
	private JobService jobService;
	
	@RequestMapping( value ="/addJob",  method = RequestMethod.GET )
	public String addJob(Model model) {
		Job job = new Job();
		model.addAttribute("job",job);
		return "addJob";
	}
	
	@RequestMapping( value ="/addJob",  method = RequestMethod.POST )
	public String addJobProcess(@Valid  Job job, BindingResult errors, Model model) {
		// add job to database
		if (! errors.hasErrors()) {
		    System.out.println("Add Job");
		    return "redirect:/hrjobs";
		}
		else
		{
			System.out.println("Sorry! Errors");
			return "addJob";
		}
	}
    	
	
	@RequestMapping("/jobs")
	public String list(Model model) {
		
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(new Job("PROG","Programmer"));
		jobs.add(new Job("DBA","Database Adminstrator"));
		jobs.add(new Job("SA","System Analyst"));
		model.addAttribute("jobs", jobs);
		return "jobs";
	}
	
	@RequestMapping("/selectJob")
	public String selectJob(Model model) {
		model.addAttribute("job",new Job());
		model.addAttribute("jobs",  jobService.getJobs());
		return "selectJob";
	}
	
	@RequestMapping("/processJob")
	public String processJob(Job job) {
        System.out.println( job.getId()); 
		return "redirect:/selectJob";
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
