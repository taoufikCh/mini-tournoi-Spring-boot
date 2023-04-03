package spring.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Expulsion {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Joueur joueur;
    
    @ManyToOne
    //@JoinColumn(name="match_id")
    private MatchFoot match;
    
    @Column(name="minute_du_jeu")
    private int minuteDuJeu;
    
    
	public Expulsion() {
	}


	public Expulsion(Joueur joueur, MatchFoot match, int minuteDuJeu) {
		this.joueur = joueur;
		this.match = match;
		this.minuteDuJeu = minuteDuJeu;
	}


	public Long getId() {
		return this.id;
	}



	public Joueur getJoueur() {
		return this.joueur;
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


	public int getMinuteDuJeu() {
		return minuteDuJeu;
	}


	public void setMinuteDuJeu(int minuteDuJeu) {
		this.minuteDuJeu = minuteDuJeu;
	}
    
    
}
