package spring.jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tournoi {
    @Id
    @GeneratedValue
    private Long id;
    
    private int numero;
    private String description;
    @ManyToOne
	private Pays pays;
    private Date annee;
    @Column(name = "date_ouverture")
    private Date dateOuverture;
    @Column(name = "date_fermeture")
    private Date dateFermeture;
    
    private int nombreEquipes;
    
    @ManyToMany
    private Collection<Equipe> equipes = new ArrayList<Equipe>();
    //private List<Equipe> equipesParticipantes;
    
    @OneToMany
    private Collection<Journee> journees = new ArrayList<Journee>();
    
	public Tournoi() {
	}
	
	public Tournoi(int numero, String description, Pays pays, Date annee, Date dateOuverture, Date dateFermeture,
			int nombreEquipes, Collection<Equipe> equipes, Collection<Journee> journees) {
		this.numero = numero;
		this.description = description;
		this.pays = pays;
		this.annee = annee;
		this.dateOuverture = dateOuverture;
		this.dateFermeture = dateFermeture;
		this.nombreEquipes = nombreEquipes;
		this.equipes = equipes;
		this.journees = journees;
	}

	public Long getId() {
		return this.id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Date getAnnee() {
		return annee;
	}

	public void setAnnee(Date annee) {
		this.annee = annee;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Date getDateFermeture() {
		return dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	public int getNombreEquipes() {
		return nombreEquipes;
	}

	public void setNombreEquipes(int nombreEquipes) {
		this.nombreEquipes = nombreEquipes;
	}

	public Collection<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Collection<Journee> getJournees() {
		return journees;
	}

	public void setJournees(Collection<Journee> journees) {
		this.journees = journees;
	}
	
	
    
    
}