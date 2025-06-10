package es.progcipfpbatoi.batoiflix_prg.controller;

import java.util.ArrayList;
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

import es.progcipfpbatoi.batoiflix_prg.exceptions.IncorrectPasswordException;
import es.progcipfpbatoi.batoiflix_prg.exceptions.NotFoundException;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Produccion;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Usuario;
import es.progcipfpbatoi.batoiflix_prg.model.repositories.BatoiFlixRepository;
import es.progcipfpbatoi.batoiflix_prg.model.repositories.BatoiFlixSQLRepository;
import es.progcipfpbatoi.batoiflix_prg.utils.Validator;



@Controller
public class BatoiFlixController {
	
	@Autowired
	private BatoiFlixSQLRepository repo;	

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
	        Usuario user = repo.validarLogin(name, password);
	        model.addAttribute("user", user);
	        return "user_main_view";

	    } catch (NotFoundException e) {
	        redAtt.addFlashAttribute("error", "El usuario no existe");
	    } catch (IncorrectPasswordException e) {
	        redAtt.addFlashAttribute("error", "La contraseña no coincide con el usuario");
	    }
	    return "redirect:/batoiFlix";
	}

	@GetMapping ("/mejorValoradas")
	public String getMejorValoraciones(Model model) {
	    model.addAttribute("recomendadas", repo.getMasRecomendados());
	    return "mejor_valoradas_view";  
	}

}
