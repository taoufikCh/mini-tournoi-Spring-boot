package spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;


@Entity
public class But {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    @Column(name = "minute_jeu")
    private int minuteJeu;
    @Column(name = "mi_temps")
    private int miTemps;
    
    @ManyToOne
    private Joueur joueur;
    
    @ManyToOne
    private MatchFoot match;
    
	public But() {
	}


	public But(String type, int minuteJeu, int miTemps, Joueur joueur, MatchFoot match) {
		this.type = type;
		this.minuteJeu = minuteJeu;
		this.miTemps = miTemps;
		this.joueur = joueur;
		this.match = match;
	}


	public Long getId() {
		return id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getMinuteJeu() {
		return minuteJeu;
	}


	public void setMinuteJeu(int minuteJeu) {
		this.minuteJeu = minuteJeu;
	}


	public int getMiTemps() {
		return miTemps;
	}


	public void setMiTemps(int miTemps) {
		this.miTemps = miTemps;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public MatchFoot getMatch() {
		return match;
	}


	public void setMatch(MatchFoot match) {
		this.match = match;
	}
    
}
