package machine.coffee.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import machine.coffee.bean.CoffeeAvailability;
import machine.coffee.bean.CoffeeXML;
import machine.coffee.dao.CoffeeInventoryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.SmartLifecycle;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service(value="asda")
@Qualifier("primary")
public class CoffeeServiceImpl implements CoffeeService, SmartLifecycle {
	@Autowired
	private CoffeeInventoryDAO coffeeInventoryDAO;

	private Collection<CoffeeXML> getDummyInventory() {

		CoffeeXML coffee1 = new CoffeeXML();
		coffee1.setName("coffee01");
		coffee1.setQuantity(20);

		CoffeeXML coffee2 = new CoffeeXML();
		coffee2.setName("coffee01");
		coffee2.setQuantity(20);

		Collection<CoffeeXML> collection = new ArrayList<CoffeeXML>();
		collection.add(coffee1);
		collection.add(coffee2);

		return collection;

	}

	@Override

public CoffeeAvailability getCoffeeAvailability(String name) {
	System.out.println("Thread name for coffeeServiceImpl.getCoffeeAvailability:   "+ Thread.currentThread().getName());
	CoffeeAvailability avail = new CoffeeAvailability();
	avail.setAvailable("false");
	avail.setSuggestions("You may add this coffee");
	
	/*for(Iterator<CoffeeXML>  iterator = getDummyInventory().iterator();iterator.hasNext();){
		if(iterator.next().getName().equals(name)){
			avail.setAvailable("true");
			avail.setSuggestions("'");
			break;
		}
	}
	*/
	if(name.equals(coffeeInventoryDAO.getCoffeeAvailability(name).getName())){
		avail.setAvailable("true");
		avail.setSuggestions("'");
	}
	//avail.setAvailable("false");
	return avail;
}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPhase() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void stop(Runnable arg0) {
		// TODO Auto-generated method stub

	}

}
