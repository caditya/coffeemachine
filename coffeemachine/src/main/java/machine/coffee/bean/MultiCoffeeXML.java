package machine.coffee.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace ="machine.coffee.bean.coffeelist1")
public class MultiCoffeeXML {
	
	
	private List<CoffeeXML> coffeeXMLList1;
	
	@XmlElementWrapper(name = "coffee-list")
	@XmlElement(name="coffee")
	public List<CoffeeXML> getCoffeeXMLList() {
		return coffeeXMLList1;
	}
	public void setCoffeeXMLList(List<CoffeeXML> coffeeXMLList1) {
		this.coffeeXMLList1 = coffeeXMLList1;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	private String uploadedBy;
	
	

}
