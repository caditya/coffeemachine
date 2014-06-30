package machine.coffee.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import machine.coffee.bean.CoffeeAvailability;
import machine.coffee.bean.CoffeeJSON;
import machine.coffee.bean.CoffeeXML;
import machine.coffee.service.CoffeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cofeeshop.error.CoffeeNotFound;

@Controller
@SessionAttributes({"coffeecatalog"})
public class CoffeeMachine {
	
	@Autowired
	@Qualifier("primary")
	private CoffeeService coffeeService;
	
	
	public CoffeeService getCoffeeService() {
		return coffeeService;
	}
	//public void configure(CoffeeService coffeeService) {
	//	this.coffeeService = coffeeService;
	//}
	
	
	@RequestMapping(value="/addcoffee", method={RequestMethod.GET, RequestMethod.POST})
	public String addMyCoffee(@ModelAttribute("coffeecatalog") Object coffeecatalog,@ModelAttribute("coffeeJSON") CoffeeJSON coffeejson,BindingResult result ){

			if(result.hasErrors()){
				System.out.println("Has Errors...");
			}
			if(coffeecatalog!=null){
				System.out.println("coffee-catalog is:: " + coffeecatalog);
				
			}
			System.out.println("Name:" + coffeejson.getName());
			return "catalog";
	}
	
	@RequestMapping(value="/viewCatalog", method={RequestMethod.GET, RequestMethod.POST})
	public String viewCatalog(@ModelAttribute("coffeecatalog") Object coffeecatalog,@ModelAttribute("coffeeJSON") CoffeeJSON coffeejson,BindingResult result ){

			if(result.hasErrors()){
				System.out.println("Has Errors...");
			}
			if(coffeecatalog!=null){
				System.out.println("coffee-catalog is:: " + coffeecatalog);
				
			}
			System.out.println("Name:" + coffeejson.getName());
			return "catalog";
	}
	
	
	@ModelAttribute
	public void addToCatalog(Model model, CoffeeJSON coffeejson){
		if(model.asMap().get("coffeecatalog")==null){
			List list = new ArrayList();
			Model addAttribute = model.addAttribute("coffeecatalog",list);
		}
		else{
			ArrayList list  = (ArrayList)model.asMap().get("coffeecatalog");
			list.add(coffeejson);
		}
	}
	
	@RequestMapping("upload")
	public String updloadCoffee(){
		return "uploadcoffee";
		
	}
	
	@RequestMapping("acceptfile")
	public String acceptFile(@RequestParam("name") String fileName, @RequestPart("file") MultipartFile mPartFile){
		System.out.println("in acceptfile...");
		if(mPartFile!=null){
			return "redirect:catalog";
		}
			else{
				return "redirect:error";
			}
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/check/{coffeename}")
	public String getCoffeeDetails(Model model,@ModelAttribute("coffeecatalog") List<CoffeeJSON> catalog, @PathVariable("coffeename") String coffeename) throws Exception{
		System.out.println("catalog: "+ catalog);
		if(!catalog.contains(new CoffeeJSON())){
			throw new CoffeeNotFound();
		}
		
		
		Iterator<CoffeeJSON> iterator = catalog.iterator();
		while(iterator.hasNext()){
			CoffeeJSON coffeejson = iterator.next();
			if(coffeejson.getName().equals(coffeename)){
				model.addAttribute("productdetails",coffeejson);
				break;
			}
		}
		return "productpage";
	} 
	/* Methods to handle exceptions */
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="IO Exception occured")
	@ExceptionHandler(CoffeeNotFound.class)
	public String handleCoffeeNotFoundException(CoffeeNotFound ex, HttpServletRequest request){
		//model.addAttribute("exception_msg","IO Exception occured");
		System.out.println("in handleCoffeeNotFoundException method..");
		request.setAttribute("excecption", "CoffeeNotFound - handleCoffeeNotFoundException method ");
		return "error";
	}
	
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) throws Exception{
		System.out.println("In handleError");
		// If this exception has Response status throw execption again, it will be handled 
		// by method such as handleIOException.
		if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null)
            throw exception;
		
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
	
	// test exception handling
	
	@RequestMapping("/exception")
	public void testExceptions() throws Exception{
		System.out.println("Inside Exception method");
		//throw new IOException();
		throw new NullPointerException();
	}
	
	/* End - methods to handle exceptions*/
	
	//Company catalog
	@RequestMapping("/companycatalog")
	public String companycatalog(){
		return "companycatalog";
	}
	/*
	 * USED BY AJAX TO FIND OUT IF COFFEE IS PRESENT IN INVENTORY.
	 * RETURNS COFFEAVAILABILITY CONVERTED TO JSON.
	 */
	@RequestMapping(value="/checkInventory")
	public @ResponseBody CoffeeAvailability checkInventory(@RequestParam String name){
		System.out.println("Thread name for checkInventory:    "+ Thread.currentThread().getName());
		return coffeeService.getCoffeeAvailability(name);
		
	}
	
	@RequestMapping(value="/updateinventory/{name}/{newname}", method=RequestMethod.PUT  )
	public @ResponseBody boolean updateinventory(@PathVariable("name") String name, @PathVariable(value="newname") String newname){
		System.out.println("name: "+ name);
		System.out.println("newname: "+ newname);
		return true;
	}
	
	
	
	
	private Collection<CoffeeXML> getDummyInventory(){
		
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
	
	
	
		
}

