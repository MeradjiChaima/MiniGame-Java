package application;
import java.io.* ;
import java.util.* ;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Definition extends Question
{   
    private  String couleur="bleu";
    private int deplacer=0;
    private int score=0;
    
    
    String user ="" ; 
    static HashMap <String, String> definition = new HashMap<String, String>();
    Random rand=new Random();
    String def1 , def2 , line , deef ; 
   
    
    
    
    public void Hashdef()  {
    	//remlpir le hashmap <mot,def> d'aprés le fichier texte de definition 
    	int i = 0 ;
    	 String[] strs = new String[2]; //pour stocker le mot et la def aprés division
    	try 
        {
             FileReader fichier = new FileReader("C:\\Users\\pc\\eclipse-workspace\\tp\\src\\application\\file.txt");
             try (BufferedReader buffer = new BufferedReader(fichier)) 
        {
  			//------------- parcourir le fichier texte de definition ------------------------------
  			  while ((line = buffer.readLine())!= null) //while not the end of the file 
  			  {    strs = line.split(":"); //diviser la ligne par : 
  			       definition.put(strs[0],strs[1]); // remplir le hashmap <mot,def> 
  			   i++;    
  			  }
  		} 
    }
    	catch (IOException e)
        {
          e.printStackTrace();
        }  
    } 
    
    
    
    public int[] action  (int y)
    {   
    	// pour parcourir le hashmap 
    	int f ; 
    	int aleat = 0 ; 
    	Iterator it = definition.entrySet().iterator();  
        aleat= rand.nextInt(definition.size()); //choisir un couple aleatoire 
        
         for(int k =0 ; k<aleat ; k++) 
         {  
          it.next();  
         }
         
         Map.Entry m = (Map.Entry) it.next();
         def1=(String)m.getKey(); //def1= obtenue par hashmap
         f=def1.length(); 
         deef= (String)m.getValue();
         String [] userdef = new String[f]; 
    	Stage st =new Stage();
        st.setTitle("Definition");
        TextField tf = new TextField(); 
        TextField [] tabinput=new TextField[f];
		TextField elem ;
		HBox box = new HBox(); 
		box.setAlignment(Pos.BASELINE_CENTER);
		box.setSpacing(20);
		for (int k=0 ; k<f ; k++) {
		   elem=new TextField();
		   elem.setMinHeight(40);
		   elem.setMaxHeight(40);
		   elem.setMaxWidth(40);
		   tabinput[k]=elem;
		   tabinput[k].setTextFormatter(new TextFormatter<>((Change change) -> {
			    String newText = change.getControlNewText();
			    if (newText.length() > 1) {
			        return null ;
			    } 
			    else 
			    {
			        return change ;
			    } 
			})); 
		  box.getChildren().add(tabinput[k]);
		}
        Button b = new Button("OK") ; 
        b.setOnAction(e-> {
        	  for(int g=0 ; g<f ; g++)
        	  {
     	      userdef[g] = tabinput[g].getText();
     	      user=user+userdef[g]; 
        	  }
     	      if (def1.equalsIgnoreCase(user)) // comparer deux strings sans tenir compte le majuscule et le miniscule 
                   {
                      this.deplacer=4;
                      this.score=20; 
                   }
              else 
                   {   
                 this.score=-10; 

                   }
     	        st.close(); 
        	  }); 
        b.setMinWidth(100);
		 b.setStyle("-fx-background-radius:15px; -fx-background-color:rgb(30, 30, 30, 1) ");
		b.setTextFill(Color.rgb(255, 191, 8, 1));
		 b.setMinHeight(30);
        Text titre = new Text(); 
        Text def = new Text() ; 
        def.setFont(Font.font("Roboto" ,FontWeight.LIGHT ,FontPosture.ITALIC ,18)); 
        def.setFill(Color.rgb(30, 30, 30, 1));
        titre.setText("Enter the correct word to WIN!: ");
        titre.setFont(Font.font("Roboto" ,FontWeight.BLACK ,   25));
        titre.setFill(Color.rgb(30, 30, 30, 1));
        VBox deff = new VBox (); 
        deff.getChildren().add(titre);
        deff.getChildren().add(def); 
        deff.getChildren().add(box); 
        deff.getChildren().add(b); 
        deff.setAlignment(Pos.BASELINE_CENTER);
        deff.setSpacing(40);
        deff.setStyle("-fx-background-color:#F6D470");    
        def.setText(deef);     
        Scene sci =new Scene (deff,800,400);
        st.setScene(sci); 
        st.showAndWait();
        int [] tabdepart= {this.score,this.deplacer};
        return(tabdepart);
    }
     public String affichercolor()
    {
        return(this.couleur);
    }
    public int getLength () {
        return(def1.length()); 
    }
    public int getscore(){
        return(this.score);
    }
    public int getdeplacer(){
        return(this.deplacer);
    }

}