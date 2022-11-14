package application;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Random;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class Main extends Application  {
	
	
	@Override
	public void start(Stage primaryStage) throws Caseexception  {
		Jeu jeu1=new Jeu();
		VBox usermenu=new VBox();
		Text welcome=new Text();
		welcome.setText("Welcome To Gosse Game:");
		welcome.setFont(Font.font("Roboto" ,FontWeight.BLACK,FontPosture.ITALIC , 25));
		
		
		usermenu.getChildren().add(welcome);
		
		usermenu.setStyle("");
		primaryStage.setTitle("User Informations");
		usermenu.setStyle("-fx-background-color:rgba(251, 189, 8, 1)");
		 Scene first=new Scene (usermenu,600,300);
		 Text labele=new Text();
		 labele.setText("Enter your name:");
		 labele.setFont(Font.font("Roboto" ,FontWeight.LIGHT,FontPosture.ITALIC , 15));
		 usermenu.setAlignment(Pos.CENTER);
		 usermenu.setSpacing(13);
		 usermenu.getChildren().add(labele);
		 TextField spacename=new TextField();
		 spacename.setMaxSize(300, 30);
		spacename.setMinHeight(30);
		 spacename.setStyle("-fx-background-radius:15px ; ");
		 usermenu.getChildren().add(spacename);
		 Button submit=new Button("Play");
		 submit.setMinWidth(100);
		 submit.setStyle("-fx-background-radius:15px; -fx-background-color:rgb(30, 30, 30, 1) ");
		 submit.setTextFill(Color.rgb(255, 191, 8, 1));
		 submit.setMinHeight(30);
		 usermenu.getChildren().add(submit);
		 submit.setOnAction(e->{
			 String nomy=spacename.getText();
			 System.out.println("le nom du joueur est :"+nomy);
			 Joueur playeer=new Joueur(nomy,-100);
			 jeu1.part.setplayer(playeer);
			 jeu1.verifier();
			// jeu1.lancerjeu();
			 primaryStage.close();
		 });
		 primaryStage.setScene(first);
		 primaryStage.show();
		 
		
	}

	
	
	public static void main (String args[])
	{
		
	   
	     launch(args);
	     
		
		
	}



	
	

}
/*package application;
import java.util.Random; 
import java.util.Iterator;
import java.util.HashSet;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application  {
	
	int ligne=0;
	int column=0;
	int partie=1;
	Button tabbutton[]=new Button[300];
	static Partie part=new Partie();
	 int count=0;
	@Override
	public void start(Stage primaryStage) throws Caseexception  {
		//Group root= new Group();
		 Definition defdef = new Definition () ; 
		 defdef.Hashdef(); 
		  Scanner sc=new Scanner (System.in);
		  Rectangle rec=new Rectangle();
		  rec.setWidth(100);
		  Text txt=new Text();
		  Text playtxt=new Text();
		  Text spacetxt=new Text();
		  playtxt.setText("Player ");
		  spacetxt.setText("Space");
		  playtxt.setFont(Font.font("Roboto" ,FontWeight.BLACK , 30));
		  playtxt.setFill(Color.rgb(30, 30, 30, 1));
		  spacetxt.setFont(Font.font("Roboto" ,FontWeight.LIGHT , 25));
		  rec.setHeight(100);
		  rec.setStyle("-fx-background-color: #484848;");
          HBox fortext=new HBox();
          fortext.getChildren().add(playtxt);
          fortext.getChildren().add(spacetxt);
		  DropShadow shadow =new DropShadow();
		  shadow.setSpread(0.7);
		  shadow.setColor(Color.SILVER);
		  fortext.setAlignment(Pos.BASELINE_CENTER);
		GridPane panel=new GridPane();
		panel.setPadding(new Insets(30));
		panel.setHgap(6);
		panel.setVgap(6);
		panel.setAlignment(Pos.CENTER);
		panel.setStyle("-fx-background-color:#787878; -fx-background-radius: 50px;");
	     txt.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 20));
	     HBox globale=new HBox();
	    VBox play =new VBox();
	    ImageView img;
	   // img = new ImageView(new Image(getClass().getResourceAsStream("Group 1 (1).png")));
	    // play.getChildren().add(img);
		VBox box=new VBox();
		StackPane userbox=new StackPane();
		box.getChildren().add(panel);
		box.setSpacing(20);
		box.setPadding(new Insets(40,40,40,150));
		Button de=new Button("Lancer dée");
		Button de1=new Button("");
		Button de2=new Button("");
		 HBox hb=new HBox();
		 Rectangle rect=new Rectangle();
		 rect.setFill(Color.rgb(30, 30, 30, 1));
		 rect.setWidth(300);
		 rect.setArcWidth(50.0);
	     rect.setArcHeight(50.0);
		 rect.setHeight(450);
		 play.setPadding(new Insets(60,60,60,60));
		 play.setSpacing(30);
		// userbox.getChildren().addAll(rect,img);
		// img.setFitHeight(200);
		//img.setFitWidth(293);
		//userbox.setAlignment(img, Pos.TOP_CENTER);
	//	userbox.setMargin(img, new Insets(5));
		
		 play.getChildren().add(fortext);
		// play.getChildren().add(rect);
		 play.getChildren().add(userbox);
		 play.setStyle("-fx-background-color:rgba(251, 189, 8, 1);");
		 String nomjoueur=part.player.name;
		 Text nom=new Text();
		 Text name=new Text();
		 VBox scorename=new VBox();
		 scorename.getChildren().add(name);
		 scorename.getChildren().add(nom);
		 VBox score=new VBox();
		 Text scoreactuel=new Text();
		 Text scoree=new Text();
		 String scorejoueur="    "+part.score;
		 scoreactuel.setText("Score Actuel");
		 scoreactuel.setFont(Font.font("Roboto" ,FontWeight.LIGHT,FontPosture.ITALIC, 15));
		 scoree.setText(scorejoueur);
		 scoreactuel.setFill(Color.WHITE);
		scoree.setFill(Color.WHITE);
		 scoree.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 20));
		 score.getChildren().add(scoreactuel);
		 score.getChildren().add(scoree);
		 nom.setText(nomjoueur);
		 name.setText("Player Name");
		 nom.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 20));
		 nom.setFill(Color.WHITE);
		 name.setFont(Font.font("Roboto" ,FontWeight.LIGHT,FontPosture.ITALIC, 15));
		name.setFill(Color.WHITE);
		userbox.getChildren().add(scorename);
		userbox.getChildren().add(score);
		 scorename.setPadding(new Insets(180,60,60,110));
		 score.setPadding(new Insets(250,60,60,110));
		 hb.getChildren().add(de);
		 hb.getChildren().add(de1);
		 hb.getChildren().add(de2);
		 hb.getChildren().add(txt);
		 box.getChildren().add(hb);
		
		  globale.getChildren().add(play);
		  globale.getChildren().add(box);
		
		 hb.setSpacing(27);
	     hb.setAlignment(Pos.CENTER);
	     hb.setStyle("-fx-background-color:#F6D470 ");
	     box.setStyle("-fx-background-color: #F6D470");
	     globale.setStyle("-fx-background-color:#F6D470");
		Scene scene=new Scene(globale,1280,650);
		Button case1;
		String couleur;
		int positive=1;
		part.lancerpartie();
		int actuel=part.caseactuel;
		int controle=10;
		int fixed=0;
		 
	    int minCol=1; 
	    int maxCol=9; 
	    int minRow=0;
	    int maxRow=9; 
		int i=0;
		int q=0; 
		for(int v=0 ; v<maxCol*maxRow ; v++)
		{
		for (q=minCol-1 ; q <=maxCol ; q++)
			{ 
			if(i>99)
			{
				break; 
			}
			System.out.println("boucle1"); 
			 case1 =new Button(""+i);
			 case1.setId(""+i);
			 case1.setMinWidth(42);
			 case1.setMinHeight(42);
			 tabbutton[i]=case1;
			 tabbutton[i].setOnAction(l->{
				Button b =(Button) l.getSource();
				int j=Integer.parseInt(b.getId());
				count=j;
			    
				System.out.println("le numero de la case est : "+j);
				try{
			         part.verifiercase(j);
			         int posi=part.caseactuel;
			         tabbutton[posi].setEffect(null);
			         posi=part.getcasedestination();
			         tabbutton[posi].setEffect(shadow);
			         partie=part.deplacer();
			         tabbutton[posi].setEffect(null);
			         posi=part.caseactuel;
			         tabbutton[posi].setEffect(shadow);
			         txt.setText(null);
			         String scor="    "+part.score;
			         scoree.setText(scor);
			     
			     }
			     catch(Caseexception e){
			    	
			        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
			        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
			     }
				
				 
				 
			});
			
				panel.add(tabbutton[i], minRow, q);
				couleur= this.part.plat.tabcase[i].affichercolor();
				System.out.println(i); 
				i++; 
				
				
				if(couleur=="jaune")
				{
					case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
				}
				if(couleur=="blanc")
				{
					case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
				}
				if(couleur=="rose")
				{
					case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
				}
				if(couleur=="bleu")
				{
					case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
					
				}
				if(couleur=="vert")
				{
					case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
				}
				if(couleur=="noir")
				{
					case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
				}
				if(couleur=="rouge")
				{
					case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
				}
				if(couleur=="orange")
				{
					case1.setStyle("-fx-background-color:#FFA500; -fx-background-radius: 20px; ");
				}
	
			}
			for(q=minRow +1 ; q<=maxRow ; q++)
			{ if(i>99)
			{
				break; 
			}
				System.out.println("boucle2"); 
			 case1 =new Button(""+i);
			 case1.setId(""+i);
			 case1.setMinWidth(42);
			 case1.setMinHeight(42);
			 tabbutton[i]=case1;
			 tabbutton[i].setOnAction(l->{
				Button b =(Button) l.getSource();
				int j=Integer.parseInt(b.getId());
				count=j;
			    
				System.out.println("le numero de la case est : "+j);
				try{
			         part.verifiercase(j);
			         int posi=part.caseactuel;
			         tabbutton[posi].setEffect(null);
			          posi=part.getcasedestination();
			         tabbutton[posi].setEffect(shadow);
			         partie=part.deplacer();
			         tabbutton[posi].setEffect(null);
			         posi=part.caseactuel;
			         tabbutton[posi].setEffect(shadow);
			        txt.setText(null);
			      String scor="    "+part.score;
			        scoree.setText(scor);
			     
			     }
			     catch(Caseexception e){
			    	
			        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
			        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
			     }
				
				 
				 
			});
			
				panel.add(tabbutton[i], q , maxCol);
				
				couleur= this.part.plat.tabcase[i].affichercolor();
				System.out.println(i); 
				i++; 
				if(couleur=="jaune")
				{
					case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
				}
				if(couleur=="blanc")
				{
					case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
				}
				if(couleur=="rose")
				{
					case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
				}
				if(couleur=="bleu")
				{
					case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
					
				}
				if(couleur=="vert")
				{
					case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
				}
				if(couleur=="noir")
				{
					case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
				}
				if(couleur=="rouge")
				{
					case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
				}
				if(couleur=="orange")
				{
					case1.setStyle("-fx-background-color: #FFA500; -fx-background-radius: 20px; ");
				}
				 
			} 
			for(q=maxCol-1 ; q>=minCol ; q--)
			{   
				if(i>99)
				{
					break; 
				}
			System.out.println("boucle3"); 
			 case1 =new Button(""+i);
			 case1.setId(""+i);
			 case1.setMinWidth(42);
			 case1.setMinHeight(42);
			 tabbutton[i]=case1;
			 tabbutton[i].setOnAction(l->{
				Button b =(Button) l.getSource();
				int j=Integer.parseInt(b.getId());
				count=j;
			    
				System.out.println("le numero de la case est : "+j);
				try{
			         part.verifiercase(j);
			         int posi=part.caseactuel;
			         tabbutton[posi].setEffect(null);
			          posi=part.getcasedestination();
			         tabbutton[posi].setEffect(shadow);
			         partie=part.deplacer();
			         tabbutton[posi].setEffect(null);
			         posi=part.caseactuel;
			         tabbutton[posi].setEffect(shadow);
			        txt.setText(null);
			      String scor="    "+part.score;
			        scoree.setText(scor);
			     
			     }
			     catch(Caseexception e){
			    	
			        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
			        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
			     }
				
				 
				 
			});
			
				panel.add(tabbutton[i], maxRow, q);
				
				couleur= this.part.plat.tabcase[i].affichercolor();
				System.out.println(i); 
				i++;
				
				if(couleur=="jaune")
				{
					case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
				}
				if(couleur=="blanc")
				{
					case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
				}
				if(couleur=="rose")
				{
					case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
				}
				if(couleur=="bleu")
				{
					case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
					
				}
				if(couleur=="vert")
				{
					case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
				}
				if(couleur=="noir")
				{
					case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
				}
				if(couleur=="rouge")
				{
					case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
				}
				if(couleur=="orange")
				{
					case1.setStyle("-fx-background-color:#FFA500; -fx-background-radius: 20px; ");
				}
				 
			} 
			for (q=maxRow-1; q>=minRow+2 ; q-- )
			{ if(i>99)
			{
				break; 
			}
				System.out.println("boucle4"); 
			 case1 =new Button(""+i);
			 case1.setId(""+i);
			 case1.setMinWidth(42);
			 case1.setMinHeight(42);
			 tabbutton[i]=case1;
			 tabbutton[i].setOnAction(l->{
				Button b =(Button) l.getSource();
				int j=Integer.parseInt(b.getId());
				count=j;
			    
				System.out.println("le numero de la case est : "+j);
				try{
			         part.verifiercase(j);
			         int posi=part.caseactuel;
			         tabbutton[posi].setEffect(null);
			          posi=part.getcasedestination();
			         tabbutton[posi].setEffect(shadow);
			         partie=part.deplacer();
			         tabbutton[posi].setEffect(null);
			         posi=part.caseactuel;
			         tabbutton[posi].setEffect(shadow);
			        txt.setText(null);
			      String scor="    "+part.score;
			        scoree.setText(scor);
			     
			     }
			     catch(Caseexception e){
			    	
			        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
			        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
			     }
				
				 
				 
			});
			
				panel.add(tabbutton[i], q , minCol);
				System.out.println(i); 
				couleur= this.part.plat.tabcase[i].affichercolor();
				i++;
				
				if(couleur=="jaune")
				{
					case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
				}
				if(couleur=="blanc")
				{
					case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
				}
				if(couleur=="rose")
				{
					case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
				}
				if(couleur=="bleu")
				{
					case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
					
				}
				if(couleur=="vert")
				{
					case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
				}
				if(couleur=="noir")
				{
					case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
				}
				if(couleur=="rouge")
				{
					case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
				}
				if(couleur=="orange")
				{
					case1.setStyle("-fx-background-color: #FFA500; -fx-background-radius: 20px; ");
				}
				 
			} 
			
			minCol++; 
			minRow++;
			maxCol--; 
			maxRow--;
			minCol++; 
			minRow++;
			maxCol--; 
			maxRow--;
			
		
		 
		 
		}
		
		tabbutton[actuel].setEffect(shadow);
		
		
		
		
		
		 de.setOnAction(d->{
			 Button s =(Button) d.getSource();
			 
			 part.sommedée();
			 int val=part.getdeplacement();
			 int valde1=part.d1.getvaleur();
			 int valde2=part.d2.getvaleur();
			 de1.setText(""+valde1);
			 de2.setText(""+valde2);
			// s.setText(""+val);
			 
			 
		 });
		 de.setMinWidth(120);
		 de.setMinHeight(40);
		 de.setStyle("-fx-background-color:rgb(30, 30, 30, 1);  -fx-font-size: 14; -fx-background-radius:16px ; ");
		 de.setTextFill(Color.rgb(255, 191, 8, 1));
		
		 de1.setMinWidth(50);
		 de1.setMinHeight(50);
		 de1.setStyle("-fx-background-color:#FFFFFF;  -fx-font-size: 18; ");
		 de2.setMinWidth(50);
		 de2.setMinHeight(50);
		 de2.setStyle("-fx-background-color:#FFFFFF;  -fx-font-size: 18; ");
		 
		scene.setFill(Color.CADETBLUE);
		primaryStage.setTitle("le jeu");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
	
	public static void main (String args[])
	{
		
	   
	     launch(args);
	     
		
		
	}



	
	

}*/
