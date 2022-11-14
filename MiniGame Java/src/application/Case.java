package application;

import java.io.Serializable;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Case implements Serializable
{
   
    private String couleur="blanc";
    private int score=0;
    private int deplacer=0;
    public int[] action(int position)
    {
        this.score=0;
        this.deplacer=0;    
        int [] table= {this.score,this.deplacer};
      
        
     
        return(table);
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