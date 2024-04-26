package ra.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.thymeleaf.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
