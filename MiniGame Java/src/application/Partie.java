package application;
import java.io.Serializable;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Partie implements Serializable
{
   
   private Plateau plat=new Plateau();
   private Dée d1=new Dée();
   private Dée d2=new Dée();
    private int caseactuel;
    private int score;
   private Joueur player;
    private int deplacement;
  private  int casedestination;
  public Joueur getjoueur()
  {
	  return(this.player);
  }
    public Plateau getplateau() {
    	return(this.plat);
    }
    public Dée getd1()
    {
    	return(this.d1);
    }
    public Dée getd2() {
    	return(this.d2);
    }
    public int getscoreactuel() {
    	return(this.score);
    }
   public int getcaseactuel() {
	   return(this.caseactuel);
   }
    public void setplayer(Joueur player)
    {
    	this.player=player;
    }
    
    public void setcaseactuel(int i)
    {
    	this.caseactuel=i;
    }
    public void setscoreactuel(int scoree)
    {
    	this.score=scoree;
    }
    public void lancerpartie (){
    	
    	
        plat.createplateau();
       
        
    }
    public int getscore() {
    return(	this.score);
    }
    public void sommedée (){
    	
        int somme=d1.lancerdée()+d2.lancerdée();
        System.out.println(somme);
        this.deplacement=somme;    
    }
    public void verifiercase(int valeur) throws Caseexception
    {
        
       this.casedestination=caseactuel+deplacement;
       if(casedestination<0)
       {
           this.casedestination=0;
       }
       if(casedestination>99)
       {
          this.casedestination=99-(this.casedestination-99);
       }
        
        int nmrcase=valeur;
        if((casedestination!=nmrcase)&&(plat.tabcase[valeur].affichercolor().equals("blanc")))
        {
          throw new Caseexception();
        }
        else {
        	this.casedestination=valeur;
        }
        
        
    }
    public int getcasedestination()
    {
        return(this.casedestination);
    }
    
    public int getdeplacement()
    {
        return(this.deplacement);
    }
    
    public int deplacer (){
        int fin=1;
    	
       
        this.caseactuel=this.casedestination;
        System.out.println("le type du case :"+   plat.tabcase[caseactuel].affichercolor());
        int [] tableaction= plat.tabcase[caseactuel].action(caseactuel);
        int scoree=tableaction[0];
        int deplacerr=tableaction[1];
      
        System.out.println("le score est :"+scoree);
        System.out.println("le deplacement est "+deplacerr);
       this.score=this.score+ scoree;
         System.out.println("le score du jeu :"+  this.score);
         this.caseactuel=this.caseactuel+deplacerr;
         System.out.println("position apres traitement :"+ this.caseactuel);
         if(caseactuel==99)
         {
             System.out.println("Congratulation!!!");
             fin=0;
            
             
         }
       
     	while((plat.tabcase[caseactuel].affichercolor()!="blanc" )&&( deplacerr!=0))
     	{
     		
     		 System.out.println("le type du case :"+   plat.tabcase[caseactuel].affichercolor());
             tableaction= plat.tabcase[caseactuel].action(caseactuel);
             scoree=tableaction[0];
             deplacerr=tableaction[1];
             System.out.println("le score est :"+scoree);
             System.out.println("le deplacement est "+deplacerr);
             if((plat.tabcase[caseactuel].affichercolor()=="vert") && (plat.tabcase[caseactuel+deplacerr].affichercolor()=="rouge"))
             {
            	 break;
             }
            this.score=this.score+ scoree;
              System.out.println("le score du jeu :"+  this.score);
              this.caseactuel=this.caseactuel+deplacerr;
              System.out.println("position apres traitement :"+ this.caseactuel);
              if(caseactuel==99)
              {
                  System.out.println("Congratulation!!!");
                  fin=0;
                
                  
              }
     		
     	}
     	
         return(fin);
         
        
    }
    
    
    
  
}
