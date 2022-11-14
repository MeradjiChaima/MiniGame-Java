package application;

import java.io.Serializable;
import java.util.Random;
public class Dée implements Serializable
{
   private int valeur;

    
    public int lancerdée()
    {
        Random rand = new Random(); 
        int val =(rand.nextInt(6))+1; 
       this.valeur=val;
       
        return(val);
    }
    public void afficherdée()
    {
        System.out.println(valeur);
    }
    public int getvaleur()
    {
    	return(this.valeur);
    }
    

   
}