package spring.jpa.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import spring.jpa.model.GardienDeBut;
import spring.jpa.model.Joueur;
import spring.jpa.model.JoueurDeMilieuDeTerrain;
import spring.jpa.model.Pays;
import spring.jpa.repository.EquipeRepository;
import spring.jpa.repository.GardienDeButRepository;
import spring.jpa.repository.JoueurDeMilieuDeTerrainRepository;
import spring.jpa.repository.JoueurRepository;


@RestController // pour déclarer un service web de type REST
@RequestMapping("/joueurs")  //
@CrossOrigin("*")
public class JoueurController {
	
	@Autowired // pour l'injection de dépendances
	private JoueurRepository joueurRepos;
	@Autowired // pour l'injection de dépendances
	private GardienDeButRepository gardientRepos;
	@Autowired // pour l'injection de dépendances
	private JoueurDeMilieuDeTerrainRepository milieuRepos;
	@Autowired
	private EquipeRepository equipeRepos;
	
		@GetMapping(value= "/", produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })
		public  List<Joueur> getAllList() {
			return joueurRepos.findAll();
		}
		
		@GetMapping(value= "/search")
		public  List<Joueur> search(@RequestParam(name= "keyword", defaultValue="") String keyword) {
			return joueurRepos.findByNomLike("%"+keyword+"%");

		}
		
		@PostMapping(value = "/gardient"  ,
		produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  },
					consumes= { MediaType.APPLICATION_JSON_VALUE })
		public Joueur saveGardient(@RequestBody GardienDeBut joueur) {
		//public Joueur saveInfo(@RequestBody Map<String, Object> request) {
			//String typeJoueur = (String) request.get("typeJoueur");
			//Joueur p = (Joueur) request.get("joueur");
			//if("Gardient".equals(p['typeJoueur'])) {
			//GardienDeBut gardient = (GardienDeBut) p;
				return joueurRepos.save(joueur);
			// return GardienDeButRepository.save(joueur);
		}
		@PostMapping(value = "/milieu"  ,
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  },
							consumes= { MediaType.APPLICATION_JSON_VALUE })
				public Joueur saveMilieu(@RequestBody JoueurDeMilieuDeTerrain joueur) {
						return joueurRepos.save(joueur);
				}
		

			@DeleteMapping(value = "/{id}")
			public void deleteRow(@PathVariable Long id) 
			{
				joueurRepos.deleteById(id);
			}

			@GetMapping(value= "/{id}" ,
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
					    )
			public Joueur getRow(@PathVariable Long id) { 
				Joueur p =joueurRepos.findById(id).get();
				return p;
			}
			

		@PutMapping(value = "/"  ,
				produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE  })
		public Joueur updateRow(@RequestBody Joueur p) {
			return joueurRepos.save(p);
		}
		
		@GetMapping(value= "/team")
		public  List<Joueur> listPlayersOfTeam(@RequestParam(name= "id") Long id) {
			List<Joueur> joueurs = new ArrayList<Joueur>();
			Equipe equipe = equipeRepos.getOne(id);
			List<GardienDeBut> gardients = gardientRepos.findByEquipeLike(equipe);
			//List<Joueur> joueurs = joueurRepos.findByEquipeLike(equipe);
			List<JoueurDeMilieuDeTerrain> milieus = milieuRepos.findByEquipeLike(equipe);
			for (GardienDeBut gardient : gardients) 
			{
				//System.out.println(joueur);
				joueurs.add(gardient);
			}
			for (JoueurDeMilieuDeTerrain j : milieus) 
			{
				joueurs.add(j);
			}
			
			return joueurs;

		}
			

}
