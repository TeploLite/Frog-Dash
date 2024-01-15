import greenfoot.*;

public class Player1 extends Actor
{
    private GreenfootImage image1 = new GreenfootImage("Skate_1.png");;
    private GreenfootImage image2 = new GreenfootImage("Skate_2.png");
    private GreenfootImage image3 = new GreenfootImage("Skate_3.png");
    private GreenfootImage image4 = new GreenfootImage("Skate_4.png");
    private GreenfootImage image5 = new GreenfootImage("Skate_5.png");
    private GreenfootImage image6 = new GreenfootImage("Skate_6.png");
    private GreenfootImage image11 = new GreenfootImage("Heli_1.png");;
    private GreenfootImage image22 = new GreenfootImage("Heli_2.png");
    private GreenfootImage image33 = new GreenfootImage("Heli_3.png");
    private GreenfootImage image44 = new GreenfootImage("Heli_4.png");
    private GreenfootImage image55 = new GreenfootImage("Heli_5.png");
    private GreenfootImage image66 = new GreenfootImage("Heli_6.png");
    private int img_count = 0;
    private int y_location;
    private int count = 0;
    private int current = 0;
    private int steps=0;
    private int base_y_location = 300;
    private int return_location;
    private int height;
    private boolean UP;
    private boolean JUMP_FLAG = false;
    private boolean CAN_FLY = false;
    
    /**
     * Constructor
     */
    public Player1()
    {
        setImage(image1);
    }
    
    /**
     * Act - This method gets called every time.
     */
      
   public void act(){
        sky_fly();
        if (CAN_FLY){
            getWorld().removeObjects(getWorld().getObjects(Life1.class));
            getWorld().removeObjects(getWorld().getObjects(Power1.class));
            is_chance();
            flying_image();
            fly();
            bonus();
            life();
        }
        else{
           moving_image();
           if ( JUMP_FLAG ){
               jump();
               
           }
           else if ( Greenfoot.isKeyDown("space") && !JUMP_FLAG){
               JUMP_FLAG = true;
               Greenfoot.playSound("jump1.wav");
               if ( getY() <= 236 ){
                   return_location = 228;
                   height = (return_location - 80);
                   
               }
               else if ( getY() > 236 && getY() <= 252 ){
                   return_location = 242;
                   height = ( return_location - 80 );
               }
               else if ( getY() > 252 && getY() <= 268 ){
                   return_location = 260;
                   height = ( return_location - 80 );
               }
               else if ( getY() > 268 && getY() <= 284 ){
                   return_location = 274;
                   height = ( return_location - 80 );
               }
               else{
                   return_location = 292;
                   height = ( return_location - 80 );
               }
                
           }
           else{
               is_chance();
               if ( Greenfoot.isKeyDown("UP") && getY() >= 220){
                   setLocation(getX(), getY()-4);
               }
               if ( Greenfoot.isKeyDown("DOWN") && getY() < 300){
                   setLocation(getX(), getY()+4);
               }
               bonus();
               life();
           }
        }
   }
   /**
    * Sky_fly - If the player touched a power-up, it changes to the helicopter image and starts the bonus level
    */
   private void sky_fly(){
       if ( isTouching(Power.class)){
           removeTouching(Power.class);
           setImage(image1);
           level2 bg = (level2) getWorld();
           y_location = getY();
           setLocation(getX(), 200);
           CAN_FLY = true;
           getWorld().removeObjects(getWorld().getObjects(Snake1.class));
           bg.Helicopter=true;
           bg.Heli_flag=true;
           setImage(image11);
       }
   }  
   
   /**
    * fly() - This starts the helicopter power for 540 cycles and resets the necessary flags after that.
    */
   private void fly(){
       level2 bg = (level2) getWorld();
       if ( count > 400 ){
           bg.Heli_flag=false;
       }
       if (count < 540 ){
           if ( Greenfoot.isKeyDown("UP")){
               setLocation(getX(), getY()-2);
            }
           if ( Greenfoot.isKeyDown("DOWN")){
               setLocation(getX(), getY()+2);
           }
            count ++;
       }
       if ( count == 540 ){
           count = 0;
           CAN_FLY = false;
           setLocation(getX(), y_location);
           bg.Helicopter=false;
           setImage(image1);
       }
   }
   
   /**
    * If the player touches a fly, this method removes the fly and increments the score.
    */
   private void life(){
       
       if ( isTouching(Points1.class)){
           removeTouching(Points1.class);
           level2 world=(level2) getWorld();
           world.tambahskor();
           Greenfoot.playSound("collect.wav");
       }
   }
  
   
   /**
    * is_chance()
    * If the player touches a snake:
    * If he has lives remaining, he loses a life. Otherwise, the game is over and the world changes.
    */
   private void is_chance(){
       level2 bg = (level2) getWorld();
       if ( isTouching(Snake1.class)){
           if ( bg.lifes == 0){
               Greenfoot.playSound("bomb.wav");
               Greenfoot.setWorld(new EndGame()); 
               bg.backgroundMusic.stop();
               Greenfoot.playSound("game-over.wav");
                level2 world=(level2) getWorld();
           }
           else{
               removeTouching(Snake1.class);
               Greenfoot.playSound("bomb.wav");
               bg.lifes --;
                level2 world=(level2) getWorld();
           }    
        }
    }
   
    
    /**
     * bonus()
     * If the player touches a life, his lives increases by 1.
     */
   private void bonus(){
       level2 bg = (level2) getWorld();
       if ( isTouching(Life1.class)){
           bg.lifes ++;
           removeTouching(Life1.class);
           Greenfoot.playSound("collect.wav");
            level2 world=(level2) getWorld();
       }
  }
  
  
  /**
   * This handles the animation for the normal player.
   * 
   */
   private void moving_image(){
                img_count ++;

                if (getImage() == image1 && img_count == 10)
                {
                       setImage(image2);
                       img_count = 0;
                }    
                else if (getImage() == image2 && img_count == 10)
                {
                       setImage(image3);
                       img_count = 0;
                }
                else if ( getImage() == image3 && img_count == 10)
                {
                       setImage(image4);
                       img_count = 0;
                }
                else if ( getImage() == image4 && img_count == 10)
                {
                       setImage(image5);
                       img_count = 0;
                }
                else if ( getImage() == image5 && img_count == 10)
                {
                       setImage(image6);
                       img_count = 0;
                }
                else if ( getImage() == image6 && img_count == 10)
                {
                       setImage(image1);
                       img_count = 0;
                }
                
   }
   
   /**
   * This handles the animation for the helicopter player.
   * 
   */
    private void flying_image(){
                img_count ++;

                if (getImage() == image11 && img_count == 20)
                {
                       setImage(image22);
                       img_count = 0;
                }    
                else if (getImage() == image22 && img_count == 20)
                {
                       setImage(image33);
                       img_count = 0;
                }
                else if ( getImage() == image33 && img_count == 20)
                {
                       setImage(image44);
                       img_count = 0;
                }
                else if ( getImage() == image44 && img_count == 20)
                {
                       setImage(image55);
                       img_count = 0;
                }
                else if ( getImage() == image55 && img_count == 20)
                {
                       setImage(image66);
                       img_count = 0;
                }
                else if ( getImage() == image66 && img_count == 20)
                {
                       setImage(image11);
                       img_count = 0;
                }
                
   }
   
   /**
    * This handles the jumping motion of the player.
    */
    
   private void jump(){         
      
            if (getY()<=height)
            {
                UP=false;
               // Greenfoot.delay(3);
            }
            if (UP && getY() > height )
            {
                if ( getY() < (height + 10) )
                {
                    Greenfoot.delay(1);
                }
                    setLocation(getX(),getY()-4);
                    steps++;
                }
            if (!UP && getY() < return_location )
            {
                setLocation(getX(),getY()+4);
                steps++;
            }
            if (getY()>=return_location)
            {
                setLocation(getX(), return_location);
                JUMP_FLAG=false;
                UP=true;
            }
     
   }
}
