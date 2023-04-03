package spring.jpa.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Milieu")
public class JoueurDeMilieuDeTerrain extends Joueur {
	
    private int nombre_buts_marques;
    private int meilleure_distance_parcourue_par_match;
    
	public JoueurDeMilieuDeTerrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JoueurDeMilieuDeTerrain(int nombre_buts_marques, int meilleure_distance_parcourue_par_match) {
		this.nombre_buts_marques = nombre_buts_marques;
		this.meilleure_distance_parcourue_par_match = meilleure_distance_parcourue_par_match;
	}

	public JoueurDeMilieuDeTerrain(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat, Equipe equipe) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat, equipe);
		// TODO Auto-generated constructor stub
	}
	public JoueurDeMilieuDeTerrain(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat);
		// TODO Auto-generated constructor stub
	}
	
	public JoueurDeMilieuDeTerrain(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat, 
			int nombre_buts_marques, int meilleure_distance_parcourue_par_match) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat);
		this.nombre_buts_marques = nombre_buts_marques;
		this.meilleure_distance_parcourue_par_match = meilleure_distance_parcourue_par_match;
	}

	public int getNombre_buts_marques() {
		return nombre_buts_marques;
	}

	public void setNombre_buts_marques(int nombre_buts_marques) {
		this.nombre_buts_marques = nombre_buts_marques;
	}

	public int getMeilleure_distance_parcourue_par_match() {
		return meilleure_distance_parcourue_par_match;
	}

	public void setMeilleure_distance_parcourue_par_match(int meilleure_distance_parcourue_par_match) {
		this.meilleure_distance_parcourue_par_match = meilleure_distance_parcourue_par_match;
	}
	
	
    
    
}
