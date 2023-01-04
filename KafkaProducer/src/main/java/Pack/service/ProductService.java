package Pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Pack.dto.ProductRequest;
import Pack.dto.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
    private KafkaTemplate<String, ProductRequest> postViewKafkaTemplate;
	
	@Autowired
	private RestTemplate restTemplate; // 빈으로 등록해줘야 한다. (main파일에서 빈 등록함)
    
    public void sendMessage(ProductRequest product) {
    	postViewKafkaTemplate.send("order", null, product);
    }

    public void insert(ProductRequest product) {
    	postViewKafkaTemplate.send("insert", null, product);
    }

    public List<ProductResponse> getProducts() {
    	// 다른 서비스를 하고 있는 서버에 요청을 보내고 데이터를 받는다.
    	String msg = "test";
		ResponseEntity<ProductResponse[]> recvProducts =  restTemplate.getForEntity("http://192.168.0.217:8084/select", ProductResponse[].class, msg); 
		
		List<ProductResponse> products = new ArrayList<>();

		for(ProductResponse data : recvProducts.getBody()) {
			ProductResponse dto = new ProductResponse();
			dto.setPid(data.getPid());
			dto.setPname(data.getPname());
			dto.setPrice(data.getPrice());
			dto.setStock(data.getStock());
			products.add(dto);
		}
		
		return products;
    }
}
