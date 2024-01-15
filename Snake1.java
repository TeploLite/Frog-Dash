import greenfoot.*;

public class Snake1 extends Actor
{
    public int speed = -5;

    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        level2 bg1 = (level2) getWorld();
        
        move((-1*bg1.scrollSpeed)-3);
        if (isAtEdge())
        {
            bg1.removeObject(this);
        }
        if ( ((bg1.score % 50) == 0) && (bg1.score > 0)){
            bg1.scrollSpeed ++;
            speed = speed - 3;
            bg1.score++;
        }
        //if ( getObjectsInRange(5, Opponent.class){
           
} 
}   

