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

import spring.jpa.model.Entraineur;
import spring.jpa.repository.EntraineurRepository;


@RestController // pour déclarer un service web de type REST
@RequestMapping("/entraineurs")  //
@CrossOrigin("*")
public class EntraineurController {
	
	@Autowired // pour l'injection de dépendances
	private EntraineurRepository entraineurRepos;
	
		@GetMapping(value= "/", produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
		public  List<Entraineur> getAllList() {
			return entraineurRepos.findAll();
		}
		
		@GetMapping(value= "/search")
		public  List<Entraineur> search(@RequestParam(name= "keyword", defaultValue="") String keyword) {
			return entraineurRepos.findByNomOrPrenomLike("%"+keyword+"%", "%"+keyword+"%");

		}
		
			@PostMapping(value = "/"  ,
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  },
					consumes= { MediaType.APPLICATION_JSON_VALUE }
					)
			public Entraineur saveInfo(@RequestBody Entraineur p) {
				return entraineurRepos.save(p);
			}
		

			@DeleteMapping(value = "/{id}")
			public void deleteRow(@PathVariable Long id) 
			{
				entraineurRepos.deleteById(id);
			}

			@GetMapping(value= "/{id}" ,
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
					    )
			public Entraineur getRow(@PathVariable Long id) { 
				Entraineur p =entraineurRepos.findById(id).get();
				return p;
			}
			

		@PutMapping(value = "/"  ,
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
		public Entraineur updateRow(@RequestBody Entraineur p) {
			return entraineurRepos.save(p);
		}
			

}

