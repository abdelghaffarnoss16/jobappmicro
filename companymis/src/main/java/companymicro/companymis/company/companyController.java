package companymicro.companymis.company;

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
@RequestMapping("/companies")
public class companyController {
private final companyService cs;

    public companyController(companyService cs) {
        this.cs = cs;
    }
    @GetMapping("/all")
    public List<company> getallComapnies(){
        return cs.getAllCompanies();
    }
   
    @PutMapping("/{id}")
public ResponseEntity<String> updatecompany(@PathVariable Long id, @RequestBody company companyUpdated){
boolean updated = cs.updateCompany(companyUpdated, id);
if (updated){
return new ResponseEntity<>("company updated",HttpStatus.OK);}
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping("/add")
    public String createJobs(@RequestBody company company){
        cs.createCompany(company);
        return " company added successfully";
    }

    @GetMapping("/{id}")
    public ResponseEntity<company> getCompanyByid(@PathVariable Long id){
       company C = cs.findcompany(id);
       if(C != null){
        return new ResponseEntity<>(C, HttpStatus.OK);
       }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedcomaopny(@PathVariable Long id){
        boolean deleted = cs.deletejcompany(id);
        if(deleted){
            return new ResponseEntity<>("company deleted",HttpStatus.OK);

        }
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
        
}
