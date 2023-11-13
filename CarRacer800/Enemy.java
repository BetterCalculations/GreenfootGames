import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * @Module Enemy
 * @author (Maximilian Schaefer) 
 * @version (1.0.0)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Vars ENEMY = new Vars();
    public int x_axis_change_counter = 100;
    public int randomiser = 2;
    public HighscoreHandler highscore = new HighscoreHandler();
    
    public void act()
    {   if (ENEMY.Score >= 10){
            if (ENEMY.Score %100 == 0){
                getWorld().addObject(new Enemy(), ENEMY.randint(ENEMY.WorldWidth - 20 ) + 10, (int)ENEMY.EnemyStartY);
            } 
    }
        if (x_axis_change_counter == 0){
            // is zero than change x coord
            int r = ENEMY.randint(randomiser); // 0 = getX() + Speed or 1 = getX() - Speed
            x_axis_change_counter = 100;
            if (r == 0){
                setLocation(getX() + (int)ENEMY.EnemySpeed, getY());
            }
            else{
                
                setLocation(getX() - (int)ENEMY.EnemySpeed, getY());            
            
            }
            
        }
        if (ENEMY.EnemyCounter <= 0){
            ENEMY.EnemySpeedUp();
            
            ENEMY.ResetEnemyCounter();
            
            
        }
        if (getY() > ENEMY.EnemyCollisionY){
            // Set new Position and the wave + 1
            setRandomLocation();
            ENEMY.ScoreUp();
        }
        move_enemy(); // Move loop
        ENEMY.EnemyCountDown(); // Counter Loop
        showScore(); // Score Loop
        x_axis_change_counter--;
        showHighscore();
        if (highscore.readToInt() < ENEMY.Score){
            highscore.write(Integer.toString(ENEMY.Score));
        }
        
     
    }
    public int Highscore(){
        return highscore.readToInt();
    }
    public String intToString(int x){
        return Integer.toString(x);
    }
    public void showHighscore(){
        getWorld().showText("Highscore:" + intToString(Highscore()), ENEMY.HighscoreX, ENEMY.HighscoreY);
    }
    public void move_enemy(){
        setLocation(getX(), getY() + (int)ENEMY.EnemySpeed); // Move Y
    }
    public void setRandomLocation(){
        // set the new X random position 
        setLocation(ENEMY.randint(getWorld().getWidth()), (int)ENEMY.EnemyStartY);
    }
    public void showScore(){
        /// shows the Wave
        getWorld().showText(ENEMY.getScoreText(), ENEMY.ScoreX, ENEMY.ScoreY);
    }
    public void Debug(String txt){
        System.out.println(txt);
    }    
}
