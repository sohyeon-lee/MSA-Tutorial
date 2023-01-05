package Pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="product")
@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private int stock;
	private int price;

}
