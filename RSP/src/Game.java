
import java.util.Scanner;
import java.util.Random;

public class Game {


    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner( System.in);
        int player, computer;
        System.out.println("Choose rock, paper, or scissors:\n\t1 = Rock\n\t2 = Paper\n\t3 = Scissors\nEnter 1, 2, or 3:");
        player = input.nextInt();
        computer = random.nextInt(3) + 1;
        System.out.printf("Computer chose:\t%d",computer);
        if(player == computer){
            System.out.println("\nTIE");
        }
        else if(player == 1 && computer == 2 || player == 2 && computer == 3 || player == 3 && computer == 1){
            System.out.println("\nYou lose!");
        }
        else{
            System.out.println("\nWinner!");
        }

        


        
    }
    
}