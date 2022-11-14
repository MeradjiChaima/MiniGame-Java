package application;

public class Depart extends Case
{
    private String couleur="jaune";
    private int score=0;
   private int deplacer=0;
    public int[] action (int position)
    {
        this.score=0;
        this.deplacer=0;
        int [] tabdepart= {this.score,this.deplacer};
        return(tabdepart);
    
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