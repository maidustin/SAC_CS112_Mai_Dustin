import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CS112Midterm
{

	 public static void main(String[] args) {
	        int randomnumber = 0; 
	        int replay = 0;
	        int guess = 0;
	        int high = 0;
	        int low = 0;
	        int guessright = 0;
	        int gametries = 0;
	        ArrayList<String> gamehistory = new ArrayList<String>() ;
	        
	        String[] buttons1 = {"Low", "High"};
	        String[] buttons2 = {"Yes", "No"};
	        String[] buttons3 = {"OK"};
	        String currentgameinfo = "";
	        
	        while(replay == 0){
	            ++gametries;
	            randomnumber = diceroll(12);  
	          
	            guess = messagedialog("Choose Low or High", buttons1);
	            currentgameinfo = "Game #"+gametries+"\tDice roll #"+randomnumber+"\tYour guess: "+(iseven(guess) ? "Low\t" : "High\t");
	            
	            if (iseven(randomnumber) && guess == 0) {
	                messagedialog("Correct!. \nThe number was:\t"+randomnumber+"\n",buttons3);
	                ++low;
	                ++guessright;
	                currentgameinfo = currentgameinfo +"CORRECT!\n";
	            }
	         
	            else if (!iseven(randomnumber) && guess == 1){
	                messagedialog("Correct!.\nThe number was:\t"+randomnumber+"\n",buttons3);
	                ++high;
	                ++guessright;
	                currentgameinfo = currentgameinfo +"Correct!\n";
	            }
	          
	            else{
	                messagedialog("Sorry, you lose.\nThe number was:\t"+randomnumber+"\n",buttons3);
	                currentgameinfo = currentgameinfo +"Incorrect.\n";
	            }
	            gamehistory.add(currentgameinfo);
	            replay = messagedialog("Play again?\n", buttons2);
	        }
	      
	        float guesspercentage = (float) guessright / gametries;
	        JTextArea endgame = new JTextArea("\n"
	                + "You played a total rounds of:\t"+gametries+"\n"
	                + "Total right:\t\t"+guessright+"\n"
	                + "Percentage correct:\t"+Math.round(guesspercentage * 100)+"%\n");
	        for (int count = 0;count < gamehistory.size();++count){
	            endgame.append(gamehistory.get(count));
	        }
	        messagedialog(endgame, buttons3);
	    }
	    
	    public static int diceroll(int sidesofdice){
	        Random random = new Random();
	        return (random.nextInt(sidesofdice) + 1) ;
	    }
	  
	    public static int messagedialog(String messagestring, String[] buttons) {
	        return (JOptionPane.showOptionDialog(null, messagestring, "Confirmation", JOptionPane.DEFAULT_OPTION, 0, null, buttons, buttons[0]));
	    }  
	    
	    public static int messagedialog(JTextArea messagestring, String[] buttons) {
	        return (JOptionPane.showOptionDialog(null, messagestring, "Confirmation", JOptionPane.DEFAULT_OPTION, 0, null, buttons, buttons[0]));
	    }  
	   
	    public static boolean iseven(int testnumber){
	        if ((testnumber & 1) == 0) return true;
	        return false;
	    }
	}
