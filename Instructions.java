import greenfoot.*;

public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    
    
    public Instructions()
    {    
        super(800, 320, 1); 
    }
    
     public void act(){
         Greenfoot.delay(20);
         if (Greenfoot.isKeyDown("space")){
             Greenfoot.delay(10);
                Greenfoot.setWorld(new Background());
                
            }
            
     }
     
}

