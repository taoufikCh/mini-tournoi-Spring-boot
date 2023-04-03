package spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_JOUEUR")
public class Joueur {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected Long id;
	protected String nom;
	protected String prenom;
	@Column(name="date_naissance")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date dateNaissance;
	@ManyToOne
	private Pays pays;
    private Double salaire;
	@Column(name="nombre_matchs_joues")
    private int nombreMatchsJoues;
    private int nombre_avertissements_recus;
    private int nombre_avertissements_actifs;
    private int nombre_expulsions;
    private int nombre_matchs_suspendus;
    private String etat;
    
    //@JsonIgnore
    @ManyToOne
    private Equipe equipe;
    
    /*@OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL)
    private Collection <Avertissement> avertissements = new ArrayList<Avertissement>();
    
    @OneToMany(mappedBy = "joueur", cascade = CascadeType.ALL)
    private Collection <Expulsion> expulsions = new ArrayList<Expulsion>();*/
    
    
	public Joueur() {
	}
	public Joueur(String nom, String prenom, Date dateNaissance, Pays pays, Double salaire, int nombreMatchsJoues,
			int nombre_avertissements_recus, int nombre_avertissements_actifs, int nombre_expulsions,
			int nombre_matchs_suspendus, String etat) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.salaire = salaire;
		this.nombreMatchsJoues = nombreMatchsJoues;
		this.nombre_avertissements_recus = nombre_avertissements_recus;
		this.nombre_avertissements_actifs = nombre_avertissements_actifs;
		this.nombre_expulsions = nombre_expulsions;
		this.nombre_matchs_suspendus = nombre_matchs_suspendus;
		this.etat = etat;
	}
	public Joueur(String nom, String prenom, Date dateNaissance,  Pays pays, Double salaire, int nombreMatchsJoues, 
			int nombre_avertissements_recus, int nombre_avertissements_actifs, int nombre_expulsions,
			int nombre_matchs_suspendus, String etat, Equipe equipe) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.salaire = salaire;
		this.nombreMatchsJoues = nombreMatchsJoues;
		this.nombre_avertissements_recus = nombre_avertissements_recus;
		this.nombre_avertissements_actifs = nombre_avertissements_actifs;
		this.nombre_expulsions = nombre_expulsions;
		this.nombre_matchs_suspendus = nombre_matchs_suspendus;
		this.etat = etat;
		this.equipe = equipe;
	}
	public Joueur(String nom, String prenom, Date dateNaissance,  Pays pays, Double salaire, int nombreMatchsJoues,
			int nombre_avertissements_recus, int nombre_avertissements_actifs, int nombre_expulsions,
			int nombre_matchs_suspendus, String etat, Equipe equipe, Collection<Avertissement> avertissements,
			Collection<Expulsion> expulsions) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.salaire = salaire;
		this.nombreMatchsJoues = nombreMatchsJoues;
		this.nombre_avertissements_recus = nombre_avertissements_recus;
		this.nombre_avertissements_actifs = nombre_avertissements_actifs;
		this.nombre_expulsions = nombre_expulsions;
		this.nombre_matchs_suspendus = nombre_matchs_suspendus;
		this.etat = etat;
		this.equipe = equipe;
		//this.avertissements = avertissements;
		//this.expulsions = expulsions;
	}
	public int getNombre_avertissements_recus() {
		return nombre_avertissements_recus;
	}
	public void setNombre_avertissements_recus(int nombre_avertissements_recus) {
		this.nombre_avertissements_recus = nombre_avertissements_recus;
	}
	public int getNombre_avertissements_actifs() {
		return nombre_avertissements_actifs;
	}
	public void setNombre_avertissements_actifs(int nombre_avertissements_actifs) {
		this.nombre_avertissements_actifs = nombre_avertissements_actifs;
	}
	public int getNombre_expulsions() {
		return nombre_expulsions;
	}
	public void setNombre_expulsions(int nombre_expulsions) {
		this.nombre_expulsions = nombre_expulsions;
	}
	public int getNombre_matchs_suspendus() {
		return nombre_matchs_suspendus;
	}
	public void setNombre_matchs_suspendus(int nombre_matchs_suspendus) {
		this.nombre_matchs_suspendus = nombre_matchs_suspendus;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@JsonIgnore
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	/*public Collection<Avertissement> getAvertissements() {
		return avertissements;
	}
	public void setAvertissements(Collection<Avertissement> avertissements) {
		this.avertissements = avertissements;
	}
	public Collection<Expulsion> getExpulsions() {
		return expulsions;
	}
	public void setExpulsions(Collection<Expulsion> expulsions) {
		this.expulsions = expulsions;
	}*/
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public int getNombreMatchsJoues() {
		return nombreMatchsJoues;
	}
	public void setNombreMatchsJoues(int nombreMatchsJoues) {
		this.nombreMatchsJoues = nombreMatchsJoues;
	}
	


}
