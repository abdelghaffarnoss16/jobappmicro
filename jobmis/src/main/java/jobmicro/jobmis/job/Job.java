package jobmicro.jobmis.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_table")
public class Job {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;
    private Long companyId;
    
    public Job(){
        
    }


    public Job(Long id, String title, String description, String minsalary, String maxsalary, String location, Long companyId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minsalary = minsalary;
        this.maxsalary = maxsalary;
        this.location = location;
        this.companyId = companyId;
    }


    /**
     * @return long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
     * @return String return the Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.description = Description;
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


    public Long getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

   

}
