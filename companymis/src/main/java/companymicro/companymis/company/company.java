package companymicro.companymis.company;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name ="company_Table")
public class company {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double rating;
    @ElementCollection
@CollectionTable(name = "company_jobs",
        joinColumns = @JoinColumn(name = "company_id"))
@Column(name = "job_id")
private List<Long> jobsId = new ArrayList<>();

@ElementCollection
@CollectionTable(name = "company_reviews",
        joinColumns = @JoinColumn(name = "company_id"))
@Column(name = "review_id")
private List<Long> reviewsId = new ArrayList<>();
    public List<Long> getJobsId() {
        return this.jobsId;
    }

    public void setJobsId(List<Long> jobsId) {
        this.jobsId = jobsId;
    }

    public List<Long> getReviewsId() {
        return this.reviewsId;
    }

    public void setReviewsId(List<Long> reviewsId) {
        this.reviewsId = reviewsId;
    }

   

public company(){

}

    public company(Long id, String name, String description, double rating, List<Long> jobsId, List<Long> reviewsId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.jobsId = jobsId;
        this.reviewsId = reviewsId;
    }


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return double return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

}

