package com.hirehub.EmployEase.job;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jobs")
public class JobController {

	private JobService jobService;
	
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("")
	public ResponseEntity<List<Job>> findAll(@RequestHeader("Authorization") String jwt)
	{
		return ResponseEntity.ok((jobService.findAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id,@RequestHeader("Authorization") String jwt)
	{
       Job job = jobService.findJobById(id);
	   if(job!=null)
	   return new ResponseEntity<>(job,HttpStatus.OK);
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJob(@RequestHeader("Authorization") String jwt,
	@RequestParam String keyword)
	{
		return ResponseEntity.ok((jobService.searchJob(keyword)));
	}

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<List<Job>> getSpecificJobs(@RequestHeader("Authorization") String jwt,
	@RequestParam boolean isFullTime, @RequestParam boolean isPartTime, @RequestParam boolean isInternship, @PathVariable Long companyId)
	{
		return ResponseEntity.ok(jobService.getSpecificJobs(companyId,isFullTime,isPartTime,isInternship));
	}

}
