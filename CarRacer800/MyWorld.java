import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * @Module MyWorld
 * @author (Maximilian Schaefer) 
 * @version (1.0.0)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Vars vars = new Vars(); // Get Vars for Spawn Enemy
    public int StartEnemyY = (int)vars.EnemyStartY; // Enemy Start Y point 
    public MyWorld()
    {    
        super(800, 600, 1, false); // Create a world with 800x600px without use a border 
        preparingStart();
        
        
    }
    
    public boolean isWrongResolution(){
        if (getWidth() != vars.WorldWidth){
            return true;
        }
        else if (getHeight() != vars.WorldHeight){
            return true;
        }
        else{
            return false;
        }
    }
    public void preparingStart(){
        if (isWrongResolution()){
            System.out.println("[Error]: The Game has Crashed Reason: The World Height is > as definded or < as defined");
            Greenfoot.stop();
        }
        else{
            Start();
        }
    }
    public void Start(){
        CreateStreetLine(); // add street Lines
        CreateEnemies(); // Add Enemies
        Greenfoot.setSpeed(vars.GameSpeed); // Set the Game Speed
        CreatePlayer(); // Add Player
    }
    public void CreatePlayer(){
        // Spawn the Player
        addObject(new Player(), vars.WorldWidth / 2, vars.WorldHeight - 20);
    }
    public void CreateEnemies(){
        // Spawn 10x Enemy with a random X position
        for (int Enemies = 0; Enemies <10;Enemies++){
            addObject(new Enemy(), vars.randint(vars.WorldWidth - 20 ) + 10, StartEnemyY);
        }
    }
    public void CreateStreetLine(){
        // add the Street Line to the Game
        addObject(new StreetLine(), vars.WorldWidth / 2, vars.WorldHeight / 2);
        
    }
}
