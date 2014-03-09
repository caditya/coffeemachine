package machine.coffee.handler;

import machine.coffee.bean.LoginForm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping(value = "/login")
	public String getHandleLogin(@ModelAttribute LoginForm loginForm) {
		return "login";
	}
}
