package spring.jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
public class Journee {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    @OneToMany(mappedBy = "journee", cascade = CascadeType.ALL)
    private Collection<MatchFoot> matchs =  new ArrayList<MatchFoot>();;
    //@ManyToOne
    //private Tournoi tournoi;
    @ManyToMany (mappedBy = "journees")
    private Collection<Tournoi> tournois = new ArrayList<Tournoi>();
   
    
	public Journee() {
	}


	public Journee(Date date, Collection<MatchFoot> matchs, Collection<Tournoi> tournois) {
		this.date = date;
		this.matchs = matchs;
		this.tournois = tournois;
	}


	public Long getId() {
		return id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Collection<MatchFoot> getMatchs() {
		return matchs;
	}


	public void setMatchs(Collection<MatchFoot> matchs) {
		this.matchs = matchs;
	}

	
	public Collection<Tournoi> getJournees() {
		return this.tournois;
	}

	public void setJournees(Collection<Tournoi> tournois) {
		this.tournois = tournois;
	}
	  
    
}
