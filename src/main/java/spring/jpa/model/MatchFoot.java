package spring.jpa.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;


@Entity
public class MatchFoot {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Equipe equipe1;
    
    @ManyToOne
    private Equipe equipe2;
    
    @ManyToOne
    private Journee journee;
    //private Date date;
     
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection <But> equipe1Goals = new ArrayList<But>();
    
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection <But> equipe2Goals = new ArrayList<But>();
    
   //@ManyToMany
   // private List<Joueur> equipe1Scorers;
   // private List<Joueur> equipe2Scorers;
    
    /*@ManyToMany
    @JoinTable(name = "remplacement_match",joinColumns = @JoinColumn(name = "match_id"),inverseJoinColumns = @JoinColumn(name = "joueur_id"))
    private Collection<Joueur> equipe1Remplacement = new ArrayList<Joueur>();
    
    @ManyToMany
    @JoinTable(name = "remplacement_match",joinColumns = @JoinColumn(name = "match_id"), inverseJoinColumns = @JoinColumn(name = "joueur_id"))
    private Collection<Joueur> equipe2Remplacement = new ArrayList<Joueur>();
    */
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection<Avertissement> equipe1Avertis = new ArrayList<Avertissement>();
    
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection<Avertissement> equipe2Avertis = new ArrayList<Avertissement>();
    
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection<Expulsion> equipe1Expulsion = new ArrayList<Expulsion>();
    
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Collection<Expulsion> equipe2Expulsion = new ArrayList<Expulsion>();
    
    @Column(name = "mi_temps_1_extra_minutes")
    private int miTemps1ExtraMinutes;
    
    @Column(name = "mi_temps_2_extra_minutes")
    private int miTemps2ExtraMinutes;

	public MatchFoot() {
	}

	public MatchFoot(Equipe equipe1, Equipe equipe2, Journee journee, Collection<But> equipe1Goals,
			Collection<But> equipe2Goals, Collection<Avertissement> equipe1Avertis,
			Collection<Avertissement> equipe2Avertis, Collection<Expulsion> equipe1Expulsion,
			Collection<Expulsion> equipe2Expulsion, int miTemps1ExtraMinutes, int miTemps2ExtraMinutes) {
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.journee = journee;
		this.equipe1Goals = equipe1Goals;
		this.equipe2Goals = equipe2Goals;
		//this.equipe1Remplacement = equipe1Remplacement;
		//this.equipe2Remplacement = equipe2Remplacement;
		this.equipe1Avertis = equipe1Avertis;
		this.equipe2Avertis = equipe2Avertis;
		this.equipe1Expulsion = equipe1Expulsion;
		this.equipe2Expulsion = equipe2Expulsion;
		this.miTemps1ExtraMinutes = miTemps1ExtraMinutes;
		this.miTemps2ExtraMinutes = miTemps2ExtraMinutes;
	}

	public Long getId() {
		return id;
	}

	public Equipe getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}

	public Equipe getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}

	public Journee getJournee() {
		return journee;
	}

	public void setJournee(Journee journee) {
		this.journee = journee;
	}

	public Collection<But> getEquipe1Goals() {
		return equipe1Goals;
	}

	public void setEquipe1Goals(Collection<But> equipe1Goals) {
		this.equipe1Goals = equipe1Goals;
	}

	public Collection<But> getEquipe2Goals() {
		return equipe2Goals;
	}

	public void setEquipe2Goals(Collection<But> equipe2Goals) {
		this.equipe2Goals = equipe2Goals;
	}

	/*public Collection<Joueur> getEquipe1Remplacement() {
		return equipe1Remplacement;
	}

	public void setEquipe1Remplacement(Collection<Joueur> equipe1Remplacement) {
		this.equipe1Remplacement = equipe1Remplacement;
	}

	public Collection<Joueur> getEquipe2Remplacement() {
		return equipe2Remplacement;
	}

	public void setEquipe2Remplacement(Collection<Joueur> equipe2Remplacement) {
		this.equipe2Remplacement = equipe2Remplacement;
	}*/

	public Collection<Avertissement> getEquipe1Avertis() {
		return equipe1Avertis;
	}

	public void setEquipe1Avertis(Collection<Avertissement> equipe1Avertis) {
		this.equipe1Avertis = equipe1Avertis;
	}

	public Collection<Avertissement> getEquipe2Avertis() {
		return equipe2Avertis;
	}

	public void setEquipe2Avertis(Collection<Avertissement> equipe2Avertis) {
		this.equipe2Avertis = equipe2Avertis;
	}

	public Collection<Expulsion> getEquipe1Expulsion() {
		return equipe1Expulsion;
	}

	public void setEquipe1Expulsion(Collection<Expulsion> equipe1Expulsion) {
		this.equipe1Expulsion = equipe1Expulsion;
	}

	public Collection<Expulsion> getEquipe2Expulsion() {
		return equipe2Expulsion;
	}

	public void setEquipe2Expulsion(Collection<Expulsion> equipe2Expulsion) {
		this.equipe2Expulsion = equipe2Expulsion;
	}

	public int getMiTemps1ExtraMinutes() {
		return miTemps1ExtraMinutes;
	}

	public void setMiTemps1ExtraMinutes(int miTemps1ExtraMinutes) {
		this.miTemps1ExtraMinutes = miTemps1ExtraMinutes;
	}

	public int getMiTemps2ExtraMinutes() {
		return miTemps2ExtraMinutes;
	}

	public void setMiTemps2ExtraMinutes(int miTemps2ExtraMinutes) {
		this.miTemps2ExtraMinutes = miTemps2ExtraMinutes;
	}
	
	
    
    
}
