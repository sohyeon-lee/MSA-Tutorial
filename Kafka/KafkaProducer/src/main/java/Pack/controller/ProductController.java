package Pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Pack.dto.ProductRequest;
import Pack.dto.ProductResponse;
import Pack.service.ProductService;

@Controller
public class ProductController {
	@Autowired
    private ProductService kafkaSampleProducerService;
	
    @GetMapping(value = "/products")
    public String getProducts(Model model) {
    	List<ProductResponse> products = kafkaSampleProducerService.getProducts();
    	model.addAttribute("products", products);
    	
    	return "index";
    }

    @PostMapping(value = "/order")
    public String order(ProductRequest product) {
    	kafkaSampleProducerService.sendMessage(product);
    	return "redirect:/";
    }

    @PostMapping(value = "/product/insert")
    public String insert(ProductRequest product) {
    	kafkaSampleProducerService.insert(product);
    	return "redirect:/";
    }
}
