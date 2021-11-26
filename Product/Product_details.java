package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Product_details")
public class Product_details {

	@Id
	@Column (name="id")
	private int id;
	
	@Column (name="Product_brand")
	private String Product_brand;
	
	@Column (name="Product_description")
	private String Product_description;

	@Column (name="Product_size")
	private String Product_size;


	@Column (name="Product_color")
	private String Product_color;
	
	@Column (name="Product_weight")
	private String Product_weight;
	
	public Product_details() {
		
	}

	public Product_details(String product_brand, String product_description, String product_size, String product_color,
			String product_weight) {
		
		this.Product_brand = product_brand;
		this.Product_description = product_description;
		this.Product_size = product_size;
		this.Product_color = product_color;
		this.Product_weight = product_weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_brand() {
		return Product_brand;
	}

	public void setProduct_brand(String product_brand) {
		Product_brand = product_brand;
	}

	public String getProduct_description() {
		return Product_description;
	}

	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}

	public String getProduct_size() {
		return Product_size;
	}

	public void setProduct_size(String product_size) {
		Product_size = product_size;
	}

	public String getProduct_color() {
		return Product_color;
	}

	public void setProduct_color(String product_color) {
		Product_color = product_color;
	}

	public String getProduct_weight() {
		return Product_weight;
	}

	public void setProduct_weight(String product_weight) {
		Product_weight = product_weight;
	}

	@Override
	public String toString() {
		return "Product_details [id=" + id + ", Product_brand=" + Product_brand + ", Product_description="
				+ Product_description + ", Product_size=" + Product_size + ", Product_color=" + Product_color
				+ ", Product_weight=" + Product_weight + "]";
	}

	
	
}
