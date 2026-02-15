package reviewsmicro.reviewsmis.reviews;

import java.util.List;

public interface reviewsService {
List<Reviews> getAllReviews(Long CompanyId);
boolean CreateReview(Long companyId,Reviews review);
Reviews getReviwByid(Long reviewId );
boolean Updatereview(Long reviewId,Reviews review );
boolean deletedReview(Long reviewId );
}
