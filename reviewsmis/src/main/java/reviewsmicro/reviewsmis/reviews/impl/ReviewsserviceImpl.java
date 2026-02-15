package reviewsmicro.reviewsmis.reviews.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import reviewsmicro.reviewsmis.reviews.Reviews;
import reviewsmicro.reviewsmis.reviews.ReviewsRepository;
import reviewsmicro.reviewsmis.reviews.reviewsService;


@Service 
public class ReviewsserviceImpl implements reviewsService{
private ReviewsRepository rr;

    public ReviewsserviceImpl(ReviewsRepository rr) {
        this.rr = rr;
    }

    

    @Override
    public List<Reviews> getAllReviews(Long CompanyId) {
        List<Reviews> reviews = rr.findByCompanyId(CompanyId);
        return reviews;
    }

    @Override
    public boolean CreateReview(Long companyId,Reviews Review) {
    if(companyId !=null  && Review !=null){
            Review.setCompanyId(companyId);
            rr.save(Review);
            return true;
    }
    return false;
    }



    @Override
    public Reviews getReviwByid( Long reviewId) {
        return rr.findById(reviewId).orElse(null);
    }



    @Override
    public boolean  Updatereview( Long reviewId, Reviews review) {
    

    Reviews existingReview = rr.findById(reviewId).orElse(null);
    if (existingReview == null) {
        return false;
    }

   

    existingReview.setTitle(review.getTitle());
    existingReview.setDescription(review.getDescription());
    existingReview.setRatings(review.getRatings());
    existingReview.setCompanyId(review.getCompanyId());
    rr.save(existingReview);
    return true;

    }



    @Override
    public boolean deletedReview(Long reviewId) {
        // TODO Auto-generated method stub
   if(rr.existsById(reviewId)){
    Reviews rev= rr.findById(reviewId).orElse(null);
    rr.deleteById(rev.getId());
    return true;

       }
    return false;

}
}