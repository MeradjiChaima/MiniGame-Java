package application;

import java.io.Serializable;
import java.util.Random;
public class D�e implements Serializable
{
   private int valeur;

    
    public int lancerd�e()
    {
        Random rand = new Random(); 
        int val =(rand.nextInt(6))+1; 
       this.valeur=val;
       
        return(val);
    }
    public void afficherd�e()
    {
        System.out.println(valeur);
    }
    public int getvaleur()
    {
    	return(this.valeur);
    }
    

   
}