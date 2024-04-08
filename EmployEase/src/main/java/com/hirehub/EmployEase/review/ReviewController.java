package com.hirehub.EmployEase.review;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
        HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId)
    {
        Review review = reviewService.findById(companyId,reviewId);
        if(review!=null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,@RequestBody Review review)
    {
        boolean isReviewAdded =   reviewService.addReview(companyId,review);;
        if(isReviewAdded){
        return new ResponseEntity<>("Review added successfully!",HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>("Review not added company doesn't exist!",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public  ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review)
    {
        boolean isUpdated = reviewService.updateReviewByiId(companyId,reviewId,review);
        if(isUpdated)
        {
            return new ResponseEntity<>("Review updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Review not found!",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public  ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId)
    {
        boolean isDeleted = reviewService.deleteReviewById(companyId,reviewId);
        if(isDeleted)
        {
            return new ResponseEntity<>("Review deleted successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Review not found!",HttpStatus.NOT_FOUND);
        }
    }

}
