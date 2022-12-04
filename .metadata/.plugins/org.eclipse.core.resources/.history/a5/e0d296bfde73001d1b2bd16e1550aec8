package models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tomcat.util.json.JSONParser;


@Entity 
@Table(name = "products")
public class Products {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String barcode;
	private String quantity;
	private String categoryFK;
	private String companyFK;
	private String price;
	
	public Products () {
		
	}
	public Integer getId() {
		return id;

	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;

	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCategoryFK() {
		return categoryFK;
	}
	public void setCategoryFK(String categoryFK) {
		this.categoryFK = categoryFK;
	}
	public String getCompanyFK() {
		return companyFK;
	}
	public void setCompanyFK(String companyFK) {
		this.companyFK = companyFK;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", barcode=" + barcode + ", quantity=" + quantity
				+ ", categoryFK=" + categoryFK + ", companyFK=" + companyFK + ", price=" + price + "]";
	}



	
}
