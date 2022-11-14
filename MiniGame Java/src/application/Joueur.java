package application;

import java.io.Serializable;

public class Joueur implements Serializable {
	private String name;
	private int meilleur_score;
	public Joueur (String namee,int scoor) {
		this.name=namee;
		this.meilleur_score=scoor;
	}
	public void setscore (int score)
	{
		this.meilleur_score=score;
	}
	public int getbestscore() {
		return(this.meilleur_score);
	}
	public String getname() {
		return(this.name);
	}

}