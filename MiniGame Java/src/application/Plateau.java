package application;

import java.util.Random;
import java.util.Iterator;
import java.io.Serializable;
import java.util.HashSet;

public class Plateau implements Serializable
{
   public Case tabcase []=new Case[100];

    
    public void createplateau ()
    {
    Random rand = new Random(); 
       int aleat = rand.nextInt(98); 
       int i =0 ; 
       HashSet<Integer> numbers = new HashSet<Integer>();
       while(aleat==0)
       {
           aleat=rand.nextInt(98); 
       }
       numbers.add(aleat) ; 
         while(i <24) 
         {   while(numbers.contains(aleat) || (aleat==0))
             {
                 aleat=rand.nextInt(98); 
             }
             numbers.add(aleat); 
             i++;  
         }
         System.out.println(numbers);
         System.out.println(numbers.size());
         
         //********************** create objects**********************//
                  tabcase[0]=new Depart();
         
         tabcase [99]=new Fin ();
        
         //*************** la creation des cases saut**************//
          Iterator<Integer> it = numbers.iterator();
         
          i=0;
           while ( it.hasNext() ){
              
             Integer c = it.next();
             if(i<5){
                 tabcase [c]=new Bonus();
            
             }
             if((i>=5)&&(i<10)){
             tabcase [c]=new Malus();
             

             }
             if((i>=10)&&(i<15)){
             tabcase [c]=new Saut();
           

             }
             if((i>=15)&&(i<20)){
             tabcase [c]=new Imagefile();
            

             }
             if((i>=20)&&(i<25)){
             tabcase [c]=new Definition ();
             

             }
              i++;
         
    }
     
   
    
    for(i=1;i<99;i++)
    {
        if(!numbers.contains(i))
        {
            tabcase[i]=new Case();
        }
        
    }
    for(i=0;i<100;i++)
    {
        System.out.println(tabcase[i].affichercolor()); 
        
    }
    
    
   
    
}
}
