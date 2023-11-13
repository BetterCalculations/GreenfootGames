import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * @Module Player
 * @author (your name) 
 * @version (1.0.0)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Vars PLAYER = new Vars(); // get Player Vars
 
    public void act()
        
    {   if (getX() >= PLAYER.WorldWidth - 30){
            move((int)-PLAYER.PlayerSpeed);
    }
    if (getX() <= 30){
            move((int)PLAYER.PlayerSpeed);
    }
        if(PLAYER.PlayerSpeed <= 0){
            PLAYER.ResetPlayerSpeed();
    } //if Player Speed is negative set the Player speed to Default Player Speed
        if (isKeyDown(PLAYER.SPEED)){
            PLAYER.PlayerSpeedUp();
    }
    if (isKeyDown(PLAYER.BRAKE)){
        PLAYER.PlayerBrake();
    }
        
    
        if (isKeyDown(PLAYER.LEFT)){
            move(-(int)PLAYER.PlayerSpeed);
        }
        if (isKeyDown(PLAYER.RIGHT)){
            move((int)PLAYER.PlayerSpeed);
            
        }
        if (Collision()){
            removeTouching(Enemy.class);
            Greenfoot.stop();
        }
    }
    public boolean isKeyDown(String Key){
        if (Greenfoot.isKeyDown(Key)){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean Collision(){
        if (isTouching(Enemy.class)){
            return true;
        }
        else{
            return false;
        }
    }
}
