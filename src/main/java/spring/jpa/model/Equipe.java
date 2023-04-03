package spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;

@Entity
public class Equipe {
	
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date date_creation;
    @ManyToOne
	private Pays pays;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("equipe")
    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<Joueur> joueurs= new ArrayList<Joueur>();
    
    @ManyToOne
    private Entraineur entraineur;
    
    //@OneToOne
    //private Tournoi tournoi;
    //@JsonIgnore
    //@ManyToMany (mappedBy = "equipes")
    //private Collection<Tournoi> tournois = new ArrayList<Tournoi>();
    
	public Equipe() {
	}

	public Equipe(String nom, Date date_creation, Pays pays, Collection<Joueur> joueurs, Entraineur entraineur) {
		this.nom = nom;
		this.date_creation = date_creation;
		this.pays = pays;
		this.joueurs = joueurs;
		this.entraineur = entraineur;
	}

	public Long getID() {
		return id;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Collection<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Collection<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Entraineur getEntraineur() {
		return entraineur;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
    
   

}
