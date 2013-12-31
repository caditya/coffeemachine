package machine.coffee.bean;

import java.io.Serializable;

 

public class CoffeeJSON implements Serializable{
 
	String name;
	int quantity;
 
	public String getName() {
		return name;
	}
 
	
	public void setName(String name) {
		this.name = name;
	}
 
	public int getQuantity() {
		return quantity;
	}
 

	public void setQuantity(int quanlity) {
		this.quantity = quanlity;
	}
 
	public CoffeeJSON(String name, int quanlity) {
		this.name = name;
		this.quantity = quanlity;
	}
 
	public CoffeeJSON() {
	}
 
}