package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Fin extends Case
{
    private  String couleur="noir";
    private int deplacer=0;
   private  int score=0;

   public void sauvegarder() {
       
		  try {
			 
		         FileOutputStream fos=new FileOutputStream(".\\"+Jeu.part.getjoueur().getname()+".dat");
		         ObjectOutputStream os=new ObjectOutputStream(fos);
		         os.writeObject(Jeu.part);
		         
		         System.out.println("dooooone");
		         
		         for(int i=0;i<Jeu.part.getplateau().tabcase.length;i++)
		         {
		        	 os.writeObject(Jeu.part.getplateau().tabcase[i]);
		         }
		         
		         System.out.println("dooooone");
		         
		         
		         os.close();
		         
		       
		        }
		        catch(IOException except){
		     	   except.printStackTrace();
		        }
		  
   }
   
    public int[] action(int position)
    {
        this.deplacer=0;
        this.score=0;
        int [] tabfin= {this.score,this.deplacer};
        Stage stagee=new Stage();
        VBox finale=new VBox();
        finale.setStyle("-fx-background-color:#000000");
        Text congrats=new Text();
        Text newscore= new Text();
        newscore.setText(null);
        congrats.setText("Congratulation!");
        congrats.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 30));
        congrats.setFill(Color.WHITE);
        finale.getChildren().add(congrats);
        int scoredufin=Jeu.part.getscore();
        Joueur player1=Jeu.part.getjoueur();
        //----------------- new best score for the player---------------
       if(scoredufin>player1.getbestscore())
       {
    	  newscore.setText("You have a new Score !");
    	  newscore.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 15));
          newscore.setFill(Color.WHITE);
    	  finale.getChildren().add(newscore);
    	  player1.setscore(scoredufin);
    	
          try {
          File file1=new File("C:\\Users\\pc\\eclipse-workspace\\tp\\src\\application\\fichier_joueurs.txt");
    	   File file2=new File("C:\\Users\\pc\\eclipse-workspace\\tp\\src\\application\\filee.txt");
    	   file2.createNewFile();
    	   FileReader file1read=new FileReader(file1);
    	   FileWriter file2write=new FileWriter(file2);
    	   BufferedReader buf1=new BufferedReader(file1read);
    	   BufferedWriter buf2=new BufferedWriter(file2write);
    	   Joueur oly=Jeu.bestplayer;
    	   int verifier=0;
    	   String[] argms=new String[7];
    	   String line;
    	   if(scoredufin>oly.getbestscore())
    	   {
    		   
    		   Jeu.bestplayer=Jeu.part.getjoueur();
    		   line=""+Jeu.part.getjoueur().getname()+"/"+Jeu.part.getjoueur().getbestscore();
    		   buf2.write(line);
    		   System.out.println(line);
    		   buf2.newLine();
    		   line=buf1.readLine();
    	   }
    	   else {
    		   line=buf1.readLine();
    		   buf2.write(line);
    		   System.out.println(line);
    		   buf2.newLine();
    	   }
    	
    	   while((line=buf1.readLine())!= null)
    	   {
    		   System.out.println("la ligne :"+line);
 
    			  argms=line.split("/");
    			 System.out.println("le joueur"+argms[0]);
    			  if(argms[0].equals(Jeu.part.getjoueur().getname()))
    			  {
    				  System.out.println("le joueur"+argms[0]);
    				  String specific=Jeu.part.getjoueur().getname()+"/"+Jeu.part.getjoueur().getbestscore()+"/no/null/null";
    				  buf2.write(specific);
    				  verifier=1;
    			  }
    			  else
    			  {
    			  buf2.write(line);
       			  
    			  }
    			 
    			   
    		   
    		  buf2.newLine();
    		   
    		  
    	   }
    	   
    	   if(verifier==0)
    	   {
    		   line=Jeu.part.getjoueur().getname()+"/"+Jeu.part.getjoueur().getbestscore()+"/no/null/null";
    		   buf2.write(line);
    	   }
    	   buf1.close();
    	   buf2.close();
    	   
    	file1.delete() ;
    	   file2.renameTo(file1);
    	   
       }
       catch(IOException except){
    	   except.printStackTrace();
       }
    	  
       }
       
       Text best=new Text();
       int bestscore=player1.getbestscore();
       best.setText("Your Best Score is: "+bestscore);
       best.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 15));
       best.setFill(Color.WHITE);
       finale.getChildren().add(best);
   
       
       //---------bestplayer-------------
       Joueur bestj=Jeu.bestplayer;
       System.out.println("le nom du best player"+bestj.getname()+"le best score "+bestj.getbestscore());
       Text bestplyr=new Text();
       bestplyr.setText("Best player:"+bestj.getname());
       Text bestscr=new Text();
       bestscr.setText("Best Score:"+bestj.getbestscore());
       
 
       bestplyr.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 15));
       bestplyr.setFill(Color.WHITE);
       finale.getChildren().add(bestplyr);
       bestscr.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 15));
       bestscr.setFill(Color.WHITE);
       finale.getChildren().add(bestscr);
       
       finale.setAlignment(Pos.CENTER);
       finale.setSpacing(13);
        Button btn=new Button("close");
        btn.setMinHeight(30);
        btn.setMinWidth(120);
        btn.setStyle("-fx-background-radius:15px ; -fx-background-color:rgb(255, 191, 8, 1)");
        btn.setTextFill(Color.rgb(30, 30, 30, 1));
        finale.getChildren().add(btn);
        btn.setOnAction(m->{
        	sauvegarder();
        	stagee.close();
        	
        });
        Scene sne=new Scene (finale,600,300);
        stagee.setScene(sne);
        stagee.show();
        return(tabfin);
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
