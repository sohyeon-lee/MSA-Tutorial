package Pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import Pack.dto.ProductOrderDTO;
import Pack.entity.Product;
import Pack.repository.ProductRepository;

import java.io.IOException;
import java.util.List;
 
@Service
public class KafkaProductService {
	
	@Autowired
	ProductRepository repository;
	
    // 주문
    @KafkaListener(topics = "order", groupId = "group-id-oing")
    public void orderProduct(ProductOrderDTO orderDTO) throws IOException {
    	
    	System.out.println("test 확인");
    	System.out.println(orderDTO);
    	repository.updateStock(orderDTO);
    	repository.deleteProduct();
    }
	
    // 추가
    @KafkaListener(topics = "insert", groupId = "group-id-oing")
    public void insertProduct(ProductOrderDTO orderDTO) throws IOException {
    	
    	System.out.println("test 확인");
    	System.out.println(orderDTO);
    	
    	Product product = new Product();
    	product.setPname(orderDTO.getPname());
    	product.setPrice(orderDTO.getPrice());
    	product.setStock(orderDTO.getStock());
    	
    	repository.save(product);
    }

    
}