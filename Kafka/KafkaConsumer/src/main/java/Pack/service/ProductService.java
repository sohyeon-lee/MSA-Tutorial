package Pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pack.entity.Product;
import Pack.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
    public List<Product> selectProductList() {
    	List<Product> productList = repository.findAll();    	
    	return productList;
    }

}
