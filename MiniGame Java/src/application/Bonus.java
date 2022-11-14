package application;

public class Bonus extends Case
{
    private  String couleur="vert";
   private int deplacer=0;
    private int score=0;
    
    public int[] action (int position)
    {
        this.deplacer=2;
        this.score=10;
        int[] tab= {this.score,this.deplacer};
        return(tab);
        
    }
     public String affichercolor()
    {
        return(this.couleur);
    }
   public  int getscore(){
        return(this.score);
    }
    public int getdeplacer(){
        return(this.deplacer);
    }

}