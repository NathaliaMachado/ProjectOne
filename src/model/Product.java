package model;

import java.sql.Date;

public class Product {
	
	int code;
	Double price;
	String description;
	Date warranty;
	Double costPrice;
	String stock;

	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getWarranty() {
		return warranty;
	}
	
	public void setWarranty(Date warranty) {
		this.warranty = warranty;
	}
	
	public Double getCostPrice() {
		return costPrice;
	}
	
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public String toString(){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("Code: " + this.code + "\n");
		buffer.append("Price: " + this.price + "\n");
		buffer.append("Description: " + this.description + "\n");
		buffer.append("Waranty: " + this.warranty + "\n");
		buffer.append("Stock: " + this.stock + "\n");
		
		return buffer.toString();
	}

}
