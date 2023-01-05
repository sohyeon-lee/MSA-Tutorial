package Pack.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductOrderDTO {
	
	private int pid;
	private String pname;
	private int stock;
	private int price;

}
