package jobmicro.jobmis.job.external;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="company_Table")
public class company {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private List<Long> jobsId;
    private List<Long> reviewsId;

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

    public company(Long id, String name, String description, List<Long> jobsId, List<Long> reviewsId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobsId = jobsId;
        this.reviewsId = reviewsId;
    }

public company(){

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

}

