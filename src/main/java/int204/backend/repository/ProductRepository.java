package int204.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import int204.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
