package application;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import java.util.Iterator;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class Imagefile extends Question
{
    private  String couleur="rose";
   private  int deplacer=0;
  private  int score=0;
   static int index=0;
   static HashMap <String,ImageView>mapy=new HashMap <String,ImageView>();
   
  
   public void start()
   {
	   ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20;
	    img1 = new ImageView(new Image(getClass().getResourceAsStream("images.jpg")));
	    String key1="Mango";
	    mapy.put(key1,img1);
	    img2 = new ImageView(new Image(getClass().getResourceAsStream("stickers-pomme-verte.jpg.jpg")));
	    String key2="Apple";
	    mapy.put(key2,img2);
	    img3 = new ImageView(new Image(getClass().getResourceAsStream("G03-200x200.jpg")));
	    String key3="Boring";
	    mapy.put(key3,img3);
	    img4 = new ImageView(new Image(getClass().getResourceAsStream("funny-cartoon-monster-3D-model_0.jpg")));
	    String key4="Monster";
	    mapy.put(key4,img4);
	    img5 = new ImageView(new Image(getClass().getResourceAsStream("f61e2a5d19213ffc2bba72d4a915f5d1.png")));
	    String key5="SuperHero";
	    mapy.put(key5,img5);
	    img6 = new ImageView(new Image(getClass().getResourceAsStream("pngtree-exam-character-illustration-paper-png-image_4031052.jpg")));
	    String key6="Studing";
	    mapy.put(key6,img6);
	    img7 = new ImageView(new Image(getClass().getResourceAsStream("Lovepik_com-400243363-house.png")));
	    String key7="House";
	    mapy.put(key7,img7);
	    
	    img8 = new ImageView(new Image(getClass().getResourceAsStream("Pink_Flower_PNG_Clipart-173 (1).png")));
	    String key8="Flower";
	    mapy.put(key8,img8);
	    
	    img9 = new ImageView(new Image(getClass().getResourceAsStream("—Pngtree—wooden table png element_4007167.png")));
	    String key9="Table";
	    mapy.put(key9,img9);
	    img10 = new ImageView(new Image(getClass().getResourceAsStream("télécharger.jpg")));
	    String key10="Tree";
	    mapy.put(key10,img10);
	    
	    img11 = new ImageView(new Image(getClass().getResourceAsStream("395841.png")));
	    String key11="Flag";
	    mapy.put(key11,img11);
	    img12 = new ImageView(new Image(getClass().getResourceAsStream("images.png")));
	    String key12="Book";
	    mapy.put(key12,img12);
	    img13= new ImageView(new Image(getClass().getResourceAsStream("pngtree-color-planet-pattern-decoration-illustration-image_1412482.jpg")));
	    String key13="Planet";
	    mapy.put(key13,img13);
	   img14 = new ImageView(new Image(getClass().getResourceAsStream("pngtree-cute-bear-ear-straw-hat-png-free-material-image_1133529.jpg")));
	    String key14="Hat";
	    mapy.put(key14,img14);
	    img15 = new ImageView(new Image(getClass().getResourceAsStream("pngtree-vector-cloud-icon-png-image_312934.jpg")));
	    String key15="Cloud";
	    mapy.put(key15,img15);
	    img16 = new ImageView(new Image(getClass().getResourceAsStream("socks_drawing.png")));
	    String key16="Socks";
	    mapy.put(key16,img16);
	    img17 = new ImageView(new Image(getClass().getResourceAsStream("2a77536f84d47206315384809ce9cd46.png")));
	    String key17="Bag";
	    mapy.put(key17,img17);
	    img18 = new ImageView(new Image(getClass().getResourceAsStream("6-119.jpg")));
	    String key18="Butterfly";
	    mapy.put(key18,img18);
	    img19 = new ImageView(new Image(getClass().getResourceAsStream("Fish-DRAWING-–-STEP-10.jpg")));
	    String key19="Fish";
	    mapy.put(key19,img19);
	   img20 = new ImageView(new Image(getClass().getResourceAsStream("image_processing20200510-8902-rr1aj9.png")));
	    String key20="Package";
	    mapy.put(key20,img20);
	    
	    
   }

   

	public int [] action (int y)
    {
		HashSet <String> ourset= new HashSet<String>();
		HBox pan=new HBox();
		pan.setAlignment(Pos.BASELINE_CENTER);
		pan.setSpacing(40);
		VBox pann=new VBox(); 
		pann.setAlignment(Pos.BASELINE_CENTER);
		pann.setSpacing(15);
		Stage stage=new Stage();
		Text mot=new Text();
		mot.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC ,40)); 
        mot.setFill(Color.rgb(30, 30, 30, 1));
        Text titre = new Text(); 
        titre.setText("Choose the correct picture to WIN !");
        titre.setFont(Font.font("Roboto" ,FontWeight.LIGHT,FontPosture.ITALIC ,20)); 
        titre.setFill(Color.rgb(30, 30, 30, 1));
		Random rando=new Random();
		int l=0;
		String clé;
		while(l<4)
		{
			clé=Keys.getRandomKey().name();
			while(ourset.contains(clé))
			{
				 clé=Keys.getRandomKey().name();
			}
			ourset.add(clé);
			l++;
		}
		Iterator<String> it=ourset.iterator();
		ImageView imagess =new ImageView();
		String c="";
		int choix=rando.nextInt(4);
		int cpt=0;
		String choixstring="";
		while (it.hasNext())
		{
			
			 c=it.next();
			 if(cpt==choix)
				{
					choixstring=c;
					mot.setText(choixstring);
				}
			 imagess=mapy.get(c);
			 imagess.setFitHeight(100);
				imagess.setFitWidth(100);
				Button btn1=new Button();
				btn1.setStyle("-fx-background-radius:15px; -fx-background-color:#FFFFFF"); 
				 btn1.setMinWidth(100);
				 btn1.setMinHeight(100);
			   	 btn1.setGraphic(imagess);
				 btn1.setOnAction(d->{
					 Button s =(Button) d.getSource();
					 ImageView r=(ImageView) s.getGraphic();
					 Iterator ity=mapy.entrySet().iterator();
					 String clicked="";
					 String compare=mot.getText();
				        for (Map.Entry mapentry : mapy.entrySet()) {
				        	if(mapentry.getValue()== r)
				        	{
				        		clicked=(String) mapentry.getKey();
				        		System.out.println("clé: "+clicked);
				        	}
				        	
				        }
				        if(clicked==compare)
				        {
				        	System.out.println("congrats");
				        	this.score=10;
				        	this.deplacer=2;
				        	
				        	stage.close();
				        
				        }
				        else {
				        	System.out.println("faiiiled");
				        	this.score=0;
				        	this.deplacer=0;
				        	stage.close();
				        
				        }
				       
					
					 
				 });
		    
				
			pan.getChildren().add(btn1);
		
			cpt++;
		}
		
		System.out.println(c);
		
        deplacer=0;
        score=0;
        System.out.println("la case actuel est de type Image");
      
      
        pann.setStyle("-fx-background-color:#FEAE73");
       
        pann.getChildren().add(titre); 
        pann.getChildren().add(mot);
        pann.getChildren().add(pan); 
         
        Scene sn=new Scene (pann,800,400);
        stage.setTitle("Image game");
        stage.setScene(sn);
        stage.showAndWait();
        int tabdep[]= {this.score,this.deplacer};
        return(tabdep);
      
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
