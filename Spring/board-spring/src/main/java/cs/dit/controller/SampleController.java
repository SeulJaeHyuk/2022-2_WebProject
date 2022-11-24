package cs.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("/basic")
	public void basic() {
		log.info("basic......................................");
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		log.info("ex01.........................");
		
		return "/sample/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(String name) {
		log.info("ex02.....................");
		
		log.info("name : " + name);
		return "/sample/ex02";
	}
	
	@GetMapping("/ex03")
	public void ex03(@RequestParam("id") String name) {
		log.info("ex03 .....................");
		log.info("name : " + name);
	}
	
	
	@GetMapping("/ex04")
	public void ex04(@ModelAttribute("id") String name) {
		log.info("ex04 .....................");
		log.info("name : " + name);
	}
	
	@GetMapping("/ex05")
	public String ex05(String name) {
		log.info("ex05 .....................");
		log.info("name : " + name);
		return "redirect:/";
	}
}