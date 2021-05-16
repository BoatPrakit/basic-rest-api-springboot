package int204.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import int204.backend.model.Product;
import int204.backend.repository.ProductRepository;

@RestController
public class ProductRestController {
	
	private ProductRepository productRepository;
	public ProductRestController() {
	}
	@GetMapping("/health")
	public String health() {
		return "Health good";
	}
	
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
		
}
