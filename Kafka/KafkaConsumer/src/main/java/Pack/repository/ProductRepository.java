package Pack.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Pack.dto.ProductOrderDTO;
import Pack.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query(value = "update Product set stock = stock - :#{#paramProduct.stock} where pid = :#{#paramProduct.pid}")
    @Modifying(clearAutomatically = true)
    @Transactional
    public int updateStock(@Param(value = "paramProduct") ProductOrderDTO orderDTO);
	
	@Query("delete from Product p where p.stock <= 0")
    @Modifying(clearAutomatically = true)
    @Transactional
	public int deleteProduct();
    
    
}