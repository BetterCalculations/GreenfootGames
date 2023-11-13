import greenfoot.*;
/**
 * Write a description of class Vars here.
 * @Module Variables for the Game
 * @author (Maximilian Schaefer) 
 * @version (1.0.0)
 */
public class Vars extends GameManager 
{
    public Vars()
    {
    }
    // Define Game Vars
    public int HighscoreX = 400;// shows the score at the Pixel Y=400
    public int HighscoreY = 50; // shows the score at the Pixel Y=50
    public int ScoreX = 50; // shows the Score at the Pixel x = 50
    public int ScoreY = 50; // shows the Score at the Pixel y = 50
    public int SpeedViewerX = 200; // shows the Speed at the Pixel x = 200
    public int SpeedViewerY = 50; // shows the Score at the Pixel y = 50
    public String ScoreText; // The Score as Type String 
    public String SpeedText; // The Speed as Type String
    public int WorldHeight = 600; // World Width
    public int WorldWidth = 800; // World Height
    public int SpeedLimit = 260; // Speed Limit
    public int GameSpeed = 45;
    // Define Player Vars and Methods
    public double PlayerSpeed = 1.431; // Player start speed
    public double PlayerPower = 0.241; // The Power of the Engine 
    public double PlayerWeight = 1.000; // The Weight for the Player car
    public String LEFT = "a"; // Keybind for drive Left
    public String RIGHT = "d"; // Keybind for drive Right
    public String SPEED = "space"; // Keybind for acceleration
    public String BRAKE = "s"; // Keybind for brake
    public int Score = 1; // Score
    public boolean isPlayerSpeedLimit(){
        if ((int)PlayerSpeed  * 20 >=SpeedLimit){
            return true;
        }
        else{
            return false;
        }
    }
    public void PlayerSpeedUp (){
        if (isPlayerSpeedLimit()){
            return; // Cancel Player Speed Up Event
        }
        else{
            PlayerSpeed += PlayerPower * PlayerWeight *   PlayerSpeed ; // New Speed
        }
    }
    public void PlayerBrake(){
        if ((int)PlayerSpeed * 20 <= 20){
            return; // Cancel Player Brake Event
        }
        else{
            PlayerSpeed =  PlayerSpeed - PlayerPower   ; // Player is Braking
        }
    }
    public void ResetPlayerSpeed(){
        PlayerSpeed = 1.431;
    }
     public void isPlayerSpeedNegative(){
        if (PlayerSpeed <=0){
             ResetPlayerSpeed();
        }
        
    }
    public String getPlayerSpeedText(){
        SpeedText = "" + (int)PlayerSpeed *20 + "km/h";
        return SpeedText;
    }
    public String getScoreText(){
        ScoreText = "Wave: " + Score;
        return ScoreText;
    }
     public void ScoreUp(){
        Score += 1;
    }
    //Define Enemy Vars 
    public double EnemySpeed = 1.431; // Enemy Start Speed
    public double EnemyPower = 0.241; // Enemy Engine Power
    public double EnemyWeight = 0.1251;// Enemy Weight
    public double EnemyCounter = 0.005; // Countdown for Enemy Speed Up
    public double EnemyCollisionY = 600; // Collision Y axis
    public double EnemyStartY = 50; // Enemy y-axis start point
    public boolean isEnemySpeedLimit(){
        if ((int)EnemySpeed  * 20 <=SpeedLimit){
            return false; 
        }
        else{
            return true;
        }
    }
    public void EnemySpeedUp(){
        if (EnemySpeed *20 <= SpeedLimit){
             EnemySpeed +=   EnemyPower * EnemyWeight * EnemySpeed  ; // Enemy Speed up
        }
        else{
            return; // Cancel Speed up Event             
        }
        
    }
    public void EnemyCountDown(){
        EnemyCounter -= 0.001; // Enemy counter - 0.001
    }
    
    public void ResetEnemyCounter(){
        EnemyCounter = 0.005; // reset the Counter
    }
    // Shortcut for Greenfoot.isKeyDown
    public boolean isKeyDown(String Key){
        if (Greenfoot.isKeyDown(Key)){
            return true; // Is the vailid key down then is that true
        }
        else{
            return false; // else it is false
        }
    }
    // shortcut for Greenfoot.getRandomNumber(int area -1)
    public int randint(int area){
        return Greenfoot.getRandomNumber(area);
    }
    
    
   
}
