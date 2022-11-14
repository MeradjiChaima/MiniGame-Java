package application;

import java.util.Random;
public class Saut extends Case
{
   private String couleur="orange";
   private int deplacer=0;
  private int score=0;

    public int[] action (int position)
    {
        int num=generealea();
        System.out.println("le num alea"+num);
        this.deplacer=num-position;
        int [] tabsaut= {this.score,this.deplacer};
        return(tabsaut);
        
    }
    private int generealea ()
    {
        Random rand=new Random();
        int numCase = rand.nextInt(99);
        
        return(numCase);
     
    }
     public String affichercolor()
    {
        return(this.couleur);
    }
    public int getscore(){
        return(this.score);
    }
    public int getdeplacer(){
        return(this.deplacer);
    }

}