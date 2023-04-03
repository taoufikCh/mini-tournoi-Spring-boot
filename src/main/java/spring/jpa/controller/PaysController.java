package spring.jpa.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

import spring.jpa.model.Pays;
import spring.jpa.repository.PaysRepository;

@RestController // pour déclarer un service web de type REST
@RequestMapping("/pays")  //    http://localhost:8080/pays/
@CrossOrigin("*")
public class PaysController {
	
	@Autowired // pour l'injection de dépendances
	private PaysRepository paysRepos;

	
	//  Message d'accueil
    //  http://localhost:8080/joueurs/index  (GET)
	@GetMapping(value ="/index" ) 	 
	public String accueil() {
		return "BienVenue au service Web REST 'pays'.....";
	}
	
	//  Afficher la liste des joueurs
    //  http://localhost:8080/pays/ (GET)
		@GetMapping(value= "/", produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
		public  List<Pays> getAllPays() {
			return paysRepos.findAll();

		}
		
		@GetMapping(value= "/search2")
		public  List<Pays> getAll(@RequestParam(name= "keyword", defaultValue="")String keyword) {
			//return paysRepos.findAll();
			return paysRepos.findByNomLike("%"+keyword+"%");

		}
		@GetMapping("/tutorials")
		  public ResponseEntity<Map<String, Object>> getAllPays(
		        @RequestParam(required = false) String nom,
		        @RequestParam(defaultValue = "0") int page,
		        @RequestParam(defaultValue = "3") int size
		      ) {

		    try {
		      List<Pays> tutorials = new ArrayList<Pays>();
		      Pageable paging = PageRequest.of(page, size);
		      
		      Page<Pays> pageTuts;
		      if (nom == null)
		        pageTuts = paysRepos.findAll(paging);
		      else
		        pageTuts = paysRepos.findByNomContaining(nom, paging);

		      tutorials = pageTuts.getContent();

		      Map<String, Object> response = new HashMap<>();
		      response.put("tutorials", tutorials);
		      response.put("currentPage", pageTuts.getNumber());
		      response.put("totalItems", pageTuts.getTotalElements());
		      response.put("totalPages", pageTuts.getTotalPages());

		      return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		
		/*@GetMapping(value= "/search")
		public  Page<Pays> searchPays(@RequestParam(name= "keyword", defaultValue="") String keyword, @RequestParam (name="page" , defaultValue ="1") int p) {
			//return paysRepos.findByNomLike("%"+keyword+"%",PageRequest.of(p, 5));
			//Page <Pays> pays= paysRepos.findByNomLike("%"+keyword+"%",PageRequest.of(p, 5));
			return paysRepos.findByNomLike("%"+keyword+"%",PageRequest.of(p, 10));

		}*/
		
		
		//  ajouter un pays avec la méthode "POST"
		//  http://localhost:8080/pays/   (POST)
			@PostMapping(value = "/"  ,
					//spécifier le format de retour
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  },
					consumes= { MediaType.APPLICATION_JSON_VALUE }
					)
			public Pays saveCountry(@RequestBody Pays p) {
				return paysRepos.save(p);
			}
		
			// Supprimer un pays par 'id' avec la méthode 'GET'
		    //  http://localhost:8080/pays/{id}  (GET)
			@DeleteMapping(value = "/{id}")
			public void deleteProduit(@PathVariable Long id) 
			{
				paysRepos.deleteById(id);
			}
		//  Afficher un pays en spécifiant son 'id'
			//  http://localhost:8080/pays/{id} (GET)
			@GetMapping(value= "/{id}" ,
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
					    )
			public Pays getPays(@PathVariable Long id) { 
				Pays p =paysRepos.findById(id).get();
				return p;
			}
			
			
		//  modifier un pays avec la méthode "PUT"
		//  http://localhost:8080/pays/   (PUT)
		@PutMapping(value = "/{id}"  ,
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
		public Pays updatePays(@PathVariable Long id, @RequestBody Pays p) {
			/*Pays existingPays = paysRepos.findById(id).orElse(null);
		    if (existingPays == null) {
		      return false;
		    }

		    existingPays.setNom_pays(p.getNom());
			return paysRepos.save(existingPays);*/
			return paysRepos.save(p);
		}
			

}
