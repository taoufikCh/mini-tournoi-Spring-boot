package spring.jpa.model;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;


@Entity
public class Avertissement {
	
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Joueur joueur;
    
    @ManyToOne
    private MatchFoot match;
    
    private int minute_du_jeu;
    private String type;
    
    
	public Avertissement() {
	}


	public Avertissement(Joueur joueur, MatchFoot match, int minuteDuJeu, String type) {
		this.joueur = joueur;
		this.match = match;
		this.minute_du_jeu = minuteDuJeu;
		this.type = type;
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


	public int getMinuteDuJeu() {
		return minute_du_jeu;
	}


	public void setMinuteDuJeu(int minuteDuJeu) {
		this.minute_du_jeu = minuteDuJeu;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getId() {
		return id;
	}


 
}
