import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StreetLine here.
 * @Module Street Line 
 * @author (Maximilian Schäfer) 
 * @version (1.0.0)
 */
public class StreetLine extends Actor
{
    /**
     * Act - do whatever the StreetLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Vars PlayerInteract = new Vars(); // Ready for interactions with the Keyboard 
    public void act()
    {   if(PlayerInteract.PlayerSpeed <= 0){
            //if Player Speed is negative set the Player speed to the Default Player Speed    
            PlayerInteract.ResetPlayerSpeed();
    } 
        // if Player Speed negative set the Player speed to Default Player Speed
        if (PlayerInteract.isKeyDown(PlayerInteract.SPEED)){
            PlayerInteract.PlayerSpeedUp(); // MORE Engery (;
        }
        if (PlayerInteract.isKeyDown(PlayerInteract.BRAKE)){
            PlayerInteract.PlayerBrake(); // Loss Engery );
        }
        if (getY() >=600) {
            setLocation(getX(), PlayerInteract.WorldHeight / 2);
        }
        move_line(); // Move me
        showSpeed();
        Greenfoot.setSpeed(PlayerInteract.GameSpeed);
    }
    
    public void move_line(){
        setLocation(getX(), getY() + (int)PlayerInteract.PlayerSpeed); // Move the Street Line
    }
       public void showSpeed(){
        getWorld().showText(PlayerInteract.getPlayerSpeedText(), PlayerInteract.SpeedViewerX, PlayerInteract.SpeedViewerY);
    }
}
