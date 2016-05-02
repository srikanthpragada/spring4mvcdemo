package service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import model.Job;
import model.JobRowMapper;

@Repository
public class JobService  {
  
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public JobService(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public List<Job> getJobs() {
		List<Job> jobs = jdbcTemplate.query("select * from jobs", new JobRowMapper());
		return jobs; 
	}
	
	public List<Job> search(String title) {
		List<Job> jobs = jdbcTemplate.query("select * from jobs where upper(job_title) like  ?", new JobRowMapper(),
				   "%" + title.toUpperCase() + "%");
		return jobs; 
	}
}
