package reviewsmicro.reviewsmis.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long>{

    public List<Reviews> findByCompanyId(Long CompanyId);


}
