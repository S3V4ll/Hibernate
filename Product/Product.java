package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Table(name="Product")    
public class Product {
	
	@Id
	@Column(name="Product_id")
	private int Product_id;
	
	@Column(name="SKU")
	private String SKU;
	
	@Column(name="Product_name")
	private String Product_name;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Product_detail_id" , referencedColumnName = "Product_id")
	private Product_details Product_details;

	//
	
	//Constructor
	public Product() {
		
	}
	
	
	public Product(String sKU, String product_name) {
	
		this.SKU = sKU;
		this.Product_name = product_name;
	
	}


	public int getProduct_id() {
		return Product_id;
	}


	public void setProduct_id(int product_id) {
		Product_id = product_id;
	}


	public String getSKU() {
		return SKU;
	}


	public void setSKU(String sKU) {
		SKU = sKU;
	}


	public String getProduct_name() {
		return Product_name;
	}


	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}


	public Product_details getProduct_details() {
		return Product_details;
	}


	public void setProduct_details(Product_details product_details) {
		Product_details = product_details;
	}


	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", SKU=" + SKU + ", Product_name=" + Product_name
				+ ", Product_details=" + Product_details + "]";
	}






	
}
