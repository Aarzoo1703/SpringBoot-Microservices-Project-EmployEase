package com.hirehub.jobapplication.microservice.jobapplication.mapper;

import com.hirehub.jobapplication.microservice.jobapplication.JobApplication;
import com.hirehub.jobapplication.microservice.jobapplication.dto.JobApplicationDto;
import com.hirehub.jobapplication.microservice.jobapplication.external.Company;
import com.hirehub.jobapplication.microservice.jobapplication.external.User;

public class JobApplicationMapper {

    public static JobApplicationDto mapToJobApplicationDto(JobApplication jobApplication, Company company, User user)
    {
        JobApplicationDto jobApplicationDto = new JobApplicationDto();
        jobApplicationDto.setJobApplicationId(jobApplication.getJobApplicationId());
        jobApplicationDto.setStatus(jobApplication.getStatus());
        jobApplicationDto.setAppliedDate(jobApplication.getAppliedDate());
        jobApplicationDto.setCompany(company);
        jobApplicationDto.setUserProfile(user);
        return jobApplicationDto;
    }

}
