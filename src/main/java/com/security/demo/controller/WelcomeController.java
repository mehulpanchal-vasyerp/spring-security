package com.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class WelcomeController {
	@GetMapping("/user")
	public ModelAndView user() {
		ModelAndView mav = new ModelAndView("UserPage");
		return mav;
	}

	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("AdminPage");
		return mav;
	}

	@GetMapping("/secure")
	public String secure(){
	return "hello from secure point";	
	}


//	@Autowired
//	private CustomUserService customUserService;

//	@GetMapping("/welcome")
//	public String getWelcome() {
//		return "welcome";
//	}

//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}

//	@GetMapping("/clogin")
//	public String regist() {
//		return "clogin";
//	}

//	@PostMapping("/addUser")
//	public String addUser(UserDetailDto userDetailDto) {
//		customUserService.saveUser(userDetailDto);
//		return "redirect:/clogin";
//	}

//	@GetMapping("/admin")
//	public String admin() {
//		return "admin";
//	}

//	@GetMapping("/user")
//	public String user() {
//		return "user";
//	}
//	@GetMapping("/forgotpassword")
//	public String openemailform() {
//		return "forgotpassword";
//	}
//	@PostMapping("/sendotp")
//	public String sendotp(@RequestParam("email") String email) {
//		Random random=new Random(1000);
		//	int otp=random.nextInt(999999);
		///return "sendotp";
		
		
//		@PostMapping("/addUser")
		///public ResponseEntity<AuthenticationResponse> addUser(@RequestBody UserDetailDto userDetailDto){
			//return ResponseEntity.ok(authenticationService.register(userDetailDto));
		//}
		//@PostMapping("/authenticate")
		//public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
		//	return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
		

		
	}
	
	

