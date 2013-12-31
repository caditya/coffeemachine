package machine.coffee.handler;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import machine.coffee.bean.CoffeeJSON;
import machine.coffee.bean.CoffeeXML;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("coffee");
//@SessionAttributes("coffeecatalog")
public class HomeController {

	@PostConstruct
	public void postConstruct(){
		System.out.println("********Constructed HomeController");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("********Pre-Destroy HomeController");
	}
	
	public void init(){
		System.out.println("********Inside HomeController init");
	}
	
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	// @ResponseBody
	public String home(Locale locale, Model model,
			@RequestParam(value = "id", required = false) String id,
			@RequestBody byte[] body,
			@ModelAttribute("session-coffee") CoffeeXML sessionCoffee) {
		
		model.addAttribute("coffeecatalog", getDummyInventory());

		System.out.println("sessinCoffee: " + sessionCoffee.getName());
		// model.addAttribute("coffee",new CoffeeXML("session-coffee",1000));
		String name = ((CoffeeJSON) model.asMap().get("coffeejson")).getName();
		System.out.println("Coffee JSON: "
				+ ((CoffeeJSON) model.asMap().get("coffeejson")).getName());
		System.out.println("mAttString: " + model.asMap().get("mAttString"));
		System.out.println("id is: " + id);
		System.out.println("body: " + body);
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "coffeemachine";
	}

	@RequestMapping(value = "/test/{alpha:[a-z-]+}/extra/{beta:[1-9]+}", method = RequestMethod.GET)
	public String getForDay(@PathVariable Map<String, String> map,
			@PathVariable("alpha") String alpha,
			@PathVariable("beta") String beta, Model model) {
		logger.info("Welcome home! day is: ", alpha);
		System.out.println("beta:  " + beta);
		System.out.println("alpha:  " + alpha);
		System.out.println("alpha in map: " + map.get("alpha"));
		return "home";
	}

	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET)
	public void findPet(@PathVariable String petId, Model model) {
		System.out.println("petId:    " + petId);
	}

	public void findPetById(@RequestParam("id") String id,
			@RequestBody String body) {
		System.out.println("body : " + body);
		System.out.println("id : " + id);

	}

	@RequestMapping(value = "/getxml", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody
	CoffeeXML handle(@RequestBody String body,
			@RequestHeader("Accept") String acceptHeader,
			@RequestHeader("User-Agent") String userAgent) {
		System.out.println("acceptHeader: " + acceptHeader);
		System.out.println("user agent: " + userAgent);
		return new CoffeeXML("java", 10);

	}

	@RequestMapping(value = "/getjson", method = RequestMethod.GET)
	public @ResponseBody
	CoffeeJSON handle_2(@RequestBody String body) {
		System.out.println("json");
		return new CoffeeJSON("java", 10);

	}

	@RequestMapping(value = "/getraw", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String handle_3(@RequestBody String reqBody) {

		System.out.println("raw");
		return "raw data";

	}

	@RequestMapping("/getEntity")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity)
			throws UnsupportedEncodingException {
		String requestHeader = requestEntity.getHeaders().getFirst(
				"MyRequestHeader");
		byte[] requestBody = requestEntity.getBody();
		System.out.println("Body -  to String: " + requestBody.toString());

		// do something with request header and body
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<String>("Hello World", responseHeaders,
				HttpStatus.NOT_FOUND);
	}

	@ModelAttribute("coffeejson")
	public CoffeeJSON addModel() {
		return new CoffeeJSON("1-coffee", 400);
	}

	@ModelAttribute("mAttString")
	public String addStringToModel(Model model) {
		model.addAttribute("session-coffee",
				new CoffeeXML("sesion-coffee", 400));
		return "modelAttributeString";
	}

	@RequestMapping(value = "/home")
	public String homepage() {
		return "home";
	}

	@RequestMapping("/something")
	public void doSomething(CoffeeJSON coffee, Model model) {
		model.addAttribute("coffee", new CoffeeJSON());

	}

	public void doSomwthingElse(@ModelAttribute("coffee") CoffeeJSON coffeejson) {

	}
	
private Collection<CoffeeXML> getDummyInventory(){
		
		CoffeeXML coffee1 = new CoffeeXML();
		coffee1.setName("coffee-session-1");
		coffee1.setQuantity(20);
		
		CoffeeXML coffee2 = new CoffeeXML();
		coffee2.setName("coffee-session-2");
		coffee2.setQuantity(20);
		
		Collection<CoffeeXML> collection = new ArrayList<CoffeeXML>();
		collection.add(coffee1);
		collection.add(coffee2);

		return collection;
		
	}
	
	

}