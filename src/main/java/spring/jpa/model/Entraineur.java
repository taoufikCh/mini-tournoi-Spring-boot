package spring.jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@DiscriminatorValue("entraineur")
public class Entraineur{
	
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
	@JsonIgnore
    @OneToMany(mappedBy = "entraineur", cascade = CascadeType.ALL)
    private Collection <Equipe> equipes = new ArrayList<Equipe>();


	public Entraineur() {
	}

	public Entraineur(String nom, String prenom, Date dateNaissance,  Pays pays, Double salaire,
			int nombreMatchsJoues, Collection<Equipe> equipes) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.pays = pays;
		this.salaire = salaire;
		this.nombreMatchsJoues = nombreMatchsJoues;
		this.equipes = equipes;
	}

	public Entraineur(String nom, String prenom, Date dateNaissance, Collection<Equipe> equipes) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.equipes = equipes;
	}

	public Entraineur(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Collection<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}

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
