package es.progcipfpbatoi.batoiflix_prg.model.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import es.progcipfpbatoi.batoiflix_prg.exceptions.NotFoundException;
import es.progcipfpbatoi.batoiflix_prg.model.entities.Usuario;

@Repository
public class BatoiFlixRepository {

    private ArrayList<Usuario> usuarios;

    public BatoiFlixRepository() {
        this.usuarios = new ArrayList<>();
        this.usuarios.add(new Usuario(1, "admin", "admin", "admin", "admin@gmail.com","1234" , "admin", null, null));     		
    }

    public Usuario getById(int id) throws NotFoundException {
    	for(Usuario user : usuarios) {
    		if(user.getId() == id) {
    			return user;
    		}
    	}
        throw new NotFoundException("La tarea con codigo "+id+" no existe");
    }
    
    public Usuario getByNombre(String n) throws NotFoundException {
    	for(Usuario user : usuarios) {
    		if(user.getNombre().equals(n)) {
    			return user;
    		}
    	}
        throw new NotFoundException("El usuario con nombre "+n+" no existe");
    }

}


