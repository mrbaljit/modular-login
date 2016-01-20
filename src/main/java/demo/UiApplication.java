package demo;

import java.security.Principal;
import java.util.*;

import demo.domain.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class UiApplication {

    @Autowired
	UserService userService;

	// Match everything without a suffix (so not a static resource)
	@RequestMapping(value = "/{[path:[^\\.]*}")
	public String redirect() {
		// Forward to home page so that route is preserved.
		return "forward:/";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal user) {
		System.out.println(userService.getAllUsers().size());
		Optional<User> user1 = userService.getUserByEmail("demo@localhost");
		System.out.println(user1.get().getEmail());
		System.out.println(user1.get().getId());
		System.out.println(user1.get().getRole());
		System.out.println(user1.get().getPasswordHash());
		System.out.println(">>>>>>>>>>>>>>>>>");
		return user;
	}

	@RequestMapping("/resource")
	@ResponseBody
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}




}
