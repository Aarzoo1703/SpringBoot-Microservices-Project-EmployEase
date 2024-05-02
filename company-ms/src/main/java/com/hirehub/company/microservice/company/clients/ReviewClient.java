package com.hirehub.company.microservice.company.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="REVIEW-SERVICE")
public interface ReviewClient {

    @GetMapping("/api/reviews/average-rating")
    Double getAverageRatingForCompany(@RequestParam("companyId") Long companyId);
}
