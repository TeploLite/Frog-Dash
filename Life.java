import greenfoot.*;

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Player
{
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("icon.png");
        Background bg = (Background) getWorld();
        move(-1*bg.scrollSpeed);
        if (isAtEdge())
        {
            bg.removeObject(this);
}
      
   }   
}
