package jobmicro.jobmis.job.dto;

import java.util.List;

import jobmicro.jobmis.job.external.company;
import jobmicro.jobmis.job.external.review;

public class jobDTO {
    private Long id;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;
    private company company;
    private List<review> review;
  


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
     * @return String return the minsalary
     */
    public String getMinsalary() {
        return minsalary;
    }

    /**
     * @param minsalary the minsalary to set
     */
    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    /**
     * @return String return the maxsalary
     */
    public String getMaxsalary() {
        return maxsalary;
    }

    /**
     * @param maxsalary the maxsalary to set
     */
    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return company return the company
     */
    public company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(company company) {
        this.company = company;
    }




    /**
     * @return List<review> return the review
     */
    public List<review> getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(List<review> review) {
        this.review = review;
    }

}
