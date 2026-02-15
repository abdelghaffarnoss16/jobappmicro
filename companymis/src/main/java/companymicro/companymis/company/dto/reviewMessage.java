package companymicro.companymis.company.dto;

public class reviewMessage {
    private Long id;
    private String title;
    private String description;
    private double ratings;
    private Long companyId;

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

    /**
     * @return Long return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}
