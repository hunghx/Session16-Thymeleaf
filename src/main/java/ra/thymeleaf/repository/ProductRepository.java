package ra.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.thymeleaf.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
