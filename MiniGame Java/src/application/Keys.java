package application;

import java.util.Random;

public enum Keys {
	Mango,
	Apple,
	Monster,
	SuperHero,
	Studing,
	Boring,
	Planet,
	Hat,
	Cloud,
	Book,
	Flag,
	Tree,
	Table,
	Flower,
	House;
	
	public static Keys getRandomKey() {
		Random rand=new Random();
		return values()[rand.nextInt(values().length)];
		
	}
	

}