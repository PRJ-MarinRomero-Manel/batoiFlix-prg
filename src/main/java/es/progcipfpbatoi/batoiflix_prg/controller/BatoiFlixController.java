package es.progcipfpbatoi.batoiflix_prg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.progcipfpbatoi.batoiflix_prg.exceptions.NotFoundException;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Usuario;
import es.progcipfpbatoi.batoiflix_prg.model.repositories.BatoiFlixRepository;
import es.progcipfpbatoi.batoiflix_prg.utils.Validator;



@Controller
public class BatoiFlixController {
	
	@Autowired
	private BatoiFlixRepository repo;	

	@GetMapping("/batoiFlix")
	public String getMenu() {
		return "user_login_view";
	}
	
	@PostMapping("/batoiFlix")
	public String userLog(@RequestParam String name,
	                      @RequestParam String password,
	                      RedirectAttributes redAtt,
	                      Model model) {

	    try {
	        Usuario user = repo.getByNombre(name);

	        if (!user.coincideContrasenya(password)) {
	            redAtt.addFlashAttribute("error", "La contraseña no coincide con el usuario");
	            return "redirect:/batoiFlix";
	        }

	        model.addAttribute("user", user);
	        return "user_main_view";

	    } catch (NotFoundException e) {
	        redAtt.addFlashAttribute("error", "El usuario no existe");
	        return "redirect:/batoiFlix";
	    }
	}

}
