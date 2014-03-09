package machine.coffee.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import javax.inject.Inject;

import machine.coffee.bean.Astronaut;
import machine.coffee.bean.Page;
import machine.coffee.training.bpp.Timed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestCallsController {
	@Inject
	private Astronaut austronaut;
	
	
	@RequestMapping(value="/fbwebservice")
	@Timed
	public @ResponseBody Page invokeWebService(){
		
		
		System.out.println("Inside invokeWebService");
		RestTemplate restTemplate = new RestTemplate();
        Page page = restTemplate.getForObject("http://graph.facebook.com/adityachaudhary", Page.class);
		return page;
        
	}

}
