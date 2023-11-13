import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader; 




/**
 * Write a description of class HighscoreHandler here.
 * @Module HighscoreHandler
 * @Sources:https://javabeginners.de/Ein-_und_Ausgabe/Eine_Datei_zeilenweise_auslesen.php
 *              http://www.javaschubla.de/2007/javaerst0260.html
 *                  https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/
 * @author (Maximilian Schäfer) 
 * @version (1.0.0)
 */
public class HighscoreHandler extends GameManager 
{
    // instance variables - replace the example below with your own
    
    public HighscoreHandler()
    {
    }
    // Diesen Teil hab ich aus Google weil ich eine Highscore Anzeige wollte 
    private File high = new File("highscore.txt");
    private static boolean checkFile(File file) {
        if (file != null) {
            try {
                file.createNewFile(); // create file 
            } catch (IOException e) {
                // if get error show error
                System.err.println("Error creating " + file.toString());
            }
            if (file.isFile() && file.canWrite() && file.canRead())
                return true;
        }
        return false;
    }
    public String read(){
        if (checkFile(high)){
            try{
                FileReader fReader = new FileReader(high.toString());
                BufferedReader br = new BufferedReader(fReader);
                return br.readLine();
                
            } catch(IOException e){
                
            }
        }
       
        return "0";
    }
    public int readToInt(){
        return Integer.valueOf(read());
    }
    public void write(String txt){
        if (checkFile(high)){
            try {
            FileWriter fWriter = new FileWriter(high.toString(), false);
            BufferedWriter bw = new BufferedWriter(fWriter);
            bw.write(txt);
            bw.close();
            } catch (IOException e) {
                System.err.println("Error creating " + high.toString());
            }
            
        }
    }
 
}
