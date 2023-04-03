package spring.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import spring.jpa.model.Pays;
import spring.jpa.repository.PaysRepository;

@SpringBootApplication
public class TournoiMiniFootballApplication {
	// Déclarer une référence de l'interface "PaysRepository"
		static PaysRepository paysRepos;

	public static void main(String[] args) {
		// référencer le contexte
		 ApplicationContext contexte = SpringApplication.run(TournoiMiniFootballApplication.class, args);
		
		// Récupérer une implémentation de l'interface "CategorieRepository" par injection de dépendance
		/*paysRepos =contexte.getBean(PaysRepository.class);

		Pays p1 = new Pays("Tunis");
		Pays p2 = new Pays("Algerie");	
		
		//Attacher les deux catégories à la BD (insertion)
		paysRepos.save(p1);
		paysRepos.save(p2);
		
		//Afficher la liste des pays
		afficherTousLesPays(); 
	}
	
	static void afficherTousLesPays()
	{
		System.out.println("***************************************");
		// Lister l'ensemble des produits
		System.out.println("Afficher tous les pays...");
		List<Pays> lp = paysRepos.findAll();
		for (Pays p : lp) 
		{
			System.out.println(p.getNom());
		}
		System.out.println("***************************************");
	}
	*/
	}

}
