package reviewsmicro.reviewsmis.reviews;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reviewsmicro.reviewsmis.reviews.messaging.ReviewMessageProducer;

@RestController
@RequestMapping("/reviews")
public class reviewsController {
 private final reviewsService rs;
    private ReviewMessageProducer rmp;
    public reviewsController(reviewsService rs,ReviewMessageProducer rmp) {
        this.rs = rs;
        this.rmp=rmp;
    }


    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(rs.getAllReviews(companyId),HttpStatus.OK);
    }

@PostMapping("/add")
public ResponseEntity<String> CreateReviews(@RequestBody Reviews Review,@RequestParam Long companyId ){
        boolean created =rs.CreateReview(companyId,Review);
    if(created){
        return new ResponseEntity<>("review created ",HttpStatus.OK);
    }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

@GetMapping("{reviewId}")
public ResponseEntity<Reviews> getReview(@PathVariable Long reviewId){
    return new ResponseEntity<>(rs.getReviwByid(reviewId), HttpStatus.OK);
}
@PutMapping("{reviewId}")
public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Reviews Review ){
    boolean updated =rs.Updatereview( reviewId, Review);
    if(updated){
        return new ResponseEntity<>("review updated ",HttpStatus.OK);
    }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
@DeleteMapping("{reviewId}")
public ResponseEntity<String> DeleteReview(@PathVariable Long reviewId){
    boolean deleted=rs.deletedReview(reviewId);
      if(deleted){
        return new ResponseEntity<>("review deleted ",HttpStatus.OK);
    }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

@GetMapping("/averagerating")
public double getaverageRating(@RequestParam Long companyId){
List<Reviews> reviews=rs.getAllReviews(companyId);
return reviews.stream().mapToDouble(Reviews::getRatings).average().orElse(0.0);

}

}

