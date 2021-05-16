package int204.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import int204.backend.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findByProductName(String productName);
	public Boolean existsByProductName(String productName);
}
