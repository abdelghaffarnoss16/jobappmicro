package reviewsmicro.reviewsmis.reviews;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Reviews {

    public Reviews() {
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double ratings;
    private Long companyId;

    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Reviews(Long id, String title, String description, double ratings, Long companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ratings = ratings;
        this.companyId = companyId;
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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return double return the ratings
     */
    public double getRatings() {
        return ratings;
    }

    /**
     * @param ratings the ratings to set
     */
    public void setRatings(double ratings) {
        this.ratings = ratings;
    }


    

}