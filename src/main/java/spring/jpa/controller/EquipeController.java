package spring.jpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.jpa.model.Equipe;
import spring.jpa.repository.EquipeRepository;


@RestController // pour déclarer un service web de type REST
@RequestMapping("/equipes")  
@CrossOrigin("*")
public class EquipeController {
	
	@Autowired // pour l'injection de dépendances
	private EquipeRepository equipeRepos;
	
		@GetMapping(value= "/", produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
		public  List<Equipe> getAllList() {
			return equipeRepos.findAll();
		}
		
		@GetMapping(value= "/search")
		public  List<Equipe> search(@RequestParam(name= "keyword", defaultValue="") String keyword) {
			return equipeRepos.findByNomLike("%"+keyword+"%");

		}
		
			@PostMapping(value = "/"  ,
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  },
					consumes= { MediaType.APPLICATION_JSON_VALUE }
					)
			public Equipe saveInfo(@RequestBody Equipe p) {
				return equipeRepos.save(p);
			}
		

			@DeleteMapping(value = "/{id}")
			public void deleteRow(@PathVariable Long id) 
			{
				equipeRepos.deleteById(id);
			}

			@GetMapping(value= "/{id}" ,
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
					    )
			public Equipe getRow(@PathVariable Long id) { 
				Equipe p =equipeRepos.findById(id).get();
				return p;
			}
			

		@PutMapping(value = "/"  ,
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
		public Equipe updateRow(@RequestBody Equipe p) {
			return equipeRepos.save(p);
		}
			

}


