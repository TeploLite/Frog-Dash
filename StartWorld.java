import greenfoot.*;

public class StartWorld extends World
{
   
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public GreenfootSound music = new GreenfootSound("bgm4.wav");
    public void started()
    {
        music.setVolume(100);
        music.play();
        music.playLoop();
    }
    
    public void stopped()
    {
        music.stop();
    }
    
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 320, 1);  
    
        
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {   
                Greenfoot.delay(20);
                Greenfoot.setWorld(new Instructions());
                music.stop();
       }
    }
}