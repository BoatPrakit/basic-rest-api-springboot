package int204.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import int204.backend.model.Product;
import int204.backend.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAllProduct(){
		return productRepository.findAll();
	}
	public String addProduct(Product newProduct) {
		if(!productRepository.existsByProductName(newProduct.getProductName())) {
			productRepository.save(newProduct);
			return "Add complete";
		}
		return "Can't Add please change productName";
	}
	public Product findProduct(long id){
		return productRepository.findById(id).orElse(null);
	}
	public String deleteProduct(long id) {
		boolean isExist = productRepository.existsById(id);
		if(isExist) {
			productRepository.deleteById(id);
			return "Product deleted";
		}
		return "No Product for delete";
	}
	public String updateProduct(long id, Product updatedProduct) {
		Product oldProduct = productRepository.findById(id).orElse(null);
		if(oldProduct == null) {
			return "No Product Found";
		}
		if(updatedProduct.getProductName().equals(oldProduct.getProductName())) {
			return "Please change product name because it was match old name";
		}
		oldProduct.setProductName(updatedProduct.getProductName());
		productRepository.save(oldProduct);
		return "Your Product has been update";
	}
}
