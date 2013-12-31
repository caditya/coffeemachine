package machine.coffee.bean;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "coffee")
public class CoffeeXML {
 
	String name;
	int quantity;
	
 
	public String getName() {
		return name;
	}
 
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
 
	public int getQuantity() {
		return quantity;
	}
 
	@XmlElement
	public void setQuantity(int quanlity) {
		this.quantity = quanlity;
	}
 
	public CoffeeXML(String name, int quanlity) {
		this.name = name;
		this.quantity = quanlity;
	}
 
	public CoffeeXML() {
	}
 
}