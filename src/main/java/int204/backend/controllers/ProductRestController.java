package int204.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import int204.backend.model.Product;
import int204.backend.services.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	public ProductRestController() {
	}
	@GetMapping("/health")
	public String health() {
		return "Health good";
	}
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productService.findAllProduct();
	}
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable long id) {
		return productService.findProduct(id);
	}
	@PostMapping("/product")
	public String addProduct(@RequestBody Product newproduct) {
		return productService.addProduct(newproduct);	
	}
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}
	@PutMapping("/product/{id}")
	public String updateProduct(@PathVariable long id, @RequestBody Product updatedProduct) {
		return productService.updateProduct(id, updatedProduct);
	}
}
