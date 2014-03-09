package machine.coffee.handler;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import machine.coffee.bean.*;

@Controller
public class CoffeeCatalog {
	@RequestMapping("/catalog")
	public String getCatalog(Model model, @ModelAttribute("coffeecatalog") ArrayList<CoffeeXML> coffeecatalog){
		System.out.println("size: "+ coffeecatalog.size());
			CoffeeXML coffeexml = new CoffeeXML();
			coffeexml.setName("coffee-sample-name");
			coffeexml.setQuantity(100);
			coffeecatalog.add(coffeexml);
			
			CoffeeXML coffeexml2 = new CoffeeXML();
			coffeexml2.setName("coffee-sample-name");
			coffeexml2.setQuantity(100);
			coffeecatalog.add(coffeexml2);
			
			model.addAttribute("cofeexml", coffeexml);
			//model.addAttribute("coffeecatalog", coffeecatalog);
			
			
		
		return "/it/catalog";
		
	}
}
