package machine.coffee.dao;

import machine.coffee.bean.CoffeeXML;

public interface CoffeeInventoryDAO {
	
	public abstract CoffeeXML getCoffeeAvailability(String coffeeName);


}