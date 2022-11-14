package application;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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



public class Jeu
{
    
   private int best_score=0;
   static Joueur bestplayer;
    
	int partie=1;
	
	static Partie part=new Partie();
	
	
	public void sauvegarder() {
		         
		  try {
			 
		         FileOutputStream fos=new FileOutputStream(".\\"+part.getjoueur().getname()+".dat");
		         ObjectOutputStream os=new ObjectOutputStream(fos);
		         os.writeObject(part);
		         
		         for(int i=0;i<part.getplateau().tabcase.length;i++)
		         {
		        	 os.writeObject(part.getplateau().tabcase[i]);
		         }
		         
		        
		         
		         os.close();
		         fos.close();
		         
		        }
		        catch(IOException except){
		     	   except.printStackTrace();
		        }
	
	}

	 public void verifier() {
			 
			
			
				 Partie parte;
				 int found=0;
				 Partie sauv=new Partie();
				 Case tab[]=new Case[100];
				 String path=".\\"+part.getjoueur().getname()+".dat";
				 File file=new File(path);
				 try {
					file.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 Object o;
				 
				 
					try {
					    
						
						FileInputStream fis = new FileInputStream(file);
						ObjectInputStream ois=new ObjectInputStream(fis);
					
					 while(true)
					 {
						 
						 o=ois.readObject();
						
						if(o instanceof Partie)
						 {
							 parte=(Partie)o;
							 System.out.println(""+parte.getjoueur().getname());
								
								if (parte.getjoueur().getname().equals(part.getjoueur().getname()))
								{
									sauv=parte;
									found=1;
									int j=0;
									while(j<100)
									{
										tab[j]=(Case) ois.readObject();
										
										System.out.println(tab[j].affichercolor());
										j++;
									}
									sauv.getplateau().tabcase=tab;
									
								}
							 
						 }
						
						 
					 }
					
					
					} catch(EOFException e)
					{
						
					}
					catch (Exception e) {
						 
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						 
							
							
					  
						
						if(found==1)
						{
							
							
						
							if(sauv.getcaseactuel()==99)
							{
								
								part.lancerpartie();
								lancerjeu();
							}
							else
							{
								
								
								
								this.part=sauv;
								
					        
			        			 Stage stagereprendre=new Stage();
			        			 VBox reprendre =new VBox();
			        			 reprendre.setStyle("-fx-background-color:#000000");
			        			 Text confirmation=new Text();
			        			 confirmation.setText("Do you want to take back the round ?  ");
			        			 confirmation.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 30));
			        		     confirmation.setFill(Color.WHITE);
			        		     reprendre.getChildren().add(confirmation);
			        		     HBox boxbutton=new HBox();
			        		     Button btn1=new Button("Yes");
			        		     Button btn2=new Button("No");
			        		    Text caseact=new Text();
			        		     Text scoreactu=new Text();
			        		     
			        		     btn1.setOnAction(e->{
			        		    	
			        		     stagereprendre.close();
			        		     
			        		     lancerjeu();
			        		     
			        		     });
			        		     btn2.setOnAction(e->{
			        		    	part=new Partie();
			        		    	part.lancerpartie();
			        		    	  stagereprendre.close();
			        		    	lancerjeu(); 
			        		     });
			        		     btn1.setMinWidth(100);
			        		     btn1.setMinHeight(30);
			        		     btn2.setMinHeight(30);
			        		     btn2.setMinWidth(100);
			        		     btn1.setStyle("-fx-background-radius:15px; -fx-background-color:rgba(251, 189, 8, 1)");
			        		     btn2.setStyle("-fx-background-radius:15px; -fx-background-color:rgba(251, 189, 8, 1)");
			        		     boxbutton.getChildren().add(btn1);
			        		     boxbutton.getChildren().add(btn2);
			        		     boxbutton.setSpacing(100);
			        		     boxbutton.setAlignment(Pos.CENTER);
			        		     reprendre.setAlignment(Pos.CENTER);
			        		     reprendre.setSpacing(30);
			        		     reprendre.getChildren().add(boxbutton);
			        			 Scene scenereprendre=new Scene(reprendre,600,300);
			        			 
			        			 stagereprendre.setScene(scenereprendre);
			        			 stagereprendre.show();
								
								////fin
							}
						}
						else
						{
							
							part.lancerpartie();
							lancerjeu();
						}
						
						
						
						
				 
		 
			try {
				String re="fichier_joueurs.txt";
				  FileReader filee = new FileReader("C:\\Users\\pc\\eclipse-workspace\\tp\\src\\application\\fichier_joueurs.txt");
		           BufferedReader buffer = new BufferedReader(filee); 
		        // ----------- parcourir le fichier ------------------------------
		           String liny=buffer.readLine();
		           String [] strings=new String[7];
		           strings=liny.split("/");
		           int scr=Integer.parseInt(strings[1]);
		           this.bestplayer=new Joueur(strings[0],scr);
		           this.bestplayer.setscore(Integer.parseInt(strings[1]));
		           this.best_score=Integer.parseInt(strings[1]);
				 
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		 
		 
		 
		 
		 
		 
	 

	 public void quitterjeu(Stage stage2) {
	    	Stage stagequit=new Stage();
	    	VBox quitbox=new VBox();
	    	Text sure=new Text();
	    	sure.setText("Do you want to save the round");
	    	quitbox.setAlignment(Pos.CENTER);
	    	HBox buttons=new HBox();
	    	Button sauvgard=new Button("Save");
	    	Button cancel=new Button("Cancel");
	    	buttons.getChildren().add(cancel);
	    	buttons.getChildren().add(sauvgard);
	    	 sauvgard.setMinWidth(100);
			 sauvgard.setMinHeight(30);
				buttons.setSpacing(100);	
				buttons.setAlignment(Pos.CENTER);
			 sauvgard.setStyle("-fx-background-radius:15px; -fx-background-color:rgba(251, 189, 8, 1)");
			 cancel.setMinWidth(100);
			 cancel.setMinHeight(30);	 
			 cancel.setStyle("-fx-background-radius:15px; -fx-background-color:rgba(251, 189, 8, 1)");
	    	cancel.setOnAction(e->{
	    		stagequit.close();
	    		stage2.close();
	    	});
	    	sauvgard.setOnAction(e->{
	    		sauvegarder();
	    		stagequit.close();
	    		stage2.close();
	    	});
	    	sure.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 30));
	        sure.setFill(Color.WHITE);
	    	quitbox.getChildren().add(sure);
	    	quitbox.getChildren().add(buttons);
	    	quitbox.setStyle("-fx-background-color:#000000;");
	    	quitbox.setSpacing(30);
	    	Scene scenequit=new Scene(quitbox,600,300);
	    	stagequit.setScene(scenequit);
	    	stagequit.show();
	    	
			 
	    }
	
	
		
	 public void lancerjeu()  {
			
			int ligne=0;
			int column=0;
			
			int count=0;
			  Button tabbutton[]=new Button[100];
			  
		    	Stage primaryStage=new Stage();
		    	
		    	Definition defdef= new Definition() ; 
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
				  Effect shadow =new DropShadow();
				  fortext.setAlignment(Pos.BASELINE_CENTER);
				GridPane panel=new GridPane();
				panel.setPadding(new Insets(30));
			    
				panel.setHgap(1);
				panel.setVgap(1);
				panel.setAlignment(Pos.CENTER);
				panel.setStyle("-fx-background-color:#787878; -fx-background-radius: 50px;");
			     txt.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 20));
			     HBox globale=new HBox();
			    VBox play =new VBox();
			    ImageView img;
			    img = new ImageView(new Image(getClass().getResourceAsStream("Group 1 (1).png")));
			     play.getChildren().add(img);
				VBox box=new VBox();
				StackPane userbox=new StackPane();
				
				box.getChildren().add(panel);
				box.setSpacing(20);
				box.setPadding(new Insets(10,40,40,60));
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
				 userbox.getChildren().addAll(rect,img);
				 img.setFitHeight(200);
				img.setFitWidth(293);
				userbox.setAlignment(img, Pos.TOP_CENTER);
				userbox.setMargin(img, new Insets(5));
				
				 play.getChildren().add(fortext);
				// play.getChildren().add(rect);
				 play.getChildren().add(userbox);
				 play.setStyle("-fx-background-color:rgba(251, 189, 8, 1);");
				 String nomjoueur=this.part.getjoueur().getname();
				 Text nom=new Text();
				 Text name=new Text();
				 VBox scorename=new VBox();
				 scorename.getChildren().add(name);
				 scorename.getChildren().add(nom);
				 VBox score=new VBox();
				 Text scoreactuel=new Text();
				 Text scoree=new Text();
				 String scorejoueur="    "+part.getscore();
				 scoreactuel.setText("Score Actuel");
				 scoreactuel.setFont(Font.font("Roboto" ,FontWeight.LIGHT,FontPosture.ITALIC, 15));
				 scoree.setText(scorejoueur);
				 scoreactuel.setFill(Color.WHITE);
				scoree.setFill(Color.WHITE);
				 scoree.setFont(Font.font("Roboto" ,FontWeight.BLACK ,FontPosture.ITALIC, 20));
				 score.getChildren().add(scoreactuel);
				 score.getChildren().add(scoree);
				
				 Button trye =new Button("Quit");
				 score.getChildren().add(trye);
				 trye.setMinWidth(100);
				 trye.setMinHeight(30);
				 
						 
				 trye.setStyle("-fx-background-radius:15px; -fx-background-color:rgba(251, 189, 8, 1)");
				 
				 trye.setOnAction(e->{
					quitterjeu(primaryStage);
					
				 });
				 
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
				
			
				Imagefile starting=new Imagefile();
				starting.start();
				
				
				int actuel=part.getcaseactuel();
				int i=0;
				 
			    int minCol=1; 
			    int maxCol=11; 
			    int minRow=0;
			    int maxRow=15; 
				
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
							
						    
							System.out.println("le numero de la case est : "+j);
							try{
						         part.verifiercase(j);
						         int posi=part.getcaseactuel();
						         tabbutton[posi].setEffect(null);
						          posi=part.getcasedestination();
						         tabbutton[posi].setEffect(shadow);
						        
						         partie=part.deplacer();
						         
						         tabbutton[posi].setEffect(null);
						         posi=part.getcaseactuel();
						         tabbutton[posi].setEffect(shadow);
						        txt.setText(null);
						        
						      String scor="    "+part.getscore();
						        scoree.setText(scor);
						     
						     }
						     catch(Caseexception e){
						    	
						        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
						        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
						     }
							
					 }); 
							 
					
						panel.add(tabbutton[i], minRow, q);
						couleur= this.part.getplateau().tabcase[i].affichercolor();
						System.out.println(i); 
						i++; 
						
						
						if(couleur.equals("jaune"))
						{
							case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
						}
						if(couleur.equals("blanc"))
						{
							case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
						}
						if(couleur.equals("rose"))
						{
							case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("bleu"))
						{
							case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
							
						}
						if(couleur.equals("vert"))
						{
							case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("noir"))
						{
							case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("rouge"))
						{
							case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("orange"))
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
						
					    
						System.out.println("le numero de la case est : "+j);
						try{
					         part.verifiercase(j);
					         int posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(null);
					          posi=part.getcasedestination();
					         tabbutton[posi].setEffect(shadow);
					         partie=part.deplacer();
					         tabbutton[posi].setEffect(null);
					         posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(shadow);
					        txt.setText(null);
					      String scor="    "+part.getscore();
					        scoree.setText(scor);
					     
					     }
					     catch(Caseexception e){
					    	
					        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
					        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
					     }
						
						 
						 
					});
					
						panel.add(tabbutton[i], q , maxCol);
						
						couleur= this.part.getplateau().tabcase[i].affichercolor();
						System.out.println(i); 
						i++; 
						if(couleur.equals("jaune"))
						{
							case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
						}
						if(couleur.equals("blanc"))
						{
							case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
						}
						if(couleur.equals("rose"))
						{
							case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("bleu"))
						{
							case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
							
						}
						if(couleur.equals("vert"))
						{
							case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("noir"))
						{
							case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("rouge"))
						{
							case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("orange"))
						{
							case1.setStyle("-fx-background-color:#FFA500; -fx-background-radius: 20px; ");
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
					
					    
						System.out.println("le numero de la case est : "+j);
						try{
					         part.verifiercase(j);
					         int posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(null);
					          posi=part.getcasedestination();
					         tabbutton[posi].setEffect(shadow);
					         partie=part.deplacer();
					         tabbutton[posi].setEffect(null);
					         posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(shadow);
					        txt.setText(null);
					      String scor="    "+part.getscore();
					        scoree.setText(scor);
					     
					     }
					     catch(Caseexception e){
					    	
					        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
					        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
					     }
						
						 
						 
					});
					
						panel.add(tabbutton[i], maxRow, q);
						
						couleur= this.part.getplateau().tabcase[i].affichercolor();
						System.out.println(i); 
						i++;
						
						if(couleur.equals("jaune"))
						{
							case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
						}
						if(couleur.equals("blanc"))
						{
							case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
						}
						if(couleur.equals("rose"))
						{
							case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("bleu"))
						{
							case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
							
						}
						if(couleur.equals("vert"))
						{
							case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("noir"))
						{
							case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("rouge"))
						{
							case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("orange"))
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
						
					    
						System.out.println("le numero de la case est : "+j);
						try{
					         part.verifiercase(j);
					         int posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(null);
					          posi=part.getcasedestination();
					         tabbutton[posi].setEffect(shadow);
					         partie=part.deplacer();
					         tabbutton[posi].setEffect(null);
					         posi=part.getcaseactuel();
					         tabbutton[posi].setEffect(shadow);
					        txt.setText(null);
					      String scor="    "+part.getscore();
					        scoree.setText(scor);
					     
					     }
					     catch(Caseexception e){
					    	
					        System.out.println("veuillez cliquer sur la case nmr:"+ part.getcasedestination()); 
					        txt.setText("Veuillez cliquer sur la case numero  "+ part.getcasedestination());
					     }
						
						 
						 
					});
					
						panel.add(tabbutton[i], q , minCol);
						System.out.println(i); 
						couleur= this.part.getplateau().tabcase[i].affichercolor();
						i++;
						
						if(couleur.equals("jaune"))
						{
							case1.setStyle("-fx-background-color: #FAD02C;-fx-background-radius: 20px; ");
						}
						if(couleur.equals("blanc"))
						{
							case1.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 20px;");
						}
						if(couleur.equals("rose"))
						{
							case1.setStyle("-fx-background-color: #FFB6C1; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("bleu"))
						{
							case1.setStyle("-fx-background-color: #9BC4E2; -fx-background-radius: 20px; ");
							
						}
						if(couleur.equals("vert"))
						{
							case1.setStyle("-fx-background-color: #ABEA7C; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("noir"))
						{
							case1.setStyle("-fx-background-color: #000000; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("rouge"))
						{
							case1.setStyle("-fx-background-color: #DD5F51; -fx-background-radius: 20px; ");
						}
						if(couleur.equals("orange"))
						{
							case1.setStyle("-fx-background-color:#FFA500; -fx-background-radius: 20px; ");
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
					 int valde1=part.getd1().getvaleur();
					 int valde2=part.getd2().getvaleur();
					 de1.setText(""+valde1);
					 de2.setText(""+valde2);
					
					 
					 
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

		}
	 
  
