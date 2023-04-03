package spring.jpa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pays {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected Long id;
	protected String nom;
	
	@OneToMany (mappedBy = "pays" , cascade = {CascadeType.ALL})
    private Collection <Joueur> joueurs = new ArrayList<Joueur>();
	@OneToMany (mappedBy = "pays" ,cascade = {CascadeType.ALL} )
    private Collection <Entraineur> entraineurs = new ArrayList<Entraineur>();
	
	@OneToMany (mappedBy = "pays" ,cascade = {CascadeType.ALL} )
    private Collection <Equipe> equipes = new ArrayList<Equipe>();
	
	@OneToMany (mappedBy = "pays" ,cascade = {CascadeType.ALL} )
    private Collection <Tournoi> tournois = new ArrayList<Tournoi>();
	
	public Pays() {
	}
	public Pays(String nom_pays) {
		this.nom = nom_pays;
	}
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom_pays(String nom_pays) {
		this.nom = nom_pays;
	}
	
	
	
	
}
