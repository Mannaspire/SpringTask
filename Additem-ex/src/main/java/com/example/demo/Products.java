package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
	private Long productid;

	@Column(name = "name")
	private String name;

	@Lob
	@Column(name = "image", length = 2200)
	private byte[]  image;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private String price;

	@Column(name = "category")
	private String category;

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Products [productid=" + productid + ", name=" + name + ", image=" + image + ", description="
				+ description + ", price=" + price + ", category=" + category + "]";
	}
}
