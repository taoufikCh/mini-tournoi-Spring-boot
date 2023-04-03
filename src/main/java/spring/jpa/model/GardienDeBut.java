package spring.jpa.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gardient")
public class GardienDeBut extends Joueur {
	
	private int nombre_buts_encaisses;
	private int nombre_clean_sheets;
	
	public GardienDeBut() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public GardienDeBut(int nombre_buts_encaisses, int nombre_clean_sheets) {
		super();
		this.nombre_buts_encaisses = nombre_buts_encaisses;
		this.nombre_clean_sheets = nombre_clean_sheets;
	}
	public GardienDeBut(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat, Equipe equipe) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat, equipe);
		// TODO Auto-generated constructor stub
	}
	
	public GardienDeBut(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat);
		// TODO Auto-generated constructor stub
	}
	
	public GardienDeBut(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire,
			int nombreMatchsJoues, int nombre_avertissements_recus, int nombre_avertissements_actifs,
			int nombre_expulsions, int nombre_matchs_suspendus, String etat, 
			int nombre_buts_encaisses, int nombre_clean_sheets) {
		super(nom, prenom, dateNaissance, pays, salaire, nombreMatchsJoues, nombre_avertissements_recus,
				nombre_avertissements_actifs, nombre_expulsions, nombre_matchs_suspendus, etat);
		this.nombre_buts_encaisses = nombre_buts_encaisses;
		this.nombre_clean_sheets = nombre_clean_sheets;
	}


	public int getNombre_buts_encaisses() {
		return nombre_buts_encaisses;
	}


	public void setNombre_buts_encaisses(int nombre_buts_encaisses) {
		this.nombre_buts_encaisses = nombre_buts_encaisses;
	}


	public int getNombre_clean_sheets() {
		return nombre_clean_sheets;
	}


	public void setNombre_clean_sheets(int nombre_clean_sheets) {
		this.nombre_clean_sheets = nombre_clean_sheets;
	}

	
	
	
	

}
