package com.hirehub.EmployEase.job;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hirehub.EmployEase.company.Company;
import com.hirehub.EmployEase.jobapplication.JobApplication;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job {

	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	private Integer experience;

	@Enumerated(EnumType.STRING)
	private JOB_TYPE jobType;



	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<JobApplication> applicants;

	@ManyToOne
	private Company company;
	public Company getCompany() {
		return company;
	}

	public Job(long id, String title, String description, String minSalary, String maxSalary, String location,
            Integer experience, JOB_TYPE jobType, List<JobApplication> applicants, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.experience = experience;
        this.jobType = jobType;
        this.applicants = applicants;
        this.company = company;
    }

    public void setCompany(Company company) {
		this.company = company;
	}


	public Job()
	{

	}
	
	public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public JOB_TYPE getJobType() {
        return jobType;
    }

    public void setJobType(JOB_TYPE jobType) {
        this.jobType = jobType;
    }

    public List<JobApplication> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<JobApplication> applicants) {
        this.applicants = applicants;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    public boolean isFullTime() {
        return jobType == JOB_TYPE.FULL_TIME;
    }

    public boolean isInternship() {
        return jobType == JOB_TYPE.INTERNSHIP;
    }
	
}
