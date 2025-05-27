package es.progcipfpbatoi.batoiflix_prg.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BatoiFlixController {

	@GetMapping("/batoiFlix")
	public String getMenu() {
		return "user_login_view";
	}
	
	@PostMapping("/user-log")
	@ResponseBody
	public String userLog(@RequestParam Map<String,String> params ) {
		String nombre = params.get("name");
		return nombre;
	}
}
