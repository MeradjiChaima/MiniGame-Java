package application;

public class Malus extends Case
{
   private String couleur="rouge";
   private int deplacer=0;
   private int score=0;
   
    public int[] action(int position)
    {
        this.deplacer=-2;
        this.score=-10;
        int [] tabmalus= {this.score,this.deplacer};
        return(tabmalus);
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